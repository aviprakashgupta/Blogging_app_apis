//package com.example.blogapp.Config;
//
//import org.hibernate.internal.util.xml.XmlDocument;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SwaggerConfig {
//
//	@Bean
//	public Docket config() {
//		 return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo())
//				 .select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
//	}
//
//	private ApiInfo getInfo() {
//		return new ApiInfo("Blogging App APIs", "", null, null, null, null, null);
//	}
//	
//	
//}
