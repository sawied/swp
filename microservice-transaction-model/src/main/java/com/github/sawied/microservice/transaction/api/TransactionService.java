package com.github.sawied.microservice.transaction.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.sawied.microservice.transaction.api.model.BusinessTransaction;

@RequestMapping("/transactions")
public interface TransactionService {

	@RequestMapping(name = "/", method = RequestMethod.POST)
	BusinessTransaction save(@RequestBody BusinessTransaction t);

	@RequestMapping(name = "/", method = RequestMethod.GET)
	public List<BusinessTransaction> listTransaction();

}
