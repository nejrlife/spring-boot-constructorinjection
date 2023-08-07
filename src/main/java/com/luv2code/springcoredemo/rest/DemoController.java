package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public String hello() {
		return "hello world!";
	}
	
	@GetMapping("/getSomeString")
	@Operation(summary = "Get Some String", description = "Get some random string")
	public String getSomeString() {
		return "heroku time";
	}
	
	@Autowired
	public DemoController (@Qualifier("baseballCoach") Coach theCoach) {
		System.out.println("In construcor: " + getClass().getSimpleName());
		myCoach = theCoach;
	}
}
