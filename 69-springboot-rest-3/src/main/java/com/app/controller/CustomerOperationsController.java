package com.app.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Address;
import com.app.model.Company;
import com.app.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {
	
	
//	for gettting data in xml or json use below dependency
//	<dependency>
//	<groupId>com.fasterxml.jackson.dataformat</groupId>
//	<artifactId>jackson-dataformat-xml</artifactId>
//	<version>2.19.2</version>
//</dependency>


	@GetMapping("/report")
	public ResponseEntity<Customer> showReport() {
		
		Address ad = new Address()
				.builder()
				.adPincode("434343")
				.adPlace("New Delhi")
				.aid(4343)
				.area("India Gate")
				.build();
		
		Company com = new Company().builder().cid(4343).compName("Tech Mahindra").location(ad).size(25).build();
		
		Customer c = new Customer().builder().cname("rohit").cadd("India").billAmt(2565.79f).cno(11).friends(List.of("raja","rauneet","priyanshi","ragini"))
				.idDetails(Map.of("adhar-card", 54545445, "driving license", "dl7877870", "pan card", "34343555fl"))
				.phones(Set.of(3333333333333l,6666666666l))
				.company(com).build();
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@GetMapping("/report2")
	public ResponseEntity<List<Customer>> showReport2(){
		Address ad = new Address()
				.builder()
				.adPincode("434343")
				.adPlace("New Delhi")
				.aid(4343)
				.area("India Gate")
				.build();
		Company com = new Company().builder().cid(4343).compName("Tech Mahindra").location(ad).size(25).build();
		
		Customer c = new Customer().builder().cname("rohit").cadd("India").billAmt(2565.79f).cno(11).friends(List.of("raja","rauneet","priyanshi","ragini"))
				.idDetails(Map.of("adhar-card", 54545445, "driving license", "dl7877870", "pan card", "34343555fl"))
				.phones(Set.of(3333333333333l,6666666666l))
				.company(com).build();
		Customer c2 = new Customer().builder().cname("rohit").cadd("India").billAmt(2565.79f).cno(11).friends(List.of("raja","rauneet","priyanshi","ragini"))
				.idDetails(Map.of("adhar-card", 54545445, "driving license", "dl7877870", "pan card", "34343555fl"))
				.phones(Set.of(3333333333333l,6666666666l))
				.company(com).build();
		return new ResponseEntity<List<Customer>>(List.of(c,c2), HttpStatus.OK);
	}
	
}
