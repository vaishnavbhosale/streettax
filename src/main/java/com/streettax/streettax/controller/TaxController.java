package com.streettax.streettax.controller;

import com.streettax.streettax.dto.TaxCalculationRequest;
import com.streettax.streettax.dto.TaxCalculationResponse;
import com.streettax.streettax.service.TaxService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tax")
public class TaxController {

    private final TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping("/calculate")
    public TaxCalculationResponse calculateTax(
            @RequestBody TaxCalculationRequest request){
        return taxService.calculateTax(request);
    }
}
