package tw.edu.ntub.imd.camping.banker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ntub.imd.camping.banker.bean.BankAccountBean;
import tw.edu.ntub.imd.camping.banker.service.BankAccountService;
import tw.edu.ntub.imd.camping.banker.util.http.BindingResultUtils;
import tw.edu.ntub.imd.camping.banker.util.http.ResponseEntityBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/bank-account")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping(path = "")
    public ResponseEntity<String> create(
            @RequestBody @Valid BankAccountBean bankAccount,
            BindingResult bindingResult
    ) {
        BindingResultUtils.validate(bindingResult);
        bankAccountService.save(bankAccount);
        return ResponseEntityBuilder.success()
                .message("新增成功")
                .build();
    }
}
