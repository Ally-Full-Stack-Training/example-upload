package com.ironyard.movies;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

    // important this ends with a trailing '/'
    public static String IMG_DIRECTORY = "/data/img/";

    public static String IMG_CONTEXT_PATH = "/img/";
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        //configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(IMG_CONTEXT_PATH+"**").addResourceLocations("file:"+IMG_DIRECTORY);
    }
}