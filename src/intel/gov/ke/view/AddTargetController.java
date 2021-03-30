/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intel.gov.ke.view;

import intel.gov.ke.Main;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class AddTargetController extends JFrame implements Initializable {
    
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
    private Hyperlink copyrightStatement;

    @FXML
    private Button homeBtn;

    @FXML
    private Button minimizeStageBtn;

    @FXML
    private ToggleGroup sex;

    @FXML
    private ToggleGroup Male;

    @FXML
    private ToggleGroup Male1;

    @FXML
    private Button exitBtn1;

    @FXML
    private Button exitBtn11;

    @FXML
    private Button exitBtn12;

    @FXML
    private Button exitBtn121;

    @FXML
    private Button exitBtn1211;

    @FXML
    private Button exitBtn122;

    @FXML
    private Button exitBtn1221;

    @FXML
    private Button exitBtn12211;

    @FXML
    private Button exitBtn1222;
    
    //TextAreas and TextFields
    @FXML
    private TextArea txt_profile;

    @FXML
    private TextField txt_workplace;

    @FXML
    private TextField txt_job;

    @FXML
    private TextField txt_residence;

    @FXML
    private TextField txt_homeplace;

    @FXML
    private TextArea txt_academicinstitutions;

    @FXML
    private TextArea txt_academicqualifications;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_surname;

    @FXML
    private TextField txt_id;

    @FXML
    private DatePicker txt_dob;
    
    @FXML
    private TextField txt_bloodtype;

    @FXML
    private TextField txt_height;
    
    @FXML
    private TextField txt_drivinglicence;

    @FXML
    private TextField txt_serviceno;

    @FXML
    private TextField txt_criminalrecord;

    @FXML
    private TextField txt_religion;
    
    @FXML
    Button printBtn;
    
    private static BorderPane mainLayout;
    private static Stage mainStage;
    
        public void showReport() throws SQLException, ClassNotFoundException, JRException {
            String idno = txt_id.getText();
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
            JasperDesign jd = JRXmlLoader.load("C:\\Users\\Collins Mbwika\\Documents\\NetBeansProjects\\Intelbase\\src\\intel\\gov\\ke\\reports\\target.jrxml");
            String sql = "SELECT targets.'id_number' AS targets_id_number, targets.'firstname' AS targets_firstname, targets.'surname' AS targets_surname FROM targets WHERE id_number = '"+idno+"'";

            JRDesignQuery newQ = new JRDesignQuery();
            newQ.setText(sql);
            jd.setQuery(newQ);
            
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);
    
        }catch(JRException ex){
             ex.printStackTrace();}
    }
        
        
        //            InputStream in = this.getClass().getClassLoader().getResourceAsStream("C:\\Users\\Collins Mbwika\\Documents\\NetBeansProjects\\Intelbase\\src\\intel\\gov\\ke\\reports\\target.jrxml");
            //My way of loading the report. Same Path
//            JasperReport jasperReport = JasperCompileManager.compileReport("");
        //            Map<String, Object> parameter = new HashMap<String, Object>();
//            parameter.put("idno", idno);

//            JasperReport jasperReport = JasperCompileManager.compileReport("C:\\Users\\"
//            + "Collins Mbwika\\Documents\\NetBeansProjects\\Intelbase\\src\\intel\\gov\\ke\\"
//                    + "reports\\target.jrxml");
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
//            JRViewer viewer = new JRViewer(jasperPrint);
//            viewer.setOpaque(true);
//            viewer.setVisible(true);
//            this.add(viewer);
//            this.setSize(900, 700);
//            this.setVisible(true);
    
    @FXML
    void print(ActionEvent event) throws IOException, SQLException, ClassNotFoundException, JRException{
     showReport();
    }

    
    @FXML
    Button saveEditedTargetBtn;
    
    @FXML
    void saveEditedTarget(ActionEvent event) {

        String name = txt_name.getText();
        String surname = txt_surname.getText();
        String idno = txt_id.getText();
        String driving_licence = txt_drivinglicence.getText();
        String service_no = txt_serviceno.getText();
        String criminal_record = txt_criminalrecord.getText();
        String religion = txt_religion.getText();
        String height = txt_height.getText();
        String homeplace = txt_homeplace.getText();
        String workplace = txt_workplace.getText();
        String job = txt_job.getText();
        String bloodtype = txt_bloodtype.getText();
        String residence = txt_residence.getText();
        String profile = txt_profile.getText();
        String academic_institutions = txt_academicinstitutions.getText();
        String academic_qualifications = txt_academicqualifications.getText();
        

        try{
           
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
         
                st = conn.prepareStatement("UPDATE targets SET id_number = '"+idno+"',firstname = '"+name+"',surname = '"+surname+"',dob = '"+name+"',work_places = '"+workplace+"'"
                        + ",job_titles = '"+job+"',academic_institutions = '"+academic_institutions+"',academic_qualifications = '"+academic_qualifications+"',height = '"+height+"',profile = '"+profile+"'"
                        + ",blood_type = '"+bloodtype+"',driving_license_no = '"+driving_licence+"',service_no = '"+service_no+"',criminal_records = '"+criminal_record+"'"
                        + ",religion = '"+religion+"',home_place = '"+homeplace+"',resident_place = '"+residence+"' WHERE id_number = '"+idno+"'");
                st.execute();

            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("TARGET DATA MANIPULATED SUCCESSFULLY!");
                            alert.setHeaderText("Target name: " +name+ " " +surname);
                            //alert.setContentText("1 target added!");
                            alert.showAndWait();


        }catch(ClassNotFoundException | SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("DATABASE MANIPULATION PERMISSION DENIED!");
                            alert.setHeaderText("Possible ID Number Manipulation");
                            alert.setContentText("Do not edit the ID, otherwise enter as a new Target." +er);
                            alert.showAndWait();
        }
    }
    
    
    @FXML
    void addNewTarget(ActionEvent event) {
        
        String name = txt_name.getText();
        String surname = txt_surname.getText();
        String idno = txt_id.getText();
        String driving_licence = txt_drivinglicence.getText();
        String service_no = txt_serviceno.getText();
        String criminal_record = txt_criminalrecord.getText();
        String religion = txt_religion.getText();
        String height = txt_height.getText();
        String homeplace = txt_homeplace.getText();
        String workplace = txt_workplace.getText();
        String job = txt_job.getText();
        String bloodtype = txt_bloodtype.getText();
        String residence = txt_residence.getText();
        String profile = txt_profile.getText();
        String academic_institutions = txt_academicinstitutions.getText();
        String academic_qualifications = txt_academicqualifications.getText();
        

        try{
           
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
         if(name != null){
                st = conn.prepareStatement("INSERT INTO targets (id_number,firstname,surname,dob,work_places,job_titles,academic_institutions,academic_qualifications,height,profile,blood_type,driving_license_no,service_no,criminal_records,religion,home_place,resident_place) VALUES "
                        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
         
                st.setString(1, idno);
                st.setString(2, name);
                st.setString(3, surname);
                st.setString(4, ((TextField)txt_dob.getEditor()).getText());
                st.setString(5, workplace);
                st.setString(6, job);
                st.setString(7, academic_institutions);
                st.setString(8, academic_qualifications);
                st.setString(9, height);
                st.setString(10, profile);
                st.setString(11, bloodtype);
                st.setString(12, driving_licence);
                st.setString(13, service_no);
                st.setString(14, criminal_record);
                st.setString(15, religion);
                st.setString(16, homeplace);
                st.setString(17, residence);
                st.executeUpdate();
                //int i = st.executeUpdate();
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("1 TARGET ADDED SUCCESSFULLY!");
                            alert.setHeaderText("Target name: " +name+ " " +surname);
                            //alert.setContentText("1 target added!");
                            alert.showAndWait();
                }else{
                    Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("SUCCESS!");
                            alert.setHeaderText("0 TARGET ADDED!");
                            alert.setContentText("No Target Added. Try Again!");
                            alert.showAndWait();
                }
        }catch(ClassNotFoundException | SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("DATABASE MANIPULATION PERMISSION DENIED!");
                            alert.setHeaderText("Possible ID Number duplication or Ommission");
                            alert.setContentText("Try Again or Check whether the target is already in the system." +er);
                            alert.showAndWait();
        }      
    }
    @FXML
    Button removeTargetBtn;
    
    @FXML
    void removeTarget(ActionEvent event){
        
        try{
           
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
         
        String name = txt_name.getText();
        String surname = txt_surname.getText();
        String idno = txt_id.getText();
         
                st = conn.prepareStatement("DELETE FROM targets WHERE id_number = '"+idno+"'");
                //System.out.println("Text: "+idno);
                //st.setString(1, idno);
                boolean ok, cancel;
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("CONFIRM TO REMOVE THIS TARGET!");
                            alert.setHeaderText("Target name: " +name+ " " +surname);
                            alert.setContentText("THIS PROCESS IS IRREVERSIBLE!");
                            alert.showAndWait();
                            ok = alert.equals(true);
                            cancel = alert.equals(false);
                            //st.execute();
                if(ok == alert.equals(true)){
                st.execute();
                alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("TARGET REMOVED SUCCESSFULLY!");
                            alert.setHeaderText("1 target removed!");
                            //alert.setContentText("1 target removed!");
                            alert.showAndWait();
                            //clearFields();
                }
                else if(cancel == alert.equals(false)){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("TARGET REMOVAL ABORTED!");
                            alert.setHeaderText("Target name: " +name+ " " +surname);
                            //alert.setContentText("1 target added!");
                            alert.showAndWait();
                }
                else{
                    alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("TARGET ID FIELD IS EMPTY!");
                            alert.setHeaderText("Target name: " +name+ " " +surname);
                            //alert.setContentText("1 target added!");
                            alert.showAndWait();
                }         
                

        }catch(ClassNotFoundException | SQLException er){
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("DATABASE MANIPULATION PERMISSION DENIED!");
                            alert.setHeaderText("Possible ID Number Manipulation");
                            alert.setContentText("ERROR: " +er);
                            alert.showAndWait();
        }
    }
    
    
    @FXML
    Button addNewTargetBtn;
    
    @FXML
    Button clearFieldsBtn;
    
    @FXML
    void clearFields(ActionEvent event){
        txt_name.clear();
        txt_profile.clear();
        txt_surname.clear();
        txt_id.clear();
        txt_drivinglicence.clear();
        txt_criminalrecord.clear();
        txt_religion.clear();
        txt_height.clear();
        txt_homeplace.clear();
        txt_dob.setValue(null);
        txt_bloodtype.clear();
        txt_serviceno.clear();
        txt_academicinstitutions.clear();
        txt_academicqualifications.clear();
        txt_residence.clear();
        txt_job.clear();
        txt_workplace.clear();
    }
    
    @FXML
    Button searchTargetBtn;
   
    
    @FXML
    void searchTarget(ActionEvent event) throws SQLException{
        
        String idno = txt_id.getText();
        

        
           
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AddTargetController.class.getName()).log(Level.SEVERE, null, ex);
            }
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
         
         
                st = conn.prepareStatement("SELECT * FROM targets WHERE id_number=?");
                st.setString(1, idno);

                    try (java.sql.ResultSet rs = st.executeQuery()) {
 
                                while(rs.next()){
                               String name = rs.getString(4);
                               txt_name.setText(name);
                               String profile = rs.getString(15);
                               txt_profile.setText(profile);
                               //
                               String surname = rs.getString(6);
                               txt_surname.setText(surname);                               
                               String height = rs.getString(13);
                               txt_height.setText(height);
                               String bloodtype = rs.getString(18);
                               txt_bloodtype.setText(bloodtype);
                               String workplace = rs.getString(9);
                               txt_workplace.setText(workplace);
                               String job = rs.getString(10);
                               txt_job.setText(job);
                               String residence = rs.getString(25);
                               txt_residence.setText(residence);
                               String homeplace = rs.getString(24);
                               txt_homeplace.setText(homeplace);
                               String academicinstitutions = rs.getString(11);
                               txt_academicinstitutions.setText(academicinstitutions);
                               String academicqualifications = rs.getString(12);
                               txt_academicqualifications.setText(academicqualifications);
                               String drivinglicence = rs.getString(20);
                               txt_drivinglicence.setText(drivinglicence);
                               String serviceno = rs.getString(21);
                               txt_serviceno.setText(serviceno);
                               String criminalrecord = rs.getString(22);
                               txt_criminalrecord.setText(criminalrecord);
                               String religion = rs.getString(23);
                               txt_religion.setText(religion);
                               
//data.add(new LandingController.TargetDetails(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(2), rs.getString(9), rs.getString(25), rs.getString(22)));

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
    void aboutIntelbase(MouseEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        Main.showLanding();
    }

    @FXML
    void copyrightStatementInfo(ActionEvent event) {

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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    
}
