package com.andrewwish.b2c.sale.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class S3BucketService {

    private final AmazonS3 s3;
    private final String BUCKET_URL = "spelmegov-bucket-1";

    public S3BucketService(AmazonS3 s3) {
        this.s3 = s3;
    }

    @SneakyThrows
    public String save(MultipartFile report) {
        String fileName = prepareFileName(report);
        log.info("Storing file with name = {}", fileName);

        s3.putObject(
                BUCKET_URL,
                fileName,
                new ByteArrayInputStream(createMetadata(report)),
                new ObjectMetadata()
        );
        return getCreatedFilePath(fileName);
    }

    private String prepareFileName(MultipartFile report) {
        String originalFileName = Optional.ofNullable(report.getOriginalFilename()).orElseThrow(IllegalArgumentException::new);
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        return UUID.randomUUID().toString().replace("-", "") + fileExtension;
    }

    private String getCreatedFilePath(String fileName) {
        GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(BUCKET_URL, fileName);
        return s3.generatePresignedUrl(urlRequest).toString();
    }

    private byte[] createMetadata(MultipartFile report) throws IOException {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(report.getContentType());
        byte[] bytes = report.getBytes();
        metadata.setContentLength(bytes.length);
        return bytes;
    }
}
