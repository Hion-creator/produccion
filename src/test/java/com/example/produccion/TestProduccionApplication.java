package com.example.produccion;

import org.springframework.boot.SpringApplication;

public class TestProduccionApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProduccionApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
