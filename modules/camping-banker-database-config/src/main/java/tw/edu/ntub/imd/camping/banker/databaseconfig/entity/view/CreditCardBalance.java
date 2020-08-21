package tw.edu.ntub.imd.camping.banker.databaseconfig.entity.view;

import lombok.Data;
import org.hibernate.annotations.Immutable;
import tw.edu.ntub.imd.camping.banker.databaseconfig.Config;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "credit_card_balance", schema = Config.DATABASE_NAME)
@Immutable
public class CreditCardBalance {
    @Id
    @Column(name = "card_id", length = 16, nullable = false)
    private String cardId;

    @Column(name = "balance", nullable = false, columnDefinition = "UNSIGNED")
    private Integer balance;
}
