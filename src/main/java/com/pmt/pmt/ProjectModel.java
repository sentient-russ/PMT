package com.pmt.pmt;

public class ProjectModel {
    int projId;
    String companyName;
    String projOwner;
    String projManager;
    String projDescription;
    String projEstimatedHours;
    String projStatus;
    public ProjectModel(int projIdIn, String projOwnerIn, String projManagerIn, String projDescriptionIn, String projEstimatedHoursIn, String projStatusIn){
        this.projId = projIdIn;
        this.projOwner = projOwnerIn;
        this.projManager = projManagerIn;
        this.projDescription = projDescriptionIn;
        this.projEstimatedHours = projEstimatedHoursIn;
        this.projStatus = projStatusIn;
    }
}
