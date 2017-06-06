package com.github.swagger.gateway.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SwaggerRedirectController {

    @RequestMapping("")
    public String redirectSwagger() {

	return "redirect:/swagger-ui.html";
    }
}
