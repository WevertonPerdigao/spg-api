package br.com.sgp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SgpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgpApplication.class, args);
	}
}
