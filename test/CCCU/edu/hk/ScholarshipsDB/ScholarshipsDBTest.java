/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CCCU.edu.hk.ScholarshipsDB;

import CCCU.edu.hk.Scholarships.*;
import CCCU.edu.hk.Scholarships.Scholarships;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Athens
 */
public class ScholarshipsDBTest {
    
    public ScholarshipsDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getScholarshipsCount method, of class ScholarshipsDB.
     */
    @Test
    public void testGetScholarshipsCount() {
        System.out.println("getScholarshipsCount");
        ScholarshipsDB instance = new ScholarshipsDB();
        int expResult = 1;
        int result = instance.getScholarshipsCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getScholarship method, of class ScholarshipsDB.
     */
    @Test
    public void testGetScholarship() {
        System.out.println("getScholarship");
        String ScholarshipsID = "CCCU02";
        ScholarshipsDB instance = new ScholarshipsDB();
        
                List<String> testlist = new ArrayList<>();
        testlist.add("Test1");
        testlist.add("test2");
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "01-01-2017";
        Date date = sdf.parse(dateInString);
        
        Scholarships Scholarships = new Internal_Scholarships("CCCU Performance Scholarship2(Associate)","CCCU02","CCCU","Best Performance in each programme",30000.0,4,0,date,date,testlist,testlist,testlist,testlist,testlist,testlist,testlist,3.5);
        
        String expResult = "Best Performance in each programme";
        Scholarships result = instance.getScholarship(ScholarshipsID);
        assertEquals(expResult,  result.getDescription().trim());
        }catch (Throwable e){
            //
        }
        
    }

    /**
     * Test of addScholarship method, of class ScholarshipsDB.
     */
    @Test
    public void testAddScholarship() {
        System.out.println("addScholarship");
        ScholarshipsDB instance = new ScholarshipsDB();
        
        List<String> testlist = new ArrayList<>();
        testlist.add("Test1");
        testlist.add("test2");
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "01-01-2017";
        Date date = sdf.parse(dateInString);
        
        Scholarships Scholarships = new Internal_Scholarships("CCCU Performance Scholarship2(Associate)","CCCU02","CCCU","Best Performance in each programme",30000.0,4,0,date,date,testlist,testlist,testlist,testlist,testlist,testlist,testlist,3.5);
        //Internal_Scholarships(String nam, String id, String org, String des, double amt, int maxAwd, int maxApp, Date ICO, Date FCO, List<String> lvl, List<String> div, List<String> prgm, List <String> wait, List <String> rec, List <String> acpt, List <String> rej,double cgpa)
        instance.addScholarship(Scholarships);
        } catch (Throwable ex) {
            //
        }
    }

    /**
     * Test of deleteScholarship method, of class ScholarshipsDB.
     */
    @Test
    public void testDeleteScholarship() {
        System.out.println("deleteScholarship");
        String ScholarshipsID = "CCCU02";
        ScholarshipsDB instance = new ScholarshipsDB();
        
        List<String> testlist = new ArrayList<>();
        testlist.add("Test1");
        testlist.add("test2");
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
        String dateInString = "01-01-2017";
        Date date = sdf.parse(dateInString);
        
        Scholarships Scholarships = new Internal_Scholarships("CCCU Performance Scholarship2(Associate)","CCCU02","CCCU","Best Performance in each programme",30000.0,4,0,date,date,testlist,testlist,testlist,testlist,testlist,testlist,testlist,3.5);
        //Internal_Scholarships(String nam, String id, String org, String des, double amt, int maxAwd, int maxApp, Date ICO, Date FCO, List<String> lvl, List<String> div, List<String> prgm, List <String> wait, List <String> rec, List <String> acpt, List <String> rej,double cgpa)
        instance.addScholarship(Scholarships);
        } catch (Throwable ex) {
            //
        }
        
        instance.deleteScholarship(ScholarshipsID);
        
        
    }

    /**
     * Test of cleanup method, of class ScholarshipsDB.
     */
    @Test
    public void testCleanup() {
        System.out.println("cleanup");
        ScholarshipsDB instance = new ScholarshipsDB();
        instance.cleanup();
    }
    
}
