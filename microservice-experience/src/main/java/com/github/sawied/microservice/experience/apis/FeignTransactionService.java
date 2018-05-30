package com.github.sawied.microservice.experience.apis;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.github.sawied.microservice.transaction.api.TransactionService;

@FeignClient("microservice-jboot")
public interface FeignTransactionService extends TransactionService {

}

