package com.practice.springPractice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringPracticeApplication {


	private static final Logger logger= LoggerFactory.getLogger(SpringPracticeApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringPracticeApplication.class, args);
		logger.info("😎😎 "+"APPLICATION STARTED "+  " 😎😎");

	}

}
