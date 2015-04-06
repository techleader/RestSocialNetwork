package com.social.network.service;

import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.SpringBootServletInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;

public class HelloWebXml extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}