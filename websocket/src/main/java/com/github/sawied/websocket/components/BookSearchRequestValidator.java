package com.github.sawied.websocket.components;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.github.sawied.websocket.beans.BookSearchRequest;

public final class BookSearchRequestValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls) {
		return BookSearchRequest.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
		BookSearchRequest request = (BookSearchRequest)obj;
		if(request.getUseDate()!=null && request.getUseDate()){
			ValidationUtils.rejectIfEmpty(e, "date", "date.empty");
		}
	}
}