package com.app.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Template;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

//@Service
public class ActorApiConsumerTestRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void run(String... args) throws Exception {

		RestTemplate rest = new RestTemplate();
//		String baseurl = "http://localhost:4444/actor-api/wish/{id}/{name}";
		String baseurl = "http://localhost:4444/actor-api/save";
//		ResponseEntity<String> response = rest.getForEntity(baseurl, String.class);
//		System.out.println(response.getBody()+"  "+response.getStatusCodeValue());

//		String data = rest.getForObject(baseurl, String.class);
//		System.out.println(data);

//		MultiValueMap<String, String> headers = new 
//
//		HttpEntity<?> entity = new HttpEntity<>(null)

//		ResponseEntity<String> data = rest.exchange(baseurl, HttpMethod.GET, null, String.class, Map.of("id",11,"name","rohit_verma"));
//		System.out.println(data.getBody());

		String jsonbody = "{\"id\":\"11\",\"name\":\"rohit\",\"addrs\":\"gwalior\",\"fee\":\"2500.00\",\"category\":\"sc\"}";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
//		RequestEntity<String> request = new RequestEntity<>(jsonbody, );
		HttpEntity<String> entity = new HttpEntity<>(jsonbody,header);
		ResponseEntity<String> responsebody = restTemplate.exchange(baseurl, HttpMethod.POST, entity, String.class);

		System.out.println(responsebody.getBody());
		
		
//		rest.getForObject(null, null)

	
	}

}
