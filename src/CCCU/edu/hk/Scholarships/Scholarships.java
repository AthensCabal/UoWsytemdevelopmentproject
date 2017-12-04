package CCCU.edu.hk.Scholarships;

import java.util.List;

/**
 * Name:Scholarships
 * Description:An Interface for Scholarships:Internal and External Scholarships
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public interface Scholarships {
    
    public String getName();
    
    public int getNumOfScholarships();
    
    //Returns a list(Strings) of level(s) of studies that is/are eligble for it
    public List<String> getLevelApplicable();
    //Returns a list(Strings) of division that are eligble for it
    public List<String> getDivisionApplicable();
    //Returns a list(Strings) of programmes that are eligble for it
    public List<String> getProgrammeApplicable();
    
    
}
