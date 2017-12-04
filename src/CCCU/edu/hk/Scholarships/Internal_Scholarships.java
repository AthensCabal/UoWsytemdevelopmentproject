package CCCU.edu.hk.Scholarships;

import java.util.List;

/**
 * Name:Internal_Scholarships
 * Description:Attributes and methods of Internal Scholarships that are provided at CCCU
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class Internal_Scholarships implements Scholarships
{

    //Atrributes
    
    /**
     * @param name
     * Purpose:It stores the name of the scholarship(Internal)
    */
    private String name;
    
    /**
     * @param numberOfScholarships;
     * Purpose: It holds the number of scholarships available
     */
    private int numberOfScholarships;
    
    public Internal_Scholarships(){
    
    
    }
    
    public Internal_Scholarships(String nam){
    
        name = nam;
        
    }
    
    @Override
    public String getName() {
        
        return name;
        
    }

    @Override
    public int getNumOfScholarships() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getLevelApplicable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getDivisionApplicable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getProgrammeApplicable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
