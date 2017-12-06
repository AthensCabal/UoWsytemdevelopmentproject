/**
 * Name:ScholarshipSystem
 * Description:It is the main class for the entire system: starting point
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */


import CCCU.edu.hk.GUI.*;
import CCCU.edu.hk.ScholarshipsDB.*;
import CCCU.edu.hk.StaffDB.*;
import CCCU.edu.hk.StudentsDB.*;

public class ScholarshipSystem {
    
    public static void main(String [] args){
        StaffDB staffDataBase  = new StaffDB();
        StudentsDB studentsDataBase = new StudentsDB();
        //ScholarshipsDB scholarshipDataBase = new ScholarshipsDB();
        mainFrame test = new mainFrame(staffDataBase,studentsDataBase/*,scholarshipDataBase*/);
        test.setVisible(true);
        staffDataBase.cleanup();
        studentsDataBase.cleanup();
    }
}
