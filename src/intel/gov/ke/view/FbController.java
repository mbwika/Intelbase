package intel.gov.ke.view;

import intel.gov.ke.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Collins Mbwika <androidapps.collinsmbwika.me>
 */
public class FbController implements Initializable {

    @FXML
    Button showFBBtn;
    
    private static BorderPane fbLayout;
    
    @FXML
    void showFB(ActionEvent event) {
        Stage FBStage = new Stage();
        Parent root = fbLayout;
        Scene scene = new Scene(root, 610, 450);
        WebView fbWebView = new WebView();
        WebEngine fbEngine = fbWebView.getEngine();
        fbEngine.load("https://www.google.co.ke");
        
        
        FBStage.setScene(scene);
        FBStage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }  

    @FXML
    void minimizeStage(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
    }

    @FXML
    void exitApplication(ActionEvent event) {
        ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
    }

}
    

