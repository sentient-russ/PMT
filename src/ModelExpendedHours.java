public class ModelExpendedHours {
    int expId = 0;
    int projNumber = 0;
    int reqNumber = 0;
    String memberFirstName = "";
    String memberLastName = "";
    String expHoursType = "";
    String expDescription = "";
    double expNumHours = 0;
    public ModelExpendedHours(){
    }
    public ModelExpendedHours(int expIdIn, int projNumberIn, String memberFirstNameIn, String memberLastNameIn, String expHoursTypeIn, String expDescriptionIn, double expNumHoursIn,int reqNumberIn){
        this.expId = expIdIn;
        this.projNumber = projNumberIn;
        this.memberFirstName = memberFirstNameIn;
        this.memberLastName = memberLastNameIn;
        this.expHoursType = expHoursTypeIn;
        this.expDescription = expDescriptionIn;
        this.expNumHours = expNumHoursIn;
        this.reqNumber = reqNumberIn;
    }
}