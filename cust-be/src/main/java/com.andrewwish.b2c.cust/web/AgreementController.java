package com.andrewwish.b2c.cust.web;

import com.andrewwish.b2c.cust.domain.AgreementEntity;
import com.andrewwish.b2c.cust.service.AgreementService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AgreementController {

    private AgreementService agreementService;

    @GetMapping("/api/v1/agreements/{id}")
    public AgreementEntity getAgreement(@PathVariable long id) {
        return agreementService.getAgreement(id);
    }

    @PostMapping("/api/v1/agreements")
    public AgreementEntity postAgreement(@RequestBody AgreementEntity agreement) {
        return agreementService.createAgreement(agreement);
    }
}
