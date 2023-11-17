package com.cg.fas;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscoveryClient
public class ChatboxServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatboxServiceApplication.class, args);
	}

}
