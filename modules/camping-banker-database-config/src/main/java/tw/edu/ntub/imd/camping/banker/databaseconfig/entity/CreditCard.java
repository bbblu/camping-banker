package tw.edu.ntub.imd.camping.banker.databaseconfig.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.NonNull;
import tw.edu.ntub.imd.camping.banker.databaseconfig.Config;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.view.CreditCardBalance;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 信用卡資料
 *
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(exclude = "bankAccountByBankAccount")
@Entity
@Table(name = "credit_card", schema = Config.DATABASE_NAME)
@IdClass(CreditCardId.class)
public class CreditCard implements Persistable<CreditCardId> {
    @Transient
    private boolean save;
    /**
     * 信用卡卡號
     *
     * @since 1.0.0
     */
    @Id
    @Column(name = "card_id", length = 16, nullable = false)
    private String cardId;

    /**
     * 安全碼
     *
     * @since 1.0.0
     */
    @Id
    @Column(name = "safe_code", length = 3, nullable = false)
    private String safeCode;

    /**
     * 過期時間
     *
     * @since 1.0.0
     */
    @Id
    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    /**
     * 銀行帳號
     *
     * @since 1.0.0
     */
    @Column(name = "bank_account", length = 16, nullable = false)
    private String bankAccount;

    /**
     * 銀行帳號
     *
     * @see BankAccount
     * @since 1.0.0
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account", referencedColumnName = "account", nullable = false, insertable = false, updatable = false)
    private BankAccount bankAccountByBankAccount;

    @ManyToOne
    @JoinColumn(name = "card_id", referencedColumnName = "card_id", nullable = false, insertable = false, updatable = false)
    private CreditCardBalance creditCardBalanceByCardId;

    public Integer getBalance() {
        return creditCardBalanceByCardId.getBalance();
    }

    @NonNull
    @Override
    public CreditCardId getId() {
        CreditCardId result = new CreditCardId();
        result.setCardId(cardId);
        result.setSafeCode(safeCode);
        result.setExpireDate(expireDate);
        return result;
    }

    @Override
    public boolean isNew() {
        return save;
    }
}
