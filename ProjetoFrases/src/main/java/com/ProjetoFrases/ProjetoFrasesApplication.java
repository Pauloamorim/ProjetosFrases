package com.ProjetoFrases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ProjetoFrasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoFrasesApplication.class, args);
	}
	
	@Configuration
	public static class MvcConfig extends WebMvcConfigurerAdapter{
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/index");
		}
	}
}
