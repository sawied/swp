package com.github.sawied.jboot;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.github.sawied.jboot.apis.TransactionController;
import com.github.sawied.jboot.jpa.Transaction;
import com.github.sawied.jboot.jpa.TransactionRepository;
import com.github.sawied.microservice.transaction.api.model.BusinessTransaction;

@RunWith(SpringJUnit4ClassRunner.class)
@JsonTest
public class DemoApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private JacksonTester<BusinessTransaction> json;

	@Before
	public void setup() {
		Transaction transaction = new Transaction();
		transaction.setId(1L);
		transaction.setName("transaction_name");
		TransactionRepository repository = mock(TransactionRepository.class);
		when(repository.save(org.mockito.Matchers.any(Transaction.class))).thenReturn(transaction);
		this.mockMvc = MockMvcBuilders.standaloneSetup(new TransactionController(repository)).build();
	}

	@Test
	public void create_transaction_success() throws IOException, Exception {
		BusinessTransaction bt = new BusinessTransaction();
		bt.setName("Test Transaction");
		mockMvc.perform(post("/transactions").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
				.content(json.write(bt).getJson())).andExpect(status().is(200)).andDo(print());
	}

}
