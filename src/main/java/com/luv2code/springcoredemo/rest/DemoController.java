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

import com.luv2code.springcoredemo.common.TableRow;
import com.luv2code.springcoredemo.common.TableWrapper;

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
	    r1.setStatus("Approved");
	    r1.setId("CTLKTQ00000577");
	    r1.setRevision(7);
	    r1.setName("AG Audit Services - IBM");
	    r1.setCw_ccr("CW161439");
	    r1.setStartDate("1/1/2021");
	    r1.setEndDate("12/31/2024");
	    r1.setOwnerEmail("Anna.M.Shivers@lumen.com");
	    r1.setOwnerName("Anna");
	    r1.setProgramConsultant("Alexis Herrera");
	    r1.setWithActiveWorkers("Yes");
	    r1.setAccountID("WFKDX");
	    r1.setDataExtract("");
	    r1.setManualUpdate("");
	    
	    TableRow r2 = new TableRow();
	    r2.setStatus("Approved");
	    r2.setId("CTLKTQ00000599");
	    r2.setRevision(9);
	    r2.setName("IBM WTX Staffing SOW");
	    r2.setCw_ccr("CW158709");
	    r2.setStartDate("2/1/2021");
	    r2.setEndDate("12/31/2023");
	    r2.setOwnerEmail("Beth.Gonzalez@lumen.com");
	    r2.setOwnerName("Beth");
	    r2.setProgramConsultant("Marina Sanchez");
	    r2.setWithActiveWorkers("Yes");
	    r2.setAccountID("WPR4X");
	    r2.setDataExtract("");
	    r2.setManualUpdate("");
	    
        List<TableRow> listy = new ArrayList<TableRow>();
        listy.add(r1);
        listy.add(r2);
        
        TableWrapper tw = new TableWrapper();
        tw.setExpiringProjects(listy);
        
        return tw;
	}
	
	@Autowired
	public DemoController () {
		System.out.println("In construcor: ");
	}
}
