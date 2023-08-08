package com.luv2code.pmo.dao;

import com.luv2code.pmo.domain.Project;

public interface ProjectDao {

    public Project create();
    public void delete(Project project);
    public Project save();
    public Project readProjectById(String addressId);
}
