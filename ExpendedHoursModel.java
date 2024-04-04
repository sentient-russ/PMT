public class ExpendedHoursModel {
    int expId = 0;
    int projNumber = 0;
    String memberFirstName = "";
    String memberLastName = "";
    String expHoursType = "";
    String expDescription = "";
    String expNumHours = "";
    public ExpendedHoursModel(){
    }
    public ExpendedHoursModel(int expIdIn, int projNumberIn, String memberFirstNameIn, String memberLastNameIn, String expHoursTypeIn, String expDescriptionIn, String expNumHoursIn){
        this.expId = expIdIn;
        this.projNumber = projNumberIn;
        this.memberFirstName = memberFirstNameIn;
        this.memberLastName = memberLastNameIn;
        this.expHoursType = expHoursTypeIn;
        this.expDescription = expDescriptionIn;
        this.expNumHours = expNumHoursIn;
    }
}