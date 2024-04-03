//import ProjectModel;
//import RequirementModel;

import java.sql.*;
import java.util.ArrayList;

public class DbAccess {
    String user = "classremote";
    String pass = "FiddleDeeStix1928";
    public DbAccess(){
    }

    /*******************
     Projects Block
     *******************/
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
        if(newProjectIn.companyName == null || newProjectIn.projOwner == null || newProjectIn.projManager == null || newProjectIn.projDescription == null || newProjectIn.projEstimatedHours == null || newProjectIn.projStatus == null){
            ArrayList<ProjectModel> updatedList = new ArrayList<>();
            updatedList.get(0).projId = 0;
            updatedList.get(0).projDescription = "Passing projects with null values is not permissible.  Passing empty strings or zeros are permissible.";
            return updatedList;
        }

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
    public ArrayList<ProjectModel> UpdateProject(ProjectModel projectIn){
        try{
            String query = ("UPDATE pmt.Projects SET companyName=?, projOwner=?, projManager=?,projDescription=?,projEstimatedHours=?,projStatus=? WHERE projId=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(7, projectIn.projId);
            stmt.setString(1, projectIn.companyName);
            stmt.setString(2, projectIn.projOwner);
            stmt.setString(3, projectIn.projManager);
            stmt.setString(4, projectIn.projDescription);
            stmt.setString(5, projectIn.projEstimatedHours);
            stmt.setString(6, projectIn.projStatus);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<ProjectModel> updatedList = GetProjects();
        return updatedList;
    }
    public ArrayList<ProjectModel> DeleteProject(int projectIn){
        try{
            String query = ("DELETE FROM pmt.Projects  WHERE projId=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, projectIn);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<ProjectModel> updatedList = GetProjects();
        return updatedList;
    }
    /*******************
     Requirements Block
     *******************/
    /*
     *@param projIdIn the project id for the requirements list that will be returned
     *@return resultsList list of requirements for a specific project id
     */
    public ArrayList<RequirementModel> GetRequirements(int projIdIn){
        ArrayList<RequirementModel> resultsList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjReq WHERE projNumber=?";
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, projIdIn);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                RequirementModel foundRequirement = new RequirementModel();
                foundRequirement.reqId = resultSet.getInt("reqId");
                foundRequirement.projNumber = resultSet.getInt("projNumber");
                foundRequirement.reqType = resultSet.getString("reqType");
                foundRequirement.reqDescription = resultSet.getString("reqDescription");
                foundRequirement.reqStatus = resultSet.getString("reqStatus");
                resultsList.add(foundRequirement);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return resultsList;
    }
    /*
     *Creates a new requirement record in the Db
     *@param reqIn the project id for the requirements list that will be returned
     *@return resultsList list of updated requirements for a specific project id
     */
    public ArrayList<RequirementModel> InsertRequirement(RequirementModel reqIn){
        int projNumber = reqIn.projNumber;
        String reqType = reqIn.reqType, reqDescription = reqIn.reqDescription, reqStatus = reqIn.reqStatus;
        if(!(reqIn.reqId >= 0) || !(reqIn.projNumber >= 0) || reqIn.reqType == null || reqIn.reqDescription == null || reqIn.reqStatus == null){
            ArrayList<RequirementModel> updatedReqList = new ArrayList<>();
            updatedReqList.get(0).reqId = 0;
            updatedReqList.get(0).reqDescription = "Passing requirements with null values is not permissible.  Passing empty strings or zeros are permissible.";
            return updatedReqList;
        }
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO pmt.ProjReq" +
                    "(projNumber, reqType, reqDescription, reqStatus)" +
                    " VALUES('"+ projNumber +"','"+ reqType +"','"+ reqDescription +"','"+ reqStatus +"')";
            statement.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RequirementModel> updatedReqList = GetRequirements(reqIn.projNumber);
        return updatedReqList;
    }


    /*******************
     Team Members Block
     *******************/

    /*******************
     Hours Block
     *******************/

    /*******************
     Risks Block
     *******************/
}