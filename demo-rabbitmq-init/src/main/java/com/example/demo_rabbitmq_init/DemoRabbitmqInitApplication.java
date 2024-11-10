package com.example.demo_rabbitmq_init;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DemoRabbitmqInitApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRabbitmqInitApplication.class, args);
	}

}
