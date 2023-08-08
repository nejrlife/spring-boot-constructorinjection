package com.luv2code.springcoredemo.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class DemoController {
	
	//define a constructore for dependency injection
	@GetMapping(path = "/", produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Hello World", description = "Hello worldy")
	@Description(value = "This is just a hello worldy")
	public Map<String, String> hello() {
		
		HashMap<String, String> map = new HashMap<>();
	    map.put("Status", "OK");
	    map.put("StatusCode", "200");
        
        return map;
	}
	
	@GetMapping(path = "/getAString", produces=MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Get String", description = "Get a random string")
	@Description(value = "This is just to get a random string.")
	public TableWrapper getAString() {
	    
	    TableRow r1 = new TableRow();
	    r1.setEmail("nixonedora@ibm.com");
	    r1.setProjectId("123451");
	    
	    TableRow r2 = new TableRow();
	    r2.setEmail("sampleemail2@sample2.com");
	    r2.setProjectId("123452");
	    
        List<TableRow> listy = new ArrayList<TableRow>();
        listy.add(r1);
        listy.add(r2);
        
        TableWrapper tw = new TableWrapper();
        tw.setTrList(listy);
        
        return tw;
	}
	
	@Autowired
	public DemoController () {
		System.out.println("In construcor: ");
	}
	
	public class TableWrapper {
		private List<TableRow> trList;
		
		public void setTrList(List<TableRow> trList) {
			this.trList = trList;
	     }
		
		public List<TableRow> getTrList() {
	         return this.trList;
	     }
	}
	
	public class TableRow {
		private String email;
		private String projectId;
		
		public void setEmail(String email) {
			this.email = email;
	     }
		public void setProjectId(String projectId) {
			this.projectId = projectId;
	     }
		
		public String getEmail() {
	         return this.email;
	     }
		
		public String getProjectId() {
	         return this.projectId;
	     }

	}
}
