package com.itrail.graph.grafp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class GrafpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrafpApplication.class, args);
		log.info( "GRAFP START");
	}

}
