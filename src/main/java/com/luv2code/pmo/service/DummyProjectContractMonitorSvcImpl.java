package com.luv2code.pmo.service;

import com.luv2code.pmo.domain.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "dummy")
public class DummyProjectContractMonitorSvcImpl implements ProjectContractMonitorSvc {

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
        Project p1 = new Project("Approved", "CTLKTQ00000577", 7.0, "AG Audit Services - IBM", "CW161439", "1/1/2021", "12/31/2024", "nixon.edora@ibm.com", "Anna", "Alexis Herrera", "Yes", "WFKDX", "", "");
        Project p2 = new Project("Approved", "CTLKTQ00000599", 9.0, "IBM WTX Staffing SOW", "CW158709", "2/1/2021", "12/31/2023", "sample@samplemail.com", "Beth", "Marina Sanchez", "Yes", "WPR4X", "", "");

        expiringProjectList.add(p1);
        expiringProjectList.add(p2);

        return expiringProjectList;
    }

    @Override
    public List<Project> getProjectList() {
        ArrayList<Project> projectList = new ArrayList<>();
        Project p1 = new Project("Approved", "CTLKTQ00000577", 7.0, "AG Audit Services - IBM", "CW161439", "1/1/2021", "12/31/2024", "Anna.M.Shivers@lumen.com", "Anna", "Alexis Herrera", "Yes", "WFKDX", "", "");
        Project p2 = new Project("Approved", "CTLKTQ00000599", 9.0, "IBM WTX Staffing SOW", "CW158709", "2/1/2021", "12/31/2023", "Beth.Gonzalez@lumen.com", "Beth", "Marina Sanchez", "Yes", "WPR4X", "", "");

        projectList.add(p1);
        projectList.add(p2);

        return projectList;
    }

    @Override
    public List<String> sendEmailToSponsor() {
        List<String> emailList = new ArrayList<>();

        List<Project> expiringProjects = this.getExpiringProjectList();
        for (Project project : expiringProjects) {
            String bodyTemplate = "Hi " + project.getOwnerName() + "\n" +
                    "SOW ID " + project.getId() + " is expiring on " + project.getEndDate() + "\n" +
                    "Please advise if these SOW IDs are under negotiation for extension " +
                    "or will not be extended so we may work with the Delivery Managers " +
                    "reference to the workers assigned to the project if they will be extended, moved, or closed. " +
                    "\n Please Advise";

            emailList.add(project.getOwnerEmail());
        }
        return emailList;
    }

}
