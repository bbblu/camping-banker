package tw.edu.ntub.imd.camping.banker.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.YearMonth;

@Data
@EqualsAndHashCode
public class CreditCardBean {
    @NotBlank(message = "信用卡卡號 - 未填寫")
    @Size(min = 16, max = 16, message = "信用卡卡號 - 應為16個字")
//    @CreditCardNumber(message = "信用卡卡號 - 格式不符")
    private String cardId;

    @NotBlank(message = "安全碼 - 未填寫")
    @Size(min = 3, max = 4, message = "安全碼 - 應為{min}到{max}個字")
    private String safeCode;

    @NotNull(message = "過期時間 - 未填寫")
    @Future(message = "過期時間 - 應為未來時間")
    private YearMonth expireDate;
}
