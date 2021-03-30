package intel.gov.ke;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Collins Mbwika <collinsmbwika.me>
 */

public class Main extends Application {
    
    private static BorderPane primaryLayout, fbLayout, mainLayout, youtubeLayout, googleLayout, linkedinLayout, gplusLayout, igLayout, twitterLayout;
    private static Stage primaryStage, FBStage, mainStage, GoogleStage, YoutubeStage, LinkedinStage, GplusStage, IgStage, TwitterStage;
    
    @Override
    public void start(Stage stage) {
        Parent loaderRoot = null;
        try {
            loaderRoot = FXMLLoader.load(getClass().getResource("view/home.fxml"));
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scene loadScene = new Scene(loaderRoot);
        stage.setScene(loadScene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));

        stage.show();


        primaryStage = new Stage(StageStyle.TRANSPARENT);
        primaryStage.setTitle("INTELLIGENCE SYSTEM");
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setStage(primaryStage);
        
        mainStage = new Stage(StageStyle.TRANSPARENT);
        mainStage.setTitle("INTELLIGENCE SYSTEM");
        mainStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setMainStage(mainStage);

        GoogleStage = new Stage(StageStyle.DECORATED);
        GoogleStage.setTitle("INTELLIGENCE SYSTEM : GOOGLE");
        GoogleStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setGoogleStage(GoogleStage);
        
        YoutubeStage = new Stage(StageStyle.DECORATED);
        YoutubeStage.setTitle("INTELLIGENCE SYSTEM : YOUTUBE");
        YoutubeStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setYoutubeStage(YoutubeStage);
        
        LinkedinStage = new Stage(StageStyle.DECORATED);
        LinkedinStage.setTitle("INTELLIGENCE SYSTEM : LinkedIn");
        LinkedinStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setLinkedinStage(LinkedinStage);
        
        GplusStage = new Stage(StageStyle.DECORATED);
        GplusStage.setTitle("INTELLIGENCE SYSTEM : G-PLUS");
        GplusStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setGplusStage(GplusStage);
        
        IgStage = new Stage(StageStyle.DECORATED);
        IgStage.setTitle("INTELLIGENCE SYSTEM : INSTAGRAM");
        IgStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setIgStage(IgStage);
        
        TwitterStage = new Stage(StageStyle.DECORATED);
        TwitterStage.setTitle("INTELLIGENCE SYSTEM : TWITTER");
        TwitterStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setTwitterStage(TwitterStage);
        
        FBStage = new Stage(StageStyle.DECORATED);
        FBStage.setTitle("INTELLIGENCE SYSTEM : FACEBOOK");
        FBStage.getIcons().add(new Image(this.getClass().getResourceAsStream("images/logo.png")));
        setFBStage(FBStage);

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                Platform.runLater(() -> {
                try {
                    Thread.sleep(1000);
                    try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/login.fxml"));
                    primaryLayout = loader.load();
                    Parent root = primaryLayout;

                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    stage.hide();
                    
                    //when screen is dragged, translate it accordingly
                primaryLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        primaryStage.setX(me.getScreenX() - initX);
                        primaryStage.setY(me.getScreenY() - initY);
                    }
                });
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            });
        }   catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }).start();
            
    }
    public static Stage getFBStage() {
        return FBStage;
    }

    public static void setFBStage(Stage stage) {
        FBStage = stage;
    }
    public static Stage getTwitterStage() {
        return TwitterStage;
    }

    public static void setTwitterStage(Stage stage) {
        TwitterStage = stage;
    }
    public static Stage getIgStage() {
        return IgStage;
    }

    public static void setIgStage(Stage stage) {
        IgStage = stage;
    }
    public static Stage getGoogleStage() {
        return GoogleStage;
    }

    public static void setGoogleStage(Stage stage) {
        GoogleStage = stage;
    }
    public static Stage getYoutubeStage() {
        return YoutubeStage;
    }

    public static void setYoutubeStage(Stage stage) {
        YoutubeStage = stage;
    }
    public static Stage getGplusStage() {
        return GplusStage;
    }

    public static void setGplusStage(Stage stage) {
        GplusStage = stage;
    }
    public static Stage getLinkedinStage() {
        return LinkedinStage;
    }

    public static void setLinkedinStage(Stage stage) {
        LinkedinStage = stage;
    }
    
    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage stage) {
        mainStage = stage;
    }

    public static Stage getStage() {
        return primaryStage;
    }

    public static void setStage(Stage stage) {
        primaryStage = stage;
    }

        public static void setRoot() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/login.fxml"));
        primaryLayout = loader.load();
    }
        public static void fbPage() throws IOException{
            VBox root = new VBox();

            Scene scene = new Scene(root, 650, 500);
            
            WebView fbWebView = new WebView();
            WebEngine fbEngine = fbWebView.getEngine();
                    
                    FBStage.setScene(scene);
                    FBStage.show();
                    
                    fbEngine.load("https://www.facebook.com");
                    
                    
                    root.getChildren().addAll(fbWebView);
                    
                    //when screen is dragged, translate it accordingly
                fbLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        FBStage.setX(me.getScreenX() - initX);
                        FBStage.setY(me.getScreenY() - initY);
                    }
                });

        }
        
        public static void twitterPage() throws IOException{
            VBox root = new VBox();

            Scene scene = new Scene(root, 650, 500);
            
            WebView fbWebView = new WebView();
            WebEngine fbEngine = fbWebView.getEngine();
                    
                    TwitterStage.setScene(scene);                    
                    TwitterStage.show();
                    
                    fbEngine.load("https://www.twitter.com");
                    
                    
                    root.getChildren().addAll(fbWebView);
                    
                    //when screen is dragged, translate it accordingly
                    twitterLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        TwitterStage.setX(me.getScreenX() - initX);
                        TwitterStage.setY(me.getScreenY() - initY);
                    }
                });

        }
        
        public static void igPage() throws IOException{
            VBox root = new VBox();

            Scene scene = new Scene(root, 650, 500);
            
            WebView fbWebView = new WebView();
            WebEngine fbEngine = fbWebView.getEngine();
                    
                    IgStage.setScene(scene);
                    IgStage.show();
                    
                    fbEngine.load("https://www.instagram.com");
                    
                    
                    root.getChildren().addAll(fbWebView);
                    
                    //when screen is dragged, translate it accordingly
                igLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        IgStage.setX(me.getScreenX() - initX);
                        IgStage.setY(me.getScreenY() - initY);
                    }
                });

        }
        
        public static void gplusPage() throws IOException{
            VBox root = new VBox();

            Scene scene = new Scene(root, 650, 500);
            
            WebView fbWebView = new WebView();
            WebEngine fbEngine = fbWebView.getEngine();
                    
                    GplusStage.setScene(scene);
                    GplusStage.show();
                    
                    fbEngine.load("https://www.google.com/plus");
                    
                    
                    root.getChildren().addAll(fbWebView);
                    
                    //when screen is dragged, translate it accordingly
                gplusLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        GplusStage.setX(me.getScreenX() - initX);
                        GplusStage.setY(me.getScreenY() - initY);
                    }
                });

        }
        
        public static void linkedinPage() throws IOException{
            VBox root = new VBox();

            Scene scene = new Scene(root, 650, 500);
            
            WebView fbWebView = new WebView();
            WebEngine fbEngine = fbWebView.getEngine();
                    
                    LinkedinStage.setScene(scene);
                    LinkedinStage.show();
                    
                    fbEngine.load("https://www.linkedin.com");
                    
                    
                    root.getChildren().addAll(fbWebView);
                    
                    //when screen is dragged, translate it accordingly
                linkedinLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        LinkedinStage.setX(me.getScreenX() - initX);
                        LinkedinStage.setY(me.getScreenY() - initY);
                    }
                });

        }
        public static void youtubePage() throws IOException{
            VBox root = new VBox();

            Scene scene = new Scene(root, 650, 500);
            
            WebView fbWebView = new WebView();
            WebEngine fbEngine = fbWebView.getEngine();
                    
                    YoutubeStage.setScene(scene);
                    YoutubeStage.show();
                    
                    fbEngine.load("https://www.youtube.com");
                    
                    
                    root.getChildren().addAll(fbWebView);
                    
                    //when screen is dragged, translate it accordingly
                youtubeLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        YoutubeStage.setX(me.getScreenX() - initX);
                        YoutubeStage.setY(me.getScreenY() - initY);
                    }
                });

        }
        public static void googlePage() throws IOException{
            VBox root = new VBox();

            Scene scene = new Scene(root, 650, 500);
            
            WebView googleWebView = new WebView();
            WebEngine googleEngine = googleWebView.getEngine();
                    
                    GoogleStage.setScene(scene);
                    GoogleStage.show();
                    
                    googleEngine.load("https://www.google.co.ke");
                    
                    
                    root.getChildren().addAll(googleWebView);
                    
                    //when screen is dragged, translate it accordingly
                googleLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        GoogleStage.setX(me.getScreenX() - initX);
                        GoogleStage.setY(me.getScreenY() - initY);
                    }
                });

        }
    
    public static void showLogin() throws IOException{
                    try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/login.fxml"));
                    primaryLayout = loader.load();
                    Parent root = primaryLayout;

                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    mainStage.hide();
                    
                    //when screen is dragged, translate it accordingly
                primaryLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        primaryStage.setX(me.getScreenX() - initX);
                        primaryStage.setY(me.getScreenY() - initY);
                    }
                });
                    
                      
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }          
            
    }
    
    
        public static void showLanding() throws IOException{
        
         try {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(Main.class.getResource("view/landing.fxml"));
                    mainLayout = loader.load();
                    Parent root = mainLayout;

                    Scene scene = new Scene(root);
                    mainStage.setScene(scene);
                    mainStage.show();
                    primaryStage.hide();
                    //when mouse button is pressed, save the initial position of screen
                mainLayout.setOnMousePressed(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        initX = me.getScreenX() - mainStage.getX();
                        initY = me.getScreenY() - mainStage.getY();
                    }
                });
 
                //when screen is dragged, translate it accordingly
                mainLayout.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    private double initX;
                    private double initY;
                    @Override
                    public void handle(MouseEvent me) {
                        mainStage.setX(me.getScreenX() - initX);
                        mainStage.setY(me.getScreenY() - initY);
                    }
                });
                    

                        
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

        public static void addNewPrintTargetContainer() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("reports/targetReport.jrxml"));
        BorderPane addTarget = loader.load();
        mainLayout.setCenter(addTarget);
    }
        public static void addNewTargetContainer() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/addTarget.fxml"));
        BorderPane addTarget = loader.load();
        mainLayout.setCenter(addTarget);
    }
        public static void addNewCrimeContainer() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/addCrime.fxml"));
        BorderPane addTarget = loader.load();
        mainLayout.setCenter(addTarget);
    }
        public static void addNewAccidentsContainer() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/addAccident.fxml"));
        BorderPane addTarget = loader.load();
        mainLayout.setCenter(addTarget);
    }
        public static void addNewAutomobileContainer() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/addAutomobile.fxml"));
        BorderPane addTarget = loader.load();
        mainLayout.setCenter(addTarget);
    }
        public static void addNewMilitaryOpContainer() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/addMilitaryOp.fxml"));
        BorderPane addTarget = loader.load();
        mainLayout.setCenter(addTarget);
    }
        public static void addNewTerrorContainer() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/addTerror.fxml"));
        BorderPane addTarget = loader.load();
        mainLayout.setCenter(addTarget);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}
                


