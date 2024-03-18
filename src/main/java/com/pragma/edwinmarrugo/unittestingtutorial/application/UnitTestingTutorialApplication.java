package com.pragma.edwinmarrugo.unittestingtutorial.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pragma.edwinmarrugo.unittestingtutorial")
public class UnitTestingTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingTutorialApplication.class, args);
	}

}
