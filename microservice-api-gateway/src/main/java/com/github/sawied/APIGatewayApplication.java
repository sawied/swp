package com.github.sawied;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Spring boot launch
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class APIGatewayApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(APIGatewayApplication.class, args);
    }
}
