package com.github.sawied.jboot.apis;


import com.github.sawied.jboot.jpa.Transaction;
import com.github.sawied.jboot.jpa.TransactionRepository;
import com.github.sawied.microservice.transaction.api.TransactionService;
import com.github.sawied.microservice.transaction.api.model.BusinessTransaction;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class TransactionController implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<BusinessTransaction> listTransaction(){
    	List<Transaction> tls=transactionRepository.findAll();
    	Iterator<Transaction> it = tls.iterator();
    	List<BusinessTransaction> bts=new ArrayList<BusinessTransaction>(tls.size());
    	while(it.hasNext()) {
    		Transaction t = it.next();
    		BusinessTransaction bt = new BusinessTransaction();
    		BeanUtils.copyProperties(t, bt);
    		bts.add(bt);
    	}
        return bts;
    }

	@Override
	public BusinessTransaction save(BusinessTransaction bt) {
		Transaction t = new Transaction();
		t.setName(bt.getName());
	    transactionRepository.save(t);
	    bt.setId(t.getId());
		return bt;
	}

}
