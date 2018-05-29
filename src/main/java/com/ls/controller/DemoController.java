package com.ls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ls.utils.BookBean;

@RestController
public class DemoController {

	@Value(value = "${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;
    @Value("${book.pinyin}")
    private String bookPinYin;
    
    @Autowired
    private BookBean bookBean;
    
    @RequestMapping(value = "/getProper1",produces = "text/plain;charset=UTF-8")
	String getProper1() {
    	return "方法1：通过@Value获取： "+bookName+";and Book Author is "+bookAuthor+";and Book PinYin is "+bookPinYin;
    }
    
    
    @RequestMapping(value = "/getProper2",produces = "text/plain;charset=UTF-8")
	String getProper2() {
    	return "方法1：通过@ConfigurationProperties封装成bean获取： "+bookBean.getName()+";and Book Author is "+bookBean.getAuthor()+";and Book price is "+bookBean.getPrice();
    }
}
