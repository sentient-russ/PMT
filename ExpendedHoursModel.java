public class ExpendedHoursModel {
    int projNumber;
    String expDescription;
    String expNumHours;

    public ExpendedHoursModel(int projNumberIn, String expDescriptionIn, String expNumHoursIn){
        this.projNumber = projNumberIn;
        this.expDescription = expDescriptionIn;
        this.expNumHours = expNumHoursIn;
    }
}