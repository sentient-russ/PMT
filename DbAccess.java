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
    public ProjectModel GetProject(int projIdIn) {
        ProjectModel foundProject = new ProjectModel();
        try {
            String query = "SELECT * FROM pmt.Projects WHERE projId=?";
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, projIdIn);
            ResultSet result = stmt.executeQuery();
            foundProject.projId = result.getInt("reqId");
            foundProject.companyName = result.getString("companyName");
            foundProject.projOwner = result.getString("projOwner");
            foundProject.projManager = result.getString("projManager");
            foundProject.projDescription = result.getString("projDescription");
            foundProject.projEstimatedHours = result.getString("projEstimatedHours");
            foundProject.projStatus = result.getString("projStatus");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return foundProject;
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
     *@return updatedReqList list of updated requirements for a specific project id
     */
    public ArrayList<RequirementModel> InsertRequirement(RequirementModel reqIn){
        int projNumber = reqIn.projNumber;
        String reqType = reqIn.reqType, reqDescription = reqIn.reqDescription, reqStatus = reqIn.reqStatus;
        if(!(reqIn.projNumber >= 0) || reqType == null || reqDescription == null || reqStatus == null){
            ArrayList<RequirementModel> updatedReqList = new ArrayList<>();
            updatedReqList.get(0).reqId = 0;
            updatedReqList.get(0).reqDescription = "Passing requirements with null values is not permissible.  Passing empty strings or zeros are permissible.";
            return updatedReqList;
        }
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO pmt.ProjReq" +
                    "(reqType, reqDescription, reqStatus)" +
                    " VALUES('"+ reqType +"','"+ reqDescription +"','"+ reqStatus +"')";
            statement.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RequirementModel> updatedReqList = GetRequirements(reqIn.projNumber);
        return updatedReqList;
    }
    /*
     *Updates a requirement record
     *@param reqIn a ReqModel that is complete with no fields null or empty string
     *@return updatedReqList list of updated requirements for the project
     */
    public ArrayList<RequirementModel> UpdateRequirement(RequirementModel reqIn){
        try{
            String query = ("UPDATE pmt.ProjReq SET reqType=?, reqDescription=?, reqStatus=? WHERE reqId=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(4, reqIn.reqId);
            stmt.setString(1, reqIn.reqType);
            stmt.setString(2, reqIn.reqDescription);
            stmt.setString(3, reqIn.reqStatus);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RequirementModel> updatedReqList = GetRequirements(reqIn.projNumber);
        return updatedReqList;
    }
    /*
     *Deletes a requirement record
     *@param reqIdIn the requirement id number to be deleted
     *@param projIdIn the id for the current project. Will be used to get the updated project results
     *@return updatedReqList list of updated requirements for the project
     */
    public ArrayList<RequirementModel> DeleteRequirement(int reqIdIn, int projIdIn){
        try{
            String query = ("DELETE FROM pmt.ProjReq  WHERE reqId=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, reqIdIn);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RequirementModel> updatedReqList = GetRequirements(projIdIn);
        return updatedReqList;
    }
    /*******************
     Team Members Block
     *******************/
    /*
     *@param projIdIn the project id for the team members list that will be returned
     *@return resultsList list of team members for a specified project id
     */
    public ArrayList<TeamMemberModel> GetTeamMembers(int projIdIn){
        ArrayList<TeamMemberModel> teamMemberList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.TeamMembers WHERE projNumber=?";
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, projIdIn);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                TeamMemberModel foundMember = new TeamMemberModel();
                foundMember.memberId = resultSet.getInt("memberId");
                foundMember.projNumber = resultSet.getInt("projNumber");
                foundMember.memberFirstName = resultSet.getString("memberFirstName");
                foundMember.memberLastName = resultSet.getString("memberLastName");
                foundMember.memberPrimaryRole = resultSet.getString("memberPrimaryRole");
                teamMemberList.add(foundMember);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return teamMemberList;
    }
    /*
     *Creates a new team member record in the Db
     *@param teamMemberIn completed team member model to insert into the Db
     *@return teamMemberList update list of team members for a specific project id
     */
    public ArrayList<TeamMemberModel> InsertTeamMember(TeamMemberModel teamMemberIn){
        int  projNumber= teamMemberIn.projNumber;
        String memberFirstName = teamMemberIn.memberFirstName, memberLastName = teamMemberIn.memberLastName, memberPrimaryRole = teamMemberIn.memberPrimaryRole;
        if(!(projNumber >= 0) || memberFirstName == null || memberLastName == null || memberPrimaryRole == null){
            ArrayList<TeamMemberModel> teamMemberList = new ArrayList<>();
            teamMemberList.get(0).memberId = 0;
            teamMemberList.get(0).memberFirstName = "No Nulls";
            teamMemberList.get(0).memberLastName = "No Nulls";
            return teamMemberList;
        }
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO pmt.TeamMembers" +
                    "(memberFirstName, memberLastName, memberPrimaryRole)" +
                    " VALUES('"+ memberFirstName +"','"+ memberLastName +"','"+ memberPrimaryRole +"')";
            statement.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<TeamMemberModel> teamMemberList = GetTeamMembers(teamMemberIn.projNumber);
        return teamMemberList;
    }
    /*
     *Updates a team member record
     *@param teamMemberIn a TeamMemberModel that is complete with no fields null or as empty string
     *@return teamMemberList list of updated team members to display for the project
     */
    public ArrayList<TeamMemberModel> UpdateTeamMember(TeamMemberModel teamMemberIn){
        try{
            String query = ("UPDATE pmt.TeamMembers SET memberFirstName=?, memberLastName=?, memberPrimaryRole=? WHERE memberId=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(4, teamMemberIn.memberId);
            stmt.setString(1, teamMemberIn.memberFirstName);
            stmt.setString(2, teamMemberIn.memberLastName);
            stmt.setString(3, teamMemberIn.memberPrimaryRole);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<TeamMemberModel> teamMemberList = GetTeamMembers(teamMemberIn.projNumber);
        return teamMemberList;
    }
    /*
     *Deletes a team member record
     *@param teamMemberIdIn the requirement id number to be deleted
     *@param projIdIn the id for the current project. Will be used to get the updated team member list
     *@return updatedTeamMemberList list of updated requirements for the project
     */
    public ArrayList<TeamMemberModel> DeleteTeamMember(int teamMemberIdIn, int projIdIn){
        try{
            String query = ("DELETE FROM pmt.TeamMembers  WHERE memberId=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, teamMemberIdIn);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<TeamMemberModel> updatedTeamMemberList = GetTeamMembers(projIdIn);
        return updatedTeamMemberList;
    }
    /*******************
     Hours Block
     *******************/
    /*
     *@param projIdIn the project id for the expended hours list that will be returned
     *@return resultsList list of expended hours records for a specified project id
     */
    public ArrayList<ExpendedHoursModel> GetExpendedHours(int projIdIn){
        ArrayList<ExpendedHoursModel> expendedHoursList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjExpHours WHERE projNumber=?";
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, projIdIn);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                ExpendedHoursModel foundExpHoursRecord = new ExpendedHoursModel();
                foundExpHoursRecord.expId = resultSet.getInt("expId");
                foundExpHoursRecord.expHoursType = resultSet.getString("expHoursType");
                foundExpHoursRecord.projNumber = resultSet.getInt("projNumber");
                foundExpHoursRecord.expDescription = resultSet.getString("expDescription");
                foundExpHoursRecord.expNumHours = resultSet.getString("expNumHours");
                expendedHoursList.add(foundExpHoursRecord);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return expendedHoursList;
    }
    /*
     *Creates a new expended hours record in the Db
     *@param expendedHoursIn the completed expended hours model to be inserted into the Db
     *@return expendedHoursList list of updated expended hours records for a specific project id
     */
    public ArrayList<ExpendedHoursModel> InsertExpendedHours(ExpendedHoursModel expendedHoursIn){
        int  projNumber= expendedHoursIn.projNumber;
        String memberFirstName = expendedHoursIn.memberFirstName, memberLastName = expendedHoursIn.memberLastName, expHoursType = expendedHoursIn.expHoursType, expDescription = expendedHoursIn.expDescription, expNumHours = expendedHoursIn.expNumHours;
        if(!(projNumber >= 0) || memberFirstName == null || memberLastName == null || expHoursType == null || expDescription == null || expNumHours == null ){
            ArrayList<ExpendedHoursModel> expendedHoursList = new ArrayList<>();
            expendedHoursList.get(0).expId = 0;
            expendedHoursList.get(0).expDescription = "No Nulls Allowed!";
            return expendedHoursList;
        }
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO pmt.ProjExpHours" +
                    "(projNumber, memberFirstName, memberLastName, expHoursType, expDescription, expNumHours)" +
                    " VALUES('" + memberFirstName + "','" + memberLastName + "','" + expHoursType +"','"+ expDescription +"','"+ expNumHours + "')";
            statement.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<ExpendedHoursModel> expendedHoursList = GetExpendedHours(expendedHoursIn.projNumber);
        return expendedHoursList;
    }
    /*
     *Deletes an expended hours record
     *@param expIdIn the expended hours id number to be deleted
     *@param projIdIn the id for the current project. Will be used to get the updated expended hours list
     *@return updatedExpendedHoursList list of updated hours list for the project
     */
    public ArrayList<ExpendedHoursModel> DeleteExpendedHours(int expIdIn, int projIdIn){
        try{
            String query = ("DELETE FROM pmt.ProjExpHours  WHERE expIdIn=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, expIdIn);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<ExpendedHoursModel> updatedExpendedHoursList = GetExpendedHours(projIdIn);
        return updatedExpendedHoursList;
    }
    /*******************
     Risks Block
     *******************/
    /*
     *@param projIdIn the project id for the project risks list that will be returned
     *@return foundRisksList list of project risks for a specified project id
     */
    public ArrayList<RiskModel> GetRisks(int projIdIn){
        ArrayList<RiskModel> foundRisksList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjRisks WHERE projNumber=?";
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, projIdIn);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                RiskModel foundRisksRecord = new RiskModel();
                foundRisksRecord.riskId = resultSet.getInt("riskId");
                foundRisksRecord.projNumber = resultSet.getInt("projNumber");
                foundRisksRecord.riskDescription = resultSet.getString("riskDescription");
                foundRisksRecord.riskStatus = resultSet.getString("riskStatus");
                foundRisksList.add(foundRisksRecord);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return foundRisksList;
    }
    /*
     *Creates a new risk record in the Db
     *@param newRiskIn the completed risk model to be inserted into the Db
     *@return updatedRiskList list of updated risk records for a specific project id
     */
    public ArrayList<RiskModel> InsertExpendedHours(RiskModel newRiskIn){
        int  projNumber= newRiskIn.projNumber;
        String riskDescription = newRiskIn.riskDescription, riskStatus = newRiskIn.riskStatus;
        if(!(projNumber >= 0) || riskDescription == null || riskStatus == null){
            ArrayList<RiskModel> updatedRiskList = new ArrayList<>();
            updatedRiskList.get(0).riskId = 0;
            updatedRiskList.get(0).riskDescription = "No Nulls Allowed!";
            return updatedRiskList;
        }
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO pmt.ProjRisks" +
                    "(projNumber, riskDescription, riskStatus)" +
                    " VALUES('" + projNumber + "','" + riskDescription + "','" + riskStatus + "')";
            statement.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RiskModel> updatedRiskList = GetRisks(newRiskIn.projNumber);
        return updatedRiskList;
    }
    /*
     *Updates a risk record
     *@param riskIn a RiskModel that is complete with no fields null or as empty string
     *@return updatedRisksList list of updated risks to display for the project
     */
    public ArrayList<RiskModel> UpdateTeamMember(RiskModel riskIn){
        try{
            String query = ("UPDATE pmt.ProjRisks SET projId=?, riskDescription=?, riskStatus=? WHERE riskId=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(4, riskIn.riskId);
            stmt.setInt(1, riskIn.projNumber);
            stmt.setString(2, riskIn.riskDescription);
            stmt.setString(3, riskIn.riskStatus);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RiskModel> updatedRisksList = GetRisks(riskIn.projNumber);
        return updatedRisksList;
    }
    /*
     *Deletes a risk record
     *@param riskIdIn the risk id number to be deleted
     *@param projIdIn the id for the current project. Will be used to get the updated the risks list
     *@return updatedRisksList list of updated risks to display for the project
     */
    public ArrayList<RiskModel> DeleteRisk(int riskIdIn, int projIdIn){
        try{
            String query = ("DELETE FROM pmt.ProjRisks  WHERE riskId=?");
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, riskIdIn);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RiskModel> updatedRisksList = GetRisks(projIdIn);
        return updatedRisksList;
    }

}