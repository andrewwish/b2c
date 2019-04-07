package com.andrewwish.b2c.cust.service;

import com.andrewwish.b2c.cust.domain.AgreementEntity;
import com.andrewwish.b2c.cust.domain.AgreementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AgreementService {

    private AgreementRepository agreementRepository;

    public AgreementEntity getAgreement(long id) {
        return agreementRepository.findById(id).orElse(null);
    }

    public AgreementEntity createAgreement(AgreementEntity agreement) {
        return agreementRepository.save(agreement);
    }
}
