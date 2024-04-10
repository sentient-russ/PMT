public class ProjectModel {
    private int projId = 0;
    private String companyName = "";
    private String projOwner = "";
    private String projManager = "";
    private String projDescription = "";
    private String projEstimatedHours = "";
    private String projStatus = "";
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

    public void setProjId(int projId) {
        this.projId = projId;
    }

    public void setProjDescription(String projDescription) {
        this.projDescription = projDescription;
    }

    public void setProjOwner(String projOwner) {
        this.projOwner = projOwner;
    }

    public void setProjManager(String projManager) {
        this.projManager = projManager;
    }

    public void setProjEstimatedHours(String projEstimatedHours) {
        this.projEstimatedHours = projEstimatedHours;
    }

    public void setProjStatus(String projStatus) {
        this.projStatus = projStatus;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getProjId() {
        return projId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getProjOwner() {
        return projOwner;
    }

    public String getProjManager() {
        return projManager;
    }

    public String getProjDescription() {
        return projDescription;
    }

    public String getProjEstimatedHours() {
        return projEstimatedHours;
    }

    public String getProjStatus() {
        return projStatus;
    }
    public String toString() {
        return "'" + this.projId + "'";
    }
}