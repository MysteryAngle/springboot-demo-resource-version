package com.example.demoresourceversion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.VersionResourceResolver;

/**
 * Configuration Resource
 */
@Configuration
public class ResourceConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .resourceChain(true)
                .addResolver(getVersionResourceResolver());
    }

    private ResourceResolver getVersionResourceResolver() {
        VersionResourceResolver resolver = new VersionResourceResolver();
        // Relative by above path (/static/**)
        // So if you write as '/static/**' will be replace to '/static/static/**'
        // Got it ?
//        resolver.addContentVersionStrategy("/static/**");

        // This is right
        resolver.addContentVersionStrategy("/**");
        return resolver;
    }
}
