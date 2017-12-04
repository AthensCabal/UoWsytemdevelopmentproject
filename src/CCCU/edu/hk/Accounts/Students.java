package CCCU.edu.hk.Accounts;

/**
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class Students implements Accounts {

    private String userName;
    private String password;
    private String name;
    private String EID;
    private String role;
    private String division;
    private String programme;
    private String STDEmail;
    private String altEmail;
    private int numOfApplication;

    public Students() {

        userName = "";
        password = null;
        name = "";
        EID = "";
        role = "Student";
        division = "";
        programme = "";
        STDEmail = "";
        altEmail = "";
        numOfApplication = 0;

    }

    public Students(String usr, String passwrd, String name, String EID, String role, int numApp) {

        userName = usr;
        password = passwrd;
        this.name = name;
        this.EID = EID;
        this.role = role;
        numOfApplication = numApp;

    }

    @Override
    public String getUserName() {

        return userName;

    }

    @Override
    public String getName() {

        return name;

    }

    @Override
    public String getRole() {

        return role;

    }

    @Override
    public String getEID() {

        return EID;

    }

    public void setNumOfApp() {

        numOfApplication++;

    }
}
