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
 * Name:StaffDB Description:It acts as a middle layer between the staff data
 * base and the GUI by having methods within the class to do modification of
 * existing data
 *
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
//userName,password,firstName,lastName,StaffEID,StaffID,Division,Title,Status,StaffEmail,CommitteeMember,CommitteeTitle
    String createTable = "CREATE TABLE StaffList (userName VARCHAR(50) NOT NULL, "
            + "password VARCHAR(256) NOT NULL, "
            + "firstName VARCHAR(256) NOT NULL, "
            + "lastName VARCHAR(256) NOT NULL, "
            + "StaffEID VARCHAR(256) NOT NULL, "
            + "StaffID VARCHAR(256) NOT NULL, "
            + "Division VARCHAR(256) NOT NULL, "
            + "Title VARCHAR(256) NOT NULL, "
            + "Status VARCHAR(256) NOT NULL, "
            + "StaffEmail VARCHAR(256) NOT NULL, "
            + "CommitteeMember VARCHAR(10) NOT NULL, "
            + "CommitteeTitle VARCHAR(256) NOT NULL "
            + ")";

    Connection conn = null;
    Statement s;
    PreparedStatement ps;
    ResultSet rs;

    String answer;

    public StaffDB() {

        try {
            
            Class.forName(driver);
            //Create and connect to database
            conn = DriverManager.getConnection(connectionURL);

            //##INITIAL SQL SECTION##
            //Create a statement to issue simple commands.
            s = conn.createStatement();
            
            //this truly deletes just incase the cleanup() fails to delete the first database            
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, dbName.toUpperCase(), null);

            if (rs.next()) {

                String sql = "DROP TABLE " + dbName.toUpperCase();
                s.executeUpdate(sql);

            }
            
            //##INITIAL SQL SECTION##
            //Create a statement to issue simple commands.
            ps = conn.prepareStatement(createTable);

            ;

            //This creates a table
            ps.executeUpdate();
            
            ps = conn.prepareStatement("INSERT INTO StaffList(userName,password,firstName,lastName,StaffEID,StaffID,Division,Title,Status,StaffEmail,CommitteeMember,CommitteeTitle) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            //#Staff SQL INIT#
            //THIS PART REPLACES COLLECTIONFACTORY ENTIRELY
            //THIS ADDS THE INFO FROM THE XML FILES INTO THE DATABASE
            try {

                //this is the XML reader
                File collectionfile = new File("./src/CCCUStaffList.xml");
                DocumentBuilderFactory collFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = collFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(collectionfile);
                doc.getDocumentElement().normalize();

                //Setting up staff
                NodeList staffList = doc.getElementsByTagName("Staff");

                for (int i = 0; i < staffList.getLength(); i++) {

                    Node node = staffList.item(i);
                   

                    //this is for checking if it is an element
                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        //userName,password,firstName,lastName,StaffEID,StaffID,Division,Status,StaffEmail,CommitteeMember,CommitteeTitle
                        Element element1 = (Element) node;
                        ps.setString(1, element1.getElementsByTagName("userName").item(0).getTextContent().trim());
                        ps.setString(2, element1.getElementsByTagName("password").item(0).getTextContent().trim());
                        ps.setString(3, element1.getElementsByTagName("firstName").item(0).getTextContent().trim());
                        ps.setString(4, element1.getElementsByTagName("lastName").item(0).getTextContent().trim());
                        ps.setString(5, element1.getElementsByTagName("StaffEID").item(0).getTextContent().trim());
                        ps.setString(6, element1.getElementsByTagName("StaffID").item(0).getTextContent().trim());
                        ps.setString(7, element1.getElementsByTagName("Division").item(0).getTextContent().trim());
                        ps.setString(8, element1.getElementsByTagName("Title").item(0).getTextContent().trim());
                        ps.setString(9, element1.getElementsByTagName("Status").item(0).getTextContent().trim());
                        ps.setString(10, element1.getElementsByTagName("StaffEmail").item(0).getTextContent().trim());
                        ps.setString(11, element1.getElementsByTagName("CommitteeMember").item(0).getTextContent().trim());
                        ps.setString(12, element1.getElementsByTagName("CommitteeTitle").item(0).getTextContent().trim());
                        ps.executeUpdate();
                    }
                }
            } catch (Throwable e2) {

                System.out.println("Exception was thrown at MyCollectionDB :");
                e2.printStackTrace(System.out);

            }

        } catch (Throwable e) {

            //When the server is off,prompt exit program
            
            /*
            System.out.println("StaffDatabase could not be connected. Connect to the server and try again.");
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
*/
            e.printStackTrace(System.out);
            
            
        }

    }

    public int getStaffCount() {
        int size = 0;
        try {

            s.executeQuery("select StaffID from StaffList");
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

    public Staff getStaff(String staffID) {

        String SQL = "SELECT userName, password, firstName, lastName, StaffEID, StaffID, Division, Title, Status, StaffEmail, CommitteeMember, CommitteeTitle FROM StaffList";
        try {

            ps = conn.prepareStatement(SQL);

            rs = ps.executeQuery();
            while (rs.next()) {
                //Step 1: Check which of the rows matches the title
                if (rs.getString("StaffID").equals(staffID)) {

                    String tempSID = rs.getString("staffID");
                    int sid = Integer.parseInt(tempSID);

                    boolean CommitteeMember = false;
                    if (rs.getString("CommitteeMember").trim().equals("True")) {
                        CommitteeMember = true;
                    }

                    //userName,password,firstName,lastName,StaffEID,StaffID,Division,Status,StaffEmail,CommitteeMember,CommitteeTitle
                    Staff tempStaff = new Staff(rs.getString("userName"),
                            rs.getString("password"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            sid,
                            rs.getString("StaffEID"),
                            rs.getString("Division"),
                            rs.getString("Title"),
                            rs.getString("Status"),
                            rs.getString("StaffEmail"),
                            rs.getString("CommitteeTitle"),
                            CommitteeMember
                    );
                    //return Staff
                    return tempStaff;

                }

            }

        } catch (Throwable ex) {
            System.out.println("Exception thrown at getStaff():");
            ex.printStackTrace(System.out);
        }
        //Never used! This will cause NullPointerException
        return null;
    }

    public void addStaff(Staff staff) {

        try {

            Staff tempStaff = staff;

            ps = conn.prepareStatement("INSERT INTO StaffList(userName,password,firstName,lastName,StaffEID,StaffID,Division,Title,Status,StaffEmail,CommitteeMember,CommitteeTitle) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, tempStaff.getUserName());
            ps.setString(2, tempStaff.getPassword());
            ps.setString(3, tempStaff.getFirstName());
            ps.setString(4, tempStaff.getLastName());
            ps.setString(5, tempStaff.getEID());
            ps.setString(6, tempStaff.getEID());

            int SID = tempStaff.getSID();
            String SIDString = Integer.toString(SID);
            ps.setString(7, SIDString);

            ps.setString(8, tempStaff.getTitle());
            ps.setString(9, tempStaff.getStatus());
            ps.setString(10, tempStaff.getSTFFEmail());

            boolean tempCom = tempStaff.CommitteeMemberCheck();
            String bool = "";
            if (tempCom == true) {
                bool = "true";
            } else {
                bool = "false";
            }
            ps.setString(11, bool);

            ps.setString(12, tempStaff.getCommitteeTitle());

            ps.executeUpdate();

        } catch (Throwable ex) {
            System.out.println("Exception thrown at addStaff():");
            ex.printStackTrace(System.out);
        }

    }

    public void deleteStaff(String staffID) {

        String SQL = "SELECT userName,password,firstName,lastName,StaffEID,StaffID,Division,Title,Status,StaffEmail,CommitteeMember,CommitteeTitle FROM StaffList";

        try {

            PreparedStatement st = conn.prepareStatement(SQL, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();
            while(rs.next()){
            
                if(rs.getString("StaffID").trim().equals(staffID)){
                    
                    rs.deleteRow();
                    break;
                }
                
            }
        } catch (Throwable ex) {

            System.out.println("Exception thrown at deleteStaff()");
            ex.printStackTrace(System.out);

        }

    }
    
    public void cleanup() {

        try {
            
            //deletes database          
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getTables(null, null, dbName.toUpperCase(), null);

            if (rs.next()) {

                String sql = "DROP TABLE " + dbName.toUpperCase();
                s.executeUpdate(sql);

            }
            
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
