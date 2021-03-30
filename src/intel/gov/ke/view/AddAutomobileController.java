/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intel.gov.ke.view;

import intel.gov.ke.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class AddAutomobileController implements Initializable {
    
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
