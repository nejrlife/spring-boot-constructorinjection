package com.luv2code.pmo.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpiringProjectsWrapper {
	
	@JsonProperty("The following are expiring projects this month. Please select a project to send the owner a notification mail.")
	private List<Project> expiringProjects;

	public void setExpiringProjects(List<Project> expiringProjects) {
		this.expiringProjects = expiringProjects;
	}

	public List<Project> getExpiringProjects() {
		return this.expiringProjects;
	}
}
