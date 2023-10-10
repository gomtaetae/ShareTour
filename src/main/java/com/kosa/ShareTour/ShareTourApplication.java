package com.kosa.ShareTour;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//exclude를 통해서 spring security 일시정지 시킴
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ShareTourApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareTourApplication.class, args);
	}

}
