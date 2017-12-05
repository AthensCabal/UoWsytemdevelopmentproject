package CCCU.edu.hk.Accounts;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * Students Class
     *
     * @param userName - Stores the username used by the student
     * @param password - Stores the password used by the student
     * @param firstname - Stores the first name of the student
     * @param lastname - Stores the last name of the student
     * @param SID - Stores the student ID card number of the student
     * @param EID - Stores the EID of the student
     * @param level - Stores the EID of the student
     * @param division - Stores the division of the student
     * @param programme - Stores the programme the student is in
     * @param STDEmail - Stores the student email
     * @param ALTEmail - Stores the private email
     * @param CGPA - Stores the CGPA
     * @param numOfApplication - Holds the number of Application
     * @param applied - Holds a list of applied scholarships
     */
    private String userName;
    private String password;
    private String firstname;
    private String lastname;
    private int SID;
    private String EID;
    private String level;
    private String division;
    private String programme;
    private String STDEmail;
    private String ALTEmail;
    private double CGPA;
    private int numOfApplication;
    private List<String> applied;

    /*Contructor of Student*/
    public Students() {

        userName = "";
        password = "";
        firstname = "";
        lastname = "";
        EID = "";
        SID = -1;
        level = "";
        division = "";
        programme = "";
        STDEmail = "";
        ALTEmail = "";
        CGPA = -1;
        numOfApplication = 0;
        applied = new ArrayList();
        
    }

    /*Constructor of Student(Overloads)*/
    public Students(String usr, String passwrd, String firstname, String lastname, String EID, int sid, String lvl, String div, String prog, String std, String alt, double cgpa,List<String> app) {

        userName = usr;
        password = passwrd;
        this.firstname = firstname;
        this.lastname = lastname;
        this.EID = EID;
        SID = sid;
        level = lvl;
        division = div;
        programme = prog;
        STDEmail = std;
        ALTEmail = alt;
        CGPA = cgpa;
        numOfApplication = 0;
        applied = app;
        
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
     * @returns lastname
     */
    public String getLastName() {

        return lastname;

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
     * @returns EID
     */
    public String getEID() {

        return EID;

    }

    /**
     * @return SID
     */
    public int getSID() {

        return SID;

    }

    /**
     * @return password
     */
    public String getPassword() {

        return password;

    }

    /**
     * @return level
     */
    public String getLevel() {

        return level;

    }

    /**
     * @return division
     */
    public String getDivsion() {

        return division;

    }

    /**
     * @return programme
     */
    public String getProgramme() {

        return programme;

    }

    /**
     * @return STDEmail
     */
    public String getSTDEmail() {

        return STDEmail;

    }

    /**
     * @return ALTEmail
     */
    public String getALTEmail() {

        return ALTEmail;

    }

    /**
     * @return CGPA
     */
    public double getCGPA() {

        return CGPA;

    }

    /**
     * @return numOfApplication
     */
    public int getNumOfApp() {

        return numOfApplication;

    }
    
    /**
     * @return applied
     */
    public List<String> getApplied(){
    
        return applied;
        
    }

    /**
     * Set Method - sets username variable
     *
     * @param newName
     */
    public void setUserName(String newName) {

        userName = newName;

    }

    /**
     * Set Method - sets password variable
     *
     * @param password
     */
    public void setPassword(String password) {

        this.password = password;

    }

    /**
     * Set Method - sets firstname variable
     *
     * @param first
     */
    public void setFirstName(String first) {

        firstname = first;

    }

    /**
     * Set Method - sets lastname variable
     *
     * @param last
     */
    public void setLastName(String last) {

        lastname = last;

    }

    /**
     * Set Method - sets EID variable
     *
     * @param EID
     */
    public void setEID(String EID) {

        this.EID = EID;

    }

    /**
     * Set Method - sets SID variable
     *
     * @param ID
     */
    public void setSID(int ID) {

        SID = ID;

    }

    /**
     * Set Method - sets level variable
     *
     * @param lvl
     */
    public void setLevel(String lvl) {

        level = lvl;

    }

    /**
     * Set Method - sets division variable
     *
     * @param div
     */
    public void setDivision(String div) {

        division = div;

    }

    /**
     * Set Method - sets programme variable
     *
     * @param prgm
     */
    public void setProgramme(String prgm) {

        programme = prgm;

    }

    /**
     * Set Method - sets STDEmail variable
     *
     * @param email
     */
    public void setSTDEmail(String email) {

        STDEmail = email;

    }

    /**
     * Set Method - sets ALTEmail variable
     *
     * @param email
     */
    public void setALTEmail(String email) {

        ALTEmail = email;

    }

    /**
     * Set Method - sets CGPA variable
     *
     * @param cgpa
     */
    public void setCGPA(double cgpa) {

        CGPA = cgpa;

    }

    /**
     * Set Method - sets numOfApplication variable
     */
    public void setNumOfApp() {

        numOfApplication++;

    }

    public void setApplied(String ID){
    
        applied.add(ID);
    
    }
}
