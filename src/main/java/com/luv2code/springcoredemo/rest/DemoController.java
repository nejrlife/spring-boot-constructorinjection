package com.luv2code.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.Coach;

@RestController
public class DemoController {
	//define a private field for the dependency
	
	private Coach myCoach;
	
	//define a constructore for dependency injection
	@GetMapping("/")
	public String hello() {
		return "hello world!";
	}
	
	@GetMapping("/getSomeString")
	public String getSomeString() {
		return "heroku time";
	}
	
	@Autowired
	public DemoController (@Qualifier("baseballCoach") Coach theCoach) {
		System.out.println("In construcor: " + getClass().getSimpleName());
		myCoach = theCoach;
	}
}
