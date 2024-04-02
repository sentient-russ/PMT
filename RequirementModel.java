public class RequirementModel {
    int reqId;
    int projNumber;
    String reqType;
    String reqDescription;
    String reqStatus;
    public RequirementModel(int reqIdIn, int projNumberIn, String reqTypeIn, String reqDescriptionIn, String reqStatusIn ){
        this.reqId = reqIdIn;
        this.projNumber = projNumberIn;
        this.reqType = reqTypeIn;
        this.reqDescription = reqDescriptionIn;
        this.reqStatus = reqStatusIn;
    }
}