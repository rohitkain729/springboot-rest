package com.app.controller;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.repo.EmpRepo;

@RestController
@RequestMapping("/wish/v1")
public class WishMessageOperationController {

	@Autowired
	private EmpRepo repo;

	@GetMapping("/greet")
	public ResponseEntity<String> showWishMessage() {
		LocalTime lt = LocalTime.now();
		int hour = lt.getHour();
		String msg = null;
		try {
			if (hour < 12) {
				msg = "Good morning";
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			} else if (hour < 16) {
				msg = "good afternoon";
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			} else if (hour < 20) {
				msg = "good evening";
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			} else {
				msg = "good night";
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}

	}

	@GetMapping("/emps")
	public List<Employee> showData() {
		return repo.findAll();
	}

}
