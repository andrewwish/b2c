package com.andrewwish.b2c.sale.web;

import com.andrewwish.b2c.sale.service.ReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@AllArgsConstructor
public class ReportController {

    private ReportService reportService;

    @PostMapping(value = "/report-api/v1/reports")
    public ResponseEntity<String> saveObjectToS3(@RequestBody MultipartFile report) {
        log.info("Sending report to s3 storage");
        return ResponseEntity.ok().body(reportService.save(report));
    }

}
