package intel.gov.ke.view;

import com.sun.prism.impl.Disposer;
import intel.gov.ke.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class LandingController implements Initializable {

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
    private Button backBtn;
        
        @FXML
    private Button viewEntirePersonsDBBtn;
        
        @FXML
    private Button addTargetBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button homeBtn;

    @FXML
    TextField targetNameField;
    
    @FXML
    TextField crimeOBNumberField;
    
    @FXML
    private Label IntelTitle;

    @FXML
    private Hyperlink copyrightStatement;
    
        @FXML
    private Button minimizeStageBtn;
        
        @FXML
    void addTarget(ActionEvent event) throws IOException {
        Main.addNewTargetContainer();
    }
    
    @FXML
    void addCrime(ActionEvent event) throws IOException {
        Main.addNewCrimeContainer();
    }

    @FXML
    Button addAccidentBtn;
    @FXML
    void addAccident(ActionEvent event) throws IOException {
        Main.addNewAccidentsContainer();
    }
    
    @FXML
    Button addAutoBtn;
    @FXML
    void addAuto(ActionEvent event) throws IOException {
        Main.addNewAutomobileContainer();
    }
    
    @FXML
    Button viewAllMilitaryOpsBtn;
    @FXML
    void viewAllMilitaryOps(ActionEvent event) throws IOException {
        Main.addNewMilitaryOpContainer();
    }
    
    @FXML
    Button addTerrorIntelBtn;
    
    @FXML
    void addTerrorIntel(ActionEvent event) throws IOException {
        Main.addNewTerrorContainer();
    }
        
            @FXML
    void minimizeStage(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    void aboutIntelbase(MouseEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {
        
        Main.showLogin();
    }

     @FXML
    void clearAutoNumber(ActionEvent event) {

    }

     @FXML
    void clearCrime(ActionEvent event) {

    }

     @FXML
    void clearPerson(ActionEvent event) {

    }

     @FXML
    void clearTerrorTargets(ActionEvent event) {

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
    void searchAutoNumber(ActionEvent event) {

    }

     @FXML
    void searchCrime(ActionEvent event) {

    }

     @FXML
    void searchTerrorTargets(ActionEvent event) {

    }
 @FXML
    void showTarget(ActionEvent event) throws IOException {
        
    }
        void viewCrimesAnalysis(ActionEvent event) {

    }
        
    
    //targets
         @FXML
    private TableView<LandingController.TargetDetails> targetsTable;

          @FXML
    private TableColumn<LandingController.TargetDetails, String> firstname;

           @FXML
    private TableColumn<LandingController.TargetDetails, String> middlename;

            @FXML
    private TableColumn<LandingController.TargetDetails, String> surname;

             @FXML
    private TableColumn<LandingController.TargetDetails, String> idno;

              @FXML
    private TableColumn<LandingController.TargetDetails, String> workplace;

               @FXML
    private TableColumn<LandingController.TargetDetails, String> homeplace;

                @FXML
    private TableColumn<LandingController.TargetDetails, String> criminal_record;
        //Initialize observable list to hold db data
    private ObservableList<LandingController.TargetDetails>data;
    private Main dc;
    @FXML
    Button searchPersonsBtn;
    @FXML
    Button searchPersonsBtn1;
    @FXML
    Button searchPersonsBtn2;
    
    @FXML
    void searchPersons(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data = FXCollections.observableArrayList();
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM targets WHERE firstname=?") ;
             pst.setString(1, targetNameField.getText());
             firstname.setText("First Name");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
                                  data.add(new LandingController.TargetDetails(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(2), rs.getString(9), rs.getString(25), rs.getString(22)));
           String fname = rs.getString(2);  
 
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        middlename.setCellValueFactory(new PropertyValueFactory<>("middlename"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        idno.setCellValueFactory(new PropertyValueFactory<>("idno"));
        workplace.setCellValueFactory(new PropertyValueFactory<>("workplace"));
        homeplace.setCellValueFactory(new PropertyValueFactory<>("homeplace"));
        criminal_record.setCellValueFactory(new PropertyValueFactory<>("criminalrecord"));
        
        targetsTable.setItems(null);
        targetsTable.setItems(data);
            //Define the button cell
  
}

    public class SubRecord1{
        private final SimpleStringProperty fieldSubRecordName;
        private final SimpleIntegerProperty fieldSubRecordValue;
         
        SubRecord1(String sn, int sv){
          this.fieldSubRecordName = new SimpleStringProperty(sn);
          this.fieldSubRecordValue = new SimpleIntegerProperty(sv);
      }
      
      public String getFieldSubRecordName() {
          return fieldSubRecordName.get();
      }
      
      public int getFieldSubRecordValue() {
          return fieldSubRecordValue.get();
      }
      
  }

    
    public class TargetDetails1 {
    private final StringProperty firstname;
    private final StringProperty middlename;
    private final StringProperty surname;
    private final StringProperty idno;
    private final StringProperty workplace;
    private final StringProperty homeplace;
    private final StringProperty criminalrecord;
    
    //default constructor
    public TargetDetails1(String firstname, String middlename, String surname, String idno, String workplace, String homeplace, String criminalrecord){
        this.firstname = new SimpleStringProperty(firstname);
        this.middlename = new SimpleStringProperty(middlename);
        this.surname = new SimpleStringProperty(surname);
        this.idno = new SimpleStringProperty(idno);
        this.workplace = new SimpleStringProperty(workplace);
        this.homeplace = new SimpleStringProperty(homeplace);
        this.criminalrecord = new SimpleStringProperty(criminalrecord);
    }
    
    //gets
    public String getFirstname(){
        return firstname.get();
    }
    public String getMiddlename(){
        return middlename.get();
    }
    public String getSurname(){
        return surname.get();
    }
    public String getIdno(){
        return idno.get();
    }
    public String getWorkplace(){
        return workplace.get();
    }
    public String getHomeplace(){
        return homeplace.get();
    }
    public String getCriminalrecord(){
        return criminalrecord.get();
    }
    
    //sets
    public void setFirstname(String value){
        firstname.set(value);
    }
    public void setMiddlename(String value){
        middlename.set(value);
    }
    public void setSurname(String value){
        surname.set(value);
    }
    public void setIdno(String value){
        idno.set(value);
    }
    public void setWorkplace(String value){
        workplace.set(value);
    }
    public void setHomeplace(String value){
        homeplace.set(value);
    }
    public void setCriminalrecord(String value){
        criminalrecord.set(value);
    }
    
    //Property values
    public StringProperty firstnameProperty(){
        return firstname;
    }
    public StringProperty middlenameProperty(){
        return middlename;
    }
    public StringProperty surnameProperty(){
        return surname;
    }
    public StringProperty idnoProperty(){
        return idno;
    }
    public StringProperty workplaceProperty(){
        return workplace;
    }
    public StringProperty homeplaceProperty(){
        return homeplace;
    }
    public StringProperty criminalrecordProperty(){
        return criminalrecord;
    }
    }
    
    @FXML
    void searchPersonsById(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data = FXCollections.observableArrayList();
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM targets WHERE id_number=?") ;
             pst.setString(1, targetNameField.getText());
             idno.setText("ID Number");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
                                  data.add(new LandingController.TargetDetails(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(2), rs.getString(9), rs.getString(25), rs.getString(22)));
           String ID_number = rs.getString(2);  
                   
            
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        middlename.setCellValueFactory(new PropertyValueFactory<>("middlename"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        idno.setCellValueFactory(new PropertyValueFactory<>("idno"));
        workplace.setCellValueFactory(new PropertyValueFactory<>("workplace"));
        homeplace.setCellValueFactory(new PropertyValueFactory<>("homeplace"));
        criminal_record.setCellValueFactory(new PropertyValueFactory<>("criminalrecord"));
        
        targetsTable.setItems(null);
        targetsTable.setItems(data);
            //Define the button cell
  
}

    public class SubRecord11{
        private final SimpleStringProperty fieldSubRecordName;
        private final SimpleIntegerProperty fieldSubRecordValue;
         
        SubRecord11(String sn, int sv){
          this.fieldSubRecordName = new SimpleStringProperty(sn);
          this.fieldSubRecordValue = new SimpleIntegerProperty(sv);
      }
      
      public String getFieldSubRecordName() {
          return fieldSubRecordName.get();
      }
      
      public int getFieldSubRecordValue() {
          return fieldSubRecordValue.get();
      }
      
  }

    
    public class TargetDetails11 {
    private final StringProperty firstname;
    private final StringProperty middlename;
    private final StringProperty surname;
    private final StringProperty idno;
    private final StringProperty workplace;
    private final StringProperty homeplace;
    private final StringProperty criminalrecord;
    
    //default constructor
    public TargetDetails11(String firstname, String middlename, String surname, String idno, String workplace, String homeplace, String criminalrecord){
        this.firstname = new SimpleStringProperty(firstname);
        this.middlename = new SimpleStringProperty(middlename);
        this.surname = new SimpleStringProperty(surname);
        this.idno = new SimpleStringProperty(idno);
        this.workplace = new SimpleStringProperty(workplace);
        this.homeplace = new SimpleStringProperty(homeplace);
        this.criminalrecord = new SimpleStringProperty(criminalrecord);
    }
    
    //gets
    public String getFirstname(){
        return firstname.get();
    }
    public String getMiddlename(){
        return middlename.get();
    }
    public String getSurname(){
        return surname.get();
    }
    public String getIdno(){
        return idno.get();
    }
    public String getWorkplace(){
        return workplace.get();
    }
    public String getHomeplace(){
        return homeplace.get();
    }
    public String getCriminalrecord(){
        return criminalrecord.get();
    }
    
    //sets
    public void setFirstname(String value){
        firstname.set(value);
    }
    public void setMiddlename(String value){
        middlename.set(value);
    }
    public void setSurname(String value){
        surname.set(value);
    }
    public void setIdno(String value){
        idno.set(value);
    }
    public void setWorkplace(String value){
        workplace.set(value);
    }
    public void setHomeplace(String value){
        homeplace.set(value);
    }
    public void setCriminalrecord(String value){
        criminalrecord.set(value);
    }
    
    //Property values
    public StringProperty firstnameProperty(){
        return firstname;
    }
    public StringProperty middlenameProperty(){
        return middlename;
    }
    public StringProperty surnameProperty(){
        return surname;
    }
    public StringProperty idnoProperty(){
        return idno;
    }
    public StringProperty workplaceProperty(){
        return workplace;
    }
    public StringProperty homeplaceProperty(){
        return homeplace;
    }
    public StringProperty criminalrecordProperty(){
        return criminalrecord;
    }
    }
    
    @FXML
    void searchPersonsBySurname(ActionEvent event) throws SQLException{

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data = FXCollections.observableArrayList();
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM targets WHERE surname=?") ;
             pst.setString(1, targetNameField.getText());
             surname.setText("Surname");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
                                  data.add(new LandingController.TargetDetails(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(2), rs.getString(9), rs.getString(25), rs.getString(22)));
           String sname = rs.getString(2);  
            
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        middlename.setCellValueFactory(new PropertyValueFactory<>("middlename"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        idno.setCellValueFactory(new PropertyValueFactory<>("idno"));
        workplace.setCellValueFactory(new PropertyValueFactory<>("workplace"));
        homeplace.setCellValueFactory(new PropertyValueFactory<>("homeplace"));
        criminal_record.setCellValueFactory(new PropertyValueFactory<>("criminalrecord"));
        
        targetsTable.setItems(null);
        targetsTable.setItems(data);
            //Define the button cell
  
}

    public class SubRecord22{
        private final SimpleStringProperty fieldSubRecordName;
        private final SimpleIntegerProperty fieldSubRecordValue;
         
        SubRecord22(String sn, int sv){
          this.fieldSubRecordName = new SimpleStringProperty(sn);
          this.fieldSubRecordValue = new SimpleIntegerProperty(sv);
      }
      
      public String getFieldSubRecordName() {
          return fieldSubRecordName.get();
      }
      
      public int getFieldSubRecordValue() {
          return fieldSubRecordValue.get();
      }
      
  }

    
    public class TargetDetails22 {
    private final StringProperty firstname;
    private final StringProperty middlename;
    private final StringProperty surname;
    private final StringProperty idno;
    private final StringProperty workplace;
    private final StringProperty homeplace;
    private final StringProperty criminalrecord;
    
    //default constructor
    public TargetDetails22(String firstname, String middlename, String surname, String idno, String workplace, String homeplace, String criminalrecord){
        this.firstname = new SimpleStringProperty(firstname);
        this.middlename = new SimpleStringProperty(middlename);
        this.surname = new SimpleStringProperty(surname);
        this.idno = new SimpleStringProperty(idno);
        this.workplace = new SimpleStringProperty(workplace);
        this.homeplace = new SimpleStringProperty(homeplace);
        this.criminalrecord = new SimpleStringProperty(criminalrecord);
    }
    
    //gets
    public String getFirstname(){
        return firstname.get();
    }
    public String getMiddlename(){
        return middlename.get();
    }
    public String getSurname(){
        return surname.get();
    }
    public String getIdno(){
        return idno.get();
    }
    public String getWorkplace(){
        return workplace.get();
    }
    public String getHomeplace(){
        return homeplace.get();
    }
    public String getCriminalrecord(){
        return criminalrecord.get();
    }
    
    //sets
    public void setFirstname(String value){
        firstname.set(value);
    }
    public void setMiddlename(String value){
        middlename.set(value);
    }
    public void setSurname(String value){
        surname.set(value);
    }
    public void setIdno(String value){
        idno.set(value);
    }
    public void setWorkplace(String value){
        workplace.set(value);
    }
    public void setHomeplace(String value){
        homeplace.set(value);
    }
    public void setCriminalrecord(String value){
        criminalrecord.set(value);
    }
    
    //Property values
    public StringProperty firstnameProperty(){
        return firstname;
    }
    public StringProperty middlenameProperty(){
        return middlename;
    }
    public StringProperty surnameProperty(){
        return surname;
    }
    public StringProperty idnoProperty(){
        return idno;
    }
    public StringProperty workplaceProperty(){
        return workplace;
    }
    public StringProperty homeplaceProperty(){
        return homeplace;
    }
    public StringProperty criminalrecordProperty(){
        return criminalrecord;
    }
    }
    

    @FXML
    void viewEntirePersonsDB(ActionEvent event){
        try {

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data = FXCollections.observableArrayList();
        
        //Execute query and store results in a resultset
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM targets");
        while (rs.next()){
            //get Strings from the database, whichever order
            data.add(new LandingController.TargetDetails(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(2), rs.getString(9), rs.getString(25), rs.getString(22)));
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        middlename.setCellValueFactory(new PropertyValueFactory<>("middlename"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        idno.setCellValueFactory(new PropertyValueFactory<>("idno"));
        workplace.setCellValueFactory(new PropertyValueFactory<>("workplace"));
        homeplace.setCellValueFactory(new PropertyValueFactory<>("homeplace"));
        criminal_record.setCellValueFactory(new PropertyValueFactory<>("criminalrecord"));
        
        targetsTable.setItems(null);
        targetsTable.setItems(data);
            //Define the button cell
  
}

    public class SubRecord{
        private final SimpleStringProperty fieldSubRecordName;
        private final SimpleIntegerProperty fieldSubRecordValue;
         
        SubRecord(String sn, int sv){
          this.fieldSubRecordName = new SimpleStringProperty(sn);
          this.fieldSubRecordValue = new SimpleIntegerProperty(sv);
      }
      
      public String getFieldSubRecordName() {
          return fieldSubRecordName.get();
      }
      
      public int getFieldSubRecordValue() {
          return fieldSubRecordValue.get();
      }
      
  }
     //Define the button cell
    private class ButtonCell extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell(final TableView targetsTable){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)targetsTable.getItems().get(selectdIndex);
                firstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
                middlename.setCellValueFactory(new PropertyValueFactory<>("middlename"));
                surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
                idno.setCellValueFactory(new PropertyValueFactory<>("idno"));
                workplace.setCellValueFactory(new PropertyValueFactory<>("workplace"));
                homeplace.setCellValueFactory(new PropertyValueFactory<>("homeplace"));
                criminal_record.setCellValueFactory(new PropertyValueFactory<>("criminalrecord"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class TargetDetails {
    private final StringProperty firstname;
    private final StringProperty middlename;
    private final StringProperty surname;
    private final StringProperty idno;
    private final StringProperty workplace;
    private final StringProperty homeplace;
    private final StringProperty criminalrecord;
    
    //default constructor
    public TargetDetails(String firstname, String middlename, String surname, String idno, String workplace, String homeplace, String criminalrecord){
        this.firstname = new SimpleStringProperty(firstname);
        this.middlename = new SimpleStringProperty(middlename);
        this.surname = new SimpleStringProperty(surname);
        this.idno = new SimpleStringProperty(idno);
        this.workplace = new SimpleStringProperty(workplace);
        this.homeplace = new SimpleStringProperty(homeplace);
        this.criminalrecord = new SimpleStringProperty(criminalrecord);
    }
    
    //gets
    public String getFirstname(){
        return firstname.get();
    }
    public String getMiddlename(){
        return middlename.get();
    }
    public String getSurname(){
        return surname.get();
    }
    public String getIdno(){
        return idno.get();
    }
    public String getWorkplace(){
        return workplace.get();
    }
    public String getHomeplace(){
        return homeplace.get();
    }
    public String getCriminalrecord(){
        return criminalrecord.get();
    }
    
    //sets
    public void setFirstname(String value){
        firstname.set(value);
    }
    public void setMiddlename(String value){
        middlename.set(value);
    }
    public void setSurname(String value){
        surname.set(value);
    }
    public void setIdno(String value){
        idno.set(value);
    }
    public void setWorkplace(String value){
        workplace.set(value);
    }
    public void setHomeplace(String value){
        homeplace.set(value);
    }
    public void setCriminalrecord(String value){
        criminalrecord.set(value);
    }
    
    //Property values
    public StringProperty firstnameProperty(){
        return firstname;
    }
    public StringProperty middlenameProperty(){
        return middlename;
    }
    public StringProperty surnameProperty(){
        return surname;
    }
    public StringProperty idnoProperty(){
        return idno;
    }
    public StringProperty workplaceProperty(){
        return workplace;
    }
    public StringProperty homeplaceProperty(){
        return homeplace;
    }
    public StringProperty criminalrecordProperty(){
        return criminalrecord;
    }
}
    //crimes
     @FXML
    private TableView<LandingController.CrimesDetails> crimesTableView;

      @FXML
    private TableColumn<LandingController.CrimesDetails, String> OBno;

       @FXML
    private TableColumn<LandingController.CrimesDetails, String> crime;

        @FXML
    private TableColumn<LandingController.CrimesDetails, String> victim_name;

         @FXML
    private TableColumn<LandingController.CrimesDetails, String> victim_idno;

          @FXML
    private TableColumn<LandingController.CrimesDetails, String> victim_contacts;

           @FXML
    private TableColumn<LandingController.CrimesDetails, String> scene_of_crime;

            @FXML
    private TableColumn<LandingController.CrimesDetails, String> perpetrator_description;

             @FXML
    private TableColumn<LandingController.CrimesDetails, String> suspects;
             
             @FXML
    private TableColumn<LandingController.CrimesDetails, String> dates;


 //Initialize observable list to hold db data
    private ObservableList<LandingController.CrimesDetails>data1;

    @FXML
    Button viewAllCrimesBtn;
    @FXML
    private void viewAllCrimes(ActionEvent event){
        try {

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data1 = FXCollections.observableArrayList();
        
        //Execute query and store results in a resultset
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM crimes");
        while (rs.next()){
            //get Strings from the database, whichever order
            data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell1 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell1(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
     @FXML
    private TableView<LandingController.TerrorDetails> terrorDbTableView;

      @FXML
    private TableColumn<LandingController.TerrorDetails, String> terror_act;

       @FXML
    private TableColumn<LandingController.TerrorDetails, String> location;

        @FXML
    private TableColumn<LandingController.TerrorDetails, String> responsible_party;

         @FXML
    private TableColumn<LandingController.TerrorDetails, String> time_of_act;

          @FXML
    private TableColumn<LandingController.TerrorDetails, String> fatality;

           @FXML
    private TableColumn<LandingController.TerrorDetails, String> non_fatal;

            @FXML
    private TableColumn<LandingController.TerrorDetails, String> weapons_used;

             @FXML
    private TableColumn<LandingController.TerrorDetails, String> attack_type;

              @FXML
    private TableColumn<LandingController.TerrorDetails, String> damage;

    
    //Initialize observable list to hold db data
    private ObservableList<LandingController.TerrorDetails>data2;

    @FXML
    Button viewAllTerrorIntelBtn;
    @FXML
    private void viewAllTerrorIntel(ActionEvent event){
        try {

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data2 = FXCollections.observableArrayList();
        
        //Execute query and store results in a resultset
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM terror");
        while (rs.next()){
            //get Strings from the database, whichever order
            data2.add(new LandingController.TerrorDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        terror_act.setCellValueFactory(new PropertyValueFactory<>("terror_act"));
        location.setCellValueFactory(new PropertyValueFactory<>("location"));
        responsible_party.setCellValueFactory(new PropertyValueFactory<>("responsible_party"));
        time_of_act.setCellValueFactory(new PropertyValueFactory<>("time_of_act"));
        fatality.setCellValueFactory(new PropertyValueFactory<>("fatality"));
        non_fatal.setCellValueFactory(new PropertyValueFactory<>("non_fatal"));
        weapons_used.setCellValueFactory(new PropertyValueFactory<>("weapons_used"));
        attack_type.setCellValueFactory(new PropertyValueFactory<>("attack_type"));
        damage.setCellValueFactory(new PropertyValueFactory<>("damage"));
        /*terror_report.setCellValueFactory(new PropertyValueFactory<>("terror_report"));
        attach_1.setCellValueFactory(new PropertyValueFactory<>("attach_1"));*/
        
        terrorDbTableView.setItems(null);
        terrorDbTableView.setItems(data2);
}


     //Define the button cell
    private class ButtonCell2 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell2(final TableView terrorDbTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)terrorDbTableView.getItems().get(selectdIndex);
                terror_act.setCellValueFactory(new PropertyValueFactory<>("terror_act"));
                location.setCellValueFactory(new PropertyValueFactory<>("location"));
                responsible_party.setCellValueFactory(new PropertyValueFactory<>("responsible_party"));
                time_of_act.setCellValueFactory(new PropertyValueFactory<>("time_of_act"));
                fatality.setCellValueFactory(new PropertyValueFactory<>("fatality"));
                non_fatal.setCellValueFactory(new PropertyValueFactory<>("non_fatal"));
                weapons_used.setCellValueFactory(new PropertyValueFactory<>("weapons_used"));
                attack_type.setCellValueFactory(new PropertyValueFactory<>("attack_type"));
                damage.setCellValueFactory(new PropertyValueFactory<>("damage"));
                /*terror_report.setCellValueFactory(new PropertyValueFactory<>("terror_report"));
                attach_1.setCellValueFactory(new PropertyValueFactory<>("attach_1"));*/
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class TerrorDetails {
    private final StringProperty terror_act;
    private final StringProperty location;
    private final StringProperty responsible_party;
    private final StringProperty time_of_act;
    private final StringProperty fatality;
    private final StringProperty non_fatal;
    private final StringProperty weapons_used;
    private final StringProperty attack_type;
    private final StringProperty damage;
    /*private final StringProperty terror_report;
    private final StringProperty attach_1;*/
    
    //default constructor , String terror_report, String attach_1
    public TerrorDetails(String terror_act, String location, String responsible_party, String time_of_act, String fatality, String non_fatal, String weapons_used, String attack_type, String damage){
        this.terror_act = new SimpleStringProperty(terror_act);
        this.location = new SimpleStringProperty(location);
        this.responsible_party = new SimpleStringProperty(responsible_party);
        this.time_of_act = new SimpleStringProperty(time_of_act);
        this.fatality = new SimpleStringProperty(fatality);
        this.non_fatal = new SimpleStringProperty(non_fatal);
        this.weapons_used = new SimpleStringProperty(weapons_used);
        this.attack_type = new SimpleStringProperty(attack_type);
        this.damage = new SimpleStringProperty(damage);
        /*this.terror_report = new SimpleStringProperty(terror_report);
        this.attach_1 = new SimpleStringProperty(attach_1);//, rs.getString(11), rs.getString(12)*/
    }
    
    //gets
    public String getTerror_act(){
        return terror_act.get();
    }
    public String getLocation(){
        return location.get();
    }
    public String getResponsible_party(){
        return responsible_party.get();
    }
    public String getTime_of_act(){
        return time_of_act.get();
    }
    public String getFatality(){
        return fatality.get();
    }
    public String getNon_fatal(){
        return non_fatal.get();
    }
    public String getWeapons_used(){
        return weapons_used.get();
    }
    public String getAttack_type(){
        return attack_type.get();
    }
    public String getDamage(){
        return damage.get();
    }
    /*public String getTerror_report(){
        return terror_report.get();
    }
    public String getAttach_1(){
        return attach_1.get();
    }*/
    
    //sets
    public void setTerror_act(String value){
        terror_act.set(value);
    }
    public void setLocation(String value){
        location.set(value);
    }
    public void setesponsible_party(String value){
        responsible_party.set(value);
    }
    public void setTime_of_act(String value){
        time_of_act.set(value);
    }
    public void setFatality(String value){
        fatality.set(value);
    }
    public void setNon_fatal(String value){
        non_fatal.set(value);
    }
    public void setWeapons_used(String value){
        weapons_used.set(value);
    }
    public void setAttack_type(String value){
        attack_type.set(value);
    }
    public void setDamage(String value){
        damage.set(value);
    }
    /*public void setTerror_report(String value){
        terror_report.set(value);
    }
    public void setAttach_1(String value){
        attach_1.set(value);
    }*/
    
    //Property values
    public StringProperty terror_actProperty(){
        return terror_act;
    }
    public StringProperty locationProperty(){
        return location;
    }
    public StringProperty responsible_partyProperty(){
        return responsible_party;
    }
    public StringProperty time_of_actProperty(){
        return time_of_act;
    }
    public StringProperty fatalityProperty(){
        return fatality;
    }
    public StringProperty non_fatalProperty(){
        return non_fatal;
    }
    public StringProperty weapons_usedProperty(){
        return weapons_used;
    }
    public StringProperty attack_typeProperty(){
        return attack_type;
    }
    public StringProperty damageProperty(){
        return damage;
    }
    /*public StringProperty terror_reportProperty(){
        return terror_report;
    }
    public StringProperty attach_1Property(){
        return attach_1;
    }*/
    }
     @FXML
    private TableView<LandingController.AutomobileDetails> automobilesTableView;

      @FXML
    private TableColumn<LandingController.AutomobileDetails, String> plate_no;

       @FXML
    private TableColumn<LandingController.AutomobileDetails, String> type_of_auto;

        @FXML
    private TableColumn<LandingController.AutomobileDetails, String> model;

         @FXML
    private TableColumn<LandingController.AutomobileDetails, String> colour;

          @FXML
    private TableColumn<LandingController.AutomobileDetails, String> registered_to;

           @FXML
    private TableColumn<LandingController.AutomobileDetails, String> imported_by;

            @FXML
    private TableColumn<LandingController.AutomobileDetails, String> imported_from;

             @FXML
    private TableColumn<LandingController.AutomobileDetails, String> insured_by;

              @FXML
    private TableColumn<LandingController.AutomobileDetails, String> registration_time;

               @FXML
    private TableColumn<LandingController.AutomobileDetails, String> accidents_involved_in;

                @FXML
    private TableColumn<LandingController.AutomobileDetails, String> crimes_involved_in;

        //Initialize observable list to hold db data
    private ObservableList<LandingController.AutomobileDetails>data3;

    @FXML
    Button viewAllAutomobilesBtn;
    @FXML
    private void viewAllAutomobiles(ActionEvent event){
        try {

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data3 = FXCollections.observableArrayList();
        
        //Execute query and store results in a resultset
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM automobiles");
        while (rs.next()){
            //get Strings from the database, whichever order
            data3.add(new LandingController.AutomobileDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        plate_no.setCellValueFactory(new PropertyValueFactory<>("plate_no"));
        type_of_auto.setCellValueFactory(new PropertyValueFactory<>("type_of_auto"));
        model.setCellValueFactory(new PropertyValueFactory<>("model"));
        colour.setCellValueFactory(new PropertyValueFactory<>("colour"));
        registered_to.setCellValueFactory(new PropertyValueFactory<>("registered_to"));
        imported_by.setCellValueFactory(new PropertyValueFactory<>("imported_by"));
        imported_from.setCellValueFactory(new PropertyValueFactory<>("imported_from"));
        insured_by.setCellValueFactory(new PropertyValueFactory<>("insured_by"));
        registration_time.setCellValueFactory(new PropertyValueFactory<>("registration_time"));
        accidents_involved_in.setCellValueFactory(new PropertyValueFactory<>("accidents_involved_in"));
        crimes_involved_in.setCellValueFactory(new PropertyValueFactory<>("crimes_involved_in"));
        
        automobilesTableView.setItems(null);
        automobilesTableView.setItems(data3);
}


     //Define the button cell
    private class ButtonCell3 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell3(final TableView automobilesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)automobilesTableView.getItems().get(selectdIndex);
                plate_no.setCellValueFactory(new PropertyValueFactory<>("plate_no"));
                type_of_auto.setCellValueFactory(new PropertyValueFactory<>("type_of_auto"));
                model.setCellValueFactory(new PropertyValueFactory<>("model"));
                colour.setCellValueFactory(new PropertyValueFactory<>("colour"));
                registered_to.setCellValueFactory(new PropertyValueFactory<>("registered_to"));
                imported_by.setCellValueFactory(new PropertyValueFactory<>("imported_by"));
                imported_from.setCellValueFactory(new PropertyValueFactory<>("imported_from"));
                insured_by.setCellValueFactory(new PropertyValueFactory<>("insured_by"));
                registration_time.setCellValueFactory(new PropertyValueFactory<>("registration_time"));
                accidents_involved_in.setCellValueFactory(new PropertyValueFactory<>("accidents_involved_in"));
                crimes_involved_in.setCellValueFactory(new PropertyValueFactory<>("crimes_involved_in"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class AutomobileDetails {
    private final StringProperty plate_no;
    private final StringProperty type_of_auto;
    private final StringProperty model;
    private final StringProperty colour;
    private final StringProperty registered_to;
    private final StringProperty imported_by;
    private final StringProperty imported_from;
    private final StringProperty insured_by;
    private final StringProperty registration_time;
    private final StringProperty accidents_involved_in;
    private final StringProperty crimes_involved_in;
    
    //default constructor , 
    public AutomobileDetails(String plate_no, String type_of_auto, String model, String colour, String registered_to, String imported_by, String imported_from, String insured_by, String registration_time, String accidents_involved_in, String crimes_involved_in){
        this.plate_no = new SimpleStringProperty(plate_no);
        this.type_of_auto = new SimpleStringProperty(type_of_auto);
        this.model = new SimpleStringProperty(model);
        this.colour = new SimpleStringProperty(colour);
        this.registered_to = new SimpleStringProperty(registered_to);
        this.imported_by = new SimpleStringProperty(imported_by);
        this.imported_from = new SimpleStringProperty(imported_from);
        this.insured_by = new SimpleStringProperty(insured_by);
        this.registration_time = new SimpleStringProperty(registration_time);
        this.accidents_involved_in = new SimpleStringProperty(accidents_involved_in);
        this.crimes_involved_in = new SimpleStringProperty(crimes_involved_in);
    }
    
    //gets
    public String getTerror_act(){
        return plate_no.get();
    }
    public String getLocation(){
        return type_of_auto.get();
    }
    public String getResponsible_party(){
        return model.get();
    }
    public String getTime_of_act(){
        return colour.get();
    }
    public String getFatality(){
        return registered_to.get();
    }
    public String getNon_fatal(){
        return imported_by.get();
    }
    public String getWeapons_used(){
        return imported_from.get();
    }
    public String getAttack_type(){
        return insured_by.get();
    }
    public String getDamage(){
        return registration_time.get();
    }
    public String getTerror_report(){
        return accidents_involved_in.get();
    }
    public String getAttach_1(){
        return crimes_involved_in.get();
    }
    
    //sets
    public void setDamage(String value){
        plate_no.set(value);
    }
    public void setTerror_act(String value){
        type_of_auto.set(value);
    }
    public void setLocation(String value){
        model.set(value);
    }
    public void setesponsible_party(String value){
        colour.set(value);
    }
    public void setTime_of_act(String value){
        registered_to.set(value);
    }
    public void setFatality(String value){
        imported_by.set(value);
    }
    public void setNon_fatal(String value){
        imported_from.set(value);
    }
    public void setWeapons_used(String value){
        insured_by.set(value);
    }
    public void setAttack_type(String value){
        registration_time.set(value);
    }
    public void setTerror_report(String value){
        accidents_involved_in.set(value);
    }
    public void setAttach_1(String value){
        crimes_involved_in.set(value);
    }
    
    //Property values
    public StringProperty plate_noProperty(){
        return plate_no;
    }
    public StringProperty type_of_autoProperty(){
        return type_of_auto;
    }
    public StringProperty modelProperty(){
        return model;
    }
    public StringProperty colourProperty(){
        return colour;
    }
    public StringProperty registered_toProperty(){
        return registered_to;
    }
    public StringProperty imported_byProperty(){
        return imported_by;
    }
    public StringProperty imported_fromProperty(){
        return imported_from;
    }
    public StringProperty insured_byProperty(){
        return insured_by;
    }
    public StringProperty registration_timeProperty(){
        return registration_time;
    }
    public StringProperty accidents_involved_inProperty(){
        return accidents_involved_in;
    }
    public StringProperty crimes_involved_inProperty(){
        return crimes_involved_in;
    }
    }

     @FXML
    private TableView<LandingController.AccidentDetails> accidentsTableView;

      @FXML
    private TableColumn<LandingController.AccidentDetails, String> id;

       @FXML
    private TableColumn<LandingController.AccidentDetails, String> time;

        @FXML
    private TableColumn<LandingController.AccidentDetails, String> base;

         @FXML
    private TableColumn<LandingController.AccidentDetails, String> county;

          @FXML
    private TableColumn<LandingController.AccidentDetails, String> road;

           @FXML
    private TableColumn<LandingController.AccidentDetails, String> place;

            @FXML
    private TableColumn<LandingController.AccidentDetails, String> mv_involved;

             @FXML
    private TableColumn<LandingController.AccidentDetails, String> accident_details;

              @FXML
    private TableColumn<LandingController.AccidentDetails, String> victimname;
   
               @FXML
    private TableColumn<LandingController.AccidentDetails, String> gender;

                @FXML
    private TableColumn<LandingController.AccidentDetails, String> age;

                 @FXML
    private TableColumn<LandingController.AccidentDetails, String> cause_code;

                  @FXML
    private TableColumn<LandingController.AccidentDetails, String> victim;

                   @FXML
    private TableColumn<LandingController.AccidentDetails, String> number;

    
    //Initialize observable list to hold db data
    private ObservableList<LandingController.AccidentDetails>data4;
    
    @FXML
    Button viewAllAccidentsBtn;
    
    @FXML
        void viewAllAccidents(ActionEvent event) {
        try {

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data4 = FXCollections.observableArrayList();
        
        //Execute query and store results in a resultset
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM accidents");
        while (rs.next()){
            //get Strings from the database, whichever order
            data4.add(new LandingController.AccidentDetails(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14)));
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        base.setCellValueFactory(new PropertyValueFactory<>("base"));
        county.setCellValueFactory(new PropertyValueFactory<>("county"));
        road.setCellValueFactory(new PropertyValueFactory<>("road"));
        place.setCellValueFactory(new PropertyValueFactory<>("place"));
        mv_involved.setCellValueFactory(new PropertyValueFactory<>("mv_involved"));
        accident_details.setCellValueFactory(new PropertyValueFactory<>("accident_details"));
        victimname.setCellValueFactory(new PropertyValueFactory<>("victimname"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        cause_code.setCellValueFactory(new PropertyValueFactory<>("cause_code"));
        victim.setCellValueFactory(new PropertyValueFactory<>("victim"));
        number.setCellValueFactory(new PropertyValueFactory<>("number"));
        
        accidentsTableView.setItems(null);
        accidentsTableView.setItems(data4);
}


     //Define the button cell
    private class ButtonCell4 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell4(final TableView accidentsTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)accidentsTableView.getItems().get(selectdIndex);
                id.setCellValueFactory(new PropertyValueFactory<>("id"));
                time.setCellValueFactory(new PropertyValueFactory<>("time"));
                base.setCellValueFactory(new PropertyValueFactory<>("base"));
                county.setCellValueFactory(new PropertyValueFactory<>("county"));
                road.setCellValueFactory(new PropertyValueFactory<>("road"));
                place.setCellValueFactory(new PropertyValueFactory<>("place"));
                mv_involved.setCellValueFactory(new PropertyValueFactory<>("mv_involved"));
                accident_details.setCellValueFactory(new PropertyValueFactory<>("accident_details"));
                victimname.setCellValueFactory(new PropertyValueFactory<>("victimname"));
                gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
                age.setCellValueFactory(new PropertyValueFactory<>("age"));
                cause_code.setCellValueFactory(new PropertyValueFactory<>("cause_code"));
                victim.setCellValueFactory(new PropertyValueFactory<>("victim"));
                number.setCellValueFactory(new PropertyValueFactory<>("number"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    
        void searchAutoAccident(ActionEvent event) {

    }
    void clearAutoAccidentnumber(ActionEvent event) {

    }
    public class AccidentDetails {
    private final StringProperty id;
    private final StringProperty time;
    private final StringProperty base;
    private final StringProperty county;
    private final StringProperty road;
    private final StringProperty place;
    private final StringProperty mv_involved;
    private final StringProperty accident_details;
    private final StringProperty gender;
    private final StringProperty victimname;
    private final StringProperty age;
    private final StringProperty cause_code;
    private final StringProperty victim;
    private final StringProperty number;
    //private final StringProperty actionBtn;
    
    //default constructor
    public AccidentDetails(String id, String time, String base, String county, String road, String place, String mv_involved, String accident_details, String victimname, String gender, String age, String cause_code, String victim, String number){
        this.id = new SimpleStringProperty(id);
        this.time = new SimpleStringProperty(time);
        this.base = new SimpleStringProperty(base);
        this.county = new SimpleStringProperty(county);
        this.road = new SimpleStringProperty(road);
        this.place = new SimpleStringProperty(place);
        this.mv_involved = new SimpleStringProperty(mv_involved);
        this.accident_details = new SimpleStringProperty(accident_details);
        this.victimname = new SimpleStringProperty(victimname);
        this.gender = new SimpleStringProperty(gender);
        this.age = new SimpleStringProperty(age);
        this.cause_code = new SimpleStringProperty(cause_code);
        this.victim = new SimpleStringProperty(victim);
        this.number = new SimpleStringProperty(number);
        //this.actionBtn = new SimpleStringProperty(actionBtn);
    }
    
    //gets
    public String getFirstname(){
        return id.get();
    }
    public String getMiddlename(){
        return time.get();
    }
    public String getSurname(){
        return base.get();
    }
    public String getIdno(){
        return county.get();
    }
    public String getWorkplace(){
        return road.get();
    }
    public String getHomeplace(){
        return place.get();
    }
    public String getCriminalrecord(){
        return mv_involved.get();
    }
    public String getAccident_details(){
        return accident_details.get();
    }
    public String getVictimname(){
        return victimname.get();
    }
    public String getGender(){
        return gender.get();
    }
    public String getAge(){
        return age.get();
    }
    public String getCause_code(){
        return cause_code.get();
    }
    public String getVictim(){
        return victim.get();
    }
    public String getNumber(){
        return number.get();
    }
    
    //sets
    public void setFirstname(String value){
        id.set(value);
    }
    public void setMiddlename(String value){
        time.set(value);
    }
    public void setSurname(String value){
        base.set(value);
    }
    public void setIdno(String value){
        county.set(value);
    }
    public void setRoad(String value){
        road.set(value);
    }
    public void setHomeplace(String value){
        place.set(value);
    }
    public void setCriminalrecord(String value){
        mv_involved.set(value);
    }
    public void setAccident_details(String value){
        accident_details.set(value);
    }
    public void setVictimname(String value){
        victimname.set(value);
    }
    public void setGender(String value){
        gender.set(value);
    }
    public void setAge(String value){
        age.set(value);
    }
    public void setCause_code(String value){
        cause_code.set(value);
    }
    public void setVictim(String value){
        victim.set(value);
    }
    public void setNumber(String value){
        number.set(value);
    }
    
    //Property values
    public StringProperty idProperty(){
        return id;
    }
    public StringProperty timeProperty(){
        return time;
    }
    public StringProperty baseProperty(){
        return base;
    }
    public StringProperty countyProperty(){
        return county;
    }
    public StringProperty roadProperty(){
        return road;
    }
    public StringProperty placeProperty(){
        return place;
    }
    public StringProperty mv_involvedProperty(){
        return mv_involved;
    }
    public StringProperty accident_detailsProperty(){
        return accident_details;
    }
    public StringProperty victimnameProperty(){
        return victimname;
    }
    public StringProperty genderProperty(){
        return gender;
    }
    public StringProperty ageProperty(){
        return age;
    }
    public StringProperty cause_codeProperty(){
        return cause_code;
    }
    public StringProperty victimProperty(){
        return victim;
    }
    public StringProperty numberProperty(){
        return number;
    }
    }
    @FXML
    Button ClearPersonBtn;
    
    @FXML
    void ClearPerson(ActionEvent event){
        targetNameField.clear();
    }
    
    @FXML
    Button clearOBFieldBtn;
    
    @FXML
    void clearOBField(ActionEvent event){
        crimeOBNumberField.clear();
    }
    
    //Crimes categories 
    //MenuItems
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
    
    //Crimes categories
    //methods
     @FXML
    void showCat_homicide(ActionEvent event) throws SQLException {
       
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Homicide");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell11 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell11(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails11 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails11(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }              
    
    @FXML
    void showCat_physicalAssault(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Physical Assault");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell22 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell22(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails22 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails22(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
    

    @FXML
    void showCat_robbery(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Robbery");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell33 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell33(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails33 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails33(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
    

    @FXML
    void showcat_Fraud(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Fraud");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell44 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell44(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails44 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails44(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
    

    @FXML
    void showcat_IdentityTheft(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Identity Theft");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
          data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
          String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell55 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell55(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails55 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails55(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
    

    @FXML
    void showcat_Kidnapping(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Kidnapping");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell66 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell66(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails66 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails66(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
    

    @FXML
    void showcat_Suicide(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Suicide");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell77 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell77(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails77 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails77(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_Terrorism(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Terrorism");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell88 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell88(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails88 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails88(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_carJacking(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Carjacking");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell99 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell99(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails99 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails99(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_corruptionAndBribery(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Corruption And Bribery");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
          data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
          String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell10 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell10(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails10 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails10(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_drugDriving(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Drug Driving");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell12 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell12(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails12 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails12(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_ethnicViolence(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Ethnic Violence");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell13 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell13(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails13 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails13(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_illegalDrugAbuse(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Illegal Drug Abuse");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell14 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell14(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails14 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails14(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_overspeeding(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Overspeeding");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell15 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell15(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails15 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails15(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_propertyDamage(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Property Damage");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell16 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell16(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails16 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails16(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_theftAndBanditry(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Theft and Banditry");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell17 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell17(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails17 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails17(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }

    @FXML
    void showcat_trespass(ActionEvent event) throws SQLException {
        
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        data1 = FXCollections.observableArrayList();
        String sql = "SELECT * FROM crimes WHERE crime=?";
        PreparedStatement pst = conn.prepareStatement(sql) ;
             pst.setString(1, "Trespassing");
             crime.setText("CRIME");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
           data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
           String Crime = rs.getString(2); 
                                }
    }
      catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
        //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell18 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell18(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails18 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails18(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
    
    @FXML
    Button searchCrimeByOBNoBtn;
    
    @FXML
    void searchCrimeByOBNo(ActionEvent e) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data1 = FXCollections.observableArrayList();
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM crimes WHERE OBno=?") ;
             pst.setString(1, crimeOBNumberField.getText());
             idno.setText("OB NUMBER");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
                                  data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
                                  String Crime = rs.getString(2);   
                   
            
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
                    //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell19 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell19(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails19 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails19(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setdatess(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
    
    @FXML
    Button searchCrimeByDateBtn;
    
    @FXML
    void searchCrimeByDate(ActionEvent e) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data1 = FXCollections.observableArrayList();
        
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM crimes WHERE date=?") ;
             pst.setString(1, crimeOBNumberField.getText());
             dates.setText("DATE");
                    try (java.sql.ResultSet rs = pst.executeQuery()) {
 
                                while(rs.next()){
                                  data1.add(new LandingController.CrimesDetails(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(12), rs.getString(14), rs.getString(19)));
                                  String OB_no = rs.getString(2);   
                   
            
        }
    } catch (SQLException err){
        Alert alert;
        alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Failed to pull data!");
                            alert.setHeaderText("Try Again!");
                            alert.setContentText("Database didn't give out any data. Please try again..." +err);
                            alert.showAndWait();
    }
                    //set cell value factory to tableView
        //propertyvalue == Factory
        OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
        crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
        victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
        victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
        victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
        scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
        perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
        suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
        dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
        
        crimesTableView.setItems(null);
        crimesTableView.setItems(data1);
}


     //Define the button cell
    private class ButtonCell20 extends TableCell<Disposer.Record, Boolean> {
        final Button cellButton = new Button("Action");
         
        ButtonCell20(final TableView crimesTableView){
             
            cellButton.setOnAction((ActionEvent t) -> {
                int selectdIndex = getTableRow().getIndex();
                
                //Create a new table show details of the selected item
                TableView selectedRecord = (TableView)crimesTableView.getItems().get(selectdIndex);
                OBno.setCellValueFactory(new PropertyValueFactory<>("OBno"));
                crime.setCellValueFactory(new PropertyValueFactory<>("crime"));
                victim_name.setCellValueFactory(new PropertyValueFactory<>("victim_name"));
                victim_idno.setCellValueFactory(new PropertyValueFactory<>("victim_idno"));
                victim_contacts.setCellValueFactory(new PropertyValueFactory<>("victim_contacts"));
                scene_of_crime.setCellValueFactory(new PropertyValueFactory<>("scene_of_crime"));
                perpetrator_description.setCellValueFactory(new PropertyValueFactory<>("perpetrator_description"));
                suspects.setCellValueFactory(new PropertyValueFactory<>("suspects"));
                dates.setCellValueFactory(new PropertyValueFactory<>("dates"));
                
                Alert alert;
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Pulled data!");
                alert.setHeaderText("Try Again!");
                alert.setContentText("Data" +selectdIndex);
                alert.showAndWait();
            });
        }
    }
    public class CrimesDetails20 {
    private final StringProperty OBno;
    private final StringProperty crime;
    private final StringProperty victim_name;
    private final StringProperty victim_idno;
    private final StringProperty victim_contacts;
    private final StringProperty scene_of_crime;
    private final StringProperty perpetrator_description;
    private final StringProperty suspects;
    private final StringProperty dates;
    
    //default constructor
    public CrimesDetails20(String OBno, String crime, String victim_name, String victim_idno, String victim_contacts, String scene_of_crime, String perpetrator_description, String suspects, String dates){
        this.OBno = new SimpleStringProperty(OBno);
        this.crime = new SimpleStringProperty(crime);
        this.victim_name = new SimpleStringProperty(victim_name);
        this.victim_idno = new SimpleStringProperty(victim_idno);
        this.victim_contacts = new SimpleStringProperty(victim_contacts);
        this.scene_of_crime = new SimpleStringProperty(scene_of_crime);
        this.perpetrator_description = new SimpleStringProperty(perpetrator_description);
        this.suspects = new SimpleStringProperty(suspects);
        this.dates = new SimpleStringProperty(dates);
    }
    
    //gets
    public String getOBno(){
        return OBno.get();
    }
    public String getCrime(){
        return crime.get();
    }
    public String getVictim_name(){
        return victim_name.get();
    }
    public String getVictim_idno(){
        return victim_idno.get();
    }
    public String getVictim_contacts(){
        return victim_contacts.get();
    }
    public String getScene_of_crime(){
        return scene_of_crime.get();
    }
    public String getPerpetrator_description(){
        return perpetrator_description.get();
    }
    public String getSuspects(){
        return suspects.get();
    }
    public String getDates(){
        return dates.get();
    }
    
    //sets
    public void setOBno(String value){
        OBno.set(value);
    }
    public void setCrime(String value){
        crime.set(value);
    }
    public void setVictim_name(String value){
        victim_name.set(value);
    }
    public void setVictim_idno(String value){
        victim_idno.set(value);
    }
    public void setVictim_contacts(String value){
        victim_contacts.set(value);
    }
    public void setScene_of_crime(String value){
        scene_of_crime.set(value);
    }
    public void setPerpetrator_description(String value){
        perpetrator_description.set(value);
    }
    public void setSuspects(String value){
        suspects.set(value);
    }
    public void setDates(String value){
        dates.set(value);
    }
    
    //Property values
    public StringProperty OBnoProperty(){
        return OBno;
    }
    public StringProperty crimeProperty(){
        return crime;
    }
    public StringProperty victim_nameProperty(){
        return victim_name;
    }
    public StringProperty victim_idnoProperty(){
        return victim_idno;
    }
    public StringProperty victim_contactsProperty(){
        return victim_contacts;
    }
    public StringProperty scene_of_crimeProperty(){
        return scene_of_crime;
    }
    public StringProperty perpetrator_descriptionProperty(){
        return perpetrator_description;
    }
    public StringProperty suspectsProperty(){
        return suspects;
    }
    public StringProperty datesProperty(){
        return dates;
    }
    }
}