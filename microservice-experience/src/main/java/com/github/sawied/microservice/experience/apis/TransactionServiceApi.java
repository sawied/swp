package com.github.sawied.microservice.experience.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.sawied.microservice.transaction.api.model.BusinessTransaction;

@RestController
@RequestMapping("/transactions")
public class TransactionServiceApi {

	@Autowired
	private FeignTransactionService ts;
	
	@RequestMapping(method=RequestMethod.PUT)
	public BusinessTransaction createTransaction(@RequestBody BusinessTransaction t) {
		return ts.save(t);
	}
	
}
