import java.sql.*;
import java.util.*;

public class DbAccess {
    String user = "classremote";
    String pass = "FiddleDeeStix1928";
    public DbAccess(){
    }
    public ArrayList<ProjectModel> GetProjects(){
        ArrayList<ProjectModel> resultsList = new ArrayList<>();
        try{

            String query = "SELECT * FROM pmt.Projects";
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                ProjectModel foundProject = new ProjectModel();
                foundProject.projId = resultSet.getInt("projId");
                foundProject.projOwner = resultSet.getString("projOwner");
                foundProject.projManager = resultSet.getString("projManager");
                foundProject.companyName = resultSet.getString("companyName");
                foundProject.projDescription = resultSet.getString("projDescription");
                foundProject.projEstimatedHours = resultSet.getString("projEstimatedHours");
                foundProject.projStatus = resultSet.getString("projStatus");
                resultsList.add(foundProject);
            }
        }catch (SQLException e){
            System.out.println(e);
        }

        return resultsList;
    }
    public ArrayList<ProjectModel> InsertProject(ProjectModel newProjectIn){
        String companyName = newProjectIn.companyName, projOwner = newProjectIn.projOwner, projManager = newProjectIn.projManager, projDescription = newProjectIn.projDescription, projEstimatedHours  = newProjectIn.projEstimatedHours, projStatus = newProjectIn.projStatus;
        ;
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            Statement statement = connection.createStatement();

            String query = "INSERT INTO pmt.Projects" +
                            "(companyName, projOwner, projManager, projDescription, projEstimatedHours, projStatus )" +
                            " VALUES('"+ companyName +"','"+ projOwner +"','"+ projManager +"','"+ projDescription +"','"+ projEstimatedHours +"','"+ projStatus +"')";
            statement.executeUpdate(query);

        }catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<ProjectModel> updatedList = GetProjects();
        return updatedList;
    }
}