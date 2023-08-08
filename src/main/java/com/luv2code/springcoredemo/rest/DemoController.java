package com.luv2code.springcoredemo.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class DemoController {
	
	//define a constructore for dependency injection
	@GetMapping(path = "/", produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Hello World", description = "Hello worldy")
	public Map<String, String> hello() {
		
		HashMap<String, String> map = new HashMap<>();
	    map.put("Status", "OK");
	    map.put("StatusCode", "200");
        
        return map;
	}
	
	@GetMapping(path = "/getAString", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get String", description = "Get a randoms string")
	public Map<String, String> getAString(@Parameter(description = "Object to add.", required = true,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema=@Schema(implementation = ReqBody.class))) ReqBody body) {
		HashMap<String, String> map = new HashMap<>();
		map.put("Status", "OK");
	    map.put("StatusCode", "200");
	    map.put("Message", body != null && body.getMyFile() != null ? body.getMyFile() : "null value");
        
        return map;
	}
	
	@Autowired
	public DemoController () {
		System.out.println("In construcor: ");
	}
	
	public class ReqBody {
		private String myFile;
		
		public String getMyFile () {
	        return myFile;
	    }

	    public void setMyFile (String myFile) {
	    	this.myFile = myFile;
	    }
	}
}
