package CCCU.edu.hk.ScholarshipsDB;

import CCCU.edu.hk.Scholarships.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * Name:ScholarshipsDB Description:It acts as a middle layer between the
 * scholarship data base and the GUI by having methods within the class to do
 * modification of existing data
 *
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

//Name,ID,Organisation,Description,Amount,maxAwardees,maxApplicants,initialCutOff,finalCutOff,Level,Division,Programme,waitList,recommendedList,acceptedList,rejectedList,CGPARequirements
    String createTable = "CREATE TABLE ScholarshipsList (Name VARCHAR(256) NOT NULL, "
            + "ID VARCHAR(256) NOT NULL, "
            + "Oragnisation VARCHAR(256) NOT NULL, "
            + "Description VARCHAR(256) NOT NULL, "
            + "Amount VARCHAR(256) NOT NULL, "
            + "maxAwardees VARCHAR(256) NOT NULL, "
            + "maxApplicants VARCHAR(256) NOT NULL, "
            + "initialCutOff VARCHAR(256) NOT NULL, "
            + "finalCutOff VARCHAR(256) NOT NULL"
            + "Level VARCHAR(256) NOT NULL, "
            + "Division VARCHAR(256) NOT NULL, "
            + "Programme VARCHAR(256) NOT NULL, "
            + "waitList VARCHAR(256) NOT NULL, "
            + "recommendedList VARCHAR(256) NOT NULL, "
            + "acceptedList VARCHAR(256) NOT NULL, "
            + "rejectedList VARCHAR(256) NOT NULL, "
            + "CGPARequirements VARCHAR(256) NOT NULL "
            + ")";

    Connection conn = null;
    Statement s;
    PreparedStatement ps;
    ResultSet rs;

    String answer;

    public ScholarshipsDB() {

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

            //This creates a table
            s.execute(createTable);
//Name,ID,Organisation,Description,Amount,maxAwardees,maxApplicants,initialCutOff,finalCutOff,Level,Division,Programme,
//waitList,recommendedList,acceptedList,rejectedList,CGPARequirements
            ps = conn.prepareStatement("INSERT INTO ScholarshipsList(Name,ID,Organisation,Description,Amount,maxAwardees,maxApplicants,initialCuttOff,finalCutOff,Level,Division,Programme,waitList,recommendedList,acceptedList,rejectedList,CGPARequirements) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            //#Scholarships SQL INIT#
            //THIS PART REPLACES COLLECTIONFACTORY ENTIRELY
            //THIS ADDS THE INFO FROM THE XML FILES INTO THE DATABASE
            try {

                //this is the XML reader
                File collectionfile = new File("./src/CCCUScholarshipsList.xml");
                DocumentBuilderFactory collFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = collFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(collectionfile);
                doc.getDocumentElement().normalize();

                //Setting up Scholarships
                NodeList ScholarshipsList = doc.getElementsByTagName("Scholarships");

                for (int i = 0; i < ScholarshipsList.getLength(); i++) {

                    Node node = ScholarshipsList.item(i);

                    //this is for checking if it is an element
                    if (node.getNodeType() == Node.ELEMENT_NODE) {

                        //Name,ID,Organisation,Description,Amount,maxAwardees,maxApplicants,initialCuttOff,Level,Division,Programme,waitList,recommendedList,acceptedList,rejectedList,CGPARequirements
                        //$$$$$$$$$$$$$$$$$$$$
                        Element element1 = (Element) node;
                        ps.setString(1, element1.getElementsByTagName("Name").item(0).getTextContent().trim());
                        ps.setString(2, element1.getElementsByTagName("ID").item(0).getTextContent().trim());
                        ps.setString(3, element1.getElementsByTagName("Organisation").item(0).getTextContent().trim());
                        ps.setString(4, element1.getElementsByTagName("Description").item(0).getTextContent().trim());
                        ps.setString(5, element1.getElementsByTagName("Amount").item(0).getTextContent().trim());
                        ps.setString(6, element1.getElementsByTagName("maxAwardees").item(0).getTextContent().trim());
                        ps.setString(7, element1.getElementsByTagName("maxApplicants").item(0).getTextContent().trim());
                        ps.setString(8, element1.getElementsByTagName("initialCutOff").item(0).getTextContent().trim());
                        ps.setString(9, element1.getElementsByTagName("finalCutOff").item(0).getTextContent().trim());
                        ps.setString(10, element1.getElementsByTagName("Level").item(0).getTextContent().trim());
                        ps.setString(12, element1.getElementsByTagName("Division").item(0).getTextContent().trim());
                        ps.setString(12, element1.getElementsByTagName("Programme").item(0).getTextContent().trim());
                        ps.setString(13, element1.getElementsByTagName("waitList").item(0).getTextContent().trim());
                        ps.setString(14, element1.getElementsByTagName("recommendedList").item(0).getTextContent().trim());
                        ps.setString(15, element1.getElementsByTagName("acceptedList").item(0).getTextContent().trim());
                        ps.setString(16, element1.getElementsByTagName("rejectedList").item(0).getTextContent().trim());
                        ps.setString(17, element1.getElementsByTagName("CGPARequirements").item(0).getTextContent().trim());

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
                if (ScholarshipsID.equals(rs.getString("ID"))) {

//Name,ID,Organisation,Description,Amount,maxAwardees,maxApplicants,initialCuttOff,Level,Division,Programme,waitList,recommendedList,acceptedList,rejectedList,CGPARequirements
                    //Amount
                    String amtString = rs.getString("Amount");
                    Double amtPass = Double.parseDouble(amtString);
                    //maxAwardees
                    String maxAwardees = rs.getString("maxAwardees");
                    int maxAwardeesPass = Integer.parseInt(maxAwardees);
                    //maxApplicants
                    String maxApplicants = rs.getString("maxApplicants");
                    int maxApplicantsPass = Integer.parseInt(maxApplicants);

                    //Initial Date CutOff
                    String dateInitial = rs.getString("initalCutOff");
                    String[] tempDateInitial = dateInitial.split("/");
                    int[] intDateInitial = null;
                    for (int i = 0; i < tempDateInitial.length; i++) {
                        tempDateInitial[i] = tempDateInitial[i].trim();
                    }
                    for (int k = 0; k < tempDateInitial.length; k++) {
                        intDateInitial[k] = Integer.parseInt(tempDateInitial[k]);
                    }
                    Date passInitialDate = new Date(intDateInitial[0], intDateInitial[1], intDateInitial[2]);

                    //Final Date CutOff
                    String dateFinal = rs.getString("finalCutOff");
                    String[] tempDateFinal = dateFinal.split("/");
                    int[] intDateFinal = null;
                    for (int i = 0; i < tempDateFinal.length; i++) {
                        tempDateFinal[i] = tempDateFinal[i].trim();
                    }
                    for (int k = 0; k < tempDateFinal.length; k++) {
                        intDateFinal[k] = Integer.parseInt(tempDateFinal[k]);
                    }
                    Date passFinalDate = new Date(intDateFinal[0], intDateFinal[1], intDateFinal[2]);

                    //CGPA
                    String CGPAString = rs.getString("CGPA");
                    Double CGPAPass = Double.parseDouble(CGPAString);

                    //Level
                    String levelString = rs.getString("Level");
                    String[] tempLevelString = levelString.split("\n");
                    for (int i = 0; i < tempLevelString.length; i++) {
                        tempLevelString[i] = tempLevelString[i].trim();
                    }
                    List passLevel = Arrays.asList(tempLevelString);
                    //Division
                    String divString = rs.getString("Division");
                    String[] tempDivString = divString.split("\n");
                    for (int i = 0; i < tempDivString.length; i++) {
                        tempDivString[i] = tempDivString[i].trim();
                    }
                    List passDiv = Arrays.asList(tempDivString);
                    //Programme
                    String prgmString = rs.getString("Programme");
                    String[] tempPrgmString = prgmString.split("\n");
                    for (int i = 0; i < tempPrgmString.length; i++) {
                        tempPrgmString[i] = tempPrgmString[i].trim();
                    }
                    List passPrgm = Arrays.asList(tempPrgmString);

                    //waitList,recommendedList,acceptedList,rejectedList
                    //waitlist
                    String waitListString = rs.getString("waitList");
                    String[] tempwaitListString = waitListString.split("\n");
                    for (int i = 0; i < tempwaitListString.length; i++) {
                        tempwaitListString[i] = tempwaitListString[i].trim();
                    }
                    List waitList = Arrays.asList(tempwaitListString);
                    //recommendedList
                    String recommendedListString = rs.getString("recommendedList");
                    String[] temprecommendedListString = recommendedListString.split("\n");
                    for (int i = 0; i < temprecommendedListString.length; i++) {
                        temprecommendedListString[i] = temprecommendedListString[i].trim();
                    }
                    List recommendedList = Arrays.asList(temprecommendedListString);
                    //acceptedList
                    String acceptedListString = rs.getString("acceptedList");
                    String[] tempacceptedListString = acceptedListString.split("\n");
                    for (int i = 0; i < tempacceptedListString.length; i++) {
                        tempacceptedListString[i] = tempacceptedListString[i].trim();
                    }
                    List acceptedList = Arrays.asList(tempacceptedListString);
                    //waitlist
                    String rejectedListString = rs.getString("rejectedList");
                    String[] temprejectedListString = rejectedListString.split("\n");
                    for (int i = 0; i < temprejectedListString.length; i++) {
                        temprejectedListString[i] = temprejectedListString[i].trim();
                    }
                    List rejectedList = Arrays.asList(temprejectedListString);

                    if ((rs.getString("Organisation")).equals("CCCU")) {
                        Scholarships tempScholarships = new Internal_Scholarships(rs.getString("Name"),
                                rs.getString("ID"),
                                rs.getString("Organisation"),
                                rs.getString("Description"),
                                amtPass,
                                maxAwardeesPass,
                                maxApplicantsPass,
                                passInitialDate,
                                passFinalDate,
                                passLevel,
                                passDiv,
                                passPrgm,
                                waitList,
                                recommendedList,
                                acceptedList,
                                rejectedList,
                                CGPAPass
                        );
                        //return Scholarships
                        return tempScholarships;
                    } else if (!((rs.getString("Organisation")).equals("CCCU"))) {
                        Scholarships tempScholarships = new External_Scholarships(rs.getString("Name"),
                                rs.getString("ID"),
                                rs.getString("Organisation"),
                                rs.getString("Description"),
                                amtPass,
                                maxAwardeesPass,
                                maxApplicantsPass,
                                passInitialDate,
                                passFinalDate,
                                passLevel,
                                passDiv,
                                passPrgm,
                                waitList,
                                recommendedList,
                                acceptedList,
                                rejectedList,
                                CGPAPass
                        );
                        //return Scholarships
                        return tempScholarships;
                    }
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

            Scholarships tempScholarships = Scholarships;
//Name,ID,Organisation,Description,Amount,
//maxAwardees,maxApplicants,initialCutOff,finalCutOff,Level,Division,Programme
//waitList,recommendedList,acceptedList,rejectedList,CGPARequirements
            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            ps = conn.prepareStatement("INSERT INTO ScholarshipsList(Name,ID,Organisation,Description,Amount,maxAwardees,maxApplicants,initialCuttOff,finalCutOff,Level,Division,Programme,waitList,recommendedList,acceptedList,rejectedList,CGPARequirements) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
            if (tempScholarships instanceof External_Scholarships) {
                Internal_Scholarships ex = (Internal_Scholarships) tempScholarships;

                ps.setString(1, String.valueOf(ex.getName()));
                ps.setString(2, String.valueOf(ex.getID()));
                ps.setString(3, String.valueOf(ex.getOrganisation()));
                ps.setString(4, String.valueOf(ex.getDescription()));
                //Amount
                Double amtDouble = ex.getAmount();
                String amtString = amtDouble.toString();
                ps.setString(5, String.valueOf(amtString));
                //maxAwardees
                int maxAwardeesInt = ex.getMaxAwardees();
                String maxAwardeesString = Integer.toString(maxAwardeesInt);
                ps.setString(6, String.valueOf(maxAwardeesString));
                //maxApplicants
                int maxAppInt = ex.getMaxApplicants();
                String maxAppString = Integer.toString(maxAppInt);
                ps.setString(7, String.valueOf(maxAppString));

                //initialCutOff
                Date initialCutOff = ex.getInitialCutOff();
                String dateInitialString = initialCutOff.toString();
                ps.setString(8, String.valueOf(dateInitialString));
                //finaCutOff
                Date finaCutOff = ex.getFinalCutOff();
                String finaCutOffString = finaCutOff.toString();
                ps.setString(9, String.valueOf(finaCutOffString));

                //maxAwardees,maxApplicants,initialCutOff,finalCutOff,Level,Division,Programme
//waitList,recommendedList,acceptedList,rejectedList,CGPARequirements
                //Level
                List<String> LevelList = ex.getLevelApplicable();
                Iterator Levelitr = LevelList.iterator();
                String LevelString = "";
                while (Levelitr.hasNext()) {
                    LevelString += (String) Levelitr.next() + "\n";
                }
                ps.setString(10, String.valueOf(LevelString));
                //Division
                List<String> DivisionList = ex.getDivisionApplicable();
                Iterator Divisionitr = DivisionList.iterator();
                String DivisionString = "";
                while (Divisionitr.hasNext()) {
                    DivisionString += (String) Divisionitr.next() + "\n";
                }
                ps.setString(11, String.valueOf(DivisionString));
                //Programme
                List<String> ProgrammeList = ex.getProgrammeApplicable();
                Iterator Programmeitr = ProgrammeList.iterator();
                String ProgrammeString = "";
                while (Programmeitr.hasNext()) {
                    ProgrammeString += (String) Programmeitr.next() + "\n";
                }
                ps.setString(12, String.valueOf(ProgrammeString));

                //waitList
                List<String> waitList = ex.getWaitList();
                Iterator waitListitr = waitList.iterator();
                String waitListString = "";
                while (waitListitr.hasNext()) {
                    waitListString += (String) waitListitr.next() + "\n";
                }
                ps.setString(13, String.valueOf(waitListString));
                //recommendedList
                List<String> recommendedList = ex.getRecommendedList();
                Iterator recommendedListitr = recommendedList.iterator();
                String recommendedListString = "";
                while (recommendedListitr.hasNext()) {
                    recommendedListString += (String) recommendedListitr.next() + "\n";
                }
                ps.setString(14, String.valueOf(recommendedListString));
                //acceptedList
                List<String> acceptedList = ex.getAcceptedList();
                Iterator acceptedListitr = acceptedList.iterator();
                String acceptedListString = "";
                while (acceptedListitr.hasNext()) {
                    acceptedListString += (String) acceptedListitr.next() + "\n";
                }
                ps.setString(15, String.valueOf(acceptedListString));
                //rejectedList
                List<String> rejectedList = ex.getRejectedList();
                Iterator rejectedListitr = rejectedList.iterator();
                String rejectedListString = "";
                while (rejectedListitr.hasNext()) {
                    rejectedListString += (String) rejectedListitr.next() + "\n";
                }
                ps.setString(16, String.valueOf(rejectedListString));

                //CGPARequirements
                double CGPA = ex.getCGPA();
                String CGPAPass = Double.toString(CGPA);
                ps.setString(17, String.valueOf(CGPAPass));
            } else if (tempScholarships instanceof Internal_Scholarships) {
                External_Scholarships ex = (External_Scholarships) tempScholarships;

                ps.setString(1, String.valueOf(ex.getName()));
                ps.setString(2, String.valueOf(ex.getID()));
                ps.setString(3, String.valueOf(ex.getOrganisation()));
                ps.setString(4, String.valueOf(ex.getDescription()));
                //Amount
                Double amtDouble = ex.getAmount();
                String amtString = amtDouble.toString();
                ps.setString(5, String.valueOf(amtString));
                //maxAwardees
                int maxAwardeesInt = ex.getMaxAwardees();
                String maxAwardeesString = Integer.toString(maxAwardeesInt);
                ps.setString(6, String.valueOf(maxAwardeesString));
                //maxApplicants
                int maxAppInt = ex.getMaxApplicants();
                String maxAppString = Integer.toString(maxAppInt);
                ps.setString(7, String.valueOf(maxAppString));

                //initialCutOff
                Date initialCutOff = ex.getInitialCutOff();
                String dateInitialString = initialCutOff.toString();
                ps.setString(8, String.valueOf(dateInitialString));
                //finaCutOff
                Date finaCutOff = ex.getFinalCutOff();
                String finaCutOffString = finaCutOff.toString();
                ps.setString(9, String.valueOf(finaCutOffString));

                //maxAwardees,maxApplicants,initialCutOff,finalCutOff,Level,Division,Programme
//waitList,recommendedList,acceptedList,rejectedList,CGPARequirements
                //Level
                List<String> LevelList = ex.getLevelApplicable();
                Iterator Levelitr = LevelList.iterator();
                String LevelString = "";
                while (Levelitr.hasNext()) {
                    LevelString += (String) Levelitr.next() + "\n";
                }
                ps.setString(10, String.valueOf(LevelString));
                //Division
                List<String> DivisionList = ex.getDivisionApplicable();
                Iterator Divisionitr = DivisionList.iterator();
                String DivisionString = "";
                while (Divisionitr.hasNext()) {
                    DivisionString += (String) Divisionitr.next() + "\n";
                }
                ps.setString(11, String.valueOf(DivisionString));
                //Programme
                List<String> ProgrammeList = ex.getProgrammeApplicable();
                Iterator Programmeitr = ProgrammeList.iterator();
                String ProgrammeString = "";
                while (Programmeitr.hasNext()) {
                    ProgrammeString += (String) Programmeitr.next() + "\n";
                }
                ps.setString(12, String.valueOf(ProgrammeString));

                //waitList
                List<String> waitList = ex.getWaitList();
                Iterator waitListitr = waitList.iterator();
                String waitListString = "";
                while (waitListitr.hasNext()) {
                    waitListString += (String) waitListitr.next() + "\n";
                }
                ps.setString(13, String.valueOf(waitListString));
                //recommendedList
                List<String> recommendedList = ex.getRecommendedList();
                Iterator recommendedListitr = recommendedList.iterator();
                String recommendedListString = "";
                while (recommendedListitr.hasNext()) {
                    recommendedListString += (String) recommendedListitr.next() + "\n";
                }
                ps.setString(14, String.valueOf(recommendedListString));
                //acceptedList
                List<String> acceptedList = ex.getAcceptedList();
                Iterator acceptedListitr = acceptedList.iterator();
                String acceptedListString = "";
                while (acceptedListitr.hasNext()) {
                    acceptedListString += (String) acceptedListitr.next() + "\n";
                }
                ps.setString(15, String.valueOf(acceptedListString));
                //rejectedList
                List<String> rejectedList = ex.getRejectedList();
                Iterator rejectedListitr = rejectedList.iterator();
                String rejectedListString = "";
                while (rejectedListitr.hasNext()) {
                    rejectedListString += (String) rejectedListitr.next() + "\n";
                }
                ps.setString(16, String.valueOf(rejectedListString));

                //CGPARequirements
                double CGPA = ex.getCGPA();
                String CGPAPass = Double.toString(CGPA);
                ps.setString(17, String.valueOf(CGPAPass));
            }

            ps.executeUpdate();

        } catch (Throwable ex) {
            System.out.println("Exception thrown at addScholarships():");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void deleteScholarship(String ScholarshipsID) {

        try {

            PreparedStatement st = conn.prepareStatement("DELETE FROM ScholarshipsList WHERE ID = ?", ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery();
            while (rs.next()) {

                if (rs.getString("ID").trim().equals(ScholarshipsID)) {
                    rs.deleteRow();;
                    break;
                }

            }
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
