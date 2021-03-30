/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intel.gov.ke.view;

import intel.gov.ke.Main;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;

/**
 * FXML Controller class
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class AddCrimeController extends JFrame implements Initializable {
    
    PreparedStatement st;
    ResultSet rs;
    java.sql.Connection conn;
    
     @FXML
    private Button backBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Label IntelTitle;

    @FXML
    private Label IntelTitle2;

    @FXML
    private Hyperlink copyrightStatement;

    @FXML
    private Button homeBtn;

    @FXML
    private Button minimizeStageBtn;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_surname;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_cellphone_no;

    @FXML
    private TextField txt_victim_contacts;

    @FXML
    private ToggleGroup gender;

    @FXML
    private Button addNewCrimeBtn;

    @FXML
    private Button searchCrimeByOBNoBtn;

    @FXML
    private Button removeCrimeBtn;

    @FXML
    private Button printBtn;

    @FXML
    private Button clearFieldsBtn;

    @FXML
    private Button saveEditedCrimeBtn;

    @FXML
    private TextField txt_crime_scene;

    @FXML
    private TextField txt_dateCrimeOccured;

    @FXML
    private TextArea txt_crimeDescription;
    
    @FXML
    private TextField txt_doCrime1;

    @FXML
    private TextArea txt_witnessDetails;

    @FXML
    private TextArea txt_surrounding_description;

    @FXML
    private TextField txt_attach1;

    @FXML
    private TextArea txt_other_related_info;

    @FXML
    private Button exitBtn1;

    @FXML
    private TextField txt_perpe_name;

    @FXML
    private TextField txt_perpe_sname;

    @FXML
    private TextField txt_suspects;

    @FXML
    private TextArea txt_perpe_description;

    @FXML
    private MenuButton typeOfCrime;

    @FXML
    private MenuItem cat_homicide;

    @FXML
    private MenuItem cat_robbery;

    @FXML
    private MenuItem cat_physicalAssault;

    @FXML
    private MenuItem cat_IdentityTheft;

    @FXML
    private MenuItem cat_carJacking;

    @FXML
    private MenuItem cat_theftAndBanditry;

    @FXML
    private MenuItem cat_ethnicViolence;

    @FXML
    private MenuItem cat_corruptionAndBribery;

    @FXML
    private MenuItem cat_Terrorism;

    @FXML
    private MenuItem cat_illegalDrugAbuse;

    @FXML
    private MenuItem cat_Suicide;

    @FXML
    private MenuItem cat_Fraud;

    @FXML
    private MenuItem cat_trespass;

    @FXML
    private MenuItem cat_propertyDamage;

    @FXML
    private MenuItem cat_overspeeding;

    @FXML
    private MenuItem cat_drugDriving;

    @FXML
    private MenuItem cat_Kidnapping;

    @FXML
    private TextField crimeOBNumberField;

    @FXML
    private DatePicker txt_doCrime;

    @FXML
    private TextField txt_crime_cat;

    @FXML
    void aboutIntelbase(MouseEvent event) {

    }

    @FXML
    void clearFields(ActionEvent event) {
        txt_name.clear();
        txt_surname.clear();
        txt_id.clear();
        txt_crime_cat.clear();
        crimeOBNumberField.clear();
        txt_victim_contacts.clear();
        txt_cellphone_no.clear();
        txt_perpe_name.clear();
        txt_perpe_sname.clear();
        txt_suspects.clear();
        txt_perpe_description.clear();
        txt_crime_scene.clear();
        txt_dateCrimeOccured.clear();
        txt_crimeDescription.clear();
        txt_witnessDetails.clear();
        txt_surrounding_description.clear();
        txt_attach1.clear();
        txt_other_related_info.clear();
        txt_doCrime.getEditor().clear();
        ToggleGroup sex = new ToggleGroup();
        //gender.selectToggle(Toggle male);
        txt_doCrime1.clear();
    }

    @FXML
    void copyrightStatementInfo(ActionEvent event) {

    }
        @FXML
        void print(ActionEvent event) throws SQLException, ClassNotFoundException{
            String OBno = crimeOBNumberField.getText();
            
//              Map<String, Serializable> conditions = new HashMap<>();
//              conditions.put(OB_no, 1);
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
            st = conn.prepareStatement("SELECT * FROM crimes WHERE OBno = $P!{OBno}");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("OBno", OBno);
            
            JasperReport caseReport = JasperCompileManager.compileReport("C:\\Users\\Collins Mbwika\\Documents\\NetBeansProjects\\Intelbase\\src\\intel\\gov\\ke\\reports\\caseReport.jrxml");
            JasperPrint casePrint = JasperFillManager.fillReport(caseReport, parameters, conn);
            JRViewer viewer = new JRViewer(casePrint);
            viewer.setOpaque(true);
            viewer.setVisible(true);
            
            this.add(viewer);
            this.setSize(900, 700);
            this.setVisible(true);  

            
        }catch(JRException ex){
        JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }
        }


    @FXML
    void removeCrime(ActionEvent event) {
        
        try{
           
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
         
        String OB_no = crimeOBNumberField.getText();
         
                st = conn.prepareStatement("DELETE FROM crimes WHERE OBno = '"+OB_no+"'");
                boolean ok, cancel;
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("CONFIRM TO REMOVE THIS CRIME!");
                            alert.setHeaderText("CRIME: " +OB_no);
                            alert.setContentText("THIS PROCESS IS IRREVERSIBLE!");
                            alert.showAndWait();
                            ok = alert.equals(true);
                            cancel = alert.equals(false);
                            //st.execute();
                if(ok == alert.equals(true)){
                st.execute();
                alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("CRIME REMOVED SUCCESSFULLY!");
                            alert.setHeaderText("1 crime removed!");
                            //alert.setContentText("1 target removed!");
                            alert.showAndWait();
                            //clearFields();
                }
                else if(cancel == alert.equals(false)){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("CRIME REMOVAL ABORTED!");
                            alert.setHeaderText("Crime: " +OB_no);
                            //alert.setContentText("1 target added!");
                            alert.showAndWait();
                }
                else{
                    alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("OB No FIELD IS EMPTY!");
                            alert.setHeaderText("Crime: " +OB_no);
                            //alert.setContentText("1 target added!");
                            alert.showAndWait();
                }         
                

        }catch(ClassNotFoundException | SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("DATABASE MANIPULATION PERMISSION DENIED!");
                            alert.setHeaderText("Message ");
                            alert.setContentText("ERROR: " +er);
                            alert.showAndWait();
        }
    }

    @FXML
    void saveEditedCrime(ActionEvent event) {
        
        String name = txt_name.getText();
        String surname = txt_surname.getText();
        String idno = txt_id.getText();
        String crime = txt_crime_cat.getText();
        String crimeOBNumber = crimeOBNumberField.getText();
        String victim_contact = txt_victim_contacts.getText();
        String cellphone = txt_cellphone_no.getText();
        String perpetrator_name = txt_perpe_name.getText();
        String perpetrator_sname = txt_perpe_sname.getText();
        String suspect = txt_suspects.getText();
        String perpetrator_description = txt_perpe_description.getText();
        String crime_scene = txt_crime_scene.getText();
        String dateCrimeOccured = txt_dateCrimeOccured.getText();
        String crimeDescription = txt_crimeDescription.getText();
        String witnessDetails = txt_witnessDetails.getText();
        String surrounding_description = txt_surrounding_description.getText();
        String attach1 = txt_attach1.getText();
        String other_related_info = txt_other_related_info.getText();
        String doCrime1 = txt_doCrime1.getText();
        RadioButton sex = (RadioButton) gender.getSelectedToggle(); 
        

        try{
           
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");//OBno = '"+crimeOBNumber+"',
         
                st = conn.prepareStatement("UPDATE crimes SET OBno = '"+crimeOBNumber+"',crime = '"+crime+"',victim_fname = '"+name+"',victim_sname = '"+surname+"',"
                        + "victim_idno = '"+idno+"',victim_contacts = '"+victim_contact+"',scene_of_crime = '"+crime_scene+"',time_of_crime = '"+dateCrimeOccured+"',witnesses = '"+witnessDetails+"',incident_description = '"+crimeDescription+"',"
                        + "perpetrator_description = '"+perpetrator_description+"',surrounding_description = '"+surrounding_description+"',suspects = '"+suspect+"',other_related_info = '"+other_related_info+"',attach_1 = '"+attach1+"',"
                        + "victim_cellphone_no = '"+cellphone+"',date = '"+doCrime1+"',victim_gender = '"+sex+"',perpetrator_fname = '"+perpetrator_name+"',perpetrator_sname = '"+perpetrator_sname+"' WHERE OBno = '"+crimeOBNumber+"'");
                st.execute();

            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("CRIME DETAILS MANIPULATED SUCCESSFULLY!");
                            alert.setHeaderText("Crime: " +crimeOBNumber+ " " +crime);
                            //alert.setContentText("1 target added!");
                            alert.showAndWait();


        }catch(ClassNotFoundException | SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("DATABASE MANIPULATION PERMISSION DENIED!");
                            alert.setHeaderText("Check Error below...");
                            alert.setContentText("Error: " +er);
                            alert.showAndWait();
        }
    }

    @FXML
    void searchCrimeByOBNo(ActionEvent event) throws SQLException {

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddTargetController.class.getName()).log(Level.SEVERE, null, ex);
            }
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
         
         
                st = conn.prepareStatement("SELECT * FROM crimes WHERE OBno=?");
                st.setString(1, crimeOBNumberField.getText());

                    try (java.sql.ResultSet rs = st.executeQuery()) {
 
                               while(rs.next()){
                               String name = rs.getString(4);
                               txt_name.setText(name);
                               String crime_cat = rs.getString(3);
                               txt_crime_cat.setText(crime_cat);
                               String surname = rs.getString(5);
                               txt_surname.setText(surname);                               
                               String victim_contacts = rs.getString(7);
                               txt_victim_contacts.setText(victim_contacts);
                               String cellphone_no = rs.getString(20);
                               txt_cellphone_no.setText(cellphone_no);
                               String perpe_name = rs.getString(22);
                               txt_perpe_name.setText(perpe_name);
                               String perpe_sname = rs.getString(23);
                               txt_perpe_sname.setText(perpe_sname);
                               String suspects = rs.getString(14);
                               txt_suspects.setText(suspects);
                               String perpe_description = rs.getString(12);
                               txt_perpe_description.setText(perpe_description);
                               String crime_scene = rs.getString(8);
                               txt_crime_scene.setText(crime_scene);
                               String dateCrimeOccured = rs.getString(9);
                               txt_dateCrimeOccured.setText(dateCrimeOccured);
                               String crimeDescription = rs.getString(11);
                               txt_crimeDescription.setText(crimeDescription);
                               String witnessDetails = rs.getString(10);
                               txt_witnessDetails.setText(witnessDetails);
                               String surrounding_description = rs.getString(13);
                               txt_surrounding_description.setText(surrounding_description);
                               String attach1 = rs.getString(17);
                               txt_attach1.setText(attach1);
                               String other_related_info = rs.getString(16);
                               txt_other_related_info.setText(other_related_info);
                               String id = rs.getString(6);
                               txt_id.setText(id);
                                       //setText(doCrime);
                               //String gender = rs.getString(21);
                               //gender.selectToggle((Toggle) gender);
                               //RadioButton sex = (RadioButton) gender.getToggles();
                               gender.getSelectedToggle();
                               //gender.selectToggle(Toggle 21);
                               String doCrime1 = rs.getString(19);
                               txt_doCrime1.setText(doCrime1);
                }

        }catch(SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Connection to Database Failed!");
                            //alert.setHeaderText("Try Again!");"Generated Error: " 
                            alert.setContentText("" +er);
                            alert.showAndWait();
        }
    }

    @FXML
    void showCat_homicide(ActionEvent event) {
        String category = "Homicide";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showCat_physicalAssault(ActionEvent event) {
        String category = "Physical Assault";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showCat_robbery(ActionEvent event) {
        String category = "Robbery";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_Fraud(ActionEvent event) {
        String category = "Fraud";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_IdentityTheft(ActionEvent event) {
        String category = "Identity Theft";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_Kidnapping(ActionEvent event) {
        String category = "Kidnapping";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_Suicide(ActionEvent event) {
        String category = "Suicide";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_Terrorism(ActionEvent event) {
        String category = "Terrorism";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_carJacking(ActionEvent event) {
        String category = "Carjacking";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_corruptionAndBribery(ActionEvent event) {
        String category = "Corruption & Bribery";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_drugDriving(ActionEvent event) {
        String category = "Drug Driving";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_ethnicViolence(ActionEvent event) {
        String category = "Ethnic Violence";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_illegalDrugAbuse(ActionEvent event) {
        String category = "Illegal Substance Possession";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_overspeeding(ActionEvent event) {
        String category = "Overspeeding";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_propertyDamage(ActionEvent event) {
        String category = "Property Damage";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_theftAndBanditry(ActionEvent event) {
        String category = "Theft & Banditry";
        txt_crime_cat.setText(category);
    }

    @FXML
    void showcat_trespass(ActionEvent event) {
        String category = "Trespassing";
        txt_crime_cat.setText(category);
    }



    @FXML
    void back(ActionEvent event) throws IOException {
        Main.showLanding();
    }

    @FXML
    void exit(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        Main.showLogin();
    }

    @FXML
    void minimizeStage(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    void addNewCrime(ActionEvent event) {
        PreparedStatement st;
        java.sql.Connection conn;
        
        String name = txt_name.getText();
        String surname = txt_surname.getText();
        String idno = txt_id.getText();
        String crime = txt_crime_cat.getText();
        String crimeOBNumber = crimeOBNumberField.getText();
        String victim_contact = txt_victim_contacts.getText();
        String cellphone = txt_cellphone_no.getText();
        String perpetrator_name = txt_perpe_name.getText();
        String perpetrator_sname = txt_perpe_sname.getText();
        String suspect = txt_suspects.getText();
        String perpetrator_description = txt_perpe_description.getText();
        String crime_scene = txt_crime_scene.getText();
        String dateCrimeOccured = txt_dateCrimeOccured.getText();
        String crimeDescription = txt_crimeDescription.getText();
        String witnessDetails = txt_witnessDetails.getText();
        String surrounding_description = txt_surrounding_description.getText();
        String attach1 = txt_attach1.getText();
        String other_related_info = txt_other_related_info.getText();
        String doCrime = txt_doCrime.getEditor().getText();
        RadioButton sex = (RadioButton) gender.getSelectedToggle();

        try{
           
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
         if(name != null){
                st = conn.prepareStatement("INSERT INTO crimes (OBno,crime,victim_fname,victim_sname,"
                        + "victim_idno,victim_contacts,scene_of_crime,time_of_crime,witnesses,incident_description,"
                        + "perpetrator_description,surrounding_description,suspects,other_related_info,attach_1,date"
                        + "victim_cellphone_no,victim_gender,perpetrator_fname,perpetrator_sname) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
         //,victim_gender
                st.setString(1, crimeOBNumber);
                st.setString(2, crime);
                st.setString(3, name);
                st.setString(4, surname);
                st.setString(5, idno);
                st.setString(6, victim_contact);
                st.setString(7, crime_scene);
                st.setString(8, dateCrimeOccured);
                st.setString(9, witnessDetails);
                st.setString(10, crimeDescription);
                st.setString(11, perpetrator_description);
                st.setString(12, surrounding_description);
                st.setString(13, suspect);
                st.setString(14, other_related_info);
                st.setString(15, attach1);
                st.setString(16, doCrime);
                st.setString(17, cellphone);
                st.setString(18, gender.getSelectedToggle().toString());
                st.setString(19, perpetrator_name);
                st.setString(20, perpetrator_sname);
                st.executeUpdate();
                
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("A CRIME ADDED SUCCESSFULLY!");
                            alert.setHeaderText("OB Number: " +crimeOBNumber+ " Crime: " +crime);
                            alert.showAndWait();
                }else{
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("FAILURE!");
                            alert.setHeaderText("NO CRIME ADDED!");
                            alert.setContentText("No crime Added. Try Again!");
                            alert.showAndWait();
                }
        }catch(ClassNotFoundException | SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("DATABASE MANIPULATION PERMISSION DENIED!");
                            alert.setHeaderText("Possible OB Number duplication or Ommission");
                            alert.setContentText("Error: " +er);
                            alert.showAndWait();
        }      
    }
    
}
