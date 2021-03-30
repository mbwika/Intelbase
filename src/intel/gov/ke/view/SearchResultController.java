package intel.gov.ke.view;

import com.sun.prism.impl.Disposer.Record;
import intel.gov.ke.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBoxBuilder;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class SearchResultController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dc = new Main();
    } 

    
    @FXML
    void goBack() throws IOException{
        Main.showLanding();
    }
    



    
    @FXML
    void logOut() throws IOException{
        Main.showLogin();
    }
        @FXML
    private TableView<TargetDetails> targetsTable;

    @FXML
    private TableColumn<TargetDetails, String> firstname;

    @FXML
    private TableColumn<TargetDetails, String> middlename;

    @FXML
    private TableColumn<TargetDetails, String> surname;

    @FXML
    private TableColumn<TargetDetails, String> idno;

    @FXML
    private TableColumn<TargetDetails, String> workplace;

    @FXML
    private TableColumn<TargetDetails, String> homeplace;

    @FXML
    private TableColumn<TargetDetails, String> criminal_record;
    


    @FXML
    private Button backBtn;

    @FXML
    private Button homeBtn;
    
        @FXML
    private Button minimizeStageBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private Button addTargetBtn;

    @FXML
    private TextField targetName;
        //Initialize observable list to hold db data
    private ObservableList<TargetDetails>data;
    private Main dc;

    @FXML
    private void addTarget(ActionEvent event){
        try {

                try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
        
        data = FXCollections.observableArrayList();
        
        //Execute query and store results in a resultset
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM targets");
        while (rs.next()){
            //get Strings from the database, whichever order
            data.add(new TargetDetails(rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(2), rs.getString(9), rs.getString(25), rs.getString(23)));
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
    private class ButtonCell extends TableCell<Record, Boolean> {
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
        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
    }


    @FXML
    void exit(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
    }
    
        @FXML
    void minimizeStage(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Main.showLanding();
    }

    @FXML
    void logOut(ActionEvent event) throws IOException {
        Main.showLogin();
    }

/**
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
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

    
}
