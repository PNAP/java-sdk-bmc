package com.pnap.bmc_sdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App {
	

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);			
	}

	private static Class<App> applicationClass = App.class;

}
