package tw.edu.ntub.imd.camping.banker.service.transformer;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.camping.banker.bean.BankAccountBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.BankAccount;

@Component
public class BankAccountTransformerImpl implements BankAccountTransformer {
    @NonNull
    @Override
    public BankAccount transferToEntity(@NonNull BankAccountBean bankAccountBean) {
        return JavaBeanUtils.copy(bankAccountBean, new BankAccount());
    }

    @NonNull
    @Override
    public BankAccountBean transferToBean(@NonNull BankAccount bankAccount) {
        return JavaBeanUtils.copy(bankAccount, new BankAccountBean());
    }
}
