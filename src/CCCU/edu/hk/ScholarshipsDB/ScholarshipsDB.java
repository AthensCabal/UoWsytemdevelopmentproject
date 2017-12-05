package CCCU.edu.hk.ScholarshipsDB;

import CCCU.edu.hk.Scholarships.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * Name:ScholarshipsDB
 * Description:It acts as a middle layer between the scholarship data base and the GUI
 * by having methods within the class to do modification of existing data
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class ScholarshipsDB implements ScholarshipsDB_Interface {
        // define the driver to use
    String driver = "org.apache.derby.jdbc.ClientDriver";

    // the database name
    String dbName = "ScholarshipsList";
    // define the Derby connection URL to use
    String connectionURL = "jdbc:derby://localhost:1527/" + dbName + ";create=true";

    String createTable = "CREATE TABLE ScholarshipsList (ScholarshipsType VARCHAR(1), "
            + "ScholarshipsID VARCHAR(9), "
            + "ScholarshipsName VARCHAR(256)"
            + "ScholarshipMax INT" /*Max number of applicants (approved)*/
            + "ScholarshipsNum INT"  /*Number of seats*/
            + "LevelApplicable VARCHAR(256), "
            + "DivisionsApplicable VARCHAR(256), "
            + "ProgrammeApplicable VARCHAR(256) )";

    Connection conn = null;
    Statement s;
    PreparedStatement ps;
    ResultSet rs;

    String answer;

    public ScholarshipsDB() {

        try {

            //Create and connect to database
            conn = DriverManager.getConnection(connectionURL);

            //##INITIAL SQL SECTION##
            //Create a statement to issue simple commands.
            s = conn.createStatement();

            //this truly deletes just incase the cleanup() fails to delete the first database
            DatabaseMetaData dbmd = conn.getMetaData();

            //This creates a table
            s.execute(createTable);

            //#Scholarships SQL INIT#
            //THIS PART REPLACES COLLECTIONFACTORY ENTIRELY
            //THIS ADDS THE INFO FROM THE XML FILES INTO THE DATABASE
            try {

                //this is the XML reader
                File collectionfile = new File("CCCUScholarshipsList.xml");
                DocumentBuilderFactory collFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = collFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(collectionfile);
                doc.getDocumentElement().normalize();

                //Setting up Scholarships
                NodeList ScholarshipsList = doc.getElementsByTagName("Scholarships");

                for (int i = 0; i < ScholarshipsList.getLength(); i++) {

                    Node node = ScholarshipsList.item(i);

                    //$$$$$$$$$$$$$$$$$$$$
                    //ps = conn.prepareStatement("INSERT INTO ScholarshipsList(ScholarshipsType, ScholarshipsID, ScholarshipsUser, ScholarshipsPassword, FirstName, LastName, Department, CommitteeTitle) VALUES (?,?,?,?,?,?,?,?)");

                    //this is for checking if it is an element
                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        //$$$$$$$$$$$$$$$$$$$$
                        /*
                        Element element1 = (Element) node;
                        ps.setString(1, element1.getElementsByTagName("ScholarshipsType").item(0).getTextContent().trim());
                        ps.setString(2, element1.getElementsByTagName("ScholarshipsID").item(0).getTextContent().trim());
                        ps.setString(3, element1.getElementsByTagName("ScholarshipsUser").item(0).getTextContent().trim());
                        ps.setString(4, element1.getElementsByTagName("ScholarshipsPassword").item(0).getTextContent().trim());
                        ps.setString(5, element1.getElementsByTagName("FirstName").item(0).getTextContent().trim());
                        ps.setString(6, element1.getElementsByTagName("LastName").item(0).getTextContent().trim());
                        ps.setString(7, element1.getElementsByTagName("Department").item(0).getTextContent().trim());
                        ps.setString(8, element1.getElementsByTagName("CommitteeTitle").item(0).getTextContent().trim());
                        ps.executeUpdate();
                        */
                    }
                }

            } catch (Throwable e2) {

                System.out.println("Exception was thrown at MyCollectionDB :");
                e2.printStackTrace(System.out);

            }

        } catch (Throwable e) {

            //When the server is off,prompt exit program
            System.out.println("Database could not be connected. Connect to the server and try again.");
            System.out.println("Do you still wish to continue the program? Y/N ");
            Scanner in = new Scanner(System.in);
            String choice = in.nextLine();

            switch (choice) {

                case "N":
                    System.out.println("Exiting program. Reconnect to the server to try again.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("The program will continue to run but do note that none of the choice will work.");
                    break;

            }
        }

    }

    @Override
    public int getScholarshipsCount() {
        int size = 0;
        try {

            s.executeQuery("select ScholarshipsID from ScholarshipsList");
            rs = s.getResultSet();
            while (rs.next()) {
                size++;

            }

        } catch (Throwable e) {
            System.out.println("Exception thrown at getCollectionSize():");
            e.printStackTrace(System.out);
        }
        return size;
    }

    @Override
    public Scholarships getScholarship(String ScholarshipsID) {

        try {

            //first get all rows
            s.executeQuery("select * from ScholarshipsList");
            rs = s.getResultSet();
            while (rs.next()) {

                //Step 1: Check which of the rows matches the title
                if (ScholarshipsID.equals(rs.getString("ScholarshipsID"))) {

                    
                    
                    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                    /*
                    Scholarships tempScholarships = new Scholarships(rs.getString("ScholarshipsUser"),
                            rs.getString("ScholarshipsPassword"),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getString("ScholarshipsID"),
                            rs.getString("Department"),
                            rs.getString("CommitteeTitle"),
                            tempbool);

                    */
                    
                    
                    //return Scholarships
                    //return tempScholarships;

                }

            }

        } catch (Throwable ex) {
            System.out.println("Exception thrown at getScholarships():");
            ex.printStackTrace(System.out);
        }
        //Never used! This will cause NullPointerException
        return null;
    }

    @Override
    public void addScholarship(Scholarships Scholarships) {

        try {
            
            Scholarships tempScholarships= Scholarships;
            
            
            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            //ps = conn.prepareStatement("INSERT INTO ScholarshipsList(ScholarshipsType, ScholarshipsID, ScholarshipsUser, ScholarshipsPassword, FirstName, LastName, Department, CommitteeTitle) VALUES (?,?,?,?,?,?,?,?)");
            
            
            
            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            //ps.setString(1, String.valueOf(tempScholarships.CommitteeMemberCheck()) );
            
            
            ps.executeUpdate();
            
        } catch (Throwable ex) {
            System.out.println("Exception thrown at addScholarships():");
            ex.printStackTrace(System.out);
        }
        
        
    }

    @Override
    public void deleteScholarship(String ScholarshipsID) {

        try {

            PreparedStatement st = conn.prepareStatement("DELETE FROM ScholarshipsList WHERE ScholarshipsID = ?");
            st.setString(1, ScholarshipsID);
            st.executeUpdate();
        } catch (Throwable ex) {

            System.out.println("Exception thrown at deleteScholarships()");
            ex.printStackTrace(System.out);

        }
        
        
    }

    public void cleanup() {
        
        try {
        conn.close();
        s.close();
        ps.close();
        rs.close();
        
        } catch (Throwable ex) {
            System.out.println("Exception thrown at cleanup()");
            ex.printStackTrace(System.out);
        }
    }
}
