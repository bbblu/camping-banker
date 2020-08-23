package tw.edu.ntub.imd.camping.banker.service;

import org.springframework.stereotype.Service;
import tw.edu.ntub.birc.common.util.BooleanUtils;
import tw.edu.ntub.imd.camping.banker.bean.TransactionRecordBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.BankAccountDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.TransactionRecordDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.BankAccount;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.TransactionRecord;
import tw.edu.ntub.imd.camping.banker.exception.DebitedException;
import tw.edu.ntub.imd.camping.banker.exception.NotFoundException;
import tw.edu.ntub.imd.camping.banker.service.transformer.TransactionRecordTransformer;

@Service
public class TransactionRecordServiceImpl
        extends BaseServiceImpl<TransactionRecordBean, TransactionRecord, Integer>
        implements TransactionRecordService {
    private final TransactionRecordDAO transactionRecordDAO;
    private final TransactionRecordTransformer transformer;
    private final BankAccountDAO bankAccountDAO;

    public TransactionRecordServiceImpl(
            TransactionRecordDAO transactionRecordDAO,
            TransactionRecordTransformer transformer,
            BankAccountDAO bankAccountDAO) {
        super(transactionRecordDAO, transformer);
        this.transactionRecordDAO = transactionRecordDAO;
        this.transformer = transformer;
        this.bankAccountDAO = bankAccountDAO;
    }

    @Override
    public TransactionRecordBean save(TransactionRecordBean transactionRecordBean) {
        TransactionRecord transactionRecord = transformer.transferToEntity(transactionRecordBean);
        transactionRecord.setDebit(false);
        TransactionRecord saveResult =
                transactionRecordDAO.saveAndFlush(transactionRecord);
        return transformer.transferToBean(saveResult);
    }

    @Override
    public void updateDebitToTrue(Integer id) {
        TransactionRecord transactionRecord =
                transactionRecordDAO.findById(id).orElseThrow(() -> new NotFoundException("無此交易紀錄"));
        if (BooleanUtils.isFalse(transactionRecord.isDebit())) {
            transactionRecordDAO.updateDebitById(id, true);
            plusMoneyAndUpdateBankAccount(transactionRecord.getPayeeBankAccount(), transactionRecord.getMoney());
        } else {
            throw new DebitedException();
        }
    }

    private void plusMoneyAndUpdateBankAccount(String bankAccount, int money) {
        BankAccount lockedBankAccount = bankAccountDAO.findById(bankAccount).orElseThrow();
        lockedBankAccount.plusMoney(money);
        bankAccountDAO.save(lockedBankAccount);
    }
}
