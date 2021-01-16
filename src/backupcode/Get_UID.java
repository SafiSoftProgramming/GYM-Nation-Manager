/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backupcode;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author SafiSoft
 */
public class Get_UID {
    
     SerialPort arduinoPort = null;
    ObservableList<String> portList;
    
   String total = "";
 String st = "";
 boolean access = false ;
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
                            
                            
                            System.out.println(st);
                            System.out.println(total);
                            
                            
                           if( total.length() == 11){                           
                             if(total.equals("C0 31 20 A8"))
                            {
                                String musicFile = "accesst.mp3";     
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();                          
                                System.out.println("hi");
                                total = "";
                                access  = true ;
                            }
                             else{                                
                                String musicFile = "accessd.mp3";    
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();                               
                                System.out.println("no");
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

    public void stop() throws Exception {
        disconnectArduino();
       
    }
    
    
    
}
