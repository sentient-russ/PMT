public class ExpendedHoursModel {
    private int expId = 0;
    private int projNumber = 0;
    private String memberFirstName = "";
    private String memberLastName = "";
    private String expHoursType = "";
    private String expDescription = "";
    private String expNumHours = "";
    public ExpendedHoursModel(){
    }
    public ExpendedHoursModel(int expIdIn, int projNumberIn, String memberFirstNameIn, String memberLastNameIn, String expHoursTypeIn, String expDescriptionIn, String expNumHoursIn){
        this.expId = expIdIn;
        this.projNumber = projNumberIn;
        this.memberFirstName = memberFirstNameIn;
        this.memberLastName = memberLastNameIn;
        this.expHoursType = expHoursTypeIn;
        this.expDescription = expDescriptionIn;
        this.expNumHours = expNumHoursIn;
    }

    public int getExpId() {
        return expId;
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

    public String getExpHoursType() {
        return expHoursType;
    }

    public String getExpDescription() {
        return expDescription;
    }

    public String getExpNumHours() {
        return expNumHours;
    }

    public void setExpId(int expId) {
        this.expId = expId;
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

    public void setExpHoursType(String expHoursType) {
        this.expHoursType = expHoursType;
    }
    public void setExpDescription(String expDescription) {
        this.expDescription = expDescription;
    }

    public void setExpNumHours(String expNumHours) {
        this.expNumHours = expNumHours;
    }
}