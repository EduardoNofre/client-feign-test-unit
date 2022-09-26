package br.com.client.feign.unit.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClientFeignTestUnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientFeignTestUnitApplication.class, args);
	}

}
