package com.ls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.ls.controller"})
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);

		// 修改Banner的模式为OFF
//		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootDemoApplication.class);
//		builder.bannerMode(Banner.Mode.OFF).run(args);
	}
	
}
