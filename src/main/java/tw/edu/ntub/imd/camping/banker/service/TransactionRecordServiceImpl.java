package tw.edu.ntub.imd.camping.banker.service;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.BooleanUtils;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.camping.banker.bean.TransactionRecordBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.CreditCardDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.TransactionRecordDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCard;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCardId;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.TransactionRecord;
import tw.edu.ntub.imd.camping.banker.exception.DebitedException;
import tw.edu.ntub.imd.camping.banker.exception.NoBalanceException;
import tw.edu.ntub.imd.camping.banker.exception.NotFoundException;
import tw.edu.ntub.imd.camping.banker.service.transformer.TransactionRecordTransformer;

import java.util.Optional;

@Service
public class TransactionRecordServiceImpl
        extends BaseServiceImpl<TransactionRecordBean, TransactionRecord, Integer>
        implements TransactionRecordService {
    private final TransactionRecordDAO transactionRecordDAO;
    private final TransactionRecordTransformer transformer;
    private final CreditCardDAO creditCardDAO;

    public TransactionRecordServiceImpl(
            TransactionRecordDAO transactionRecordDAO,
            TransactionRecordTransformer transformer,
            CreditCardDAO creditCardDAO
    ) {
        super(transactionRecordDAO, transformer);
        this.transactionRecordDAO = transactionRecordDAO;
        this.transformer = transformer;
        this.creditCardDAO = creditCardDAO;
    }

    @Override
    public TransactionRecordBean save(TransactionRecordBean transactionRecordBean) {
        Optional<CreditCard> optionalCreditCard =
                creditCardDAO.findById(getCreditCardId(transactionRecordBean));
        CreditCard creditCard = optionalCreditCard.orElseThrow(() -> new NotFoundException("沒有此信用卡"));
        if (creditCard.getBalance() < transactionRecordBean.getMoney()) {
            throw new NoBalanceException();
        }

        TransactionRecord transactionRecord = transformer.transferToEntity(transactionRecordBean);
        transactionRecord.setDebit(false);
        TransactionRecord saveResult =
                transactionRecordDAO.saveAndFlush(transactionRecord);
        return transformer.transferToBean(saveResult);
    }

    private CreditCardId getCreditCardId(TransactionRecordBean transactionRecordBean) {
        return JavaBeanUtils.copy(transactionRecordBean, new CreditCardId());
    }

    @Override
    public void updateDebitToTrue(Integer id) {
        TransactionRecord transactionRecord =
                transactionRecordDAO.findById(id).orElseThrow(() -> new NotFoundException("無此交易紀錄"));
        if (BooleanUtils.isFalse(transactionRecord.isDebit())) {
            transactionRecordDAO.updateDebitById(id, true);
            CreditCard lockedCreditCard = creditCardDAO.findById(transactionRecord.getCreditCardId()).orElseThrow();
            lockedCreditCard.plusBalance(-transactionRecord.getMoney());
            creditCardDAO.saveAndFlush(lockedCreditCard);
            
            CreditCard lockedPayeeCreditCard = creditCardDAO.findById(transactionRecord.getPayeeCreditCardId()).orElseThrow();
            lockedPayeeCreditCard.plusBalance(transactionRecord.getMoney());
            creditCardDAO.saveAndFlush(lockedPayeeCreditCard);
        } else {
            throw new DebitedException();
        }
    }
}
