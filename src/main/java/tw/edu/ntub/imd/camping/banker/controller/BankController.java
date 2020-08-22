package tw.edu.ntub.imd.camping.banker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.edu.ntub.imd.camping.banker.bean.BankBean;
import tw.edu.ntub.imd.camping.banker.service.BankService;
import tw.edu.ntub.imd.camping.banker.util.http.ResponseEntityBuilder;
import tw.edu.ntub.imd.camping.banker.util.json.object.ObjectData;

@RestController
@RequestMapping(path = "/bank")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping(path = "")
    public ResponseEntity<String> searchAll() {
        return ResponseEntityBuilder.success()
                .message("查詢成功")
                .data(bankService.searchAll(), this::addBankToObjectData)
                .build();
    }

    private void addBankToObjectData(ObjectData bankData, BankBean bank) {
        bankData.add("id", bank.getId());
        bankData.add("type", bank.getType().ordinal());
        bankData.add("name", bank.getName());
    }
}
