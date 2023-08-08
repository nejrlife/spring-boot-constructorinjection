package com.luv2code.pmo.api;

import com.luv2code.pmo.domain.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/project")
public class ProjectContractMonitorController {

    @GetMapping
    public List<Project> getProjectList() {
        return List.of(new Project());
    }



}
