package com.fastcampus.programming.dmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Developer class(entity Type)의 createdAt, updatedAt 기능 활용 시, Spring의 Auditing 기능 사용.
 */
@EnableJpaAuditing
@SpringBootApplication
public class DmakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DmakerApplication.class, args);
	}

}
