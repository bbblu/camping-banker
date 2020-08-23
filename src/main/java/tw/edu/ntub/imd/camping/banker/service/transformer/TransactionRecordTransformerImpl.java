package tw.edu.ntub.imd.camping.banker.service.transformer;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.camping.banker.bean.TransactionRecordBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.TransactionRecord;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

@Component
public class TransactionRecordTransformerImpl implements TransactionRecordTransformer {
    @NonNull
    @Override
    public TransactionRecord transferToEntity(@NonNull TransactionRecordBean transactionRecordBean) {
        TransactionRecord result = JavaBeanUtils.copy(transactionRecordBean, new TransactionRecord());
        if (transactionRecordBean.getExpireDate() != null) {
            result.setExpireDate(transactionRecordBean.getExpireDate().format(DateTimeFormatter.ofPattern("MM/yy")));
        }
        return result;
    }

    @NonNull
    @Override
    public TransactionRecordBean transferToBean(@NonNull TransactionRecord transactionRecord) {
        TransactionRecordBean result = JavaBeanUtils.copy(transactionRecord, new TransactionRecordBean());
        if (transactionRecord.getExpireDate() != null) {
            result.setExpireDate(YearMonth.parse(transactionRecord.getExpireDate(), DateTimeFormatter.ofPattern("MM/yy")));
        }
        return result;
    }
}
