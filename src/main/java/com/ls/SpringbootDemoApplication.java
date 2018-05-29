package com.ls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.ls.controller"})
@RestController
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);

		// 修改Banner的模式为OFF
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootDemoApplication.class);
//		builder.bannerMode(Banner.Mode.OFF).run(args);
	}
	
    @RequestMapping(value = "/bbb",produces = "text/plain;charset=UTF-8")
	String index() {
		  return "Hello Spring Boot2222222222222223333333333333333!";
    }
}
