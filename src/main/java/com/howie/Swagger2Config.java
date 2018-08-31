package com.howie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

	@Bean
	public Docket payApi(){
		return new Docket(DocumentationType.SWAGGER_2)
        .groupName("支付接口文档")  
        .apiInfo(apiInfo())
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.howie.pay.controller"))
		.paths(PathSelectors.any())
		.build();
	}
	
	public Docket webApi(){
		return new Docket(DocumentationType.SWAGGER_2)
        .groupName("测试接口文档")  
        .apiInfo(apiInfo())
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.howie.domain.controller"))
		.paths(PathSelectors.any())
		.build();
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
		.title("Spring-Boot-Test")
		.description("测试SpringBoot")
		//.termsOfServiceUrl("http://blog.52itstyle.com")
		.contact(new Contact("j.howie","It's a secret!","j.howie1995@outlook.com"))
		.version("1.0")
		.build();
	}
	
}
