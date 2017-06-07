package com.github.swagger.gateway;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@SpringBootApplication
@EnableSwagger2
@EnableZuulProxy
public class GatewayServiceApplication {

    public static void main(String[] args) {

	SpringApplication.run(GatewayServiceApplication.class, args);
    }

    @Bean
    public ZuulFilter requestLoggingFilter() {

	return new RequestLoggingFilter();
    }

    public static class RequestLoggingFilter extends ZuulFilter {

	private static final Logger LOG = LoggerFactory.getLogger(RequestLoggingFilter.class);

	@Override
	public Object run() {

	    HttpServletRequest req = RequestContext.getCurrentContext().getRequest();

	    LOG.info("{} {}", req.getMethod(), req.getRequestURI());
	    return null;
	}

	@Override
	public boolean shouldFilter() {

	    return true;
	}

	@Override
	public int filterOrder() {

	    return 0;
	}

	@Override
	public String filterType() {

	    return "pre";
	}
    }
}
