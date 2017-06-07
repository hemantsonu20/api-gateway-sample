package com.github.swagger.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class SwaggerRedirectController {

    @RequestMapping(value = {"", "/swagger", "/docs"}, method = RequestMethod.GET)
    public String redirectSwagger() {

	return "redirect:/swagger-ui.html";
    }
}
