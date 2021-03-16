package com.pk.eis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableJms
@SpringBootApplication
@ComponentScan(basePackages = "com.pk.eis")
public class EisApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EisApplication.class, args);
		//log.info("");
	}

}
