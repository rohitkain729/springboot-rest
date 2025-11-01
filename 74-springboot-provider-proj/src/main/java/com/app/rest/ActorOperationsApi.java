package com.app.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Actor;

@RestController
@RequestMapping("actor-api")
public class ActorOperationsApi {

	@GetMapping("/wish")
	public ResponseEntity<String> showDisplayMessage() {
		return new ResponseEntity<String>("good morning", HttpStatus.OK);
	}

	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> showDisplayMessage(@PathVariable String id, @PathVariable String name) {
		return new ResponseEntity<String>("good morning::" + id + "......" + name, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor) {
		System.out.println("actor obj data" + actor);
		return new ResponseEntity<String>(actor.toString(), HttpStatus.CREATED);
	}

	@GetMapping("/report")
	public ResponseEntity<Actor> showData() {
		
		Actor ac = new Actor(11, "rohit", "india", 4500.00, "hero");

		return new ResponseEntity<Actor>(ac, HttpStatus.OK);
	}

}
