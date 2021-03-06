package com.ls.controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

//    @Value(value = "${swagger.package}")
//    private String swaggerPackage;
    
	//启动SpringBoot项目，访问 http://localhost:8081/spring-boot/swagger-ui.html
	//http://www.leftso.com/blog/402.html
    @Bean
    public Docket buildDocket() {
    	return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(buildApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ls.controller"))
				.paths(PathSelectors.any())
				.build();
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("网站平台API接口说明文档")
                .description("服务器地址：https://www.baidu.com/")
                .termsOfServiceUrl("https://www.baidu.com/")
                .version("1.0")
                .build();
    }
}