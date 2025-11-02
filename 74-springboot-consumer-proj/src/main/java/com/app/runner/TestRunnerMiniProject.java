package com.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.model.Tourist;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TestRunnerMiniProject implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	static String urlsave = "http://localhost:4444/tourist/save";
	static String urlfetchOne = "http://localhost:4444/tourist/single/tourist/{id}";
	static String urlAll = "http://localhost:4444/tourist/all";
	static String urlUpdate = "http://localhost:4444/tourist/update/tourist";
	static String urlDelete = "http://localhost:4444/tourist/delete/tourist/{id}";

	@SuppressWarnings("unchecked")
	@Override
	public void run(String... args) throws Exception {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<>(headers);

		// all
		try {
			ResponseEntity<String> response = template.exchange(urlAll, HttpMethod.GET, request, String.class);

			String json_body = response.getBody();
			ObjectMapper om = new ObjectMapper();

			List<Tourist> list = om.readValue(json_body, new TypeReference<List<Tourist>>() {
			});
			list.forEach(System.out::println);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// save

		System.out.println("---------------save operation----------------------");
//		try {
//
//			String json_body_save = "{\"tname\":\"preety devi\",\"taddrs\":\"banglore\",\"plan\":\"9D-8N\",\"budget\": 8500.00}";
//			HttpEntity<String> request__data = new HttpEntity<>(json_body_save, headers);
//
//			ResponseEntity<String> respone_Save = template.exchange(urlsave, HttpMethod.POST, request__data,
//					String.class);
//
//			System.out.println(respone_Save.getBody());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}

		System.out.println("---------------------get by id-------------------");
		
		System.out.println("---------------Fetch By ID----------------------");
		try {

//			String json_body_save = "{\"tid\":\"0\",\"tname\":\"rama devi\",\"taddrs\":\"banglore\",\"plan\":\"9D-8N\",\"budget\": 8500.00}";
//			HttpEntity<String> request__fe = new HttpEntity<>( headers);

			ResponseEntity<String> respone_fetch_id = template.exchange(urlfetchOne, HttpMethod.GET, request,
					String.class,30);

			System.out.println(respone_fetch_id.getBody());

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
