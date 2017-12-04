package CCCU.edu.hk.Accounts;

/**
 * Name:Students Description:A class that define the necessary attributes and
 * methods for a Student Object
 *
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class Students implements Accounts {

    private String userName;
    private String password;
    private String firstname;
    private String lastname;
    private String EID;
    private String level;
    private String division;
    private String programme;
    private String STDEmail;
    private String ALTEmail;
    private long SGPA;
    private long CGPA;
    private int numOfApplication;

    public Students() {

        userName = "";
        password = null;
        firstname = "";
        lastname = "";
        EID = "";
        level = "";
        division = "";
        programme = "";
        STDEmail = "";
        ALTEmail = "";
        numOfApplication = 0;

    }

    public Students(String usr, String passwrd, String firstname, String lastname, String EID, String lvl, String div, String prog, String std, String alt) {

        userName = usr;
        password = passwrd;
        this.firstname = firstname;
        this.lastname = lastname;
        this.EID = EID;
        level = lvl;
        division = div;
        programme = prog;
        STDEmail = std;
        ALTEmail = alt;
        numOfApplication = 0;

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
    public String getUserName() {

        return userName;

    }

    @Override
    public String getEID() {

        return EID;

    }
    
    public String getPassword(){
    
        return password;
        
    }

    public void setNumOfApp() {

        numOfApplication++;

    }

    public void setUserName(String newName) {

        userName = newName;

    }

    public void setSTDEmail(String email) {

        STDEmail = email;

    }

    public void setALTEmail(String email) {

        ALTEmail = email;

    }
}
