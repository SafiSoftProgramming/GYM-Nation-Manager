/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social_gym;


import backupcode.JavaFX_jssc_Uno;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import javafx.scene.input.KeyEvent;
import javafx.stage.StageStyle;

/**
 *
 * @author SafiSoft
 */
public class Login_Scene_Controller implements Initializable {

    @FXML
    private JFXPasswordField tx_password;
    @FXML
    private JFXTextField tx_username;
    @FXML
    private JFXButton btn_login;
    @FXML
    private Pane pane;
    @FXML
    private Label lab_wrong;
    @FXML
    private Label lab_idnot;
    @FXML
    private Label lab_nonet;
    @FXML
    private JFXButton restart_btn;
    @FXML
    private FontAwesomeIconView fonta_lock_icon;
    @FXML
    private FontAwesomeIconView fonta_lock_icon1;
    @FXML
    private FontAwesomeIconView close_fontawesome_icon;
    
    
    Server_Links links = new Server_Links() ;
    
    
  
    
    
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // connectArduino("COM4");
       connectArduino(links.connectArduino_Serialport());
       
       MYSql_DBConnection con = new MYSql_DBConnection();
       if(con.conn == false){
       lab_nonet.visibleProperty().set(true);
       } 
       
       
          tx_username.setOnKeyReleased(event -> {
  if (event.getCode() == KeyCode.ENTER){

  login_btn();
  
  }
});
       
 tx_password.setOnKeyReleased(event -> {
  if (event.getCode() == KeyCode.ENTER){
      
     login_btn();

  }
});      
       
       
    }    
    
  

    @FXML
    private void log_in_btn(ActionEvent event) throws IOException {
       login_btn();
    
    }
    

    @FXML
        public void log_in_on_enter(KeyEvent ke)
        {
         
        }
        
        
        
    

    SerialPort arduinoPort = null;
    ObservableList<String> portList;
    
   String total = "";
 String st = "";
 boolean access = false ;
 MYSql_DBConnection DB_connection = new MYSql_DBConnection();
 
    public boolean connectArduino(String port){  
        System.out.println("connectArduino");
        
        boolean success = false;
        SerialPort serialPort = new SerialPort(port);
        try {
            serialPort.openPort();
            serialPort.setParams(
                    SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setEventsMask(MASK_RXCHAR);
            serialPort.addEventListener(new SerialPortEventListener() {
                @Override
                public void serialEvent(SerialPortEvent serialPortEvent) {
                   
                    if(serialPortEvent.isRXCHAR()){
                        try {
                             st = serialPort.readString(serialPortEvent
                                        .getEventValue());
                             total= total+st ;
                            Platform.runLater(() -> {
                               
                            });

                           if( total.length() == 11){  
                               
                               
                                String[][] get_rfid = DB_connection.Search_staff_data_database();
                            
                            
                            for(int i=0;i<get_rfid.length;i++){

                             if(total.equals(get_rfid[i][14]))
                            {
                                String musicFile = "accesst.wav";     
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();                          
                               
                                total = "";
                                access  = true ;
  
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {    
                                     //       hide_and_show((Stage) pane.getScene().getWindow(),"try.fxml","Social Gym");
                                       hide_and_show((Stage) pane.getScene().getWindow(),"Opening_Scene_Design.fxml","Social Gym");
                                       user_intro_stage_show("User_Intro_Design.fxml","Social Gym");
                                        } catch (IOException ex) {
                                            Logger.getLogger(Login_Scene_Controller.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
                                
                                DB_connection.rs.close();
                                
                                
                                disconnectArduino();   
                            }               
                            }              
                                if (access == false){                                
                                String musicFile = "accessd.wav";    
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();                                  
                                total = "";    
                                access = false ;
                                }                 
                           }
                           if (st.equals("*")){
                           total="";
                           st="";                         
                           }     
                        } catch (SerialPortException ex) {
                            Logger.getLogger(JavaFX_jssc_Uno.class.getName())
                                        .log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(Login_Scene_Controller.class.getName()).log(Level.SEVERE, null, ex);
                        } 
                        
                    }
                }
            });
            
            arduinoPort = serialPort;
            success = true;
        } catch (SerialPortException ex) {
            Logger.getLogger(JavaFX_jssc_Uno.class.getName())
                    .log(Level.SEVERE, null, ex);
           // System.out.println("SerialPortException: " + ex.toString());
           
           lab_idnot.visibleProperty().set(true);
           
        }

       // return success;
        
        return access ;
    }
    
   
    
    public void disconnectArduino(){
        
        System.out.println("disconnectArduino()");
        if(arduinoPort != null){
            try {
                arduinoPort.removeEventListener();
                
                if(arduinoPort.isOpened()){
                    arduinoPort.closePort();
                }
                
            } catch (SerialPortException ex) {
                Logger.getLogger(JavaFX_jssc_Uno.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

  
    
      public void hide_and_show(Stage primaryStage,String fxml_file,String titel) throws IOException{    
    primaryStage.hide();
    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml_file));
    Scene editorPage = new Scene(loader.load());
    primaryStage.setScene(editorPage);
    primaryStage.setTitle(titel);
    primaryStage.centerOnScreen();
    primaryStage.show();
    
      }
      
      
      
      
      public void user_intro_stage_show(String fxml_file,String titel) throws IOException{         
          Stage user_intro_stage = new Stage();
           FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml_file));
    Scene user_intro = new Scene(loader.load());
    user_intro_stage.setScene(user_intro);
    user_intro_stage.setTitle(titel);
    user_intro_stage.centerOnScreen();
    user_intro_stage.initStyle(StageStyle.TRANSPARENT); // hide titel bar and buttons     
    user_intro_stage.setMaximized(true);//make stage full screen
    user_intro_stage.show();
      }
      
  
      public void hide(Stage primaryStage) throws IOException{  
         primaryStage.close();
         disconnectArduino();
      }

   

    @FXML
    private void close_btn(MouseEvent event) {           
        try {
            hide((Stage) pane.getScene().getWindow());          
        } catch (IOException ex) {
            Logger.getLogger(Login_Scene_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @FXML
    private void restart_app(ActionEvent event) {
         System.out.println( "Restarting app!" );
         Platform.runLater(new Runnable() {
         @Override
         public void run() {
         try {      
         hide((Stage) pane.getScene().getWindow());
         hide_and_show((Stage) pane.getScene().getWindow(),"Login_Scene_Design.fxml","Social Gym");
         } catch (IOException ex) {
         Logger.getLogger(Login_Scene_Controller.class.getName()).log(Level.SEVERE, null, ex);
         }
          }
     });
    }
    
    public void login_btn(){
        
         String user_name = tx_username.getText();
        String password = tx_password.getText();
        boolean access = false ;
        
        MYSql_DBConnection DB_connection = new MYSql_DBConnection();
        
        String[][] get_rfid = DB_connection.Search_staff_data_database();
        
               
        for(int i=0;i<get_rfid.length;i++){
 
         if (user_name.equalsIgnoreCase(get_rfid[i][3])&&password.equalsIgnoreCase(get_rfid[i][4])) {
             access=true;
             
             Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {  
                                        hide_and_show((Stage) pane.getScene().getWindow(),"Opening_Scene_Design.fxml","Social Gym");  
                                     
                                        disconnectArduino();
                                        } catch (IOException ex) {
                                            Logger.getLogger(Login_Scene_Controller.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });
        }
       
        } 
        
        if(access == false){
        lab_wrong.visibleProperty().set(true);
        
        }

    }

 
    
}
