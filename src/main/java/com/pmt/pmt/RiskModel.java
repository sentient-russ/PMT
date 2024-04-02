package com.pmt.pmt;

public class RiskModel {
    int riskId;
    int projNumber;
    String riskDescription;
    String riskStatus;
    public RiskModel(int riskIdin, int projNumberIn, String riskDescriptionIn, String riskStatusIn){
        this.riskId = riskIdin;
        this.projNumber = projNumberIn;
        this.riskDescription = riskDescriptionIn;
        this.riskStatus = riskStatusIn;
    }
}
