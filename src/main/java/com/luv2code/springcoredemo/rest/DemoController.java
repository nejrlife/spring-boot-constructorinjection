package com.luv2code.springcoredemo.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springcoredemo.common.Coach;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class DemoController {
	//define a private field for the dependency
	
	private Coach myCoach;
	
	//define a constructore for dependency injection
	@GetMapping(path = "/", produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Hello World", description = "Hello worldy")
	@Description(value = "This is just a hello worldy")
	public Map<String, String> hello() {
		
		HashMap<String, String> map = new HashMap<>();
	    map.put("key", "value");
	    map.put("foo", "bar");
	    map.put("aa", "bb");
        
        return map;
	}
	
	@GetMapping(path = "/getAString", produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get String", description = "Get a random string")
	@Description(value = "This is just to get a random string.")
	public Map<String, String> getAString() {
		HashMap<String, String> map = new HashMap<>();
	    map.put("key", "value");
	    map.put("foo", "bar");
	    map.put("getAString", "getAString");
        
        return map;
	}
	
	@Autowired
	public DemoController (@Qualifier("baseballCoach") Coach theCoach) {
		System.out.println("In construcor: " + getClass().getSimpleName());
		myCoach = theCoach;
	}
}
