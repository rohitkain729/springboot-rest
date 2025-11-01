package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConsumerTestRunner2 implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		String basUrl = "http://localhost:4444/actor-api/report";
		ResponseEntity<String> responseEntity = template.getForEntity(basUrl, String.class);

		System.out.println(responseEntity.getBody());
	}

}
