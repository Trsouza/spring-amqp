package com.trs.springamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableMongoRepositories
@SpringBootApplication
public class CashbackServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashbackServiceApplication.class, args);
	}

}
