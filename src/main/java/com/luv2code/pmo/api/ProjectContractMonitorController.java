package com.luv2code.pmo.api;

import com.luv2code.pmo.domain.Project;
import com.luv2code.pmo.service.ProjectContractMonitorSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/project")
public class ProjectContractMonitorController {

    @Qualifier(value="dummy")
    private final ProjectContractMonitorSvc pcmSvc;

    public ProjectContractMonitorController(@Qualifier(value = "dummy") ProjectContractMonitorSvc pcmSvc) {
        this.pcmSvc = pcmSvc;
    }

    @GetMapping
    public Map<String,List<Project>> getProjectList() {
        return Collections.singletonMap("ExpiringProjects",pcmSvc.getExpiringProjectList());
    }

}
