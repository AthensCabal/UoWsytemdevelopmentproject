/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCCU.edu.hk.StaffDB;

import CCCU.edu.hk.Accounts.Staff;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Athens
 */
public class StaffDBTest {
    
    public StaffDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getStaffCount method, of class StaffDB.
     */
    @org.junit.Test
    public void testGetStaffCount() {
        System.out.println("getStaffCount() testing now.");
        StaffDB instance = new StaffDB();
        int expResult = 1;
        int result = instance.getStaffCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStaff method, of class StaffDB.
     */
    @org.junit.Test
    public void testGetStaff() {
        System.out.println("getStaff() testing now.");
        String staffID = "556678";
        StaffDB instance = new StaffDB();
        Staff tempStaff = new Staff("testStaff","testing1234","Rio","Cheng",556678,"rch2","Science and Technology","Lecturer","Full-Time","rch2@cityu.edu.hk","Member",true);
        String expResult = tempStaff.getFirstName();
        //String usr, String passwrd, String firstname, String lastname,int sid ,String EID, String div, String title, String stat, String email, String c_title, boolean isC_member
        Staff result = instance.getStaff(staffID);
        assertEquals(expResult, result.getFirstName());
    }

    /**
     * Test of addStaff method, of class StaffDB.
     */
    @org.junit.Test
    public void testAddStaff() {
        System.out.println("addStaff() testing now.");
        Staff staff = new Staff("testStaff2","testing1234","Rio1","Cheng1",556679,"rch3","Science and Technology","Lecturer","Full-Time","rch3@cityu.edu.hk","Member",true);
        StaffDB instance = new StaffDB();
        instance.addStaff(staff);
    }

    /**
     * Test of deleteStaff method, of class StaffDB.
     */
    @org.junit.Test
    public void testDeleteStaff() {
        System.out.println("deleteStaff() testing now.");
        String staffID = "556678";
        StaffDB instance = new StaffDB();
        instance.addStaff(new Staff("testStaff2","testing124","Rio1","Cheng1",556679,"rch3","Science and Technology","Lecturer","Full-Time","rch3@cityu.edu.hk","Member",true));
        instance.deleteStaff(staffID);
    }

    /**
     * Test of cleanup method, of class StaffDB.
     */
    @org.junit.Test
    public void testCleanup() {
        System.out.println("cleanup() testing now.");
        StaffDB instance = new StaffDB();
        instance.cleanup();
    }
    
}
