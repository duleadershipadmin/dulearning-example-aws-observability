package com.dulearning.observability.aws.api;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cloudwatch.CloudWatchAsyncClient;

@SpringBootApplication
public class ApiApplication {

    @Bean
    public CloudWatchAsyncClient CloudWatchAsyncClient() {
        return CloudWatchAsyncClient
                .builder()
                .region(Region.US_WEST_1)
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
