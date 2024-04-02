import java.util.ArrayList;

public class PMTApplication {

    public static void main(String[] args) {
        //This object is used to create, read and update from the remote database.
        DbAccess dataAccess = new DbAccess();

        //get projects from db
        ArrayList<ProjectModel> resultsList = dataAccess.GetProjects();
        printProjects(resultsList);
        //add new project
        ProjectModel newProject = new ProjectModel();
        newProject.companyName = "New Company";
        newProject.projOwner = "Owner Name";
        newProject.projManager = "PM Name";
        newProject.projDescription = "Detailed project description that can be in the form of a vission statement.";
        newProject.projEstimatedHours = "50";
        newProject.projStatus = "In-Progress";
        ArrayList<ProjectModel> updatedListWithNewId = dataAccess.InsertProject(newProject);

    }
    public static void printProjects(ArrayList<ProjectModel> projectsIn){

        for (int i = 0; i < projectsIn.size(); i++) {
            System.out.println("Project Id:" + projectsIn.get(i).projId + ", Company: " + projectsIn.get(i).companyName +
                    ", Owner: " + projectsIn.get(i).projOwner + ", Manager: " + projectsIn.get(i).projManager +
                    ", Description: " + projectsIn.get(i).projDescription + ", Est. Hours: " + projectsIn.get(i).projEstimatedHours +
                    ", Status: " + projectsIn.get(i).projStatus);
        }
    }
}
