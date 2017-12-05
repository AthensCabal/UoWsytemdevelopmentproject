/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCCU.edu.hk.Scholarships;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Name:External_Scholarships Description:Attributes and methods of External
 * Scholarships that are provided at CCCU
 *
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class External_Scholarships implements Scholarships {

    /**
     * External_Scholarships
     * @param name
     * @param ID
     * @param organisation
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
    private String organisation;
    private String Description;
    private double Amount;
    private int maxAwardees;
    private int maxApplicants;
    private Date initialCutOff;
    private Date finalCutOff;
    private List<String> level;
    private List<String> division;
    private List<String> programme;
    private List waitList;
    private List recommendedList;
    private List acceptedList;
    private List rejectedList;
    private double CGPARequirements;

    public External_Scholarships() {

        name = "";
        ID = "";
        organisation = "";
        Description = "";
        Amount = -1.0;
        maxAwardees = -1;
        maxApplicants = -1;
        initialCutOff = new Date();
        finalCutOff = new Date();
        level = new ArrayList();
        division = new ArrayList();
        programme = new ArrayList();
        waitList = new ArrayList();
        recommendedList = new ArrayList();
        acceptedList = new ArrayList();
        rejectedList = new ArrayList();
        CGPARequirements = -1.0;

    }

    public External_Scholarships(String nam, String id, String org, String des,double amt, int maxAwd, int maxApp, Date ICO, Date FCO, double cgpa, List<String> lvl, List<String> div, List<String> prgm,List wait,List rec,List acpt,List rej) {

        name = nam;
        ID = id;
        organisation = org;
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
        waitList = wait;
        recommendedList = rec;
        acceptedList = acpt;
        rejectedList = rej;  

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

    public String getOrganisation(){
    
        return organisation;
    
    }
    
    public double getAmount(){
    
        return Amount;
        
    }
    
    public int getMaxAwardees() {

        return maxAwardees;

    }

    public int getMaxApplicants() {

        return maxApplicants;

    }

    public Date getInitialCutOff() {

        return initialCutOff;

    }

    public Date getFinalCutOff() {

        return finalCutOff;

    }

    public double getCGPA() {

        return CGPARequirements;

    }

    public List getWaitList(){
    
        return waitList;
        
    }
    
    public List getRecommendedList(){
    
        return recommendedList;
        
    }
    
    public List getAcceptedList(){
    
        return acceptedList;
        
    }
    
    public List getRejectedList(){
    
        return rejectedList;
        
    }
    
    public void setName(String nam) {

        name = nam;

    }

    public void setID(String id) {

        ID = id;

    }

    public void setOrganisation(String org) {

        organisation = org;

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
    
    public void setWaitList(int SID){
    
        waitList.add(SID);
    
    }
    
    public void setRecommendedList(int SID){
    
        recommendedList.add(SID);
        
    }
    
    public void setAcceptedList(int SID){
    
        acceptedList.add(SID);
        
    }

    public void setRejectedList(int SID){
    
        rejectedList.add(SID);
        
    }
    
}
