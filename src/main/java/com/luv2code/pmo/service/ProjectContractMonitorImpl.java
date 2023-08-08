package com.luv2code.pmo.service;

import com.luv2code.pmo.domain.Owner;
import com.luv2code.pmo.domain.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectContractMonitorImpl implements ProjectContractMonitor {

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
    public Boolean sendEmailToSponsor(Owner sponsor) {
        boolean isSuccess = false;

        return isSuccess;
    }

}
