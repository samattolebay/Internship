package com.example.maildiscoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MailDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailDiscoveryServerApplication.class, args);
	}

}
