public class RequirementModel {
    private int reqId = 0;
    private int projNumber = 0;
    private String reqType = "";
    private String reqDescription = "";
    private String reqStatus = "";
    public RequirementModel(){

    }
    public RequirementModel(int reqIdIn, int projNumberIn, String reqTypeIn, String reqDescriptionIn, String reqStatusIn ){
        this.reqId = reqIdIn;
        this.projNumber = projNumberIn;
        this.reqType = reqTypeIn;
        this.reqDescription = reqDescriptionIn;
        this.reqStatus = reqStatusIn;
    }

    public int getReqId() {
        return reqId;
    }

    public int getProjNumber() {
        return projNumber;
    }

    public String getReqType() {
        return reqType;
    }

    public String getReqDescription() {
        return reqDescription;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public void setProjNumber(int projNumber) {
        this.projNumber = projNumber;
    }

    public void setReqDescription(String reqDescription) {
        this.reqDescription = reqDescription;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }
}