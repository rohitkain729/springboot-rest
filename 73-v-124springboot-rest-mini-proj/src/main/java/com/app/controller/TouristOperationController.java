package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Tourist;
import com.app.service.ITouristMgmtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/tourist")
@Tag(name = "Tourist",description = "Tourist Operations Controller")
public class TouristOperationController {

	@Autowired
	private ITouristMgmtService service;

	@PostMapping("/save")
	@Operation(summary = "save the toursit",description = "insert the tourist info")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201",description = "successful operation")
	})
	public ResponseEntity<String> saveTourist(@RequestBody Tourist t) {

		try {

			String msg = service.registerTourist(t);

			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

	@GetMapping("/all")
	public ResponseEntity<?> getAllTourist() {
		ResponseEntity<?> resp = null;
		try {
			List<Tourist> list = service.getAllTourist();
			return resp = new ResponseEntity<Object>(list, HttpStatus.OK);

		} catch (Exception e) {
			return resp = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/single/tourist/{id}")
	public ResponseEntity<Object> showTouristById(@PathVariable("id") Integer id) {
		ResponseEntity<Object> resp = null;
		try {
			Tourist tt = service.showTouristById(id);
			return resp = new ResponseEntity<Object>(tt, HttpStatus.OK);

		} catch (Exception e) {
			return resp = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update/tourist")
	public ResponseEntity<Object> updateTourist(@RequestBody Tourist tour) {
		ResponseEntity<Object> resp = null;
		try {

			String msg = service.updateTourist(tour);
			return resp = new ResponseEntity<Object>(msg, HttpStatus.OK);

		} catch (Exception e) {
			return resp = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/tourist/{id}")
	public ResponseEntity<Object> deleteTourist(@PathVariable Integer id) {
		ResponseEntity<Object> resp = null;
		try {

			String msg = service.deleteTouristById(id);
			return resp = new ResponseEntity<Object>(msg, HttpStatus.OK);

		} catch (Exception e) {
			return resp = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	public String updateTouristBudgetById(Integer id,double hikePercentage);
	@PatchMapping("/update/tourist/budget/{id}/{percentagehike}")
	public ResponseEntity<Object> updateTouristByBudget(@PathVariable Integer id, @PathVariable double percentagehike) {
		ResponseEntity<Object> resp = null;
		try {

			String msg = service.updateTouristBudgetById(id, percentagehike);
			return resp = new ResponseEntity<Object>(msg, HttpStatus.OK);

		} catch (Exception e) {
			return resp = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
