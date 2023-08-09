package com.luv2code.springcoredemo.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TableWrapper {
	
	@JsonProperty("Expiring Projects")
	private List<TableRow> expiringProjects;

	public void setExpiringProjects(List<TableRow> expiringProjects) {
		this.expiringProjects = expiringProjects;
	}

	public List<TableRow> getExpiringProjects() {
		return this.expiringProjects;
	}
}
