package com.luv2code.pmo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.pmo.dao.ProjectDao;
import com.luv2code.pmo.domain.Project;

@Service(value = "impl")
public class ProjectContractMonitorSvcImpl implements ProjectContractMonitorSvc {

    @Autowired
    private ProjectDao projectDao;

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
        Map<String, Project> masterList = projectDao.getProjectListFromMasterFile();
        Map<String, Project> csvList = projectDao.getProjectListFromCsvFile();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        List<Project> updatedMasterList = projectDao.updateMasterList(masterList, csvList);
        for (Project project : updatedMasterList) {
            try {
                Date endDate = sdf.parse(project.getEndDate());
                if (isProjectExpiring(endDate)) {
                	String bodyTemplate = "Hi " + project.getOwnerName() + "\n\n" +
                            "This email's purpose is to notify that SOW ID " + project.getId() + " is expiring on " + project.getEndDate() + "\n" +
                            "\nPlease advise if these SOW IDs are under negotiation for extension " +
                            "or will not be extended so we may work with the Delivery Managers " +
                            "reference to the workers assigned to the project if they will be extended, moved, or closed. " +
                            "\n\nThank you and best regards\n\nNixon Edora Jr.";
                    project.setEmailContent(bodyTemplate);
                    String subjectTemplate = "Please advise for the expiring SOW ID: " + project.getId();
                    project.setEmailSubject(subjectTemplate);
                    expiringProjectList.add(project);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return expiringProjectList;
    }

    @Override
    public List<Project> getProjectList() {
        ArrayList<Project> projectList = new ArrayList<>();


        return projectList;
    }

    public void sendEmailToExpiringProjectOwners(List<Project> expiringProjects) {
        for (Project project : expiringProjects) {
            String bodyTemplate = "Hi " + project.getOwnerName() + "\n" +
                    "SOW ID " + project.getId() + " is expiring on " + project.getEndDate() + "\n" +
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

    private Boolean isProjectExpiring(Date givenDate) {
        Date today = new Date();
        return givenDate.getMonth() == today.getMonth() && givenDate.getYear() == today.getYear();
    }

}
