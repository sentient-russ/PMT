import java.io.StringBufferInputStream;

public class ProjectModel {
    int projId = 0;
    String companyName = "";
    String projOwner = "";
    String projManager = "";
    String projDescription = "";
    String projEstimatedHours = "";
    String projStatus = "";
    public ProjectModel(){

    }
    public ProjectModel(int projIdIn, String companyNameIn, String projOwnerIn, String projManagerIn, String projDescriptionIn, String projEstimatedHoursIn, String projStatusIn){
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