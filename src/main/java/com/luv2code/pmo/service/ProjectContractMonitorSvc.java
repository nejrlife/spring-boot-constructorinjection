package com.luv2code.pmo.service;

import com.luv2code.pmo.domain.Owner;
import com.luv2code.pmo.domain.Project;

import java.util.List;

public interface ProjectContractMonitorSvc {
    Integer addDataToMasterList(List<Project> projectList);

    public List<Project> getUpdatedList();

    public List<Project> getExpiringProjectList();

    public List<Project> getProjectList();

    public List<String> sendEmailToSponsor();
}
