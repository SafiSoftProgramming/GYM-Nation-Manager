/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social_gym;

import backupcode.JavaFX_jssc_Uno;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.web.WebView;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author root
 */
public class User_Intro_Controller implements Initializable {
    
    public AnchorPane pane_user_intro;
    
     String Media_URL = "motoride.mp4";
     MediaPlayer mediaPlayer ;
    private WebView webV;
    @FXML
    private ImageView img_ads;
    @FXML
    private BorderPane pane_logedin;
    @FXML
    private BorderPane pane_ads;
    @FXML
    private BorderPane pane_search_user;
    @FXML
    private ImageView img_RFID_CARD;
    @FXML
    private Circle circle_image_user;
    @FXML
    private Label lab_user_name;
    @FXML
    private Label lab_card_not_accepted;
    
    Timer timer ;
    @FXML
    private Label lab_time;
    @FXML
    private ImageView img_chos_arm;
    @FXML
    private ImageView img_chos_back;
    @FXML
    private ImageView img_chos_legs;
    @FXML
    private ImageView img_chos_shoulder;
    @FXML
    private ImageView img_chos_chest;
    @FXML
    private ImageView img_chos_abs;
    @FXML
    private ImageView img_chos_crossfit;
    @FXML
    private ImageView img_chos_cardio;
    @FXML
    private Label lab_start_date;
    @FXML
    private Label lab_end_date;
    @FXML
    private Label lab_plane;
    @FXML
    private Label lab_help_user;
    @FXML
    private AnchorPane pane_chos_arm;
    @FXML
    private AnchorPane pane_chos_back;
    @FXML
    private AnchorPane pane_chos_legs;
    @FXML
    private AnchorPane pane_chos_shoulder;
    @FXML
    private AnchorPane pane_chos_chest;
    @FXML
    private AnchorPane pane_chos_abs;
    @FXML
    private AnchorPane pane_chos_crossfit;
    @FXML
    private AnchorPane pane_chos_cardio;
    @FXML
    private JFXButton btn_StartWorkout;

    @FXML
    private AnchorPane pane_done;
    @FXML
    private BorderPane pane_done_workout;
    @FXML
    private Label lab_rate_0;
    @FXML
    private Label lab_rate_20;
    @FXML
    private Label lab_rate_50;
    @FXML
    private Label lab_rate_80;
    @FXML
    private Label lab_rate_100;
    @FXML
    private MaterialDesignIconView ico_rate_0;
    @FXML
    private MaterialDesignIconView ico_rate_20;
    @FXML
    private MaterialDesignIconView ico_rate_50;
    @FXML
    private MaterialDesignIconView ico_rate_80;
    @FXML
    private MaterialDesignIconView ico_rate_100;
    @FXML
    private Label lb_traning_hours;
    @FXML
    private Label lb_traning_minutes;
    @FXML
    private Label lb_traning_seconds;
    @FXML
    private Circle circle_end_traning_user_img;
    @FXML
    private Label lb_end_traning_user_name;
    
    String member_id_now = "";
    String Workout_one_name = "";
    String Workout_two_name = "";
    String Workout_one_image = "";
    String Workout_two_image = "";
    
    String end_workout_member_id_now = "";
    String end_workout_rate = "50" ;
    String end_workout_mode = "Auto" ;
    
    boolean not_found_any_where = true ;
   
    Timer timer_search ;
    @FXML
    private BorderPane pane_membership_end;
    @FXML
    private FontAwesomeIconView fontaw_startdate;
    @FXML
    private FontAwesomeIconView fontaw_enddate;
    @FXML
    private Label lb_end_traning_user_name11;
    @FXML
    private HBox hbox_member_cards;
    @FXML
    private JFXButton btn_previous_card_data;
    @FXML
    private VBox vbox_card;
    private Label lab_member_plane;
    @FXML
    private VBox vbox_card1;
    private Label lab_member_plane_1;
    @FXML
    private VBox vbox_card11;
    private Label lab_member_plane_2;
    @FXML
    private VBox vbox_card111;
    private Label lab_member_plane_3;
    @FXML
    private JFXButton btn_next_card_data;
    @FXML
    private Circle circle_user_profile_end_membership;
    @FXML
    private Label lab_user_name_end_membership;
    @FXML
    private Label lab_plan_name_end_membership;
    @FXML
    private Label lab_startDate_end_membership;
    @FXML
    private Label lab_endDate_end_membership;
    @FXML
    private Label lab_registration_date_end_membership;
    @FXML
    private Label lab_member_registration_date;
    @FXML
    private Label lab_plan_month_end_membership;
    @FXML
    private Label lab_plan_days_end_membership;
    @FXML
    private JFXTextField lab_plan_price_end_membership;
    @FXML
    private Label lab_registration_date_end_membership1;
    @FXML
    private Label lab_plan_name_end_membership1;
    
    int card_count = 0 ;
    MYSql_DBConnection MYDatabase ;
    @FXML
    private Label plan_name_card;
    @FXML
    private Label plan_name_card1;
    @FXML
    private Label plan_name_card11;
    @FXML
    private Label plan_name_card111;
    @FXML
    private Label plan_month_card;
    @FXML
    private Label plan_month_card1;
    @FXML
    private Label plan_month_card11;
    @FXML
    private Label plan_month_card111;
    @FXML
    private Label plan_days_card;
    @FXML
    private Label plan_days_card1;
    @FXML
    private Label plan_days_card11;
    @FXML
    private Label plan_days_card111;
    @FXML
    private Label plan_price_card;
    @FXML
    private Label plan_price_card1;
    @FXML
    private Label plan_price_card11;
    @FXML
    private Label plan_price_card111;
    @FXML
    private ImageView plan_available_card_lock;
    @FXML
    private ImageView plan_available_card_lock1;
    @FXML
    private ImageView plan_available_card_lock11;
    @FXML
    private ImageView plan_available_card_lock111;
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        MYDatabase = new MYSql_DBConnection();
             timer = new Timer();
           timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            Platform.runLater(() -> {
                  final DateFormat df = new SimpleDateFormat("HH:mm:ss");
                    final Calendar cal = Calendar.getInstance();                
                    String string = df.format(cal.getTime());
                    lab_time.setText(string);

            });
        }
    }, 1000, 1000);
           
           
           
           
       Timer timer = new Timer();
           timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
           AutoEndWorkout(); 
        }
    }, 1000, 200000);
            
  
        
        
        
        
  MYSql_DBConnection bConnection = new MYSql_DBConnection();
  bConnection.Ads_pic(img_ads);
 
  
        
    }
    

   public void hide_all_pane(){
    pane_logedin.setVisible(false);   
    pane_ads.setVisible(false);    
    pane_search_user.setVisible(false);
    pane_done_workout.setVisible(false);
    pane_membership_end.setVisible(false);
    
    
   }
   
   
   
   
       SerialPort arduinoPort = null;
    ObservableList<String> portList;
    
   String total = "";
 String st = "";
 boolean access = false ;
 boolean access_from_first_stage = false ;
 MYSql_DBConnection DB_connection = new MYSql_DBConnection();
 Server_Links links = new Server_Links() ;

    @FXML
    private void hide_ads_image_to_search_user(MouseEvent event) {
        
         hide_all_pane();
        pane_search_user.setVisible(true);
        connectArduino(links.connectArduino_Serialport());
        
        End_Scane_RFID();
        
    }
String[][] get_rfid ;
String[][] get_rfid_member_at_gym ;
 
    public boolean connectArduino(String port){  
        System.out.println(links.connectArduino_Serialport());
        img_RFID_CARD.setImage(new Image ("img/rfid_card_insert_moving.gif"));
        
        not_found_any_where = true ;
        
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
                                
                                get_rfid_member_at_gym = DB_connection.Search_member_at_the_gym_data_database();
                                
                                 for(int i=0;i<get_rfid_member_at_gym.length;i++){

                             if(total.equals(get_rfid_member_at_gym[i][0]))
                            {
  
                                access_from_first_stage = true ;
                                
                                not_found_any_where = false ;
                                
                                String StartTime = DB_connection.member_at_the_gym_start_traning_time(get_rfid_member_at_gym[i][1]);// id not rfid
                                
                                compar_start_end_tranning_time(StartTime,Time_now(),lb_traning_hours,lb_traning_minutes,lb_traning_seconds);
                                
                                
                                Image im = new Image(links.Server_url()+get_rfid_member_at_gym[i][2]);
                                if (!im.isError()){
                                circle_end_traning_user_img.setFill(new ImagePattern(im));}
                                
                                final String user_name = get_rfid_member_at_gym[i][3] ;
                                
                                disconnectArduino();
                                total ="";
                                timer_search.cancel();
                                
                                
                                Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                lb_end_traning_user_name.setText(user_name);
                                }
                                  });

                                
                                hide_all_pane();
                                pane_done_workout.setVisible(true);
                                
                                end_workout_member_id_now = get_rfid_member_at_gym[i][1] ;
    
                            }               
                            }    
    
                            if (total.length() == 11 && access_from_first_stage == false )
                            {
                              
                                 get_rfid = DB_connection.Search_member_data_database();                                                   
                            for(int i=0;i<get_rfid.length;i++){

                             if(total.equals(get_rfid[i][15]))
                            {
                                
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");                               
                                Date end_date = dateFormat.parse(get_rfid[i][5]);
                                
                                Date date_now = new Date();
                                                               
                                if(end_date.before(date_now)){                               
                                                                  
                                    DB_connection.get_user_profile_data(get_rfid[i][0],circle_user_profile_end_membership,lab_user_name_end_membership,lab_startDate_end_membership,lab_endDate_end_membership,lab_plan_name_end_membership,lab_registration_date_end_membership);
                                    DB_connection.get_plan_data_to_update(get_rfid[i][6], lab_plan_price_end_membership, lab_plan_month_end_membership, lab_plan_days_end_membership);
                                    load_card_data();
                                    hide_all_pane();
                                    disconnectArduino();
                                    pane_membership_end.setVisible(true); 
                                    timer_search.cancel();
                                    not_found_any_where = false ;
                                }
                                
                                else{      
                                   
                                not_found_any_where = false ;
                                String musicFile = "accesst.wav";     
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();   
                                img_RFID_CARD.setImage(new Image ("img/rfid_card_accepted.gif"));                            
                                total = "";
                                access  = true ;                               
                                hide_all_pane();
                                pane_logedin.setVisible(true);     
                                DB_connection.get_user_profile_data(get_rfid[i][0],circle_image_user,lab_user_name,lab_start_date,lab_end_date,lab_plane,lab_member_registration_date);
                                member_id_now = get_rfid[i][0] ;
                                DB_connection.rs.close(); 
                                disconnectArduino(); 
                                
                                timer_search.cancel();
                                }
                            }               
                            }   
                            
                            if (not_found_any_where){                                
                                String musicFile = "accessd.wav";    
                                Media sound = new Media(new File(musicFile).toURI().toString());
                                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                                mediaPlayer.play();    
                                img_RFID_CARD.setImage(new Image ("img/rfid_card_not_accepted.gif"));
                                lab_card_not_accepted.setVisible(true);
                                total = "";    
                                access = false ;
                                } 
                                
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
                        } catch (ParseException ex) {
                            Logger.getLogger(User_Intro_Controller.class.getName()).log(Level.SEVERE, null, ex);
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
           
         //  lab_idnot.visibleProperty().set(true);
           
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
    
    
    
    public void End_Scane_RFID(){
    
      TimerTask task = new TimerTask() {
                       public void run() {

          if(arduinoPort.isOpened()){
              
               img_RFID_CARD.setImage(new Image ("img/rfid_card_standbuy.gif"));
               lab_card_not_accepted.setVisible(false);
               hide_all_pane();
               pane_ads.setVisible(true);
               disconnectArduino();
               lab_card_not_accepted.setVisible(false);

          
                }
        }
    };
    timer_search = new Timer("Timer");

    long delay = 10000L;
    timer_search.schedule(task, delay);
    
 
        
    }
    
    
    
    int total_choose_workout_image_count = 0 ;
    public void Show_and_Hide_choose_workout_image(ImageView imageView){
        lab_help_user.setText("You Can Choose ONE OR TOW Workouts");
        if(!imageView.isVisible()&&total_choose_workout_image_count < 2){
        imageView.setVisible(true);

        if(Workout_one_image.equals("")){
        Workout_one_image = imageView.getId();
        
        switch (Workout_one_image) {
        case "img_chos_arm":
        Workout_one_name = "Arm";
        break;
        case "img_chos_back":
        Workout_one_name = "Back";
        break;
        case "img_chos_legs":
        Workout_one_name = "Leg";
        break;
        case "img_chos_shoulder":
        Workout_one_name = "Shoulders";
        break;
        case "img_chos_chest":
        Workout_one_name = "Chest";
        break;
        case "img_chos_abs":
        Workout_one_name = "Abs";
        break;
        case "img_chos_crossfit":
        Workout_one_name = "Crossfit";
        break;
        case "img_chos_cardio":
        Workout_one_name = "Cardio";
        break;}
        
        }
        else if (Workout_two_image.equals("")){
        Workout_two_image = imageView.getId();
        
        switch (Workout_two_image) {
        case "img_chos_arm":
        Workout_two_name = "Arm";
        break;
        case "img_chos_back":
        Workout_two_name = "Back";
        break;
        case "img_chos_legs":
        Workout_two_name = "Leg";
        break;
        case "img_chos_shoulder":
        Workout_two_name = "Shoulders";
        break;
        case "img_chos_chest":
        Workout_two_name = "Chest";
        break;
        case "img_chos_abs":
        Workout_two_name = "Abs";
        break;
        case "img_chos_crossfit":
        Workout_two_name = "Crossfit";
        break;
        case "img_chos_cardio":
        Workout_two_name = "Cardio";
        break;}
        }

        
        total_choose_workout_image_count = total_choose_workout_image_count + 1 ;
           btn_StartWorkout.setDisable(false);
        }else if(imageView.isVisible()){
             imageView.setVisible(false);
            total_choose_workout_image_count = total_choose_workout_image_count - 1 ;  
            Workout_one_image = "";
            Workout_one_name = "";
            
          
            
        }
        if(total_choose_workout_image_count >= 2){
        lab_help_user.setText("You Can't Choose More than TWO Workouts if You Want to Change the Choosing Workouts Just Unselect The workout");
        }
        if(total_choose_workout_image_count == 0){
        btn_StartWorkout.setDisable(true);
        Workout_one_image = "";
        Workout_two_image = "";
        Workout_one_name = "";
        Workout_two_name = "";
       
        }
        
        
  
    }

    @FXML
    private void Touch_Arm_workout_pane(MouseEvent event) {
        Show_and_Hide_choose_workout_image(img_chos_arm);
    }

    @FXML
    private void Touch_Back_workout_pane(MouseEvent event) {
        Show_and_Hide_choose_workout_image(img_chos_back);
    }

    @FXML
    private void Touch_Legs_workout_pane(MouseEvent event) {
        Show_and_Hide_choose_workout_image(img_chos_legs);
    }

    @FXML
    private void Touch_Shoulder_workout_pane(MouseEvent event) {
        Show_and_Hide_choose_workout_image(img_chos_shoulder);
    }

    @FXML
    private void Touch_Chest_workout_pane(MouseEvent event) {
        Show_and_Hide_choose_workout_image(img_chos_chest);
    }

    @FXML
    private void Touch_Abs_workout_pane(MouseEvent event) {
        Show_and_Hide_choose_workout_image(img_chos_abs);
    }

    @FXML
    private void Touch_Crossfit_workout_pane(MouseEvent event) {
        Show_and_Hide_choose_workout_image(img_chos_crossfit);
    }

    @FXML
    private void Touch_Cardio_workout_pane(MouseEvent event) {
        Show_and_Hide_choose_workout_image(img_chos_cardio);
    }
    
    
    
    public String Time_now(){
    
  // DateFormat df = new SimpleDateFormat("dd-MMMM HH:mm a");
    DateFormat df = new SimpleDateFormat("hh:mm aa");
    Date date = new Date(System.currentTimeMillis());
    String time = df.format(date);

    return time ;
    }
    
    
    public String Date_now(){
    
    DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
   // DateFormat df = new SimpleDateFormat("hh:mm aa");
    Date date = new Date(System.currentTimeMillis());
    String time = df.format(date);

    return time ;
    }
    
 
    
    
    
    
    
    
      // String startTime,String endTime
    public void compar_start_end_tranning_time(String StartTimes,String EndTimes,Label lb_Hour, Label lb_Minuts, Label lb_Sc){
        
              String StartTime_cut = StartTimes.replace("AM", "").replace("PM", "").replace(" ", "").replaceAll("\\s+", " ");
              String EndTimes_cut = EndTimes.replace("AM", "").replace("PM", "").replace(" ", "").replaceAll("\\s+", " ");

              String startTimeParse[] = StartTime_cut.split(":");
              String endTimeParse[] = EndTimes_cut.split(":");
      
                LocalDate today = LocalDate.now();
		String startTimeStrT = today + " " + startTimeParse[0] + ":" + startTimeParse[1] ;
		String endTimeStrT = today + " " +endTimeParse[0] + ":" + endTimeParse[1];

		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm");

		try {

			LocalDateTime startTime = LocalDateTime.parse(startTimeStrT,
					formatter);
			LocalDateTime endTime = LocalDateTime.parse(endTimeStrT, formatter);

			Duration d = Duration.between(startTime, endTime);
                        long h =d.toHours();
                        long m = d.toMinutes();
                        
                        long Hours_count = h*60 ;
                        
                        long real_minutes = m - Hours_count ;

			if (h < 0){h = h + 11;}
                        if (real_minutes < 0){real_minutes = real_minutes + 60;}
                        
                        String H = Long.toString(h) ;
                        String M = Long.toString(real_minutes) ;
                        
                       
                        
                        if (H.length() == 1){H = "0"+H ;}
                        if (M.length() == 1){M = "0"+M ;}
                        
                        final String HH = H ;
                        final String MM = M ;
                        
                        
                        
                        final DateFormat df = new SimpleDateFormat("ss");
                        final Calendar cal = Calendar.getInstance();                
                        String sc = df.format(cal.getTime());

                        Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                        lb_Hour.setText(HH);
                        lb_Minuts.setText(MM);
                        lb_Sc.setText(sc);
                         }
                         });

                        
			
                        
		} catch (DateTimeParseException e) {
			System.out.println("Invalid Input" + e.getMessage());

		}



    }
    
    
    public void AutoEndWorkout(){
        
              String[][] time_and_id = DB_connection.get_memper_at_the_gym_starttime_id();
           
              for (int i = 0 ; i < time_and_id.length;i++){
            
              String StartTime_cut = time_and_id[i][1].replace("AM", "").replace("PM", "").replace(" ", "").replaceAll("\\s+", " ");
              String EndTimes_cut = Time_now().replace("AM", "").replace("PM", "").replace(" ", "").replaceAll("\\s+", " ");

              String startTimeParse[] = StartTime_cut.split(":");
              String endTimeParse[] = EndTimes_cut.split(":");
      
                LocalDate today = LocalDate.now();
		String startTimeStrT = today + " " + startTimeParse[0] + ":" + startTimeParse[1] ;
		String endTimeStrT = today + " " +endTimeParse[0] + ":" + endTimeParse[1];

		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("yyyy-MM-dd HH:mm");

		try {
			LocalDateTime startTime = LocalDateTime.parse(startTimeStrT,
					formatter);
			LocalDateTime endTime = LocalDateTime.parse(endTimeStrT, formatter);

			Duration d = Duration.between(startTime, endTime);
                        long h =d.toHours();
                        long m = d.toMinutes();
                        
                        long Hours_count = h*60 ;                        
                        long real_minutes = m - Hours_count ;

			if (h < 0){h = h + 11;}
                        if (real_minutes < 0){real_minutes = real_minutes + 60;}
                        
                        String H = Long.toString(h) ;
                        String M = Long.toString(real_minutes) ;
                        
                        if (H.length() == 1){H = "0"+H ;}
                        if (M.length() == 1){M = "0"+M ;}
                        
                        final String HH = H ;
                        final String MM = M ;
                                               
                        final DateFormat df = new SimpleDateFormat("ss");
                        final Calendar cal = Calendar.getInstance();                
                        String sc = df.format(cal.getTime());
                        
                        
                        if (h >= 2 ){
                            
                        String time_duration = HH+" : "+MM+" : "+sc;
                                            
                        MYSql_DBConnection bConnection = new MYSql_DBConnection();
                        bConnection.insert_member_workout_history(time_and_id[i][0], Time_now(), time_duration, "50", "Auto");
                        
                        bConnection.Delete_Data("members_at_the_gym", time_and_id[i][0]);
                                    

                        }
                        
                                                
		} catch (DateTimeParseException e) {
			System.out.println("Invalid Input" + e.getMessage());

		}
                
              }
    }
    
    
    
    
    
    
    
    
    
    

    
    
    @FXML
    private void StartWorkout(ActionEvent event) {
        MYSql_DBConnection bConnection = new MYSql_DBConnection();
        bConnection.insert_member_at_the_gym_data(member_id_now,Workout_one_name,Workout_two_name,Time_now(),Date_now());
        Workout_one_image = "";
        Workout_two_image = "";
        Workout_one_name = "";
        Workout_two_name = "";
        img_chos_arm.setVisible(false);
        img_chos_back.setVisible(false);
        img_chos_legs.setVisible(false);
        img_chos_shoulder.setVisible(false);
        img_chos_chest.setVisible(false);
        img_chos_abs.setVisible(false);
        img_chos_crossfit.setVisible(false);
        img_chos_cardio.setVisible(false);
        total_choose_workout_image_count= 0 ;
        btn_StartWorkout.setDisable(true);
        lab_card_not_accepted.setVisible(false);
        
        pane_logedin.setEffect(new GaussianBlur());
        pane_done.setVisible(true);
        
        
        
         TimerTask task = new TimerTask() {
                       public void run() {
                           
         pane_done.setVisible(false);        
         hide_all_pane();
         pane_ads.setVisible(true);
         pane_logedin.setEffect(null);

        }
    };
    Timer timer = new Timer("Timer");
    long delay = 5000L;
    timer.schedule(task, delay);  
    }
    
    
     @FXML
    private void EndWorkout(MouseEvent event) {
        String time_duration = lb_traning_hours.getText()+" : "+lb_traning_minutes.getText()+" : "+lb_traning_seconds.getText();
        end_workout_mode = "Manual";
                      
        MYSql_DBConnection bConnection = new MYSql_DBConnection();
        bConnection.insert_member_workout_history(end_workout_member_id_now, Time_now(), time_duration, end_workout_rate, end_workout_mode);
        
         lab_rate_0.setTextFill(Color.web("#212121"));
        ico_rate_0.setFill(Color.web("#212121"));
        lab_rate_20.setTextFill(Color.web("#212121"));
        ico_rate_20.setFill(Color.web("#212121"));
        lab_rate_50.setTextFill(Color.web("#b8e1dd"));
        ico_rate_50.setFill(Color.web("#b8e1dd"));
        lab_rate_80.setTextFill(Color.web("#212121"));
        ico_rate_80.setFill(Color.web("#212121"));
        lab_rate_100.setTextFill(Color.web("#212121"));
        ico_rate_100.setFill(Color.web("#212121"));
        
        end_workout_rate = "50";
        end_workout_mode = "Auto";
        
        pane_done_workout.setEffect(new GaussianBlur());
        pane_done.setVisible(true);
        
         access_from_first_stage = false ;
        
        
        bConnection.Delete_Data("members_at_the_gym", end_workout_member_id_now);
        

          TimerTask task = new TimerTask() {
                       public void run() {
                           
         pane_done.setVisible(false);        
         hide_all_pane();
         pane_ads.setVisible(true);
         pane_done_workout.setEffect(null);

        }
    };
    Timer timer = new Timer("Timer");
    long delay = 5000L;
    timer.schedule(task, delay);  
        
    }
    
    

    @FXML
    private void Cancel_Workout(ActionEvent event) {
        
        Workout_one_image = "";
        Workout_two_image = "";
        Workout_one_name = "";
        Workout_two_name = "";
        img_chos_arm.setVisible(false);
        img_chos_back.setVisible(false);
        img_chos_legs.setVisible(false);
        img_chos_shoulder.setVisible(false);
        img_chos_chest.setVisible(false);
        img_chos_abs.setVisible(false);
        img_chos_crossfit.setVisible(false);
        img_chos_cardio.setVisible(false);
        total_choose_workout_image_count= 0 ;
        btn_StartWorkout.setDisable(true);
        lab_card_not_accepted.setVisible(false);
        card_count = 0 ;
        
        
         hide_all_pane();
         pane_ads.setVisible(true);
         
         access_from_first_stage = false ;
        
    }

    @FXML
    private void lab_rate_0_click(MouseEvent event) {
        lab_rate_0.setTextFill(Color.web("#b8e1dd"));
        ico_rate_0.setFill(Color.web("#b8e1dd"));
        lab_rate_20.setTextFill(Color.web("#212121"));
        ico_rate_20.setFill(Color.web("#212121"));
        lab_rate_50.setTextFill(Color.web("#212121"));
        ico_rate_50.setFill(Color.web("#212121"));
        lab_rate_80.setTextFill(Color.web("#212121"));
        ico_rate_80.setFill(Color.web("#212121"));
        lab_rate_100.setTextFill(Color.web("#212121"));
        ico_rate_100.setFill(Color.web("#212121"));
        
        end_workout_rate = "0";
        
    }

    @FXML
    private void lab_rate_20_click(MouseEvent event) {
        lab_rate_0.setTextFill(Color.web("#212121"));
        ico_rate_0.setFill(Color.web("#212121"));
        lab_rate_20.setTextFill(Color.web("#b8e1dd"));
        ico_rate_20.setFill(Color.web("#b8e1dd"));
        lab_rate_50.setTextFill(Color.web("#212121"));
        ico_rate_50.setFill(Color.web("#212121"));
        lab_rate_80.setTextFill(Color.web("#212121"));
        ico_rate_80.setFill(Color.web("#212121"));
        lab_rate_100.setTextFill(Color.web("#212121"));
        ico_rate_100.setFill(Color.web("#212121"));
        
        end_workout_rate = "20";
    }

    @FXML
    private void lab_rate_50_click(MouseEvent event) {
        lab_rate_0.setTextFill(Color.web("#212121"));
        ico_rate_0.setFill(Color.web("#212121"));
        lab_rate_20.setTextFill(Color.web("#212121"));
        ico_rate_20.setFill(Color.web("#212121"));
        lab_rate_50.setTextFill(Color.web("#b8e1dd"));
        ico_rate_50.setFill(Color.web("#b8e1dd"));
        lab_rate_80.setTextFill(Color.web("#212121"));
        ico_rate_80.setFill(Color.web("#212121"));
        lab_rate_100.setTextFill(Color.web("#212121"));
        ico_rate_100.setFill(Color.web("#212121"));
        
        end_workout_rate = "50";
        
    }

    @FXML
    private void lab_rate_80_click(MouseEvent event) {
        lab_rate_0.setTextFill(Color.web("#212121"));
        ico_rate_0.setFill(Color.web("#212121"));
        lab_rate_20.setTextFill(Color.web("#212121"));
        ico_rate_20.setFill(Color.web("#212121"));
        lab_rate_50.setTextFill(Color.web("#212121"));
        ico_rate_50.setFill(Color.web("#212121"));
        lab_rate_80.setTextFill(Color.web("#b8e1dd"));
        ico_rate_80.setFill(Color.web("#b8e1dd"));
        lab_rate_100.setTextFill(Color.web("#212121"));
        ico_rate_100.setFill(Color.web("#212121"));
        
        end_workout_rate = "80";
       
    }

    @FXML
    private void lab_rate_100_click(MouseEvent event) {
        lab_rate_0.setTextFill(Color.web("#212121"));
        ico_rate_0.setFill(Color.web("#212121"));
        lab_rate_20.setTextFill(Color.web("#212121"));
        ico_rate_20.setFill(Color.web("#212121"));
        lab_rate_50.setTextFill(Color.web("#212121"));
        ico_rate_50.setFill(Color.web("#212121"));
        lab_rate_80.setTextFill(Color.web("#212121"));
        ico_rate_80.setFill(Color.web("#212121"));
        lab_rate_100.setTextFill(Color.web("#b8e1dd"));
        ico_rate_100.setFill(Color.web("#b8e1dd"));
        
        end_workout_rate = "100";
    }
    
    
    
     public void load_card_data(){
    
        MYDatabase.get_plan_data_card(card_count+1, plan_name_card, plan_month_card,plan_days_card,plan_price_card,plan_available_card_lock,btn_next_card_data,btn_previous_card_data,vbox_card);
        MYDatabase.get_plan_data_card(card_count+2, plan_name_card1, plan_month_card1, plan_days_card1,plan_price_card1,plan_available_card_lock1,btn_next_card_data,btn_previous_card_data,vbox_card1);
        MYDatabase.get_plan_data_card(card_count+3, plan_name_card11, plan_month_card11,plan_days_card11,plan_price_card11,plan_available_card_lock11,btn_next_card_data,btn_previous_card_data,vbox_card11);
        MYDatabase.get_plan_data_card(card_count+4, plan_name_card111, plan_month_card111,plan_days_card111,plan_price_card111,plan_available_card_lock111,btn_next_card_data,btn_previous_card_data,vbox_card111);

    }
    
    

    @FXML
    private void previous_card_data(ActionEvent event) {
         card_count = card_count -4 ;
        load_card_data();
    }

    @FXML
    private void next_card_data(ActionEvent event) {
          card_count = card_count +4 ;
        load_card_data();
    }

    @FXML
    private void log_in_on_enter(KeyEvent event) {
    }

   
    

    
    
   

    
    
}


