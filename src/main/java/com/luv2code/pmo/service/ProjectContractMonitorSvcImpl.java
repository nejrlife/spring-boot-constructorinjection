package com.luv2code.pmo.service;

import com.luv2code.pmo.domain.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "impl")
public class ProjectContractMonitorSvcImpl implements ProjectContractMonitorSvc {

    @Override
    public Integer addDataToMasterList(List<Project> projectList) {
        int recordCount = 0;

        return recordCount;

    }

    @Override
    public List<Project> getUpdatedList() {
        ArrayList<Project> updatedList = new ArrayList<>();

        return updatedList;
    }

    @Override
    public List<Project> getExpiringProjectList() {
        ArrayList<Project> expiringProjectList = new ArrayList<>();


        return expiringProjectList;
    }

    @Override
    public List<Project> getProjectList() {
        ArrayList<Project> projectList = new ArrayList<>();


        return projectList;
    }

    public void sendEmailToExpiringProjectOwners(List<Project> expiringProjects) {
        for(Project project:expiringProjects) {
            String bodyTemplate = "Hi "+project.getOwnerName()+"\n" +
                    "SOW ID "+project.getId()+" is expiring on "+project.getEndDate()+"\n" +
                    "Please advise if these SOW IDs are under negotiation for extension " +
                    "or will not be extended so we may work with the Delivery Managers " +
                    "reference to the workers assigned to the project if they will be extended, moved, or closed. " +
                    "\n Please Advise";


        }

    }

    @Override
    public List<String> sendEmailToSponsor() {


        return null;
    }

    private Boolean isProjectExpiring(Date startDate, Date endDate) {

        return false;
    }

}
