/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCCU.edu.hk.StudentsDB;

import CCCU.edu.hk.Accounts.Students;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Athens
 */
public class StudentsDBTest {
    
    public StudentsDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getStudentsCount method, of class StudentsDB.
     */
    @org.junit.Test
    public void testGetStudentsCount() {
        System.out.println("getStudentsCount() testing now.");
        StudentsDB instance = new StudentsDB();
        int expResult = 1;
        int result = instance.getStudentsCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStudents method, of class StudentsDB.
     */
    @org.junit.Test
    public void testGetStudents() {
        System.out.println("getStudents() testing now.");
        String StudentsID = "555577";
        StudentsDB instance = new StudentsDB();
        Students tempStudents = new Students("test","testing123","John","Smith","test2",555577,"Associate","Applied Science and Technology","Engineering","test2@cityu.edu.hk","test2@lolmail.com",3.22,null);
        String expResult = tempStudents.getFirstName();
//(String usr, String passwrd, String firstname, String lastname, String EID, int sid, String lvl, String div, String prog, String std, String alt, double cgpa,List<String> app) 
        Students result = instance.getStudent(StudentsID);
        assertEquals(expResult, result.getFirstName());
    }

    /**
     * Test of addStudents method, of class StudentsDB.
     */
    @org.junit.Test
    public void testAddStudents() {
        System.out.println("addStudents() testing now.");

        StudentsDB instance = new StudentsDB();
        
        List<String> templist = new ArrayList<>();
        templist.add("1300");
        templist.add("2340");
        Students Students = new Students("test2","testing124","John1","Smith2","test3",555578,"Associate","Applied Science and Technology","Engineering","test2@cityu.edu.hk","test2@lolmail.com",3.22,templist);
        
        instance.addStudent(Students);
    }

    /**
     * Test of deleteStudents method, of class StudentsDB.
     */
    @org.junit.Test
    public void testDeleteStudents() {
        System.out.println("deleteStudents() testing now.");
        String StudentsID = "555578";
        StudentsDB instance = new StudentsDB();
        List<String> templist = new ArrayList<>();
        templist.add("1300");
        templist.add("2340");
        instance.addStudent(new Students("test2","testing124","John1","Smith2","test3",555578,"Associate","Applied Science and Technology","Engineering","test2@cityu.edu.hk","test2@lolmail.com",3.22,templist));
        instance.deleteStudent(StudentsID);
    }

    /**
     * Test of cleanup method, of class StudentsDB.
     */
    @org.junit.Test
    public void testCleanup() {
        System.out.println("cleanup() testing now.");
        StudentsDB instance = new StudentsDB();
        instance.cleanup();
    }
    
}
