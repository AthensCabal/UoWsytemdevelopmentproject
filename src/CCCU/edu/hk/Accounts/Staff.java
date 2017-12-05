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

    /**
     * @param userName - Stores the username used by the staff
     * @param password - Stores the password used by the staff
     * @param firstname - Stores the first name used by the staff
     * @param lastname - Stores the last name used by the staff
     * @param EID - Stores the EID used by the staff
     * @param SID - Stores the SID used by the staff
     * @param division - Stores the division of the staff
     * @param title - Stores the title held by the staff
     * @param status - Stores the working status of the staff
     * @param STFFEmail - Stores the staff email of the staff
     * @param isCommitteeMember - Stores the boolean whether the staff is a committee member
     * @param committeeTitle - Stores the committee title used by the staff
     */
    private String userName;
    private String password;
    private String firstname;
    private String lastname;
    private String EID;
    private int SID;
    private String division;
    private String title;
    private String status;
    private String STFFEmail;
    private boolean isCommitteeMember;
    private String CommitteeTitle;

    /*Staff class constructor*/
    public Staff() {

        userName = "";
        password = "";
        firstname = "";
        lastname = "";
        EID = "";
        SID = -1;
        division = "";
        title = "";
        status = "";
        STFFEmail = "";
        isCommitteeMember = false;
        CommitteeTitle = null;

    }

    /*Constructor for staff class(Overloading)*/
    public Staff(String usr, String passwrd, String firstname, String lastname,int sid ,String EID, String div, String title, String stat, String email, String c_title, boolean isC_member) {

        userName = usr;
        password = passwrd;
        this.firstname = firstname;
        this.lastname = lastname;
        SID = sid;
        this.EID = EID;
        division = div;
        this.title = title;
        status = stat;
        STFFEmail = email;
        isCommitteeMember = isC_member;
        CommitteeTitle = c_title;

    }

    @Override
    /**
     * @return userName
     */
    public String getUserName() {

        return userName;

    }

    @Override
    /**
     * @return firstname
     */
    public String getFirstName() {

        return firstname;

    }

    @Override
    /**
     * @return lastname
     */
    public String getLastName() {
        return lastname;
    }

    @Override
    /**
     * @return EID
     */
    public String getEID() {

        return EID;

    }
    
    public int getSID(){
    
        return SID;
    
    }

    /**
     * @return password
     */
    public String getPassword() {

        return password;

    }

    /**
     * @return division
     */
    public String getDivsion() {

        return division;

    }

    /**
     * @return title
     */
    public String getTitle() {

        return title;

    }

    /**
     * @return status
     */
    public String getStatus() {

        return status;

    }

    /**
     * @return STFFEmail
     */
    public String getSTFFEmail() {

        return STFFEmail;

    }

    /**
     * @return CommitteeTitle
     */
    public String getCommitteeTitle() {

        return CommitteeTitle;

    }

    /**
     * @return isCommitteeMember
     */
    public boolean CommitteeMemberCheck() {

        return isCommitteeMember;

    }

    /**
     * @param usrnam
     */
    public void setUserName(String usrnam) {

        userName = usrnam;
        
    }

    /**
     * @param pass
     */
    public void setPassword(String pass) {

        password = pass;
        
    }

    /**
     * @param name
     */
    public void setFirstName(String name) {

       firstname = name;
        
    }

    /**
     * @param name
     */
    public void setLastName(String name) {

        lastname = name;
        
    }

    /**
     * @param eid
     */
    public void setEID(String eid) {

        EID = eid;
        
    }

    /**
     * @param div
     */
    public void setDivision(String div) {

    }

    /**
     * @param title
     */
    public void setTitle(String title) {

        this.title = title;
        
    }

    /**
     * @param stat
     */
    public void setStatus(String stat) {

        status = stat;
        
    }

    /**
     * @param email
     */
    public void setSTFFEmail(String email) {

        STFFEmail = email;
        
    }

    /**
     * @param CM
     */
    public void setIsCommitteeMember(boolean CM) {

        isCommitteeMember = CM;
        
    }

    /**
     * @param title
     */
    public void setCommitteeTitle(String title) {

        CommitteeTitle = title;
        
    }

}
