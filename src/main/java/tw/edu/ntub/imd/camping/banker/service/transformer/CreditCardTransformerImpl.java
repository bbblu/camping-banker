package tw.edu.ntub.imd.camping.banker.service.transformer;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.camping.banker.bean.CreditCardBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCard;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Component
public class CreditCardTransformerImpl implements CreditCardTransformer {
    @NonNull
    @Override
    public CreditCard transferToEntity(@NonNull CreditCardBean creditCardBean) {
        CreditCard result = JavaBeanUtils.copy(creditCardBean, new CreditCard());
        if (creditCardBean.getExpireDate() != null) {
            result.setExpireDate(creditCardBean.getExpireDate().format(DateTimeFormatter.ofPattern("MM/yy")));
        }
        return result;
    }

    @NonNull
    @Override
    public CreditCardBean transferToBean(@NonNull CreditCard creditCard) {
        CreditCardBean result = JavaBeanUtils.copy(creditCard, new CreditCardBean());
        if (creditCard.getExpireDate() != null) {
            result.setExpireDate(YearMonth.parse(creditCard.getExpireDate(), DateTimeFormatter.ofPattern("MM/yy")));
        }
        return result;
    }
}
