package com.github.sawied.jboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JbootApplication.class, args);
	}
}
