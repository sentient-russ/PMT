//import ProjectModel;
//import RequirementModel;
import java.sql.*;
import java.util.ArrayList;
public class DbAccess {
    private static String user = "classremote";
    private static String pass = "FiddleDeeStix1928";
    public DbAccess(){
    }
    /*******************
     Projects Block
     *******************/
    public static ArrayList<ProjectModel> GetProjects(){
        ArrayList<ProjectModel> resultsList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.Projects";
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                ProjectModel foundProject = new ProjectModel();
                foundProject.setProjId(resultSet.getInt("projId"));
                foundProject.setProjOwner(resultSet.getString("projOwner"));
                foundProject.setProjManager(resultSet.getString("projManager"));
                foundProject.setCompanyName(resultSet.getString("companyName"));
                foundProject.setProjDescription(resultSet.getString("projDescription"));
                foundProject.setProjEstimatedHours(resultSet.getString("projEstimatedHours"));
                foundProject.setProjStatus(resultSet.getString("projStatus"));
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
            foundProject.setProjId(result.getInt("reqId"));
            foundProject.setCompanyName(result.getString("companyName"));
            foundProject.setProjOwner(result.getString("projOwner"));
            foundProject.setProjManager(result.getString("projManager"));
            foundProject.setProjDescription(result.getString("projDescription"));
            foundProject.setProjEstimatedHours(result.getString("projEstimatedHours"));
            foundProject.setProjStatus(result.getString("projStatus"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return foundProject;
    }
    public ArrayList<ProjectModel> InsertProject(ProjectModel newProjectIn){
        String companyName = newProjectIn.getCompanyName(), projOwner = newProjectIn.getProjOwner();
        String projManager = newProjectIn.getProjManager(), projDescription = newProjectIn.getProjDescription();
        String projEstimatedHours  = newProjectIn.getProjEstimatedHours(), projStatus = newProjectIn.getProjStatus();

        if(newProjectIn.getCompanyName() == null || newProjectIn.getProjOwner() == null || newProjectIn.getProjManager() == null || newProjectIn.getProjDescription() == null || newProjectIn.getProjEstimatedHours() == null || newProjectIn.getProjStatus() == null){
            ArrayList<ProjectModel> updatedList = new ArrayList<>();
            updatedList.get(0).setProjId(0);
            updatedList.get(0).setProjDescription("Passing projects with null values is not permissible.  Passing empty strings or zeros are permissible.");
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
            stmt.setInt(7, projectIn.getProjId());
            stmt.setString(1, projectIn.getCompanyName());
            stmt.setString(2, projectIn.getProjOwner());
            stmt.setString(3, projectIn.getProjManager());
            stmt.setString(4, projectIn.getProjDescription());
            stmt.setString(5, projectIn.getProjEstimatedHours());
            stmt.setString(6, projectIn.getProjStatus());
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
                foundRequirement.setReqId(resultSet.getInt("reqId"));
                foundRequirement.setProjNumber(resultSet.getInt("projNumber"));
                foundRequirement.setReqType(resultSet.getString("reqType"));
                foundRequirement.setReqDescription(resultSet.getString("reqDescription"));
                foundRequirement.setReqStatus(resultSet.getString("reqStatus"));
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
        int projNumber = reqIn.getProjNumber();
        String reqType = reqIn.getReqType(), reqDescription = reqIn.getReqDescription(), reqStatus = reqIn.getReqStatus();
        if(!(reqIn.getProjNumber() >= 0) || reqType == null || reqDescription == null || reqStatus == null){
            ArrayList<RequirementModel> updatedReqList = new ArrayList<>();
            updatedReqList.get(0).setReqId(0);
            updatedReqList.get(0).setReqDescription("Passing requirements with null values is not permissible.  Passing empty strings or zeros are permissible.");
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
        ArrayList<RequirementModel> updatedReqList = GetRequirements(reqIn.getProjNumber());
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
            stmt.setInt(4, reqIn.getReqId());
            stmt.setString(1, reqIn.getReqType());
            stmt.setString(2, reqIn.getReqDescription());
            stmt.setString(3, reqIn.getReqStatus());
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RequirementModel> updatedReqList = GetRequirements(reqIn.getProjNumber());
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
                foundMember.setMemberId(resultSet.getInt("memberId"));
                foundMember.setProjNumber(resultSet.getInt("projNumber"));
                foundMember.setMemberFirstName(resultSet.getString("memberFirstName"));
                foundMember.setMemberLastName(resultSet.getString("memberLastName"));
                foundMember.setMemberPrimaryRole(resultSet.getString("memberPrimaryRole"));
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
        int  projNumber= teamMemberIn.getProjNumber();
        String memberFirstName = teamMemberIn.getMemberFirstName(), memberLastName = teamMemberIn.getMemberLastName(), memberPrimaryRole = teamMemberIn.getMemberPrimaryRole();
        if(!(projNumber >= 0) || memberFirstName == null || memberLastName == null || memberPrimaryRole == null){
            ArrayList<TeamMemberModel> teamMemberList = new ArrayList<>();
            teamMemberList.get(0).setMemberId(0);
            teamMemberList.get(0).setMemberFirstName("No Nulls");
            teamMemberList.get(0).setMemberLastName("No Nulls");
            return teamMemberList;
        }
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass);
            Statement statement = connection.createStatement();
            String query = "INSERT INTO pmt.TeamMembers" +
                    "(projNumber, memberFirstName, memberLastName, memberPrimaryRole)" +
                    " VALUES('"+ projNumber +"','"+ memberFirstName +"','"+ memberLastName +"','"+ memberPrimaryRole +"')";
            statement.executeUpdate(query);
        }catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<TeamMemberModel> teamMemberList = GetTeamMembers(teamMemberIn.getProjNumber());
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
            stmt.setInt(4, teamMemberIn.getMemberId());
            stmt.setString(1, teamMemberIn.getMemberFirstName());
            stmt.setString(2, teamMemberIn.getMemberLastName());
            stmt.setString(3, teamMemberIn.getMemberPrimaryRole());
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<TeamMemberModel> teamMemberList = GetTeamMembers(teamMemberIn.getProjNumber());
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
     *@param projIdIn the project id for the expended hours total that will be returned
     *@return count total of all expended hours records for a specified project id
     */
    public int calcExpendedTotal(int projIdIn) {
        int count = 0;
        ArrayList<ExpendedHoursModel> allRecords = GetExpendedHours(projIdIn);
        for (int i = 0; i < allRecords.size(); i++) {
            if (allRecords.get(i).getProjNumber() == projIdIn) {
                count += Integer.parseInt(allRecords.get(i).getExpNumHours());
            }
        }
        return count;
    }
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
                foundExpHoursRecord.setExpId(resultSet.getInt("expId"));
                foundExpHoursRecord.setExpHoursType(resultSet.getString("expHoursType"));
                foundExpHoursRecord.setProjNumber(resultSet.getInt("projNumber"));
                foundExpHoursRecord.setExpDescription(resultSet.getString("expDescription"));
                foundExpHoursRecord.setExpNumHours(resultSet.getString("expNumHours"));
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
        int  projNumber= expendedHoursIn.getProjNumber();
        String memberFirstName = expendedHoursIn.getMemberFirstName(), memberLastName = expendedHoursIn.getMemberLastName();
        String expHoursType = expendedHoursIn.getExpHoursType(), expDescription = expendedHoursIn.getExpDescription();
        String expNumHours = expendedHoursIn.getExpNumHours();
        if(!(projNumber >= 0) || memberFirstName == null || memberLastName == null || expHoursType == null || expDescription == null || expNumHours == null ){
            ArrayList<ExpendedHoursModel> expendedHoursList = new ArrayList<>();
            expendedHoursList.get(0).setExpId(0);
            expendedHoursList.get(0).setExpDescription("No Nulls Allowed!");
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
        ArrayList<ExpendedHoursModel> expendedHoursList = GetExpendedHours(expendedHoursIn.getProjNumber());
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
                foundRisksRecord.setRiskId(resultSet.getInt("riskId"));
                foundRisksRecord.setProjNumber(resultSet.getInt("projNumber"));
                foundRisksRecord.setRiskDescription(resultSet.getString("riskDescription"));
                foundRisksRecord.setRiskStatus(resultSet.getString("riskStatus"));
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
        int  projNumber= newRiskIn.getProjNumber();
        String riskDescription = newRiskIn.getRiskDescription(), riskStatus = newRiskIn.getRiskStatus();
        if(!(projNumber >= 0) || riskDescription == null || riskStatus == null){
            ArrayList<RiskModel> updatedRiskList = new ArrayList<>();
            updatedRiskList.get(0).setRiskId(0);
            updatedRiskList.get(0).setRiskDescription("No Nulls Allowed!");
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
        ArrayList<RiskModel> updatedRiskList = GetRisks(newRiskIn.getProjNumber());
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
            stmt.setInt(4, riskIn.getRiskId());
            stmt.setInt(1, riskIn.getProjNumber());
            stmt.setString(2, riskIn.getRiskDescription());
            stmt.setString(3, riskIn.getRiskStatus());
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<RiskModel> updatedRisksList = GetRisks(riskIn.getProjNumber());
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