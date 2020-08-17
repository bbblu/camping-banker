package tw.edu.ntub.imd.camping.banker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ntub.imd.camping.banker.bean.CreditCardBean;
import tw.edu.ntub.imd.camping.banker.service.CreditCardService;
import tw.edu.ntub.imd.camping.banker.util.http.BindingResultUtils;
import tw.edu.ntub.imd.camping.banker.util.http.ResponseEntityBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/credit-card")
public class CreditCardController {
    private final CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @PostMapping(path = "")
    public ResponseEntity<String> create(@RequestBody @Valid CreditCardBean creditCardBean, BindingResult bindingResult) {
        BindingResultUtils.validate(bindingResult);
        creditCardService.save(creditCardBean);
        return ResponseEntityBuilder.success().message("新增成功").build();
    }
}
