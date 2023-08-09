package com.luv2code.pmo.api;

import com.luv2code.pmo.domain.Project;
import com.luv2code.pmo.service.ProjectContractMonitorSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/project")
public class ProjectContractMonitorController {

    @Qualifier(value = "dummy")
    private final ProjectContractMonitorSvc pcmSvc;

    public ProjectContractMonitorController(@Qualifier(value = "dummy") ProjectContractMonitorSvc pcmSvc) {
        this.pcmSvc = pcmSvc;
    }

    @GetMapping("/expiring-list")
    public Map<String, List<Project>> getExpiringProjectList() {
        return Collections.singletonMap("ExpiringProjects", pcmSvc.getExpiringProjectList());
    }

    @GetMapping("/list")
    public Map<String, List<Project>> listAllProjects() {
        return Collections.singletonMap("ProjectList", pcmSvc.getProjectList());

    }


    @GetMapping("/send-mail")
    public Map<String,List<String>> sendEmailToExpiringProjectOwners() {
        return Collections.singletonMap("Emails",pcmSvc.sendEmailToSponsor());

    }

}
