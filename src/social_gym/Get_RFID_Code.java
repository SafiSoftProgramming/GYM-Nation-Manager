/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social_gym;

import backupcode.Arduino_RFID_read;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.sql.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author root
 */
public class Get_RFID_Code {
    
    
      SerialPort arduinoPort = null;
    ObservableList<String> portList;
      String total = "";
   String st = "";
   
   
   Server_Links links = new Server_Links() ;
    
    
    
    
      public void connect_aruno(JFXTextField textField_RFID_code,ImageView imgview_card_state,JFXButton button_connect,JFXButton button_disable) {
            imgview_card_state.setImage(new Image ("img/rfid_card_insert_moving.gif"));
            button_connect.setDisable(true);
            button_disable.setDisable(true);
            textField_RFID_code.setText("");
            Stop_port_Listener(imgview_card_state,button_connect,button_disable);
            
            

     System.out.println("connectArduino");       
        boolean success = false;
        SerialPort serialPort = new SerialPort(links.connectArduino_Serialport());
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
                             
                           if( total.length() == 11){                                                   
                                String musicFile = "card_accepted.wav";     
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();      
                              // tx_id_card_num.setText(total);
                                textField_RFID_code.setText(total);
                                imgview_card_state.setImage(new Image ("img/rfid_card_accepted.gif"));
                                button_connect.setDisable(false);
                                button_disable.setDisable(false);
                               System.out.println(total);  
                               disconnectArduino();
                                total = "";
                          } 
                           if (st.equals("*")){                          
                           total="";
                           st="";                         
                           }                                
                        } catch (SerialPortException ex) {
                            Logger.getLogger(Arduino_RFID_read.class.getName())
                                        .log(Level.SEVERE, null, ex);
                        }
                        
                    }
    
                }
            });           
            arduinoPort = serialPort;
            success = true;
        } catch (SerialPortException ex) {
            Logger.getLogger(Arduino_RFID_read.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    
      //desconnect arduino
       public void disconnectArduino(){       
        System.out.println("disconnectArduino()");
        if(arduinoPort != null){
            try {
                arduinoPort.removeEventListener();               
                if(arduinoPort.isOpened()){
                    arduinoPort.closePort();
                }
            } catch (SerialPortException ex) {
                Logger.getLogger(Arduino_RFID_read.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }
       
       
       
       
       

       public void Stop_port_Listener(ImageView imgview_card_state,JFXButton button_connect,JFXButton button_disable){

         TimerTask task = new TimerTask() {
                       public void run() {

          if(arduinoPort.isOpened()){

           disconnectArduino();
           button_connect.setDisable(false);
           button_disable.setDisable(false);
            imgview_card_state.setImage(new Image ("img/rfid_card_standbuy.gif"));
                }
        }
    };
    Timer timer = new Timer("Timer");

    long delay = 5000L;
    timer.schedule(task, delay);



       }
       
       
       
       
                                     
                               
                               
              
       
       
       
       
      
       
      
       
           
          
    
    
    
    
}
