package com.github.swagger.product.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.github"))
		.paths(PathSelectors.ant("/products/**")).build();
    }

//    @Bean
//    FilterRegistrationBean corsFilter() {
//
//	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	CorsConfiguration config = new CorsConfiguration();
//	config.setAllowCredentials(Boolean.TRUE);
//	config.addAllowedOrigin("*");
//	config.addAllowedHeader("*");
//	config.addAllowedMethod("*");
//	source.registerCorsConfiguration("/**", config);
//
//	FilterRegistrationBean bean = new FilterRegistrationBean();
//	bean.setFilter(new CorsFilter(source));
//	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//	return bean;
//    }
}
