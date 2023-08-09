package com.luv2code.pmo.domain;

import org.springframework.stereotype.Component;

@Component
public class Project {

    private String status;
    private String id;
    private Integer revision;
    private String name;
    private String cw_ccr;
    private String startDate;
    private String endDate;
    private String ownerEmail;
    private String ownerName;
    private String programConsultant;
    private String withActiveWorkers;
    private String accountID;
    private String dataExtract;
    private String manualUpdate;
    public Project() {
    }

    public Project(String status, String id, Integer revision, String name, String cw_ccr, String startDate, String endDate, String ownerEmail, String ownerName, String programConsultant, String withActiveWorkers, String accountID, String dataExtract, String manualUpdate) {
        this.status = status;
        this.id = id;
        this.revision = revision;
        this.name = name;
        this.cw_ccr = cw_ccr;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ownerEmail = ownerEmail;
        this.programConsultant = programConsultant;
        this.withActiveWorkers = withActiveWorkers;
        this.accountID = accountID;
        this.dataExtract = dataExtract;
        this.manualUpdate = manualUpdate;
        this.ownerName = ownerName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCw_ccr() {
        return cw_ccr;
    }

    public void setCw_ccr(String cw_ccr) {
        this.cw_ccr = cw_ccr;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getProgramConsultant() {
        return programConsultant;
    }

    public void setProgramConsultant(String programConsultant) {
        this.programConsultant = programConsultant;
    }

    public String getWithActiveWorkers() {
        return withActiveWorkers;
    }

    public void setWithActiveWorkers(String withActiveWorkers) {
        this.withActiveWorkers = withActiveWorkers;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getDataExtract() {
        return dataExtract;
    }

    public void setDataExtract(String dataExtract) {
        this.dataExtract = dataExtract;
    }

    public String getManualUpdate() {
        return manualUpdate;
    }

    public void setManualUpdate(String manualUpdate) {
        this.manualUpdate = manualUpdate;
    }
}
