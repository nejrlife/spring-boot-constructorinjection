package com.luv2code.pmo.service;

import java.util.List;

import com.luv2code.pmo.domain.Project;

public interface ProjectContractMonitorSvc {
    Integer addDataToMasterList(List<Project> projectList);

    public List<Project> getUpdatedList();

    public List<Project> getExpiringProjectList();

    public Boolean sendEmailToSponsor(Project project);
}
