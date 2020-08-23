package tw.edu.ntub.imd.camping.banker.databaseconfig.dao;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.BankAccount;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface BankAccountDAO extends BaseDAO<BankAccount, String> {
    @NonNull
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Override
    Optional<BankAccount> findById(@NonNull String id);
}
