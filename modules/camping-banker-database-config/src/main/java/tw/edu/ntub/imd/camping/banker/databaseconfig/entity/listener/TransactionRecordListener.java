package tw.edu.ntub.imd.camping.banker.databaseconfig.entity.listener;

import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.TransactionRecord;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class TransactionRecordListener {
    @PrePersist
    public void preSave(TransactionRecord transactionRecord) {
        if (transactionRecord.isEnable() == null) {
            transactionRecord.setEnable(true);
        }
        if (transactionRecord.getCreateDate() == null) {
            transactionRecord.setCreateDate(LocalDateTime.now());
        }
        if (transactionRecord.getLastModifyDate() == null) {
            transactionRecord.setLastModifyDate(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(TransactionRecord transactionRecord) {
        transactionRecord.setLastModifyDate(LocalDateTime.now());
    }
}
