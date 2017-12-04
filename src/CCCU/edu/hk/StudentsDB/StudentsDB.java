package CCCU.edu.hk.StudentsDB;

import CCCU.edu.hk.Accounts.Students;
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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Name:StudentsDB
 * Description:It acts as a middle layer between the student data base and the GUI
 * by having methods within the class to do modification of existing data
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class StudentsDB implements StudentsDB_Interface {
    // define the driver to use
    String driver = "org.apache.derby.jdbc.ClientDriver";

    // the database name
    String dbName = "StudentsList";
    // define the Derby connection URL to use
    String connectionURL = "jdbc:derby://localhost:1527/" + dbName + ";create=true";

    String createTable = "CREATE TABLE StudentsList (StudentsType VARCHAR(1), "
            + "StudentsID VARCHAR(9), "
            + "StudentsUser VARCHAR(256)"
            + "StudentsPassword VARCHAR(256)"
            + "FirstName VARCHAR(256), "
            + "LastName VARCHAR(256), "
            + "Department VARCHAR(256),"
            + "CommitteeStudentsTitle VARCHAR(256) )";

    Connection conn = null;
    Statement s;
    PreparedStatement ps;
    ResultSet rs;

    String answer;

    public StudentsDB() {

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

            //#Students SQL INIT#
            //THIS PART REPLACES COLLECTIONFACTORY ENTIRELY
            //THIS ADDS THE INFO FROM THE XML FILES INTO THE DATABASE
            try {

                //this is the XML reader
                File collectionfile = new File("CCCUStudentsList.xml");
                DocumentBuilderFactory collFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = collFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(collectionfile);
                doc.getDocumentElement().normalize();

                //Setting up Students
                NodeList StudentsList = doc.getElementsByTagName("Students");

                for (int i = 0; i < StudentsList.getLength(); i++) {

                    Node node = StudentsList.item(i);

                    //$$$$$$$$$$$$$$$$$$$$
                    //ps = conn.prepareStatement("INSERT INTO StudentsList(StudentsType, StudentsID, StudentsUser, StudentsPassword, FirstName, LastName, Department, CommitteeTitle) VALUES (?,?,?,?,?,?,?,?)");

                    //this is for checking if it is an element
                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        //$$$$$$$$$$$$$$$$$$$$
                        /*
                        Element element1 = (Element) node;
                        ps.setString(1, element1.getElementsByTagName("StudentsType").item(0).getTextContent().trim());
                        ps.setString(2, element1.getElementsByTagName("StudentsID").item(0).getTextContent().trim());
                        ps.setString(3, element1.getElementsByTagName("StudentsUser").item(0).getTextContent().trim());
                        ps.setString(4, element1.getElementsByTagName("StudentsPassword").item(0).getTextContent().trim());
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
    public int getStudentsCount() {
        int size = 0;
        try {

            s.executeQuery("select StudentsID from StudentsList");
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
    public Students getStudent(String StudentsID) {

        try {

            //first get all rows
            s.executeQuery("select * from StudentsList");
            rs = s.getResultSet();
            while (rs.next()) {

                //Step 1: Check which of the rows matches the title
                if (StudentsID.equals(rs.getString("StudentsID"))) {

                    
                    
                    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                    /*
                    Students tempStudents = new Students(rs.getString("StudentsUser"),
                            rs.getString("StudentsPassword"),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getString("StudentsID"),
                            rs.getString("Department"),
                            rs.getString("CommitteeTitle"),
                            tempbool);

                    */
                    
                    
                    //return Students
                    //return tempStudents;

                }

            }

        } catch (Throwable ex) {
            System.out.println("Exception thrown at getStudents():");
            ex.printStackTrace(System.out);
        }
        //Never used! This will cause NullPointerException
        return null;
    }

    @Override
    public void addStudent(Students Students) {

        try {
            
            Students tempStudents= Students;
            
            
            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            //ps = conn.prepareStatement("INSERT INTO StudentsList(StudentsType, StudentsID, StudentsUser, StudentsPassword, FirstName, LastName, Department, CommitteeTitle) VALUES (?,?,?,?,?,?,?,?)");
            
            
            
            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            //ps.setString(1, String.valueOf(tempStudents.CommitteeMemberCheck()) );
            
            
            ps.executeUpdate();
            
        } catch (Throwable ex) {
            System.out.println("Exception thrown at addStudents():");
            ex.printStackTrace(System.out);
        }
        
        
    }

    @Override
    public void deleteStudent(String StudentsID) {

        try {

            PreparedStatement st = conn.prepareStatement("DELETE FROM StudentsList WHERE StudentsID = ?");
            st.setString(1, StudentsID);
            st.executeUpdate();
        } catch (Throwable ex) {

            System.out.println("Exception thrown at deleteStudents()");
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
