package com.andrewwish.b2c.sale.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(value = "s3")
public class S3Properties {

    private String secretKey;
    private String accessKey;
    private String endpoint;
    private String region;
}
