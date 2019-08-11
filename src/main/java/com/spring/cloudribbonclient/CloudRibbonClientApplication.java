package com.spring.cloudribbonclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// This is extension of cloud-eureka-client3

@SpringBootApplication
@EnableDiscoveryClient
public class CloudRibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudRibbonClientApplication.class, args);
	}

//  This "LoadBalanced" RestTemplate 
	// is automatically hooked into Ribbon:
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
