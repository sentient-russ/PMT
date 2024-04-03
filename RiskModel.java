public class RiskModel {
    int riskId = 0;
    int projNumber = 0;
    String riskDescription = "";
    String riskStatus = "";
    public RiskModel(){

    }
    public RiskModel(int riskIdin, int projNumberIn, String riskDescriptionIn, String riskStatusIn){
        this.riskId = riskIdin;
        this.projNumber = projNumberIn;
        this.riskDescription = riskDescriptionIn;
        this.riskStatus = riskStatusIn;
    }
}