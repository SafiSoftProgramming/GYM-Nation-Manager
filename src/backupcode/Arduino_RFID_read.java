/*
 * Example of using jSSC library to handle serial port
 * Receive number from Arduino via USB/Serial and display on Label
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



public class Arduino_RFID_read  {
    
    SerialPort arduinoPort = null;
    ObservableList<String> portList;

 String total = "";
 String st = "";

    public void connectArduino(String port){             
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
                           if( total.length() == 11){                                                   
                                String musicFile = "accesst.wav";     
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();                                 
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
    
}