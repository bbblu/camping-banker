package tw.edu.ntub.imd.camping.banker.databaseconfig.dao;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCard;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCardId;

import javax.persistence.LockModeType;
import java.util.Optional;

@Repository
public interface CreditCardDAO extends BaseDAO<CreditCard, CreditCardId> {
    @NonNull
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Override
    Optional<CreditCard> findById(@NonNull CreditCardId id);
}
