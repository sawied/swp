package com.github.sawied;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.config.EnableWebFlux;


/**
 * Spring boot launch 
 * 
 * Spring Api gateway required netty runtime and not support tradition Servlet container 
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableWebFlux
public class APIGatewayApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(APIGatewayApplication.class, args);
    }

}
