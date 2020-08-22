package tw.edu.ntub.imd.camping.banker.service;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.camping.banker.bean.BankAccountBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.BankAccountDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.BankAccount;
import tw.edu.ntub.imd.camping.banker.exception.DuplicateCreateException;
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
        try {
            BankAccount saveResult = bankAccountDAO.save(transformer.transferToEntity(bankAccountBean));
            return transformer.transferToBean(saveResult);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateCreateException("此銀行帳戶已經存在");
        }
    }
}
