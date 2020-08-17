package tw.edu.ntub.imd.camping.banker.service;

import tw.edu.ntub.imd.camping.banker.bean.TransactionRecordBean;

public interface TransactionRecordService extends BaseService<TransactionRecordBean, Integer> {
    void updateDebitToTrue(Integer id);
}
