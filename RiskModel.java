public class RiskModel {
    private int riskId = 0;
    private int projNumber = 0;
    private String riskDescription = "";
    private String riskStatus = "";
    public RiskModel(){

    }
    public RiskModel(int riskIdin, int projNumberIn, String riskDescriptionIn, String riskStatusIn){
        this.riskId = riskIdin;
        this.projNumber = projNumberIn;
        this.riskDescription = riskDescriptionIn;
        this.riskStatus = riskStatusIn;
    }

    public int getRiskId() {
        return riskId;
    }

    public int getProjNumber() {
        return projNumber;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskId(int riskId) {
        this.riskId = riskId;
    }

    public void setProjNumber(int projNumber) {
        this.projNumber = projNumber;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }
}