package com.bunactutorials.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


// COMMENT OUT THIS FOR NOW, WE ARE USING THEMELEAF
//@EnableWebMvc
//@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {


    @Bean
    public ViewResolver internalResourceViewResolver() {
        /* Note: /WEB-INF/views must be located nuder main folder along with java
        folder and resource folder*/

        InternalResourceViewResolver viewResolverBean = new InternalResourceViewResolver();
        viewResolverBean.setViewClass(JstlView.class);
        viewResolverBean.setPrefix("/WEB-INF/views/");
        viewResolverBean.setSuffix(".jsp");
        return viewResolverBean;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/jsp/**")
                .addResourceLocations("classpath:/WEB-INF/views/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login.html").setViewName("login");

        registry.addViewController("/sample").setViewName("sample");
        registry.addViewController("/").setViewName("sample");
        registry.addViewController("/login").setViewName("login");
        //Note: you can add this overridden method or go to SampleController and uncomment the reqeust for login
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login.html");
////        registry.addViewController("/login.html").setViewName("login");
//
////        registry.addViewController("/home").setViewName("myhome");
////        registry.addViewController("/hello").setViewName("helloworld");
////        registry.addRedirectViewController("/home", "/hello");
////        registry.addStatusController("/detail", HttpStatus.BAD_REQUEST);
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("swagger-ui.html")
////                .addResourceLocations("classpath:/META-INF/resources/");
////
////        registry.addResourceHandler("/webjars/**")
////                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//        //additional resources added
//        registry.addResourceHandler(
//                "/css/**",
//                "/js/**")
//                .addResourceLocations(
//                        "classpath:/static/css/",
//                        "classpath:/static/js/");
//        //additional resources added
//        registry.addResourceHandler(
//                "/jsp/**")
//                .addResourceLocations(
//                        "classpath:/WEB-INF/jsp/");
//
//        registry.addResourceHandler("/**")
//                .addResourceLocations("/");
//    }
//
//
//
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }
    @Bean
    public InternalResourceViewResolver viewResolver() {
        // added ViewResolver to view JSP pages
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}
