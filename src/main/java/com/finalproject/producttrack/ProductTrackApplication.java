package com.finalproject.producttrack;

import com.finalproject.producttrack.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProductTrackApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ProductTrackApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductTrackApplication.class, args);
	}
}
