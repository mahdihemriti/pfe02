package tn.pfe.pfe02;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
@EnableProcessApplication
public class Pfe02Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Pfe02Application.class, args);
	}


}
