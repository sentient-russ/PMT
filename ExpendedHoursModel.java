public class ExpendedHoursModel {
    int projNumber = 0;
    String expDescription = "";
    String expNumHours = "";
    public ExpendedHoursModel(){
    }
    public ExpendedHoursModel(int projNumberIn, String expDescriptionIn, String expNumHoursIn){
        this.projNumber = projNumberIn;
        this.expDescription = expDescriptionIn;
        this.expNumHours = expNumHoursIn;
    }
}