package tw.edu.ntub.imd.camping.banker.databaseconfig.dao;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.TransactionRecord;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface TransactionRecordDAO extends BaseDAO<TransactionRecord, Integer> {
    @Modifying
    @Query("UPDATE TransactionRecord record SET record.debit = :debit WHERE record.id = :id")
    void updateDebitById(@Param("id") int id, @Param("debit") boolean debit);

    @NonNull
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Override
    Optional<TransactionRecord> findById(@NonNull Integer integer);
}
