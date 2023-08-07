package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.Coach;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class DemoController {
	//define a private field for the dependency
	
	private Coach myCoach;
	
	//define a constructore for dependency injection
	@GetMapping("/")
	@Operation(summary = "Hello World", description = "Hello worldy")
	@Description(value = "This is just a hello worldy")
	public String hello() {
		return "hello world!";
	}
	
	@GetMapping("/getAString")
	@Operation(summary = "Get String", description = "Get a random string")
	@Description(value = "This is just to get a random string.")
	public String getAString() {
		return "sample string";
	}
	
	@Autowired
	public DemoController (@Qualifier("baseballCoach") Coach theCoach) {
		System.out.println("In construcor: " + getClass().getSimpleName());
		myCoach = theCoach;
	}
}
