package tw.edu.ntub.imd.camping.banker.service.transformer;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.camping.banker.bean.CreditCardBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCard;

@Component
public class CreditCardTransformerImpl implements CreditCardTransformer {
    @NonNull
    @Override
    public CreditCard transferToEntity(@NonNull CreditCardBean creditCardBean) {
        return JavaBeanUtils.copy(creditCardBean, new CreditCard());
    }

    @NonNull
    @Override
    public CreditCardBean transferToBean(@NonNull CreditCard creditCard) {
        return JavaBeanUtils.copy(creditCard, new CreditCardBean());
    }
}
