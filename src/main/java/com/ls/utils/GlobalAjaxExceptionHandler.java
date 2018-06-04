package com.ls.utils;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalAjaxExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		System.out.println("====================="+e.getMessage());
		return "{status:500}";
	}

}