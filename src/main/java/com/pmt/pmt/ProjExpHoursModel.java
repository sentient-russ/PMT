package com.pmt.pmt;

public class ProjExpHoursModel {
    int projNumber;
    String expDescription;
    String expNumHours;

    public ProjExpHoursModel(int projNumberIn, String expDescriptionIn, String expNumHoursIn){
        this.projNumber = projNumberIn;
        this.expDescription = expDescriptionIn;
        this.expNumHours = expNumHoursIn;
    }
}
