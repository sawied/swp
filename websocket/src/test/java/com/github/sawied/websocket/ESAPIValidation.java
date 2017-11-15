package com.github.sawied.websocket;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.IntrusionException;
import org.owasp.esapi.errors.ValidationException;

public class ESAPIValidation {

	@Test
	public void test() {
		try {
			String creditCard=ESAPI.validator().getValidInput("CreditCard validation", "6225-0987-9876-4430", "CreditCard", 19, false);
			Assert.assertNotNull(creditCard);
		} catch (ValidationException e) {
			e.printStackTrace();
		} catch (IntrusionException e) {
			e.printStackTrace();
		}
	}

}
