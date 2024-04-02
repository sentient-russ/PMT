public class TeamMemberModel {
    int memberId;
    int projNumber;
    String memberFirstName;
    String memberLastName;
    String memberPrimaryRole;
    public TeamMemberModel(int memberIdIn, int projNumberIn, String memberFirstNameIn, String memberLastNameIn, String memberPrimaryRoleIn){
        this.memberId = memberIdIn;
        this.memberFirstName = memberFirstNameIn;
        this.memberLastName = memberLastNameIn;
        this.memberPrimaryRole = memberPrimaryRoleIn;
    }

}