package com.luv2code.pmo.dao;

import com.luv2code.pmo.domain.Project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ProjectDao {

    public Project create();

    public void delete(Project project);

    public Project save(Project project);

    public Project readProjectById(String addressId);

    public List<Project> listAllProject();

    public List<Project> updateMasterList(Map<String, Project> masterList, Map<String, Project> fromCsv);

    public Map<String, Project> getProjectListFromCsvFile();

    public Map<String, Project> getProjectListFromMasterFile();
}
