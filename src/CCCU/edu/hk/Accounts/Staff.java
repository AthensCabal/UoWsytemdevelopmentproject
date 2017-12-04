package CCCU.edu.hk.Accounts;

/**
 * Name:Staff Description:A class that define the necessary attributes and
 * methods for a Staff Object
 *
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class Staff implements Accounts {

    private String userName;
    private String password;
    private String firstname;
    private String lastname;
    private String EID;
    private String CommitteeTitle;
    private String Department;
    private boolean isCommitteeMember;

    public Staff() {
        userName = "";
        password = "";
        firstname = "";
        lastname = "";
        EID = "";
        CommitteeTitle = "";
        Department = "";
        isCommitteeMember = false;

    }

    public Staff(String usr, String passwrd, String firstname, String lastname, String EID, String dept, String c_title, boolean isC_member) {

        userName = usr;
        password = passwrd;
        this.firstname = firstname;
        this.lastname = lastname;
        this.EID = EID;
        Department = dept;
        CommitteeTitle = c_title;
        isCommitteeMember = isC_member;

    }

    @Override
    public String getUserName() {

        return userName;

    }

    @Override
    public String getFirstName() {

        return firstname;

    }
    
    @Override
    public String getLastName() {
        return lastname;
    }
    
    @Override
    public String getEID() {

        return EID;

    }
    
    public String getPassword() {
        return password;
    }
    
    public String getDepartment() {
        return Department;
    }
    
    public String getCommitteeTitle(){
        return CommitteeTitle;
    }

    public boolean CommitteeMemberCheck(){
        return isCommitteeMember;
    }
}
