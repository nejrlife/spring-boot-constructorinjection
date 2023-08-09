package com.luv2code.pmo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectsWrapper {
	
	@JsonProperty("Expiring Projects")
	private List<Project> expiringProjects;

	public void setExpiringProjects(List<Project> expiringProjects) {
		this.expiringProjects = expiringProjects;
	}

	public List<Project> getExpiringProjects() {
		return this.expiringProjects;
	}
}
