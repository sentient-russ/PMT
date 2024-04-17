import java.sql.*;
import java.util.ArrayList;

public class DbAccess {
    String user = "classremote";
    String pass = "FiddleDeeStix1928";
    public DbAccess(){}
    /*******************
     * Projects Section
     * @
     *******************/
    
    /**
      * @return resultsList a list containing all of the projects in the system.
      */
    public ArrayList<ModelProject> GetProjects(){
        ArrayList<ModelProject> resultsList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.Projects";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()){
                    ModelProject foundProject = new ModelProject();
                    foundProject.projId = resultSet.getInt("projId");
                    foundProject.projOwner = resultSet.getString("projOwner");
                    foundProject.projManager = resultSet.getString("projManager");
                    foundProject.companyName = resultSet.getString("companyName");
                    foundProject.projDescription = resultSet.getString("projDescription");
                    foundProject.projEstimatedHours = resultSet.getString("projEstimatedHours");
                    foundProject.projStatus = resultSet.getString("projStatus");
                    resultsList.add(foundProject);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return resultsList;
    }
    /**
     * @param projIdIn project id number to be looked up in the DB and returned
     * @return foundProject a single project model
     */
    public ModelProject GetProject(int projIdIn){
        ModelProject foundProject = new ModelProject();
        ArrayList<ModelProject> projects = GetProjects();
        for(int i = 0; i <= projects.size();i++){
            if(projects.get(i).projId == projIdIn){
                foundProject.projId = projects.get(i).projId;
                foundProject.projOwner = projects.get(i).projOwner;
                foundProject.projManager = projects.get(i).projManager;
                foundProject.companyName = projects.get(i).companyName;
                foundProject.projDescription = projects.get(i).projDescription;
                foundProject.projEstimatedHours = projects.get(i).projEstimatedHours;
                foundProject.projStatus = projects.get(i).projStatus;
                return foundProject;
            }
        }        
        return foundProject;
    }
    /**
     * This method is used by InsertProject() to get the new id of the project that it inserted into the database.
     * @param companyNameIn 
     * @param projDescriptionIn
     * @return foundProject a single project model
     */
    public ModelProject GetProjectByCompanyDesc(String companyNameIn, String projDescriptionIn){
        ModelProject foundProject = new ModelProject();
        ArrayList<ModelProject> projects = GetProjects();
        for(int i = 0; i <= projects.size();i++){
            if(projects.get(i).companyName.equalsIgnoreCase(companyNameIn) && projects.get(i).projDescription.equalsIgnoreCase(projDescriptionIn)){
                foundProject.projId = projects.get(i).projId;
                foundProject.projOwner = projects.get(i).projOwner;
                foundProject.projManager = projects.get(i).projManager;
                foundProject.companyName = projects.get(i).companyName;
                foundProject.projDescription = projects.get(i).projDescription;
                foundProject.projEstimatedHours = projects.get(i).projEstimatedHours;
                foundProject.projStatus = projects.get(i).projStatus;
                return foundProject;
            }
        }        
        return foundProject;
    }
    /**
     * This method takes in a new project model without an id and returns a project model with an id
     * @param newProjectIn
     * @return updatedProject a single project model
     */
    public ModelProject InsertProject(ModelProject newProjectIn){
        String companyName = newProjectIn.companyName, projOwner = newProjectIn.projOwner, projManager = newProjectIn.projManager, projDescription = newProjectIn.projDescription, projEstimatedHours  = newProjectIn.projEstimatedHours, projStatus = newProjectIn.projStatus;
        if(newProjectIn.companyName == null || newProjectIn.projOwner == null || newProjectIn.projManager == null || newProjectIn.projDescription == null || newProjectIn.projEstimatedHours == null || newProjectIn.projStatus == null){
            ModelProject updatedProject = new ModelProject();
            updatedProject.projId = 0;
            updatedProject.projDescription = "Passing projects with null values is not permissible.  Passing empty strings or zeros are permissible.";
            return updatedProject;
        }
        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                Statement statement = connection.createStatement();
                String query = "INSERT INTO pmt.Projects" +
                        "(companyName, projOwner, projManager, projDescription, projEstimatedHours, projStatus )" +
                        " VALUES('"+ companyName +"','"+ projOwner +"','"+ projManager +"','"+ projDescription +"','"+ projEstimatedHours +"','"+ projStatus +"')";
                statement.executeUpdate(query);
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        ModelProject updatedProject = GetProjectByCompanyDesc(newProjectIn.companyName,newProjectIn.projDescription);

        return updatedProject;
    }
    /**
     * Updates an existing project in the database with updated attributes
     * @param projectIn a complete project
     * @return updatedList a list of project models
     */
    public ArrayList<ModelProject> UpdateProject(ModelProject projectIn){
        try{
            String query = ("UPDATE pmt.Projects SET companyName=?, projOwner=?, projManager=?,projDescription=?,projEstimatedHours=?,projStatus=? WHERE projId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(7, projectIn.projId);
                stmt.setString(1, projectIn.companyName);
                stmt.setString(2, projectIn.projOwner);
                stmt.setString(3, projectIn.projManager);
                stmt.setString(4, projectIn.projDescription);
                stmt.setString(5, projectIn.projEstimatedHours);
                stmt.setString(6, projectIn.projStatus);
                stmt.executeUpdate();
                connection.close();
            }

        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<ModelProject> updatedList = GetProjects();
        return updatedList;
    }
    /**
     * Deletes a project
     * @param projectIn a project Id number to be deleted
     * @return getProjects() a list of all project models in the DB
     */
    public ArrayList<ModelProject> DeleteProject(int projectIn){
        try{
            String query = ("DELETE FROM pmt.Projects  WHERE projId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, projectIn);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return GetProjects();
    }
    /*******************
     * Requirements Block
     * @
     *******************/
    
    /**
     * @param projIdIn the project id for the requirements list that will be returned
     * @return resultsList list of requirements for a specific project id
     */
    public ArrayList<ModelRequirement> GetRequirements(int projIdIn){
        ArrayList<ModelRequirement> resultsList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjReq WHERE projNumber=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, projIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelRequirement foundRequirement = new ModelRequirement();
                    foundRequirement.reqId = resultSet.getInt("reqId");
                    foundRequirement.projNumber = resultSet.getInt("projNumber");
                    foundRequirement.reqType = resultSet.getString("reqType");
                    foundRequirement.reqDescription = resultSet.getString("reqDescription");
                    foundRequirement.reqStatus = resultSet.getString("reqStatus");
                    resultsList.add(foundRequirement);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return resultsList;
    }
    /**
     * @param reqIdIn the requirement id for the record that will be returned
     * @return resultsList single requirement model
     */
    public ModelRequirement GetRequirement(int reqIdIn){
        ModelRequirement returnReq = new ModelRequirement();
        String query = "SELECT * FROM pmt.ProjReq WHERE reqId=?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, reqIdIn);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){

                returnReq.reqId = resultSet.getInt("reqId");
                returnReq.projNumber = resultSet.getInt("projNumber");
                returnReq.reqType = resultSet.getString("reqType");
                returnReq.reqDescription = resultSet.getString("reqDescription");
                returnReq.reqStatus = resultSet.getString("reqStatus");

                    connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }        
        return returnReq;        
    }    
    /**
     * Creates a new requirement record in the Db
     * @param reqIn the project id for the requirements list that will be returned
     * @return updatedReqList list of updated requirements for a specific project id
     */
    public int InsertRequirement(ModelRequirement reqIn){
        String reqType = reqIn.reqType, reqDescription = reqIn.reqDescription, reqStatus = reqIn.reqStatus;
        int projNumber = reqIn.projNumber;
        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                Statement statement = connection.createStatement();
                String query = "INSERT INTO pmt.ProjReq" +
                        "(projNumber, reqType, reqDescription, reqStatus)" +
                        " VALUES('"+ projNumber +"','"+ reqType +"','"+ reqDescription +"','"+ reqStatus +"')";
                statement.executeUpdate(query);
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        ModelRequirement foundReq = new ModelRequirement();
        int newId = 0;
        String query = "SELECT * FROM pmt.ProjReq WHERE reqDescription=?";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, reqIn.reqDescription);
            ResultSet resultSet = stmt.executeQuery();
            
            while(resultSet.next()){

                foundReq.reqId = resultSet.getInt("reqId");
                foundReq.projNumber = resultSet.getInt("projNumber");
                foundReq.reqType = resultSet.getString("reqType");
                foundReq.reqDescription = resultSet.getString("reqDescription");
                foundReq.reqStatus = resultSet.getString("reqStatus");
                newId = foundReq.reqId;
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }        
        return newId;
    }
    /**
     * Updates a requirement record
     * @param reqIn a ReqModel that is complete with no fields null or empty string
     * @return GetRequirements() list of updated requirements for the project
     */
    public ArrayList<ModelRequirement> UpdateRequirement(ModelRequirement reqIn){
        try{
            String query = ("UPDATE pmt.ProjReq SET reqType=?, reqDescription=?, reqStatus=? WHERE reqId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(4, reqIn.reqId);
                stmt.setString(1, reqIn.reqType);
                stmt.setString(2, reqIn.reqDescription);
                stmt.setString(3, reqIn.reqStatus);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return GetRequirements(reqIn.projNumber);
    }
    /**
     * Deletes a requirement record
     * @param reqIdIn the requirement id number to be deleted
     * @param projIdIn the id for the current project. Will be used to get the updated project results
     * @return updatedReqList list of updated requirements for the project
     */
    public ArrayList<ModelRequirement> DeleteRequirement(int reqIdIn, int projIdIn){
        try{
            String query = ("DELETE FROM pmt.ProjReq  WHERE reqId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, reqIdIn);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return GetRequirements(projIdIn);
    }
    /*******************
     * Team Members Block
     * @ 
     *******************/
    
    /**
     * @param projIdIn the project id for the team members list that will be returned
     * @return resultsList list of team members for a specified project id
     */
    public ArrayList<ModelTeamMember> GetTeamMembers(int projIdIn){
        ArrayList<ModelTeamMember> teamMemberList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.TeamMembers WHERE projNumber=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, projIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelTeamMember foundMember = new ModelTeamMember();
                    foundMember.memberId = resultSet.getInt("memberId");
                    foundMember.projNumber = resultSet.getInt("projNumber");
                    foundMember.memberFirstName = resultSet.getString("memberFirstName");
                    foundMember.memberLastName = resultSet.getString("memberLastName");
                    foundMember.memberPrimaryRole = resultSet.getString("memberPrimaryRole");
                    teamMemberList.add(foundMember);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return teamMemberList;
    }
    /*
     * Creates a new team member record in the Db
     * @param teamMemberIn completed team member model to insert into the Db
     * @return teamMemberList update list of team members for a specific project id
     */
    public ArrayList<ModelTeamMember> InsertTeamMember(ModelTeamMember teamMemberIn){
        int  projNumber= teamMemberIn.projNumber;
        String memberFirstName = teamMemberIn.memberFirstName, memberLastName = teamMemberIn.memberLastName, memberPrimaryRole = teamMemberIn.memberPrimaryRole;
        if(!(projNumber >= 0) || memberFirstName == null || memberLastName == null || memberPrimaryRole == null){
            ArrayList<ModelTeamMember> teamMemberList = new ArrayList<>();
            teamMemberList.get(0).memberId = 0;
            teamMemberList.get(0).memberFirstName = "No Nulls";
            teamMemberList.get(0).memberLastName = "No Nulls";
            return teamMemberList;
        }
        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                Statement statement = connection.createStatement();
                String query = "INSERT INTO pmt.TeamMembers" +
                        "(projNumber, memberFirstName, memberLastName, memberPrimaryRole)" +
                        " VALUES('"+ projNumber +"','"+ memberFirstName +"','"+ memberLastName +"','"+ memberPrimaryRole +"')";
                statement.executeUpdate(query);
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return GetTeamMembers(teamMemberIn.projNumber);
    }
    /*
     * Updates a team member record
     * @param teamMemberIn a ModelTeamMember that is complete with no fields null or as empty string
     * @return teamMemberList list of updated team members to display for the project
     */
    public ArrayList<ModelTeamMember> UpdateTeamMember(ModelTeamMember teamMemberIn){
        try{
            String query = ("UPDATE pmt.TeamMembers SET memberFirstName=?, memberLastName=?, memberPrimaryRole=? WHERE memberId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(4, teamMemberIn.memberId);
                stmt.setString(1, teamMemberIn.memberFirstName);
                stmt.setString(2, teamMemberIn.memberLastName);
                stmt.setString(3, teamMemberIn.memberPrimaryRole);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return GetTeamMembers(teamMemberIn.projNumber);
    }
    /*
     * Deletes a team member record
     * @param teamMemberIdIn the requirement id number to be deleted
     * @param projIdIn the id for the current project. Will be used to get the updated team member list
     * @return updatedTeamMemberList list of updated requirements for the project
     */
    public ArrayList<ModelTeamMember> DeleteTeamMember(int teamMemberIdIn, int projIdIn){
        try{
            String query = ("DELETE FROM pmt.TeamMembers  WHERE memberId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, teamMemberIdIn);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return GetTeamMembers(projIdIn);
    }
    /*******************
     * Expended Hours Block
     * @return 
     *******************/
    
     /**
      * Returns the total expended hours for a project
     * @param projIdIn
     * @return 
      */
    public double calcExpendedTotal(int projIdIn){
        ArrayList<ModelExpendedHours> expendedHoursList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjExpHours WHERE projNumber=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, projIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelExpendedHours foundExpHoursRecord = new ModelExpendedHours();
                    foundExpHoursRecord.expId = resultSet.getInt("expId");
                    foundExpHoursRecord.reqNumber = resultSet.getInt("reqId");                    
                    foundExpHoursRecord.projNumber = resultSet.getInt("projNumber");
                    foundExpHoursRecord.memberFirstName = resultSet.getString("memberFirstName");
                    foundExpHoursRecord.memberLastName = resultSet.getString("memberLastName");
                    foundExpHoursRecord.expDescription = resultSet.getString("expDescription");
                    foundExpHoursRecord.expHoursType = resultSet.getString("expHoursType");
                    foundExpHoursRecord.expNumHours = resultSet.getDouble("expNumHours");
                    expendedHoursList.add(foundExpHoursRecord);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }       
        double count = 0;        
        for(int i = 0; i < expendedHoursList.size(); i++){
            if(expendedHoursList.get(i).projNumber == projIdIn){
                count += expendedHoursList.get(i).expNumHours;
            }
        }
        return count;
    }
    /**
     * @param projIdIn the project id for the expended hours list that will be returned
     * @return resultsList list of expended hours records for a specified project id
     */
    public ArrayList<ModelExpendedHours> GetExpendedHours(int reqIdIn){
        ArrayList<ModelExpendedHours> expendedHoursList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjExpHours WHERE reqId=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, reqIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelExpendedHours foundExpHoursRecord = new ModelExpendedHours();
                    foundExpHoursRecord.expId = resultSet.getInt("expId");
                    foundExpHoursRecord.reqNumber = resultSet.getInt("reqId");                    
                    foundExpHoursRecord.projNumber = resultSet.getInt("projNumber");
                    foundExpHoursRecord.memberFirstName = resultSet.getString("memberFirstName");
                    foundExpHoursRecord.memberLastName = resultSet.getString("memberLastName");
                    foundExpHoursRecord.expDescription = resultSet.getString("expDescription");
                    foundExpHoursRecord.expHoursType = resultSet.getString("expHoursType");
                    foundExpHoursRecord.expNumHours = resultSet.getDouble("expNumHours");
                    expendedHoursList.add(foundExpHoursRecord);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return expendedHoursList;
    }
    /**
     * @param reqIdIn the requirement id for the requirement to get a total expended hours count for
     * @return estHoursCount the expended hours for a specific requirement
     */
    public int GetRequirementExpendedHours(int reqIdIn){
        int estHoursCount = 0;
        ArrayList<ModelEstimatedHours> estimatedHoursList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjEstHours WHERE reqId=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, reqIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelEstimatedHours foundEstHoursRecord = new ModelEstimatedHours();
                    foundEstHoursRecord.estId = resultSet.getInt("estId");
                    foundEstHoursRecord.reqNumber = resultSet.getInt("reqId");
                    foundEstHoursRecord.estHoursType = resultSet.getString("estHoursType");
                    foundEstHoursRecord.projNumber = resultSet.getInt("projNumber");
                    foundEstHoursRecord.estDescription = resultSet.getString("estDescription");
                    foundEstHoursRecord.estNumHours = resultSet.getDouble("estNumHours");
                    estimatedHoursList.add(foundEstHoursRecord);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        for(int i = 0; i < estimatedHoursList.size(); i++){
            estHoursCount += estimatedHoursList.get(i).estNumHours;
        }
        return estHoursCount;
    }
    /**
     * Creates a new expended hours record in the Db
     * @param expendedHoursIn the partial expended hours model to be inserted into the Db
     * @return GetExpendedHours() list of updated expended hours records for a specific project id
     */
    public ArrayList<ModelExpendedHours> InsertExpendedHours(ModelExpendedHours expendedHoursIn){
        int  projNumber = expendedHoursIn.projNumber, reqId = expendedHoursIn.reqNumber;
        double expNumHours = expendedHoursIn.expNumHours;
        String memberFirstName = expendedHoursIn.memberFirstName, memberLastName = expendedHoursIn.memberLastName, expHoursType = expendedHoursIn.expHoursType, expDescription = expendedHoursIn.expDescription;

        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                Statement statement = connection.createStatement();
                
                String query = "INSERT INTO pmt.ProjExpHours" +
                        "(projNumber, memberFirstName, memberLastName, expHoursType, expDescription, expNumHours, reqId)" +
                        " VALUES('" + String.valueOf(projNumber) + "','" + memberFirstName + "','" + memberLastName + "','" + expHoursType +"','"+ expDescription +"','"+ expNumHours + "','"+ String.valueOf(reqId) + "')";
                statement.executeUpdate(query);
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return GetExpendedHours(expendedHoursIn.projNumber);
    }
    /**
     * Updates a singe expended hours record
     * @param expModelIn the completed expended hours model to be inserted into the Db
     * @return GetExpendedHours() list of updated expended hours records for a specific project id
     */
    public ArrayList<ModelExpendedHours> UpdateExpendedHoursRecord(ModelExpendedHours expModelIn){
    try{
        String query = ("UPDATE pmt.ProjExpHours SET projNumber=?, memberFirstName=?,memberLastname=?, expHoursType=?, expDescription=?,expNumHours=?,reqId=? WHERE expId=?");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(8, expModelIn.expId);
            stmt.setInt(1, expModelIn.projNumber);
            stmt.setString(2, expModelIn.memberFirstName);
            stmt.setString(3, expModelIn.memberLastName);
            stmt.setString(4, expModelIn.expHoursType);
            stmt.setString(5, expModelIn.expDescription);
            stmt.setDouble(6, expModelIn.expNumHours);
            stmt.setInt(7, expModelIn.reqNumber);
            stmt.executeUpdate();
            connection.close();
        }
    } catch (SQLException e){
        System.out.println(e);
    }
    return GetExpendedHours(expModelIn.reqNumber);
    }
    /**
     * Deletes an expended hours record
     * @param expIdIn the expended hours id number to be deleted
     * @param projIdIn the id for the current project. Will be used to get the updated expended hours list
     * @return updatedExpendedHoursList list of updated hours list for the project
     */
    public ArrayList<ModelExpendedHours> DeleteExpendedHours(int expIdIn, int projIdIn){
        try{
            String query = ("DELETE FROM pmt.ProjExpHours  WHERE expIdIn=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, expIdIn);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return GetExpendedHours(projIdIn);
    }
    /*******************
     * Estimated Hours Block
     * 
     *******************/

    /**
     * Gets the estimated hours for a single requirement
     * @param reqIdIn 
     * @return expHoursCount 
     */
    public double GetRequirementEstimatedHours(int reqIdIn){
        double expHoursCount = 0;
        ArrayList<ModelExpendedHours> expendedHoursList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjExpHours WHERE reqId=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, reqIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelExpendedHours foundExpHoursRecord = new ModelExpendedHours();
                    foundExpHoursRecord.expId = resultSet.getInt("expId");
                    foundExpHoursRecord.reqNumber = resultSet.getInt("reqId");
                    foundExpHoursRecord.expHoursType = resultSet.getString("expHoursType");
                    foundExpHoursRecord.projNumber = resultSet.getInt("projNumber");
                    foundExpHoursRecord.expDescription = resultSet.getString("expDescription");
                    foundExpHoursRecord.expNumHours = resultSet.getDouble("expNumHours");
                    expendedHoursList.add(foundExpHoursRecord);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        for(int i = 0; i < expendedHoursList.size(); i++){
            expHoursCount += expendedHoursList.get(i).expNumHours;
        }
        return expHoursCount;
    }
    /**
     * Returns the total estimated hours for a project which includes all requirements
     * @param projIdIn 
     * @return estHoursCount 
     */
    public double calcProjEstimateTotal (int projIdIn){
        ArrayList<ModelEstimatedHours> estimatedHoursList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjEstHours WHERE projNumber=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, projIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelEstimatedHours foundEstRecord = new ModelEstimatedHours();
                    foundEstRecord.estId = resultSet.getInt("estId");
                    foundEstRecord.reqNumber = resultSet.getInt("reqId");
                    foundEstRecord.estHoursType = resultSet.getString("estHoursType");
                    foundEstRecord.projNumber = resultSet.getInt("projNumber");
                    foundEstRecord.estDescription = resultSet.getString("estDescription");
                    foundEstRecord.estNumHours = resultSet.getDouble("estNumHours");
                    foundEstRecord.reqNumber = resultSet.getByte("reqId");
                    estimatedHoursList.add(foundEstRecord);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        double estHoursCount = 0;
        for(int i = 0; i < estimatedHoursList.size(); i++){
        estHoursCount += estimatedHoursList.get(i).estNumHours;  
        }       
        return estHoursCount;
    }
    /**
     * This is so the requirements time estimate records can be displayed in a table under estimate details
     * @param reqIdIn 
     * @return estimatedHoursList list of all estimates records for a single requirement
     */
    public ArrayList<ModelEstimatedHours> GetAllReqEstimateRecords (int reqIdIn){
        ArrayList<ModelEstimatedHours> estimatedHoursList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjEstHours WHERE reqId=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, reqIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelEstimatedHours foundEstRecord = new ModelEstimatedHours();
                    foundEstRecord.estId = resultSet.getInt("estId");
                    foundEstRecord.reqNumber = resultSet.getInt("reqId");
                    foundEstRecord.estHoursType = resultSet.getString("estHoursType");
                    foundEstRecord.projNumber = resultSet.getInt("projNumber");
                    foundEstRecord.memberFirstName = resultSet.getString("memberFirstName");
                    foundEstRecord.memberLastName = resultSet.getString("memberLastName");
                    foundEstRecord.estDescription = resultSet.getString("estDescription");
                    foundEstRecord.estNumHours = resultSet.getDouble("estNumHours");
                    foundEstRecord.reqNumber = resultSet.getByte("reqId");
                    estimatedHoursList.add(foundEstRecord);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return estimatedHoursList;
    }
    /**
     * This will be used to edit estimate records on the detail screen.
     * @param reqIdIn 
     * @param estIdIn 
     * @return estimatedHoursModel the estimate to be displayed and edited
     */
    public ModelEstimatedHours GetProjEstimateRecord(int estIdIn, int reqIdIn){
        ModelEstimatedHours estimatedHoursModel = new ModelEstimatedHours();
        try{
            String query = "SELECT * FROM pmt.ProjEstHours WHERE estId=? AND reqId=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, reqIdIn);
                stmt.setInt(2, estIdIn);                
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    estimatedHoursModel.estId = resultSet.getInt("estId");
                    estimatedHoursModel.reqNumber = resultSet.getInt("reqId");
                    estimatedHoursModel.estHoursType = resultSet.getString("estHoursType");
                    estimatedHoursModel.projNumber = resultSet.getInt("projNumber");
                    estimatedHoursModel.estDescription = resultSet.getString("estDescription");
                    estimatedHoursModel.estNumHours = resultSet.getDouble("estNumHours");
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return estimatedHoursModel;
    }
    /**
     * This will be used to edit estimate records on the detail screen.
     * @param requIdIn 
     * @return count the total estimated hours for one requirement
     */
    public double calcEstimateRequirementHoursTotal(int requIdIn){
    int count = 0;
    ArrayList<ModelEstimatedHours> allRecords = GetAllReqEstimateRecords(requIdIn);
    for(int i = 0; i < allRecords.size(); i++){
        if(allRecords.get(i).reqNumber   == requIdIn){
            count += allRecords.get(i).estNumHours;
        }
    }
    return count;
    }
    /**
     * This will be used to edit estimate records on the detail screen.
     * @param estModelIn 
     * @return count the total estimated hours for one requirement
     */
    public double UpdateEstimatedHoursRecord(ModelEstimatedHours estModelIn){
    try{
        String query = ("UPDATE pmt.ProjEstHours SET projNumber=?, memberFirstName=?,memberLastname=?, estHoursType=?, estDescription=?,estNumHours=?,reqId=? WHERE estId=?");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(8, estModelIn.estId);
            stmt.setInt(1, estModelIn.projNumber);
            stmt.setString(2, estModelIn.memberFirstName);
            stmt.setString(3, estModelIn.memberLastName);
            stmt.setString(4, estModelIn.estHoursType);
            stmt.setString(5, estModelIn.estDescription);
            stmt.setDouble(6, estModelIn.estNumHours);
            stmt.setInt(7, estModelIn.reqNumber);
            stmt.executeUpdate();
            connection.close();
        }
    } catch (SQLException e){
        System.out.println(e);
    }
    return calcEstimateRequirementHoursTotal(estModelIn.reqNumber);
    }
    /**
     * Creates a new estimate hours record in the Db
     * @param estimatedHoursRecordIn the completed estimated hours model to be inserted into the Db
     * @return estimatedHoursList list of updated estimated hours records for a specific project id
     */
    public ArrayList<ModelEstimatedHours> InsertEstimatedHours(ModelEstimatedHours estimatedHoursRecordIn){
        String memberFirstName = estimatedHoursRecordIn.memberFirstName, memberLastName = estimatedHoursRecordIn.memberLastName, estHoursType = estimatedHoursRecordIn.estHoursType, estDescription = estimatedHoursRecordIn.estDescription;
        int reqId = estimatedHoursRecordIn.reqNumber;
        int projNumber = estimatedHoursRecordIn.projNumber;
        double estNumHours = estimatedHoursRecordIn.estNumHours;
        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                Statement statement = connection.createStatement();
                String query = "INSERT INTO pmt.ProjEstHours" +
                        "(projNumber, memberFirstName, memberLastName, estHoursType, estDescription, estNumHours, reqId)" +
                        " VALUES('" + projNumber + "','" + memberFirstName + "','" + memberLastName + "','" + estHoursType +"','"+ estDescription +"','"+ estNumHours + "','"+ reqId + "')";
                statement.executeUpdate(query);
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return GetAllReqEstimateRecords(estimatedHoursRecordIn.reqNumber);
    }
    /**
     * Deletes an hours estimate record
     * @param reqIdIn 
     * @return updatedEstimatedHoursList 
     */
    public ArrayList<ModelEstimatedHours> DeleteEstimatedHoursRecord(int reqIdIn){
        try{
            String query = ("DELETE FROM pmt.ProjEstHours  WHERE reqId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, reqIdIn);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return GetAllReqEstimateRecords(reqIdIn);
    }
    /*******************
     * Risks Block
     * 
     *******************/
    /**
     * @param projIdIn the project id for the project risks list that will be returned
     * @return foundRisksList list of project risks for a specified project id
     */
    public ArrayList<ModelRisk> GetRisks(int projIdIn){
        ArrayList<ModelRisk> foundRisksList = new ArrayList<>();
        try{
            String query = "SELECT * FROM pmt.ProjRisks WHERE projNumber=?";
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, projIdIn);
                ResultSet resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    ModelRisk foundRisksRecord = new ModelRisk();
                    foundRisksRecord.riskId = resultSet.getInt("riskId");
                    foundRisksRecord.projNumber = resultSet.getInt("projNumber");
                    foundRisksRecord.riskDescription = resultSet.getString("riskDescription");
                    foundRisksRecord.riskStatus = resultSet.getString("riskStatus");
                    foundRisksList.add(foundRisksRecord);
                }
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return foundRisksList;
    }
    /**
     * Creates a new risk record in the Db
     * @param newRiskIn the completed risk model to be inserted into the Db
     * @return updatedRiskList list of updated risk records for a specific project id
     */
    public ArrayList<ModelRisk> InsertRisk(ModelRisk newRiskIn){
        int  projNumber= newRiskIn.projNumber;
        String riskDescription = newRiskIn.riskDescription, riskStatus = newRiskIn.riskStatus;
        if(!(projNumber >= 0) || riskDescription == null || riskStatus == null){
            ArrayList<ModelRisk> updatedRiskList = new ArrayList<>();
            updatedRiskList.get(0).riskId = 0;
            updatedRiskList.get(0).riskDescription = "No Nulls Allowed!";
            return updatedRiskList;
        }
        try{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                Statement statement = connection.createStatement();
                String query = "INSERT INTO pmt.ProjRisks" +
                        "(projNumber, riskDescription, riskStatus)" +
                        " VALUES('" + projNumber + "','" + riskDescription + "','" + riskStatus + "')";
                statement.executeUpdate(query);
                connection.close();
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return GetRisks(newRiskIn.projNumber);
    }
    /**
     * Updates a risk record
     * @param riskIn a ModelRisk that is complete with no fields null or as empty string
     * @return updatedRisksList list of updated risks to display for the project
     */
    public ArrayList<ModelRisk> UpdateRisk(ModelRisk riskIn){
        try{
            String query = ("UPDATE pmt.ProjRisks SET projNumber=?, riskDescription=?, riskStatus=? WHERE riskId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(4, riskIn.riskId);
                stmt.setInt(1, riskIn.projNumber);
                stmt.setString(2, riskIn.riskDescription);
                stmt.setString(3, riskIn.riskStatus);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        ArrayList<ModelRisk> updatedRisksList = GetRisks(riskIn.projNumber);
        return updatedRisksList;
    }
    /**
     * Deletes a risk record
     * @param riskIdIn the risk id number to be deleted
     * @param projIdIn the id for the current project. Will be used to get the updated the risks list
     * @return updatedRisksList list of updated risks to display for the project
     */
    public ArrayList<ModelRisk> DeleteRisk(int riskIdIn, int projIdIn){
        try{
            String query = ("DELETE FROM pmt.ProjRisks  WHERE riskId=?");
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://162.205.232.101:3306/pmt", this.user, this.pass)) {
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, riskIdIn);
                stmt.executeUpdate();
                connection.close();
            }
        } catch (SQLException e){
            System.out.println(e);
        }
        return GetRisks(projIdIn);
    }
}