package tw.edu.ntub.imd.camping.banker.databaseconfig.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import tw.edu.ntub.imd.camping.banker.databaseconfig.Config;
import tw.edu.ntub.imd.camping.banker.databaseconfig.entity.listener.TransactionRecordListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 交易紀錄
 *
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(exclude = {"creditCardByCardId", "bankAccountByPayeeBankAccount"})
@Entity
@EntityListeners(TransactionRecordListener.class)
@Table(name = "transaction_record", schema = Config.DATABASE_NAME)
public class TransactionRecord {
    /**
     * 流水編號
     *
     * @since 1.0.0
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * 是否啟用(0: 不啟用/ 1: 啟用)
     *
     * @since 1.0.0
     */
    @Getter(AccessLevel.NONE)
    @Column(name = "enable", nullable = false)
    private Boolean enable;

    /**
     * 信用卡卡號
     *
     * @since 1.0.0
     */
    @Column(name = "card_id", length = 16, nullable = false)
    private String cardId;

    /**
     * 安全碼
     *
     * @since 1.0.0
     */
    @Column(name = "safe_code", length = 3, nullable = false)
    private String safeCode;

    /**
     * 過期時間
     *
     * @since 1.0.0
     */
    @Column(name = "expire_date", nullable = false)
    private LocalDate expireDate;

    /**
     * 交易金額
     *
     * @since 1.0.0
     */
    @Column(name = "money", nullable = false)
    private Integer money;

    /**
     * 收款人信用卡卡號
     *
     * @since 1.0.0
     */
    @Column(name = "payee_bank_account", length = 16)
    private String payeeBankAccount;

    /**
     * 是否已經扣款(0: 未扣款/ 1: 已扣款)
     *
     * @since 1.0.0
     */
    @Getter(AccessLevel.NONE)
    @Column(name = "debit", nullable = false)
    private Boolean debit;

    /**
     * 帳單地址
     *
     * @since 1.0.0
     */
    @Column(name = "bill_address", length = 300, nullable = false)
    private String billAddress;

    /**
     * 帳單姓氏
     *
     * @since 1.0.0
     */
    @Column(name = "bill_last_name", length = 50, nullable = false)
    private String billLastName;

    /**
     * 帳單名字
     *
     * @since 1.0.0
     */
    @Column(name = "bill_first_name", length = 50, nullable = false)
    private String billFirstName;

    /**
     * 帳單城市
     *
     * @since 1.0.0
     */
    @Column(name = "bill_city", length = 50, nullable = false)
    private String billCity;

    /**
     * 帳單郵遞區號
     *
     * @since 1.0.0
     */
    @Column(name = "bill_zip_code", length = 6, nullable = false)
    private String billZipCode;

    /**
     * 帳單國家/地區
     *
     * @since 1.0.0
     */
    @Column(name = "bill_country", length = 50, nullable = false)
    private String billCountry;

    /**
     * 帳單電話號碼
     *
     * @since 1.0.0
     */
    @Column(name = "bill_cell_phone", length = 10, nullable = false)
    private String billCellPhone;

    /**
     * 建立時間
     *
     * @since 1.0.0
     */
    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    /**
     * 最後修改時間
     *
     * @since 1.0.0
     */
    @Column(name = "last_modify_date", nullable = false)
    private LocalDateTime lastModifyDate;

    /**
     * 信用卡資料
     *
     * @see CreditCard
     * @since 1.0.0
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "card_id", referencedColumnName = "card_id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "safe_code", referencedColumnName = "safe_code", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "expire_date", referencedColumnName = "expire_date", nullable = false, insertable = false, updatable = false)
    })
    private CreditCard creditCardByCardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payee_bank_account", referencedColumnName = "account", nullable = false, insertable = false, updatable = false)
    private BankAccount bankAccountByPayeeBankAccount;

    public CreditCardId getCreditCardId() {
        CreditCardId result = new CreditCardId();
        result.setCardId(cardId);
        result.setSafeCode(safeCode);
        result.setExpireDate(expireDate);
        return result;
    }

    /**
     * 是否已經扣款(0: 未扣款/ 1: 已扣款)
     *
     * @since 1.0.0
     */
    public Boolean isDebit() {
        return debit;
    }

    /**
     * 是否啟用(0: 不啟用/ 1: 啟用)
     *
     * @since 1.0.0
     */
    public Boolean isEnable() {
        return enable;
    }
}
