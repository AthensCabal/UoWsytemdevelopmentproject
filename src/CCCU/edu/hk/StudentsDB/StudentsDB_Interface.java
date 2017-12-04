package CCCU.edu.hk.StudentsDB;

import CCCU.edu.hk.Accounts.Students;
/**
 * Name:StudentsDB_Interface
 * Description:An interface implementation of the student data base class 
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public interface StudentsDB_Interface {
            /**
     * This method returns the total number of staff in the database. 
     * @return the total number of staff
     */
	int getStudentsCount();

    /**
     * This method gets the requested staff from the database.
     * @param  studentID the studentID in the student list
     * @return the student requested
     */
	Students getStudent(String studentID);
	
    /**
     * This method add an album to the database. 
     * @param student the student to be add
     */
	void addStudent(Students student);

    /**
     * This method delete a staff from the database. 
     * @param  studentID 
     */
	void deleteStudent(String studentID);

    /**
     * This method releases resources.
     */
	void cleanup();
}
