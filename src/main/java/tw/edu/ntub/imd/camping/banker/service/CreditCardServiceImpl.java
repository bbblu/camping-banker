package tw.edu.ntub.imd.camping.banker.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.camping.banker.bean.CreditCardBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.CreditCardDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCard;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCardId;
import tw.edu.ntub.imd.camping.banker.exception.DuplicateCreateException;
import tw.edu.ntub.imd.camping.banker.service.transformer.CreditCardTransformer;

@Service
public class CreditCardServiceImpl extends BaseServiceImpl<CreditCardBean, CreditCard, CreditCardId> implements CreditCardService {
    private final CreditCardDAO creditCardDAO;
    private final CreditCardTransformer transformer;

    public CreditCardServiceImpl(CreditCardDAO creditCardDAO, CreditCardTransformer transformer) {
        super(creditCardDAO, transformer);
        this.creditCardDAO = creditCardDAO;
        this.transformer = transformer;
    }

    @Override
    public CreditCardBean save(CreditCardBean creditCardBean) {
        try {
            CreditCard saveResult = creditCardDAO.save(transformer.transferToEntity(creditCardBean));
            return transformer.transferToBean(saveResult);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateCreateException("此信用卡已經存在");
        }
    }
}
