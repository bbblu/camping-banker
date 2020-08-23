package tw.edu.ntub.imd.camping.banker.bean;

import lombok.Data;
import tw.edu.ntub.imd.camping.banker.databaseconfig.enumerate.BankType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
public class BankAccountBean {
    @NotBlank(message = "帳號 - 未填寫")
    @Pattern(regexp = "^[0-9]{10,16}$", message = "帳號 - 應為10到16個字")
    private String account;
    @Size(max = 3, message = "銀行代號 - 輸入字數大於{max}個字")
    private String bankId;
    private BankType bankType;
    @Size(max = 40, message = "金融機構名稱 - 輸入字數大於{max}個字")
    private String bankName;
    @PositiveOrZero(message = "餘額 - 應大於等於0")
    private Integer money;
}
