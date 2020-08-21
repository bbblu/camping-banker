package tw.edu.ntub.imd.camping.banker.databaseconfig.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import tw.edu.ntub.imd.camping.banker.databaseconfig.Config;
import tw.edu.ntub.imd.camping.banker.databaseconfig.enumerate.BankType;

import javax.persistence.*;

/**
 * 銀行帳號
 *
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(exclude = "bank")
@Entity
@Table(name = "bank_account", schema = Config.DATABASE_NAME)
public class BankAccount {
    /**
     * 帳號
     *
     * @since 1.0.0
     */
    @Id
    @Column(name = "account", length = 16, nullable = false)
    private String account;

    /**
     * 金融機構代號
     *
     * @since 1.0.0
     */
    @Column(name = "bank_id", length = 3, nullable = false)
    private String bankId;

    /**
     * 金融機構類型(0: 銀行/ 1: 信合社/ 2: 農會/ 3: 漁會/ 4: 郵局)
     *
     * @since 1.0.0
     */
    @Enumerated
    @Column(name = "bank_type", length = 1, nullable = false)
    private BankType bankType;

    /**
     * 金融機構名稱
     *
     * @since 1.0.0
     */
    @Column(name = "bank_name", length = 40, nullable = false)
    private String bankName;

    /**
     * 餘額
     *
     * @since 1.0.0
     */
    @Column(name = "money", nullable = false)
    private Integer money;

    /**
     * 金融機構
     *
     * @since 1.0.0
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "bank_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "bank_type", referencedColumnName = "type", nullable = false, insertable = false, updatable = false),
            @JoinColumn(name = "bank_name", referencedColumnName = "name", nullable = false, insertable = false, updatable = false)
    })
    private Bank bank;

    public void plusMoney(int delta) {
        money = money - delta;
    }
}
