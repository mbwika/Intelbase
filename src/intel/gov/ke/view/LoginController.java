package intel.gov.ke.view;

import intel.gov.ke.Main;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController
  implements Initializable
{
  @FXML
  TextField usernameTxt;
  @FXML
  PasswordField passcodeTxt;
  @FXML
  Alert alert;
  @FXML
  Button LoginBtn;
  @FXML
  Button clearFieldsBtn;
  @FXML
  Button minimizeBtn;
  @FXML
  Button ExitBtn;
  @FXML
  Button fbPageOpenBtn;
  @FXML
  Button instagramOpenBtn;
  @FXML
  Button twitterOpenBtn;
  @FXML
  Button gplusOpenBtn;
  @FXML
  Button linkedinOpenBtn;
  @FXML
  Button youtubeOpenBtn;
  @FXML
  Button rssOpenBtn;
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {}
  
  @FXML
  public void goSignIn()
    throws IOException, ClassNotFoundException, SQLException
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
    }
    catch (ClassNotFoundException ex)
    {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inteldb", "root", "6337");
    
    PreparedStatement pst = conn.prepareStatement("select * from admins where username=? and passcode=?");
    pst.setString(1, this.usernameTxt.getText());
    pst.setString(2, this.passcodeTxt.getText());
    ResultSet rs = pst.executeQuery();Throwable localThrowable3 = null;
    try
    {
      if (rs.next())
      {
        Main.showLanding();
      }
      else
      {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.alert.setTitle("Login Unsuccessful!");
        this.alert.setHeaderText("Try Again!");
        this.alert.setContentText("Login credentials didn't check out. Please try again...");
        this.alert.showAndWait();
      }
      pst.close();
    }
    catch (IOException | SQLException localThrowable1)
    {
      localThrowable3 = localThrowable1;throw localThrowable1;
    }
    finally
    {
      if (rs != null) {
        if (localThrowable3 != null) {
          try
          {
            rs.close();
          }
          catch (SQLException localThrowable2)
          {
            localThrowable3.addSuppressed(localThrowable2);
          }
        } else {
          rs.close();
        }
      }
    }
  }
  
  @FXML
  void clearFields(ActionEvent event)
  {
    this.usernameTxt.clear();
    this.passcodeTxt.clear();
  }
  
  @FXML
  void minimizeApplication(ActionEvent event)
  {
    ((Stage)((Button)event.getSource()).getScene().getWindow()).setIconified(true);
  }
  
  @FXML
  public void exitApplication(ActionEvent event)
  {
    ((Stage)((Button)event.getSource()).getScene().getWindow()).close();
  }
  
  @FXML
  void fbPageOpen(ActionEvent event)
    throws IOException
  {}
  
  @FXML
  void gplusOpen(ActionEvent event)
    throws IOException
  {}
  
  @FXML
  void instagramOpen(ActionEvent event)
    throws IOException
  {}
  
  @FXML
  void linkedinOpen(ActionEvent event)
    throws IOException
  {}
  
  @FXML
  void rssOpen(ActionEvent event)
    throws IOException
  {}
  
  @FXML
  void twitterOpen(ActionEvent event)
    throws IOException
  {}
  
  @FXML
  void youtubeOpen(ActionEvent event)
    throws IOException
  {}
}
