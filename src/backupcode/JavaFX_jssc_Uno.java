/*
 * Example of using jSSC library to handle serial port
 * Receive number from Arduino via USB/Serial and display on Label
 */
package backupcode;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;



public class JavaFX_jssc_Uno extends Application {
    
    SerialPort arduinoPort = null;
    ObservableList<String> portList;
    
    Label labelValue;
     
    private void detectPort(){
         
        portList = FXCollections.observableArrayList();
 
        String[] serialPortNames = SerialPortList.getPortNames();
        for(String name: serialPortNames){
            System.out.println(name);
            portList.add(name);
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        labelValue = new Label();
        
        detectPort();
        final ComboBox comboBoxPorts = new ComboBox(portList);
        comboBoxPorts.valueProperty()
                .addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, 
                    String oldValue, String newValue) {

                System.out.println(newValue);
                disconnectArduino();
                connectArduino(newValue);
            }

        });
        
        VBox vBox = new VBox();
        vBox.getChildren().addAll(
                comboBoxPorts, labelValue);
        
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 String total = "";
 String st = "";
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
                                labelValue.setText(total);
                            });
                            
                            
                            System.out.println(st);
                            System.out.println(total);
                            
                            
                           if( total.length() == 11){                           
                             if(total.equals("C0 31 20 A8"))
                            {
                                String musicFile = "accesst.wav";     
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();                          
                                System.out.println("hi");
                                total = "";
                            }
                             else{                                
                                String musicFile = "accesst.wav";    
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();                               
                                System.out.println("no");
                                total = "";                             
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

        return success;
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

    @Override
    public void stop() throws Exception {
        disconnectArduino();
        super.stop();
    }
            
    public static void main(String[] args) {
        launch(args);
    }
    
}