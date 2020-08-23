package tw.edu.ntub.imd.camping.banker.databaseconfig.entity;

import lombok.Data;
import org.springframework.lang.NonNull;
import tw.edu.ntub.imd.camping.banker.databaseconfig.Config;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 信用卡資料
 *
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "credit_card", schema = Config.DATABASE_NAME)
@IdClass(CreditCard.class)
public class CreditCard implements Serializable, Persistable<CreditCard> {
    private static final long serialVersionUID = 2288789644856866413L;

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
    @Column(name = "expire_date", length = 5, nullable = false)
    private String expireDate;

    @NonNull
    @Override
    public CreditCard getId() {
        return this;
    }

    @Override
    public boolean isNew() {
        return save;
    }
}
