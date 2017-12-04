package CCCU.edu.hk.StaffDB;

import CCCU.edu.hk.Accounts.*;
import java.util.List;
import java.sql.*;
import java.io.*;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 * Name:StaffDB
 * Description:It acts as a middle layer between the staff data base and the GUI
 * by having methods within the class to do modification of existing data
 * @version 1.0
 * @author Athenwer Caballero Calimbahin (5980276)
 * @author Manish Mall(5993945)
 * @author Celdron Jedrick Lansangan Mapatac (5980409)
 * @author Rio, Cheung Hon Yin Nicolas (5632079)
 */
public class StaffDB implements StaffDB_Interface {
    
     // define the driver to use 
    String driver = "org.apache.derby.jdbc.ClientDriver";

    // the database name  
    String dbName = "StaffList";
    // define the Derby connection URL to use 
    String connectionURL = "jdbc:derby://localhost:1527/" + dbName + ";create=true";

    String createTable = "CREATE TABLE StaffList (StaffType VARCHAR(1), "
            + "StaffID VARCHAR(9), "
            + "FirstName VARCHAR(256), "
            + "LastName VARCHAR(256), "
            + "Department VARCHAR(256),"
            + "CommitteeStaffTitle VARCHAR(256) )";

    Connection conn = null;
    Statement s;
    PreparedStatement ps;
    ResultSet myAlbumresultset;

    String answer;

    public StaffDB() {

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

            //#ALBUM SQL INIT#
            //THIS PART REPLACES COLLECTIONFACTORY ENTIRELY
            //THIS ADDS THE INFO FROM THE XML FILES INTO THE DATABASE
            try {

                //this is the XML reader
                File collectionfile = new File("CCCUStaffList.xml");
                DocumentBuilderFactory collFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = collFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(collectionfile);
                doc.getDocumentElement().normalize();

                //Setting up staff
                NodeList staffList = doc.getElementsByTagName("Staff");

                for (int i = 0; i < staffList.getLength(); i++) {

                    Node cdNode = staffList.item(i);

                    ps = conn.prepareStatement("INSERT INTO StaffList(StaffType, StaffID, FirstName, LastName, Department, CommitteeTitle) VALUES (?,?,?,?,?,?)");

                    //this is for checking if it is an element
                    if (cdNode.getNodeType() == Node.ELEMENT_NODE) {

                        Element element1 = (Element) cdNode;
                        ps.setString(1, element1.getElementsByTagName("StaffType").item(0).getTextContent().trim());
                        ps.setString(2, element1.getElementsByTagName("StaffID").item(0).getTextContent().trim());
                        ps.setString(3, element1.getElementsByTagName("FirstName").item(0).getTextContent().trim());
                        ps.setString(4, element1.getElementsByTagName("LastName").item(0).getTextContent().trim());
                        ps.setString(5, element1.getElementsByTagName("Department").item(0).getTextContent().trim());
                        ps.setString(6, element1.getElementsByTagName("CommitteeTitle").item(0).getTextContent().trim());
                        ps.executeUpdate();
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
    
    
    
    public int getStaffCount() {
     return 0;   
    }
    
    
    public Staff getAlbum(String staffID){
        return null;
    }
    
    public void addStaff(Staff staff){
        
    }
   
    public void deleteStaff(String staffID){
        
    }
    
    
    public void cleanup(){
        //
    }
}
