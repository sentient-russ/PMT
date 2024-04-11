public class ModelProject {
    int projId = 0;
    String companyName = "";
    String projOwner = "";
    String projManager = "";
    String projDescription = "";
    String projEstimatedHours = "0";
    String projStatus = "In-Process";
    public ModelProject(){

    }
    public ModelProject(int projIdIn, String companyNameIn, String projOwnerIn, String projManagerIn, String projDescriptionIn, String projEstimatedHoursIn, String projStatusIn){
        this.projId = projIdIn;
        this.projOwner = projOwnerIn;
        this.projManager = projManagerIn;
        this.companyName = companyNameIn;
        this.projDescription = projDescriptionIn;
        this.projEstimatedHours = projEstimatedHoursIn;
        this.projStatus = projStatusIn;
    }
    public String toString() {
        return "'" + this.projId + "'";
    }
}