package com.andrewwish.b2c.sale.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ReportService {

    private final S3BucketService s3BucketService;

    public ReportService(S3BucketService s3BucketService) {
        this.s3BucketService = s3BucketService;
    }

    public String save(MultipartFile report) {
        return s3BucketService.save(report);
    }

}
