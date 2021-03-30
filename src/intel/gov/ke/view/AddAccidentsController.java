package intel.gov.ke.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddAccidentsController
  implements Initializable
{
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
  void aboutIntelbase(MouseEvent event) {}
  
  @FXML
  void back(ActionEvent event)
    throws IOException
  {}
  
  @FXML
  void copyrightStatementInfo(ActionEvent event) {}
  
  @FXML
  void exit(ActionEvent event)
  {
    ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
  }
  
  @FXML
  void logOut(ActionEvent event)
    throws IOException
  {}
  
  @FXML
  void minimizeStage(ActionEvent event)
  {
    ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
  }
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {}
}
