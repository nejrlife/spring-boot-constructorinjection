package com.luv2code.pmo.domain;

import java.util.Date;

public class Project {

    private String id;
    private String status;
    private Integer revision;
    private String name;
    private String cw_ccr;
    private Date startDate;
    private Date endDate;
    private Owner owner;
    private String programConsultant;
    private Boolean withActiveWorkers;
    private String accountID;
    private String dataExtract;
    private String manualUpdate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getProgramConsultant() {
        return programConsultant;
    }

    public void setProgramConsultant(String programConsultant) {
        this.programConsultant = programConsultant;
    }

    public Boolean getWithActiveWorkers() {
        return withActiveWorkers;
    }

    public void setWithActiveWorkers(Boolean withActiveWorkers) {
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
