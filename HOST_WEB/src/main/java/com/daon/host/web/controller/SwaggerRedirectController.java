package com.daon.host.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@RequestMapping("/api/document")
@ApiIgnore
public class SwaggerRedirectController {

    @GetMapping
    public String swaggerUrlRedirect(){
    	
    	return "redirect:/swagger-ui/index.html"; 
    }
}