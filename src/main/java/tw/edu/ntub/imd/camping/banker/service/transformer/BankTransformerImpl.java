package tw.edu.ntub.imd.camping.banker.service.transformer;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.camping.banker.bean.BankBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.Bank;

@Component
public class BankTransformerImpl implements BankTransformer {
    @NonNull
    @Override
    public Bank transferToEntity(@NonNull BankBean bankBean) {
        return JavaBeanUtils.copy(bankBean, new Bank());
    }

    @NonNull
    @Override
    public BankBean transferToBean(@NonNull Bank bank) {
        return JavaBeanUtils.copy(bank, new BankBean());
    }
}
