package CCCU.edu.hk.ScholarshipsDB;

import CCCU.edu.hk.Scholarships.*;

/**
 * Name:ScholarshipsDB_Interface
 * Description:An Interface implementation of the scholarship database class 
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public interface ScholarshipsDB_Interface {
                /**
     * This method returns the total number of staff in the database. 
     * @return the total number of staff
     */
	int getScholarshipsCount();

    /**
     * This method gets the requested staff from the database.
     * @param  ScholarshipID the ScholarshipID in the Scholarship list
     * @return the Scholarship requested
     */
	Scholarships getScholarship(String ScholarshipID);
	
    /**
     * This method add an album to the database. 
     * @param scholarship
     */
	void addScholarship(Scholarships scholarship);

    /**
     * This method delete a staff from the database. 
     * @param scholarshipID 
     */
	void deleteScholarship(String scholarshipID);

    /**
     * This method releases resources.
     */
	void cleanup();
}
