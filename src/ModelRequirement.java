public class ModelRequirement {
    int reqId = 0;
    int projNumber = 0;
    String reqType = "";
    String reqDescription = "";
    String reqStatus = "";
    public ModelRequirement(){

    }
    public ModelRequirement(int reqIdIn, int projNumberIn, String reqTypeIn, String reqDescriptionIn, String reqStatusIn ){
        this.reqId = reqIdIn;
        this.projNumber = projNumberIn;
        this.reqType = reqTypeIn;
        this.reqDescription = reqDescriptionIn;
        this.reqStatus = reqStatusIn;
    }
}