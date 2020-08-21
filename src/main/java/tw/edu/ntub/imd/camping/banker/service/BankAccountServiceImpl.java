package tw.edu.ntub.imd.camping.banker.service;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.camping.banker.bean.BankAccountBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.BankAccountDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.BankAccount;
import tw.edu.ntub.imd.camping.banker.service.transformer.BankAccountTransformer;

@Service
public class BankAccountServiceImpl extends BaseServiceImpl<BankAccountBean, BankAccount, String> implements BankAccountService {
    private final BankAccountDAO bankAccountDAO;
    private final BankAccountTransformer transformer;

    public BankAccountServiceImpl(BankAccountDAO bankAccountDAO, BankAccountTransformer transformer) {
        super(bankAccountDAO, transformer);
        this.bankAccountDAO = bankAccountDAO;
        this.transformer = transformer;
    }

    @Override
    public BankAccountBean save(BankAccountBean bankAccountBean) {
        BankAccount saveResult = bankAccountDAO.save(transformer.transferToEntity(bankAccountBean));
        return transformer.transferToBean(saveResult);
    }
}
