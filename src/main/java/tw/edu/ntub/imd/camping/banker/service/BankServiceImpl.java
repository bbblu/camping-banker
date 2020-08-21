package tw.edu.ntub.imd.camping.banker.service;

import org.springframework.stereotype.Service;
import tw.edu.ntub.imd.camping.banker.bean.BankBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.dao.BankDAO;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.Bank;
import tw.edu.ntub.imd.camping.banker.service.transformer.BankTransformer;

@Service
public class BankServiceImpl extends BaseViewServiceImpl<BankBean, Bank, Bank> implements BankService {
    private final BankDAO bankDAO;
    private final BankTransformer transformer;

    public BankServiceImpl(BankDAO bankDAO, BankTransformer transformer) {
        super(bankDAO, transformer);
        this.bankDAO = bankDAO;
        this.transformer = transformer;
    }
}
