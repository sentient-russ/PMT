public class ModelTeamMember {
    int memberId = 0;
    int projNumber = 0;
    String memberFirstName = "";
    String memberLastName = "";
    String memberPrimaryRole = "";
    public ModelTeamMember(){

    }
    public ModelTeamMember(int memberIdIn, int projNumberIn, String memberFirstNameIn, String memberLastNameIn, String memberPrimaryRoleIn){
        this.memberId = memberIdIn;
        this.memberFirstName = memberFirstNameIn;
        this.memberLastName = memberLastNameIn;
        this.memberPrimaryRole = memberPrimaryRoleIn;
    }
}