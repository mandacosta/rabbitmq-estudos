package com.example.demo_rabbitmq_init_worker;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DemoRabbitmqInitWorkerApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoRabbitmqInitWorkerApplication.class, args);
		System.out.println("Rodando Worker");
	}

}
