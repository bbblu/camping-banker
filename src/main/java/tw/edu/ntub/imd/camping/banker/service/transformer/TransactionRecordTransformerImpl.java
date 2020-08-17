package tw.edu.ntub.imd.camping.banker.service.transformer;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import tw.edu.ntub.birc.common.util.JavaBeanUtils;
import tw.edu.ntub.imd.camping.banker.bean.TransactionRecordBean;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.TransactionRecord;

@Component
public class TransactionRecordTransformerImpl implements TransactionRecordTransformer {
    @NonNull
    @Override
    public TransactionRecord transferToEntity(@NonNull TransactionRecordBean transactionRecordBean) {
        return JavaBeanUtils.copy(transactionRecordBean, new TransactionRecord());
    }

    @NonNull
    @Override
    public TransactionRecordBean transferToBean(@NonNull TransactionRecord transactionRecord) {
        return JavaBeanUtils.copy(transactionRecord, new TransactionRecordBean());
    }
}
