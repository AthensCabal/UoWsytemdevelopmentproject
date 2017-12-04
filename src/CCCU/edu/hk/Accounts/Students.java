package CCCU.edu.hk.Accounts;

/**
 * Name:Students
 * Description:A class that define the necessary attributes and methods for a Student Object 
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class Students implements Accounts {

    public String userName;
    private String password;
    public String firstname;
    public String lastname;
    public String EID;
    public String division;
    public String programme;
    public String STDEmail;
    public String altEmail;
    public int numOfApplication;

    public Students() {

        userName = "";
        password = null;
        firstname = "";
        lastname = "";
        EID = "";
        division = "";
        programme = "";
        STDEmail = "";
        altEmail = "";
        numOfApplication = 0;

    }

    public Students(String usr, String passwrd, String firstname, String lastname, String EID, int numApp) {

        userName = usr;
        password = passwrd;
        this.firstname = firstname;
        this.lastname = lastname;
        this.EID = EID;
        numOfApplication = numApp;

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

    public void setNumOfApp() {

        numOfApplication++;

    }
}
