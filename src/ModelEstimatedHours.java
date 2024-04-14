public class ModelEstimatedHours {
    int estId = 0;
    int projNumber = 0;
    int reqNumber = 0;
    String memberFirstName = "";
    String memberLastName = "";
    String estHoursType = "";
    String estDescription = "";
    double estNumHours = 0;
    public ModelEstimatedHours(){
    }
    public ModelEstimatedHours(int estIdIn, int projNumberIn, String memberFirstNameIn, String memberLastNameIn, String estHoursTypeIn, String estDescriptionIn, double estNumHoursIn, int reqNumberIn){
        this.reqNumber = 0;
        this.estId = estIdIn;
        this.projNumber = projNumberIn;
        this.memberFirstName = memberFirstNameIn;
        this.memberLastName = memberLastNameIn;
        this.estHoursType = estHoursTypeIn;
        this.estDescription = estDescriptionIn;
        this.estNumHours = estNumHoursIn;
        this.reqNumber = reqNumberIn;
    }
}