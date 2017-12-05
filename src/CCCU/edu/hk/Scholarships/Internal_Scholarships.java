package CCCU.edu.hk.Scholarships;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Name:Internal_Scholarships Description:Attributes and methods of Internal
 * Scholarships that are provided at CCCU
 *
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class Internal_Scholarships implements Scholarships {

    /**
     * Internal_Scholarships
     *
     * @param name
     * @param ID
     * @param Description
     * @param Amount
     * @param initialCutOff
     * @param finalCutOff
     * @param CGPARequirements
     * @param level
     * @param division
     * @param programme
     */
    private String name;
    private String ID;
    private String Description;
    private double Amount;
    private int maxAwardees;
    private int maxApplicants;
    private Date initialCutOff;
    private Date finalCutOff;
    private List<String> level;
    private List<String> division;
    private List<String> programme;
    private double CGPARequirements;

    public Internal_Scholarships() {

        name = "";
        ID = "";
        Description = "";
        Amount = -1.0;
        maxAwardees = -1;
        maxApplicants = -1;
        initialCutOff = new Date();
        finalCutOff = new Date();
        level = new ArrayList();
        division = new ArrayList();
        programme = new ArrayList();
        CGPARequirements = -1.0;

    }

    public Internal_Scholarships(String nam, String id, String org, String des,double amt ,int maxAwd, int maxApp, Date ICO, Date FCO, double cgpa, List<String> lvl, List<String> div, List<String> prgm) {

        name = nam;
        ID = id;
        Description = des;
        Amount = amt;
        maxAwardees = maxAwd;
        maxApplicants = maxApp;
        initialCutOff = ICO;
        finalCutOff = FCO;
        CGPARequirements = cgpa;
        level = lvl;
        division = div;
        programme = prgm;

    }

    @Override
    public String getName() {

        return name;

    }

    @Override
    public String getID() {

        return ID;

    }

    @Override
    public String getDescription() {

        return Description;

    }

    @Override
    public List<String> getLevelApplicable() {

        return level;

    }

    @Override
    public List<String> getDivisionApplicable() {

        return division;

    }

    @Override
    public List<String> getProgrammeApplicable() {

        return programme;

    }
    
    public double getAmount(){
    
        return Amount;
        
    }

    public int getMaxAwardees(){
    
        return maxAwardees;
    
    }
    
    public int getMaxApplicants(){
    
        return maxApplicants;
        
    }
    
    public Date getInitialCutOff(){
    
        return initialCutOff;
        
    }
    
    public Date getFinalCutOff(){
    
        return finalCutOff;
        
    }
    
    public double getCGPA(){
    
        return CGPARequirements;
    
    }
    
    public void setName(String nam) {

        name = nam;

    }

    public void setID(String id) {

        ID = id;

    }

    public void setDescription(String des) {

        Description = des;

    }

    public void setAmount(double amt){
    
        Amount = amt;
    
    }
    
    public void setMaxAwardees(int max) {

        maxAwardees = max;

    }

    public void setMaxApplicants(int max) {

        maxApplicants = max;

    }

    public void setInitialCutOff(Date dd) {

        initialCutOff = dd;

    }

    public void finalCutOff(Date dd) {

        finalCutOff = dd;

    }

    public void level(String lvl) {

        level.add(lvl);

    }

    public void division(String div) {

        division.add(div);

    }

    public void programme(String prgm) {

        programme.add(prgm);

    }

    public void CGPARequirements(double cgpa) {

        CGPARequirements = cgpa;

    }
}
