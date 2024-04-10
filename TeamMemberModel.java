public class TeamMemberModel {
    private int memberId = 0;
    private int projNumber = 0;
    private String memberFirstName = "";
    private String memberLastName = "";
    private String memberPrimaryRole = "";

    public TeamMemberModel() {

    }

    public TeamMemberModel(int memberIdIn, int projNumberIn, String memberFirstNameIn, String memberLastNameIn, String memberPrimaryRoleIn) {
        this.memberId = memberIdIn;
        this.memberFirstName = memberFirstNameIn;
        this.memberLastName = memberLastNameIn;
        this.memberPrimaryRole = memberPrimaryRoleIn;
    }

    public int getMemberId() {
        return memberId;
    }

    public int getProjNumber() {
        return projNumber;
    }

    public String getMemberFirstName() {
        return memberFirstName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public String getMemberPrimaryRole() {
        return memberPrimaryRole;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setProjNumber(int projNumber) {
        this.projNumber = projNumber;
    }

    public void setMemberFirstName(String memberFirstName) {
        this.memberFirstName = memberFirstName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
    }

    public void setMemberPrimaryRole(String memberPrimaryRole) {
        this.memberPrimaryRole = memberPrimaryRole;
    }
}

