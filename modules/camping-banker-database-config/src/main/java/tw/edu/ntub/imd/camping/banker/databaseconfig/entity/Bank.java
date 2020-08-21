package tw.edu.ntub.imd.camping.banker.databaseconfig.entity;

import lombok.Data;
import tw.edu.ntub.imd.camping.banker.databaseconfig.Config;
import tw.edu.ntub.imd.camping.banker.databaseconfig.enumerate.BankType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 銀行
 *
 * @since 1.0.0
 */
@Data
@Entity
@Table(name = "bank", schema = Config.DATABASE_NAME)
@IdClass(Bank.class)
public class Bank implements Serializable {
    private static final long serialVersionUID = 5927559781627722962L;

    /**
     * 代號
     *
     * @since 1.0.0
     */
    @Id
    @Column(name = "id", length = 3, nullable = false)
    private String id;

    /**
     * 類型(0: 銀行/ 1: 信合社/ 2: 農會/ 3: 漁會/ 4: 郵局)
     *
     * @since 1.0.0
     */
    @Id
    @Enumerated
    @Column(name = "type", length = 1, nullable = false)
    private BankType type;

    /**
     * 金融機構
     *
     * @since 1.0.0
     */
    @Id
    @Column(name = "name", length = 40, nullable = false)
    private String name;
}
