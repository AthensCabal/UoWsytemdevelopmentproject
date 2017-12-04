package CCCU.edu.hk.StaffDB;

import CCCU.edu.hk.Accounts.*;
import java.util.*;

/**
 * Name:StaffDB_Interface
 * Description:An interface implementation of the Staff database class
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public interface StaffDB_Interface {
        /**
     * This method returns the total number of staff in the database. 
     * @return the total number of staff
     */
	int getStaffCount();

	
    /**
     * This method gets the requested staff from the database.
     * @param  Staff the staff of the staff list
     * @return the staff requested
     */
	Staff getAlbum(String staffID);
	
    /**
     * This method add an album to the database. 
     * @param staff the staff to be add
     */
	void addStaff(Staff staff);

    /**
     * This method delete a staff from the database. 
     * @param  title the title of the album to be deleted
     */
	void deleteStaff(String staffID);

    /**
     * This method releases resources.
     */
	void cleanup();
}
