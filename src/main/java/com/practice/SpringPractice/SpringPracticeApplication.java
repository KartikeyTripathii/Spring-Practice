package com.practice.SpringPractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringPracticeApplication {

	public static void main(String[] args) {
		
		ApplicationContext context= SpringApplication.run(SpringPracticeApplication.class, args);
		MyApp myApp= context.getBean(MyApp.class);
		myApp.run();
	}

}
