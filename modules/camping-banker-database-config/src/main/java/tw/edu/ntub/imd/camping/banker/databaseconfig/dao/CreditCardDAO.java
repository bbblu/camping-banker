package tw.edu.ntub.imd.camping.banker.databaseconfig.dao;

import org.springframework.stereotype.Repository;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCard;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.CreditCardId;

@Repository
public interface CreditCardDAO extends BaseDAO<CreditCard, CreditCardId> {

}
