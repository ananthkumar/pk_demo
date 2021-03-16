package com.pk.eis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableJms
@SpringBootApplication(scanBasePackages = "com.pk.eis")
public class EisApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EisApplication.class, args);
	}

}
