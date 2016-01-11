package com.rules.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ComponentScan ("com.rules.mvc")
@EnableWebMvc
public class SpringConfig {
	
	/*@Bean
	 public UrlBasedViewResolver setupViewResolver() {
	   UrlBasedViewResolver resolver = new UrlBasedViewResolver();
	   resolver.setPrefix("/WEB-INF/views/");
	   resolver.setSuffix(".jsp");
	   resolver.setViewClass(JstlView.class);
	   return resolver;
	 }*/
	
	@Bean
    TilesViewResolver viewResolver(){
        TilesViewResolver viewResolver = new TilesViewResolver();
        /*viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);*/
        return viewResolver;
    }

    @Bean
    TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/layouts/tileLayout.xml","/WEB-INF/layouts/views.xml");
        tilesConfigurer.setPreparerFactoryClass(org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory.class);
        return tilesConfigurer;    
    }


}
