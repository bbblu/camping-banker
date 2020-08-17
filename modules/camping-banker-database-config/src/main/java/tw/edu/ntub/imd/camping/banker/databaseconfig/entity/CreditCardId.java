package tw.edu.ntub.imd.camping.banker.databaseconfig.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
public class CreditCardId implements Serializable {
    private static final long serialVersionUID = 3504509698812937892L;
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
}
