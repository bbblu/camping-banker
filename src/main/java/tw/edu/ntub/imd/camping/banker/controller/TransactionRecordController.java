package tw.edu.ntub.imd.camping.banker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tw.edu.ntub.imd.camping.banker.bean.TransactionRecordBean;
import tw.edu.ntub.imd.camping.banker.service.TransactionRecordService;
import tw.edu.ntub.imd.camping.banker.util.http.BindingResultUtils;
import tw.edu.ntub.imd.camping.banker.util.http.ResponseEntityBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionRecordController {
    private final TransactionRecordService transactionRecordService;

    public TransactionRecordController(TransactionRecordService transactionRecordService) {
        this.transactionRecordService = transactionRecordService;
    }

    @PostMapping(path = "")
    public ResponseEntity<String> create(
            @RequestBody @Valid TransactionRecordBean transactionRecordBean,
            BindingResult bindingResult
    ) {
        BindingResultUtils.validate(bindingResult);
        transactionRecordService.save(transactionRecordBean);
        return ResponseEntityBuilder.success().message("交易成功").build();
    }

    @PostMapping(path = "/{id}/debit")
    public ResponseEntity<String> updateDebit(@PathVariable(name = "id") @Positive(message = "編號 - 應為大於0的數字") Integer id) {
        transactionRecordService.updateDebitToTrue(id);
        return ResponseEntityBuilder.success().message("扣款成功").build();
    }
}
