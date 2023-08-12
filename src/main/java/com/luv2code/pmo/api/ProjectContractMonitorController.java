package com.luv2code.pmo.api;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Description;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.pmo.domain.ExpiringProjectsWrapper;
import com.luv2code.pmo.domain.FileResponseWrapper;
import com.luv2code.pmo.domain.Project;
import com.luv2code.pmo.service.ProjectContractMonitorSvc;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "api/v1/project")
public class ProjectContractMonitorController {

    private final ProjectContractMonitorSvc pcmSvc;

    public ProjectContractMonitorController(@Qualifier(value = "impl") ProjectContractMonitorSvc pcmSvc) {
        this.pcmSvc = pcmSvc;
    }

    @GetMapping(path = "/expiring-list", produces=MediaType.APPLICATION_JSON_VALUE)
  	@Operation(summary = "Get Expiring Projects List", description = "Get expiring projects list")
  	@Description(value = "This is just to get the expiring projects table.")
    public ExpiringProjectsWrapper getExpiringProjectList() {
    	ExpiringProjectsWrapper epw = new ExpiringProjectsWrapper();
    	List<Project> projectList = pcmSvc.getExpiringProjectList();
    	epw.setExpiringProjects(projectList);
        return epw;
    }
    
    @PostMapping(path = "/update-masterlist", produces=MediaType.APPLICATION_JSON_VALUE)
  	@Operation(summary = "Update Projects List", description = "Update the projects list")
  	@Description(value = "This is just to update the projects list.")
    public FileResponseWrapper updateProjectList() {
    	FileResponseWrapper fpw = new FileResponseWrapper();
    	fpw.setResponseString("resp");
        return fpw;
    }
    
    //define a constructore for dependency injection
  	@GetMapping(path = "/", produces=MediaType.APPLICATION_JSON_VALUE)
  	@Operation(summary = "Hello World", description = "Hello world")
  	@Description(value = "This is just hello world")
  	public Map<String, String> hello() {
  		HashMap<String, String> map = new HashMap<>();
  	    map.put("Status", "OK");
  	    map.put("StatusCode", "200");
  	    return map;
  	}

    @GetMapping(path = "/list", produces=MediaType.APPLICATION_JSON_VALUE)
  	@Operation(summary = "List all projects", description = "Lists all projects")
  	@Description(value = "This just lists all projects")
    public Map<String, List<Project>> listAllProjects() {
        return Collections.singletonMap("ProjectList", pcmSvc.getProjectList());

    }

    @GetMapping(path = "/send-mail", produces=MediaType.APPLICATION_JSON_VALUE)
  	@Operation(summary = "Send Email", description = "Sends emails to expiring project owners")
  	@Description(value = "This just sends emails to all expiring projects")
    public Map<String,List<String>> sendEmailToExpiringProjectOwners() {
        return Collections.singletonMap("Emails",pcmSvc.sendEmailToSponsor());
    }
}
