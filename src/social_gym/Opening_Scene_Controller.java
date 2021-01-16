/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social_gym;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.util.StringConverter;
import jssc.SerialPort;

/**
 *
 * @author SafiSoft
 */
public class Opening_Scene_Controller implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private FontAwesomeIconView close_fontawesome_icon;
    @FXML
    private Circle circle_image_v;
    private Circle circle_profile;
    private Circle cust_img1;
    private Label cust_name1;
    private Circle cust_img2;
    private Label cust_name2;
    private Circle cust_img3;
    private Label cust_name3;
    private Circle cust_img4;
    private Label cust_name4;
    private Circle cust_img5;
    private Label cust_name5;
    private Circle cust_img6;
    private Label cust_name6;
    private Circle cust_img7;
    private Label cust_name7;
    private Circle cust_img8;
    private Label cust_name8;
    private Circle cust_img9;
    private Label cust_name9;
    private Circle cust_img10;
    private Label cust_name10;
    
   
    @FXML
    public Pane pane_home;
    @FXML
    private AnchorPane pane_member_optian;
    @FXML
    private AnchorPane pane_add_new_member;
    MYSql_DBConnection MYDatabase ;
    @FXML
    private JFXTextField tx_member_fullName;
    @FXML
    private JFXTextField tx_member_phoneNumber;
    @FXML
    private JFXDatePicker tx_member_registrationDate;
    @FXML
    private JFXDatePicker tx_member_startDate;
    @FXML
    private JFXDatePicker tx_member_endDate;
    @FXML
    private JFXDatePicker tx_member_birthdate;
    @FXML
    private JFXTextField tx_member_weight;
    @FXML
    private JFXTextField tx_member_height;
    @FXML
    private JFXTextField tx_member_address;
    @FXML
    private JFXTextField tx_member_hint;
  
    private Circle circle_image_member;
    private JFXTextField tx_id_card_num;
    private ImageView imgview_card_state;
    @FXML
    private FontAwesomeIconView fontaw_kg_hg_gender;
    @FXML
    private FontAwesomeIconView fontaw_fullname;
    @FXML
    private FontAwesomeIconView fontaw_startdate;
    @FXML
    private FontAwesomeIconView fontaw_regstrationdate;
    @FXML
    private FontAwesomeIconView fontaw_address;
    @FXML
    private FontAwesomeIconView fontaw_birthdate;
    @FXML
    private FontAwesomeIconView fontaw_hint;
    @FXML
    private FontAwesomeIconView fontaw_phonenum;
    @FXML
    private FontAwesomeIconView fontaw_enddate;
    @FXML
    private FontAwesomeIconView fontaw_rfid;
    @FXML
    private FontAwesomeIconView fontaw_memberplan;
    @FXML
    private RadioButton radio_male;
    @FXML
    private RadioButton radio_female;
    @FXML
    private ImageView imageview_card_update_member;
    private JFXTextField tx_id_card_num_update_member;
    @FXML
    private JFXButton btn_home;
    @FXML
    private JFXTextField tx_id_card_num_add_new_member;
    @FXML
    private ImageView imgview_card_add_new_member;
    @FXML
    private JFXButton button_conn_idfr_update_member;
    @FXML
    private JFXButton button_conn_idfr_add_new_member;
    @FXML
    private JFXTextField tx_phone_num_update_member_search;
    @FXML
    private JFXTextField tx_id_card_num_update_member_search;
    @FXML
    private HBox hbox_save_new_member;
    @FXML
    private HBox hbox_update_member;
    private Label label_search_member_err;
    @FXML
    private HBox hbox_delete_member;
    @FXML
    private JFXButton btn_find_member_data_for_update;
    @FXML
    private JFXButton btn_find_member_data_for_delete;
    @FXML
    private JFXTextField tx_phone_num_delete_member_search;
    @FXML
    private JFXButton button_conn_idfr_delete_member;
    @FXML
    private JFXTextField tx_id_card_num_delete_member_search;
    @FXML
    private Label label_search_update_member_err;
    @FXML
    private Label label_search_delete_member_err;
    @FXML
    private ImageView imageview_card_delete_member;
    @FXML
    private JFXTextField tx_database_id;
    @FXML
    private AnchorPane pane_done;
    @FXML
    private JFXButton btn_ok_done_pane;
    @FXML
    private AnchorPane pane_staff_optian;
    @FXML
    private AnchorPane pane_add_new_staff;
    @FXML
    private HBox hbox_save_new_staff;
    @FXML
    private HBox hbox_update_staff;
    @FXML
    private HBox hbox_delete_staff;
    @FXML
    private JFXTextField tx_phone_num_update_staff_search;
    @FXML
    private JFXButton button_conn_idfr_update_staff;
    @FXML
    private ImageView imageview_card_update_staff;
    @FXML
    private JFXTextField tx_id_card_num_update_staff_search;
    @FXML
    private JFXButton btn_find_staff_data_for_update;
    @FXML
    private JFXTextField tx_phone_num_delete_staff_search;
    @FXML
    private JFXButton button_conn_idfr_delete_staff;
    @FXML
    private ImageView imageview_card_delete_staff;
    @FXML
    private JFXTextField tx_id_card_num_delete_staff_search;
    @FXML
    private JFXButton btn_find_staff_data_for_delete;
    @FXML
    private JFXTextField tx_staff_phoneNumber;
    @FXML
    private JFXDatePicker tx_staff_startDate;
    @FXML
    private JFXDatePicker tx_staff_birthdate;
    @FXML
    private RadioButton radio_staff_male;
    @FXML
    private RadioButton radio_staff_female;
    @FXML
    private JFXTextField tx_staff_hint;
    @FXML
    private JFXTextField tx_staff_fullName;
    @FXML
    private JFXTextField tx_staff_address;
    @FXML
    private JFXComboBox<?> tx_staff_JopTitle;
    @FXML
    private JFXComboBox<?> tx_staff_User_privileges;
    @FXML
    private JFXTextField tx_staff_username;
    @FXML
    private JFXTextField tx_id_card_num_add_new_staff;
    @FXML
    private FontAwesomeIconView fontaw_staff_gender;
    @FXML
    private FontAwesomeIconView fontaw_fullname_staff;
    @FXML
    private FontAwesomeIconView fontaw_startdate_staff;
    @FXML
    private FontAwesomeIconView fontaw_birthdate_staff;
    @FXML
    private FontAwesomeIconView fontaw_hint_staff;
    @FXML
    private FontAwesomeIconView fontaw_phonenum_staff;
    @FXML
    private FontAwesomeIconView fontaw_address_staff;
    @FXML
    private FontAwesomeIconView fontaw_joptitle;
    @FXML
    private FontAwesomeIconView fontaw_userprivi;
    @FXML
    private FontAwesomeIconView fontaw_staff_username;
    @FXML
    private JFXTextField tx_staff_userpassword;
    @FXML
    private FontAwesomeIconView fontaw_staff_userpassword;
    @FXML
    private FontAwesomeIconView fontaw_staff_rfid;
    @FXML
    private JFXButton button_conn_idfr_add_new_staff;
    @FXML
    private ImageView imgview_card_add_new_staff;
    @FXML
    private JFXTextField tx_database_id_staff;
    @FXML
    private Label label_search_delete_staff_err;
    @FXML
    private Label label_search_update_staff_err;
    @FXML
    private Label lab_time;
    Timer timer ;
    @FXML
    private Label lab_time1;
    @FXML
    private AnchorPane connardu;
    @FXML
    private JFXButton btn_cancel_in_update;
    @FXML
    private AnchorPane connardu1;
    @FXML
    private JFXTextField tx_database_staff_id;
    @FXML
    private JFXButton btn_cancel_in_update1;
    @FXML
    private Circle cir_profile_photo;
    @FXML
    private Label lab_member_name;
    @FXML
    private Label lab_workout_1_name;
    @FXML
    private Label lab_workout_2_name;
    @FXML
    private Label lab_end_member_date;
    @FXML
    private ImageView workout_1_img;
    @FXML
    private ImageView workout_2_img;
    @FXML
    private VBox vbox_card;
    @FXML
    public HBox hbox_member_cards;
    
   
    public int i_val ;
    @FXML
    private VBox vbox_card1;
    @FXML
    private Circle cir_profile_photo1;
    @FXML
    private Label lab_member_name1;
    @FXML
    private ImageView workout_1_img1;
    @FXML
    private ImageView workout_2_img1;
    @FXML
    private Label lab_workout_1_name1;
    @FXML
    private Label lab_workout_2_name1;
    @FXML
    private Label lab_end_member_date1;
    @FXML
    private VBox vbox_card11;
    @FXML
    private Circle cir_profile_photo11;
    @FXML
    private Label lab_member_name11;
    @FXML
    private ImageView workout_1_img11;
    @FXML
    private ImageView workout_2_img11;
    @FXML
    private Label lab_workout_1_name11;
    @FXML
    private Label lab_workout_2_name11;
    @FXML
    private Label lab_end_member_date11;
    @FXML
    private VBox vbox_card111;
    @FXML
    private Circle cir_profile_photo111;
    @FXML
    private Label lab_member_name111;
    @FXML
    private ImageView workout_1_img111;
    @FXML
    private ImageView workout_2_img111;
    @FXML
    private Label lab_workout_1_name111;
    @FXML
    private Label lab_workout_2_name111;
    @FXML
    private Label lab_end_member_date111;
    
    int card_count = 0 ;
    @FXML
    private JFXButton btn_next_card_data;
    @FXML
    private JFXButton btn_previous_card_data;
    @FXML
    private Label txtv_card_num_1;
    @FXML
    private Label txtv_card_num_2;
    @FXML
    private Label txtv_card_num_3;
    @FXML
    private Label txtv_card_num_4;
    @FXML
    private Label txtv_number_of_member_at_the_gym;
    @FXML
    private Label lab_member_start_tranning_time;
    @FXML
    private Label lab_member_plane;
    @FXML
    private Label lab_member_start_tranning_time_1;
    @FXML
    private Label lab_member_plane_1;
    @FXML
    private Label lab_member_start_tranning_time_2;
    @FXML
    private Label lab_member_plane_2;
    @FXML
    private Label lab_member_start_tranning_time_3;
    @FXML
    private Label lab_member_plane_3;
    @FXML
    private Label lab_start_member_date;
    @FXML
    private Label lab_start_member_date_1;
    @FXML
    private Label lab_start_member_date_2;
    @FXML
    private Label lab_start_member_date_3;
    @FXML
    private AnchorPane pane_send_notification;
    @FXML
    private JFXTextField edtxt_Notif_titel;
    @FXML
    private JFXTextArea edtxt_AR_text;
    @FXML
    private JFXTextArea edtxt_EN_text;
    @FXML
    private JFXTextArea edtxt_links_text;
    @FXML
    private Label lab_Notif_titel;
    private Label lab_Notif_body;
    @FXML
    private Label lab_Notif_body_ar;
    @FXML
    private Label lab_Notif_body_en;
    @FXML
    private Label lab_Notif_body_links;
    @FXML
    private JFXComboBox<String> combo_notification_icon;
    @FXML
    private Circle circle_image_notification_icon;
    @FXML
    private Label lab_notification_err;
    @FXML
    private FontAwesomeIconView fontaw_fullname1;
    @FXML
    private Circle circle_image_member_add_update_delete;
    @FXML
    private Circle circle_image_stuff_add_update_delete;
    
    
    
    Server_Links links = new Server_Links() ;
    @FXML
    private Label lab_err_frid_card_in_use;
    @FXML
    private Label lab_err_frid_card_in_use_staff;
    @FXML
    private AnchorPane pane_plan;
    @FXML
    private ImageView img_chos_1mon;
    @FXML
    private ImageView img_chos_2mon;
    @FXML
    private ImageView img_chos_3mon;
    @FXML
    private ImageView img_chos_4mon;
    @FXML
    private ImageView img_chos_5mon;
    @FXML
    private ImageView img_chos_6mon;
    @FXML
    private ImageView img_chos_7mon;
    @FXML
    private ImageView img_chos_8mon;
    @FXML
    private ImageView img_chos_9mon;
    @FXML
    private ImageView img_chos_10mon;
    @FXML
    private ImageView img_chos_11mon;
    @FXML
    private ImageView img_chos_12mon;
    @FXML
    private CheckBox checkbox_plan_available;
    @FXML
    private JFXTextField txt_plan_name;
    @FXML
    private JFXTextArea txt_plan_desc;
    @FXML
    private JFXTextField txt_plan_price;
    @FXML
    private Label lab_plan_err;
    @FXML
    private FontAwesomeIconView fontaw_fullname11;
    @FXML
    private HBox hbox_save_new_member1;
    @FXML
    private TableView<Map> table_plan;
    @FXML
    private TableColumn<?, ?> table_c1;
    
    
    public static final String ColumnKey0 = "G";
    public static final String ColumnKey1 = "A";
    public static final String ColumnKey2 = "B";
    public static final String ColumnKey3 = "C";
    public static final String ColumnKey4 = "D";
    public static final String ColumnKey5 = "E";
    public static final String ColumnKey6 = "F";
    @FXML
    private JFXButton button_delete_plan;
    @FXML
    private JFXButton button_update_plan;
    
    
    

    boolean i_update = false ;
        
    
    String plan_id = "";
    @FXML
    private ComboBox<?> combobox_member_plane;
    @FXML
    private JFXTextField txt_plan_total_price;
    @FXML
    private Label lab_plan_month;
    @FXML
    private Label lab_plan_days;
    @FXML
    private VBox vbox_conn_sensor;
    @FXML
    private VBox vbox_plan_options;
    @FXML
    private Label lab_tx_member_startDate;
    @FXML
    private Label lab_tx_member_endDate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        MYDatabase = new MYSql_DBConnection();
        Image im = new Image("img/33.jpg",false);
        circle_image_v.setFill(new ImagePattern(im));
        circle_image_v.setEffect(new DropShadow(+25d, 0d, +2d, Color.valueOf("#044a42")));
        circle_image_member_add_update_delete.setEffect(new DropShadow(+25d, 0d, +2d, Color.valueOf("#044a42")));
        imgview_card_add_new_member.setImage(new Image ("img/rfid_card_standbuy.gif"));
        
        
       ObservableList<String> listLeagues = FXCollections.observableArrayList(
        "Product", "Card", "Caution", "Idea", "Info", "Question", "Sale");
       
       combo_notification_icon.setItems(listLeagues);
  
       
       

        final ToggleGroup group = new ToggleGroup();
        radio_male.setToggleGroup(group);
        radio_female.setToggleGroup(group);
        final ToggleGroup group_stuff = new ToggleGroup();
        radio_staff_male.setToggleGroup(group_stuff);
        radio_staff_female.setToggleGroup(group_stuff);
        
        
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
            Platform.runLater(() -> {
                load_card_data();
                load_number_of_member_at_the_gym();
                    
                });
        }
    }, 100, 100000);
           
           
           
        TableColumn<Map, String> Column0 = new TableColumn<>("id");
        TableColumn<Map, String> Column1 = new TableColumn<>("Name");
        TableColumn<Map, String> Column2 = new TableColumn<>("Description");
        TableColumn<Map, String> Column3 = new TableColumn<>("Duration");
        TableColumn<Map, String> Column4 = new TableColumn<>("Price");
        TableColumn<Map, String> Column5 = new TableColumn<>("Available");
        TableColumn<Map, String> Column6 = new TableColumn<>("Status");
 
        Column0.setCellValueFactory(new MapValueFactory(ColumnKey0));
        Column0.setMinWidth(50);
        Column1.setCellValueFactory(new MapValueFactory(ColumnKey1));
        Column1.setMinWidth(130);
        Column2.setCellValueFactory(new MapValueFactory(ColumnKey2));
        Column2.setMinWidth(130);
        Column3.setCellValueFactory(new MapValueFactory(ColumnKey3));
        Column3.setMinWidth(160);
        Column4.setCellValueFactory(new MapValueFactory(ColumnKey4));
        Column4.setMinWidth(100);
        Column5.setCellValueFactory(new MapValueFactory(ColumnKey5));
        Column5.setMinWidth(100);
        Column6.setCellValueFactory(new MapValueFactory(ColumnKey6));
        Column6.setMinWidth(200);
        
        
        
        
 
        table_plan.setEditable(false);
        table_plan.getSelectionModel().setCellSelectionEnabled(false);
        table_plan.getColumns().setAll(Column0,Column1,Column2,Column3,Column4,Column5,Column6);
        Callback<TableColumn<Map, String>, TableCell<Map, String>>
            cellFactoryForMap = (TableColumn<Map, String> p) -> 
                new TextFieldTableCell(new StringConverter() {
                    @Override
                        public String toString(Object t) {
                        return t.toString();
                    }
                    @Override
                    public Object fromString(String string) {
                        return string;
                    }
            });
        Column0.setCellFactory(cellFactoryForMap);
        Column1.setCellFactory(cellFactoryForMap);
        Column2.setCellFactory(cellFactoryForMap);
        Column3.setCellFactory(cellFactoryForMap);
        Column4.setCellFactory(cellFactoryForMap);
        Column5.setCellFactory(cellFactoryForMap);
        Column6.setCellFactory(cellFactoryForMap);
        
        
        
         table_plan.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    @Override
    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
        if(table_plan.getSelectionModel().getSelectedItem() != null) 
        {                
             Object selectedItems = table_plan.getSelectionModel().getSelectedItems().get(0);
             
             txt_plan_name.setText(selectedItems.toString().split(",")[0].substring(3));
             
             txt_plan_desc.setText(selectedItems.toString().split(",")[1].substring(3));
             
             String duration = selectedItems.toString().split(",")[2].substring(3);
             duration = duration.substring(0,2);
             duration = duration.replace(" ", "");
             
             lab_plan_err.setVisible(false);
             lab_plan_err.setText("");

             img_chos_1mon.setVisible(false);
             img_chos_2mon.setVisible(false);
             img_chos_3mon.setVisible(false);
             img_chos_4mon.setVisible(false);
             img_chos_5mon.setVisible(false);
             img_chos_6mon.setVisible(false);
             img_chos_7mon.setVisible(false);
             img_chos_8mon.setVisible(false);
             img_chos_9mon.setVisible(false);
             img_chos_10mon.setVisible(false);
             img_chos_11mon.setVisible(false);
             img_chos_12mon.setVisible(false);
             
             total_choose_plan_image_count = 0 ;    
             
             switch(duration){
             
             case "1":
                 Show_and_Hide_choose_plan_image(img_chos_1mon);
                 plan_duration = "1";
              break;
             case "2":
                 Show_and_Hide_choose_plan_image(img_chos_2mon);
                 plan_duration = "2";
              break;
              case "3":
                 Show_and_Hide_choose_plan_image(img_chos_3mon);
                 plan_duration = "3";
              break;
              case "4":
                 Show_and_Hide_choose_plan_image(img_chos_4mon);
                 plan_duration = "4";
              break;
              case "5":
                 Show_and_Hide_choose_plan_image(img_chos_5mon);
                 plan_duration = "5";
              break;
              case "6":
                 Show_and_Hide_choose_plan_image(img_chos_6mon);
                 plan_duration = "6";
              break;
              case "7":
                 Show_and_Hide_choose_plan_image(img_chos_7mon);
                 plan_duration = "7";
              break;
              case "8":
                 Show_and_Hide_choose_plan_image(img_chos_8mon);
                 plan_duration = "8";
              break;
              case "9":
                 Show_and_Hide_choose_plan_image(img_chos_9mon);
                 plan_duration = "9";
              break;
              case "10":
                 Show_and_Hide_choose_plan_image(img_chos_10mon);
                 plan_duration = "10";
              break;
              case "11":
                 Show_and_Hide_choose_plan_image(img_chos_11mon);
                 plan_duration = "11";
              break;
              case "12":
                 Show_and_Hide_choose_plan_image(img_chos_12mon);
                 plan_duration = "12";
              break;
             
             
             }
             
             txt_plan_price.setText(selectedItems.toString().split(",")[3].substring(3));
             
             String available = selectedItems.toString().split(",")[4].substring(3);
             if(available.equals("Yes")){checkbox_plan_available.selectedProperty().set(true);}
             else if(available.equals("No")){checkbox_plan_available.selectedProperty().set(false);}
             
             String status = selectedItems.toString().split(",")[5].substring(3);
             status = status.substring(0,1);
             
             if(!status.equals("0")){
                 lab_plan_err.setVisible(true);
                 lab_plan_err.setText("you can't delete or update plans that is already in use by members");
                 button_update_plan.setDisable(true);
                 button_delete_plan.setDisable(true);
             }
             else{
                 lab_plan_err.setVisible(false);
                 lab_plan_err.setText("");
                 button_update_plan.setDisable(false);
                 button_delete_plan.setDisable(false);
             }
             
             
             plan_id = selectedItems.toString().split(",")[6].substring(3);
             plan_id=plan_id.replace("}","");
             
            
 
           
             
            
            
         }
         }

          
     });
    
       
           
  
    }
    
    
    private ObservableList<Map> generateDataInMap() {
        
        ObservableList<Map> allData = FXCollections.observableArrayList();
        String[][] plan_data = MYDatabase.Search_plan_data_database();
        for (int i = 0; i < plan_data.length; i++) {
            Map<String, String> dataRow = new HashMap<>();
 
            String value0 = plan_data[i][0];
            String value1 = plan_data[i][1];
            String value2 = plan_data[i][2];
            
            
            String value3 = plan_data[i][3];
            int days = Integer.valueOf(value3);
            days = days * 30 ;
            value3 = value3+" Month "+"( "+days+" Days )";
            
            
            String value4 = plan_data[i][4];
            String value5 = plan_data[i][5];
            String value6 =Integer.toString(plan_in_use_status(plan_data[i][1]))+" members using this plan";

            dataRow.put(ColumnKey0, value0);
            dataRow.put(ColumnKey1, value1);
            dataRow.put(ColumnKey2, value2);
            dataRow.put(ColumnKey3, value3);
            dataRow.put(ColumnKey4, value4);
            dataRow.put(ColumnKey5, value5);
            dataRow.put(ColumnKey6, value6);
 
            allData.add(dataRow);
        }
        return allData;
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
      
      
        public void hide(Stage primaryStage) throws IOException{
         primaryStage.close();
        // disconnectArduino();
      }

   

    @FXML
    private void button_home(ActionEvent event) {
        

        hide_all_pane();
        pane_home.visibleProperty().set(true);
        load_card_data();
        load_number_of_member_at_the_gym();
        
//         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//   LocalDateTime now = LocalDateTime.now();
//   System.out.println(dtf.format(now));
        
        
//        LocalDate date = LocalDate.now(); // gets the current date
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//System.out.println(date.format(formatter));
        
//        
//   Clock clock = Clock.systemDefaultZone();
//Instant instant = clock.instant();
//System.out.println(instant);
           
    }

    @FXML
    private void button_members(ActionEvent event) {
        hide_all_pane();
        pane_member_optian.visibleProperty().set(true);   
 
      
      after_saving_member_data_textfeilds();
      after_delete_member_data_textfeilds();
      

      
    }
    
 
      
     public void hide_all_pane(){     
       pane_member_optian.visibleProperty().set(false);
       pane_home.visibleProperty().set(false);
       pane_add_new_member.visibleProperty().set(false);
       pane_staff_optian.visibleProperty().set(false);
       pane_add_new_staff.visibleProperty().set(false);
       pane_send_notification.visibleProperty().set(false);
       pane_plan.visibleProperty().set(false);
       label_search_update_member_err.setVisible(false);
       label_search_delete_member_err.setVisible(false);
       label_search_update_staff_err.setVisible(false);
       label_search_delete_staff_err.setVisible(false);
       
    } 

  
    

    

    @FXML
    private void save_new_member_datat(ActionEvent event) {//save button on add new member page  
       if(is_all_new_member_data_valid()){
           
           if(chick_if_rfid_card_not_in_use_for_new_member()){
      
     //check the val of the checkbox if male or female
    String member_gender=""; 
    
    if(radio_male.isSelected()){
        member_gender="male"; 
    }
       
    if(radio_female.isSelected()){
        member_gender="female"; 
    }

    String member_fullName =tx_member_fullName.getText();
    String member_phoneNumber=tx_member_phoneNumber.getText();
    String member_RegistrationDate = tx_member_registrationDate.getValue().toString();
    String member_startDate =lab_tx_member_startDate.getText();
    String member_endDate =lab_tx_member_endDate.getText();
    String member_plane = combobox_member_plane.getValue().toString();
    
    String member_weight = tx_member_weight.getText();
    String member_height=tx_member_height.getText();
    String member_birthdate=tx_member_birthdate.getValue().toString();
    String member_address =tx_member_address.getText();
    String member_hint=tx_member_hint.getText();
    String member_imageTitel ="34";
   // String member_imagepath ="/root/Desktop/gym app 1-10-2019/my gym pro backup/social gym project/desktop app/social_gym/src/img/defult_user_profile.png"; //defult member image
    String member_imagepath = links.default_new_member_profile_img_server_link();
    String RFID =tx_id_card_num_add_new_member.getText() ;

    
 //send data to members table on database 
MYDatabase.insert_member_data(
        member_fullName,
        member_phoneNumber,
        member_RegistrationDate,
        member_startDate,
        member_endDate, 
        member_plane,
        member_gender,
        member_weight,
        member_height,
        member_birthdate,
        member_address,
        member_hint,
        member_imageTitel,
        member_imagepath,
        RFID);
        
        pane_add_new_member.setEffect(new GaussianBlur());
        pane_done.setVisible(true);
    
       }   
           else{
       
           
       
       }
       }
       
    }
    
  
     public boolean is_all_new_member_data_valid(){
        int validation = 0 ;
        boolean validation_state = false ;
        if(tx_member_fullName.getText().equals("")){fontaw_fullname.setVisible(true);}else{fontaw_fullname.setVisible(false);validation++;}
        if(tx_member_phoneNumber.getText().equals("")){fontaw_phonenum.setVisible(true);}else{fontaw_phonenum.setVisible(false);validation++;}
        if(lab_tx_member_startDate.getText().equals("")){fontaw_startdate.setVisible(true);}else{fontaw_startdate.setVisible(false);validation++;}
        if(lab_tx_member_endDate.getText().equals("")){fontaw_enddate.setVisible(true);}else{fontaw_enddate.setVisible(false);validation++;}
        if(tx_member_registrationDate.getValue()== null){fontaw_regstrationdate.setVisible(true);}else{fontaw_regstrationdate.setVisible(false);validation++;}
        if(combobox_member_plane.getValue() == null){fontaw_memberplan.setVisible(true);}else{fontaw_memberplan.setVisible(false);validation++;}
        if(tx_member_address.getText().equals("")){fontaw_address.setVisible(true);}else{fontaw_address.setVisible(false);validation++;}
        if(tx_member_weight.getText().equals("") || tx_member_height.getText().equals("") || radio_female.isSelected() == false && radio_male.isSelected() == false )
          {fontaw_kg_hg_gender.setVisible(true);}else{fontaw_kg_hg_gender.setVisible(false);validation++;}
        if(tx_member_birthdate.getValue()== null){fontaw_birthdate.setVisible(true);}else{fontaw_birthdate.setVisible(false);validation++;}
        if(tx_member_hint.getText().equals("")){fontaw_hint.setVisible(true);}else{fontaw_hint.setVisible(false);validation++;}
        if(tx_id_card_num_add_new_member.getText().equals("")){fontaw_rfid.setVisible(true);}else{fontaw_rfid.setVisible(false);validation++;}
        
        
        
        if(validation == 11){
           validation_state =true ;}
        
       
        return validation_state;
        
    }
     
    public void after_saving_member_data_textfeilds(){
    i_update = false ;
    tx_database_id.setText("");
    tx_member_fullName.setText("");
    tx_member_phoneNumber.setText("");
    lab_tx_member_startDate.setText("");
    lab_tx_member_endDate.setText("");
    tx_member_birthdate.setValue(null);
    tx_member_registrationDate.setValue(null);
    combobox_member_plane.getItems().removeAll(combobox_member_plane.getItems());
    lab_plan_month.setText("0");
    lab_plan_days.setText("0");
    txt_plan_total_price.setText("0");
    tx_member_weight.setText("");
    tx_member_height.setText("");
    radio_female.setSelected(false);
    radio_male.setSelected(false);
    tx_member_hint.setText("");
    tx_id_card_num_add_new_member.setText("");
    tx_member_address.setText("");
    imgview_card_add_new_member.setImage(new Image ("img/rfid_card_standbuy.gif"));
    
        fontaw_fullname.setVisible(false);
        fontaw_phonenum.setVisible(false);
        fontaw_startdate.setVisible(false);
        fontaw_enddate.setVisible(false);
        fontaw_regstrationdate.setVisible(false);
        fontaw_memberplan.setVisible(false);
        fontaw_address.setVisible(false);
        fontaw_kg_hg_gender.setVisible(false);
        fontaw_birthdate.setVisible(false);
        fontaw_hint.setVisible(false);
        fontaw_rfid.setVisible(false);
       
        lab_err_frid_card_in_use.setVisible(false);
        lab_err_frid_card_in_use_staff.setVisible(false);
    
    ///////
    
    tx_database_id_staff.setText("");
    tx_staff_fullName.setText("");
    tx_staff_phoneNumber.setText("");
    tx_staff_username.setText("");
    tx_staff_userpassword.setText("");
    tx_staff_birthdate.setValue(null);
    tx_staff_startDate.setValue(null);
    tx_staff_JopTitle.setValue(null);
    tx_staff_User_privileges.setValue(null);
    radio_staff_male.setSelected(false);
    radio_staff_female.setSelected(false);
    tx_staff_address.setText("");
    tx_staff_hint.setText("");
    tx_id_card_num_add_new_staff.setText("");
    imgview_card_add_new_staff.setImage(new Image ("img/rfid_card_standbuy.gif"));
    
      fontaw_fullname_staff.setVisible(false);
      fontaw_phonenum_staff.setVisible(false);
      fontaw_staff_username.setVisible(false);
      fontaw_staff_userpassword.setVisible(false);
      fontaw_birthdate_staff.setVisible(false);
      fontaw_startdate_staff.setVisible(false);
      fontaw_joptitle.setVisible(false);
      fontaw_userprivi.setVisible(false);
      fontaw_staff_gender.setVisible(false);
      fontaw_address_staff.setVisible(false);
      fontaw_hint_staff.setVisible(false);
      fontaw_staff_rfid.setVisible(false);

    }
    
    
    
    
    public void after_delete_member_data_textfeilds(){
    
        button_conn_idfr_add_new_member.setDisable(false);
        button_conn_idfr_add_new_staff.setDisable(false);        
        tx_member_fullName.setDisable(false);
        tx_member_phoneNumber.setDisable(false);
        tx_member_registrationDate.setDisable(false);
        lab_tx_member_startDate.setText("");
        lab_tx_member_endDate.setText("");
        tx_member_birthdate.setDisable(false);
        combobox_member_plane.setDisable(false);
        combobox_member_plane.getItems().removeAll(combobox_member_plane.getItems());
        lab_plan_month.setText("0");
        lab_plan_days.setText("0");
        txt_plan_total_price.setText("0");        
        tx_member_weight.setDisable(false);
        tx_member_height.setDisable(false);
        radio_male.setDisable(false);
        radio_female.setDisable(false);
        tx_member_address.setDisable(false);
        tx_member_hint.setDisable(false);
        vbox_plan_options.setDisable(false);
        vbox_conn_sensor.setDisable(false);

    }
    
    
    
 
    SerialPort arduinoPort = null;
    ObservableList<String> portList;
      String total = "";
   String st = "";

  


    @FXML
    private void close_btn(MouseEvent event) {
        timer.cancel();    
    //    Platform.exit();
        
         Platform.exit();
         System.exit(0);
        
        
          try {                    
            hide((Stage) pane.getScene().getWindow());                           
        } catch (IOException ex) {
            Logger.getLogger(Opening_Scene_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   



    @FXML
    private void conn_id_reader_add_new_member(ActionEvent event) {
         Get_RFID_Code get_RFID_Code = new Get_RFID_Code();
         get_RFID_Code.connect_aruno(tx_id_card_num_add_new_member, imgview_card_add_new_member,button_conn_idfr_add_new_member,button_conn_idfr_update_member); 
         fontaw_rfid.setVisible(false);
         lab_err_frid_card_in_use.setVisible(false);
    }

    
    


    @FXML
    private void update_member_datat(ActionEvent event) {
        
        if(is_all_new_member_data_valid()){
            
            if(chick_if_rfid_card_not_in_use_for_update_member()){
        
        String member_gender=""; 
    
    if(radio_male.isSelected()){
        member_gender="male"; 
    }
       
    if(radio_female.isSelected()){
        member_gender="female"; 
    }
        
        MYSql_DBConnection Update= new MYSql_DBConnection();
        Update.Update_member_data("member_data",
                tx_member_fullName.getText(),
                tx_member_phoneNumber.getText(),
                tx_member_registrationDate.getValue().toString(),
                lab_tx_member_startDate.getText(),
                lab_tx_member_endDate.getText(),
                combobox_member_plane.getValue().toString(),
                member_gender,
                tx_member_weight.getText(),
                tx_member_height.getText(),
                tx_member_birthdate.getValue().toString(),
                tx_member_address.getText(),
                tx_member_hint.getText(),
                tx_id_card_num_add_new_member.getText(),
                tx_database_id.getText());
        
        pane_add_new_member.setEffect(new GaussianBlur());       
        pane_done.setVisible(true);
        }
            else{
           fontaw_rfid.setVisible(true);
           lab_err_frid_card_in_use.setVisible(true);
        }
        }
        
        
    }
    


    @FXML
    private void delete_member_datat(ActionEvent event) {
        MYSql_DBConnection Delete = new MYSql_DBConnection();
        Delete.Delete_Data("member_data", tx_database_id.getText());
        pane_add_new_member.setEffect(new GaussianBlur());
        pane_done.setVisible(true);
        after_delete_member_data_textfeilds();
    }
    
    
     @FXML
    private void button_add_new_member(MouseEvent event) {
        hide_all_pane();
        hbox_save_new_member.setVisible(true);
        hbox_update_member.setVisible(false);
        hbox_delete_member.setVisible(false);
        after_saving_member_data_textfeilds();
        after_delete_member_data_textfeilds();
        pane_add_new_member.visibleProperty().set(true);
        
         Image im = new Image("img/defult_user_profile.png",false);
         if (!im.isError()){
         circle_image_member_add_update_delete.setFill(new ImagePattern(im));
         

       
        tx_member_registrationDate.setValue(LocalDate.now());
        
        
           ArrayList<String> plans = new ArrayList<>(); 
         ObservableList list = null ;
         String[][] plan_data = MYDatabase.Search_plan_data_database();
        for (int i = 0; i < plan_data.length; i++) {
        if(plan_data[i][5].equals("Yes")){
       
        plans.add(plan_data[i][1]);
        }
      
        }
        
      list = FXCollections.observableArrayList(plans);
      
      combobox_member_plane.setItems(list);
         
       
  
         }
        
        
        
    }
    

    @FXML
    private void Search_member_data_for_update(ActionEvent event) {
        
         i_update = true;
        
        Search_show_member_data search_show_member_data  = new Search_show_member_data();
        search_show_member_data.Search_get_member_data(tx_phone_num_update_member_search,
                tx_id_card_num_update_member_search,
                label_search_update_member_err,
                tx_database_id,
                tx_member_fullName,
                tx_member_phoneNumber,
                tx_member_registrationDate,
                lab_tx_member_startDate,
                lab_tx_member_endDate,
                combobox_member_plane,
                radio_male,
                radio_female,
                tx_member_weight,
                tx_member_height,
                tx_member_birthdate,
                tx_member_address,
                tx_member_hint,
                circle_image_member_add_update_delete,
                tx_id_card_num_add_new_member);
        
        
        if(search_show_member_data.Is_there_any_data()){   
         hide_all_pane();
         
        
       
        hbox_save_new_member.setVisible(false);
        hbox_update_member.setVisible(true);
        hbox_delete_member.setVisible(false);
        pane_add_new_member.visibleProperty().set(true);    
        
       
        
        tx_id_card_num_update_member_search.setText("");
        tx_id_card_num_delete_member_search.setText("");
        tx_phone_num_update_member_search.setText("");
        tx_phone_num_delete_member_search.setText("");
        imageview_card_update_member.setImage(new Image ("img/rfid_card_standbuy.gif"));
        imageview_card_delete_member.setImage(new Image ("img/rfid_card_standbuy.gif"));
        label_search_update_member_err.setVisible(false);
        label_search_delete_member_err.setVisible(false);
        
        
        
        
           ArrayList<String> plans = new ArrayList<>(); 
         ObservableList list = null ;
         String[][] plan_data = MYDatabase.Search_plan_data_database();
        for (int i = 0; i < plan_data.length; i++) {
        if(plan_data[i][5].equals("Yes")){
       
        plans.add(plan_data[i][1]);
        }
      
        }
        
      list = FXCollections.observableArrayList(plans);
      
      combobox_member_plane.setItems(list);
         
        }
        
        
    }

    @FXML
    private void Search_member_data_for_delete(ActionEvent event) {
         i_update = true;
        
          Search_show_member_data search_show_member_data  = new Search_show_member_data();
        search_show_member_data.Search_get_member_data(tx_phone_num_delete_member_search,
                tx_id_card_num_delete_member_search,
                label_search_delete_member_err,
                tx_database_id,
                tx_member_fullName,
                tx_member_phoneNumber,
                tx_member_registrationDate,
                lab_tx_member_startDate,
                lab_tx_member_endDate,
                combobox_member_plane,
                radio_male,
                radio_female,
                tx_member_weight,
                tx_member_height,
                tx_member_birthdate,
                tx_member_address,
                tx_member_hint,
                circle_image_member_add_update_delete,
                tx_id_card_num_add_new_member);
        
        
        if(search_show_member_data.Is_there_any_data()){   
         hide_all_pane();
        hbox_save_new_member.setVisible(false);
        hbox_update_member.setVisible(false);
        hbox_delete_member.setVisible(true);
        pane_add_new_member.visibleProperty().set(true);     
        
        button_conn_idfr_add_new_member.setDisable(true);
        button_conn_idfr_add_new_staff.setDisable(true);        
        tx_member_fullName.setDisable(true);
        tx_member_phoneNumber.setDisable(true);
        tx_member_registrationDate.setDisable(true);
      
        tx_member_birthdate.setDisable(true);
        combobox_member_plane.setDisable(true);
        tx_member_weight.setDisable(true);
        tx_member_height.setDisable(true);
        radio_male.setDisable(true);
        radio_female.setDisable(true);
        tx_member_address.setDisable(true);
        tx_member_hint.setDisable(true);
        vbox_plan_options.setDisable(true);
        vbox_conn_sensor.setDisable(true);
        

        tx_id_card_num_update_member_search.setText("");
        tx_id_card_num_delete_member_search.setText("");
        tx_phone_num_update_member_search.setText("");
        tx_phone_num_delete_member_search.setText("");
        imageview_card_update_member.setImage(new Image ("img/rfid_card_standbuy.gif"));
        imageview_card_delete_member.setImage(new Image ("img/rfid_card_standbuy.gif"));
        label_search_update_member_err.setVisible(false);
        label_search_delete_member_err.setVisible(false);
        
           ArrayList<String> plans = new ArrayList<>(); 
         ObservableList list = null ;
         String[][] plan_data = MYDatabase.Search_plan_data_database();
        for (int i = 1; i < plan_data.length; i++) {
        if(plan_data[i][5].equals("Yes")){
       
        plans.add(plan_data[i][1]);
        }
      
        }
        
      list = FXCollections.observableArrayList(plans);
      
      combobox_member_plane.setItems(list);
        
        
        
        
        }
    }
    
    
    
  

    @FXML
    private void conn_id_reader_for_search_update_member(ActionEvent event) {
        Get_RFID_Code get_RFID_Code = new Get_RFID_Code();    
        get_RFID_Code.connect_aruno(tx_id_card_num_update_member_search, imageview_card_update_member,button_conn_idfr_update_member,button_conn_idfr_delete_member); 
        label_search_update_member_err.setVisible(false);
        tx_phone_num_update_member_search.setText("");
        
    }

    @FXML
    private void conn_id_reader_for_search_delete_member(ActionEvent event) {
        Get_RFID_Code get_RFID_Code = new Get_RFID_Code();    
        get_RFID_Code.connect_aruno(tx_id_card_num_delete_member_search, imageview_card_delete_member,button_conn_idfr_delete_member,button_conn_idfr_update_member);
        label_search_delete_member_err.setVisible(false);
        tx_phone_num_delete_member_search.setText("");
    }

 
  
    @FXML
    private void whene_typing_tx_phone_num_update_member_search(MouseEvent event) {
        label_search_update_member_err.setVisible(false);
        tx_id_card_num_update_member_search.setText("");
        imageview_card_update_member.setImage(new Image ("img/rfid_card_standbuy.gif"));
    }

    @FXML
    private void whene_typing_tx_phone_num_delete_member_search(MouseEvent event) {
        label_search_delete_member_err.setVisible(false);
        tx_id_card_num_delete_member_search.setText("");
        imageview_card_delete_member.setImage(new Image ("img/rfid_card_standbuy.gif"));
    }

    @FXML
    private void btn_ok_done(ActionEvent event) {
         hide_all_pane();
        pane_home.visibleProperty().set(true);   
        pane_done.visibleProperty().set(false);
        pane_add_new_member.setEffect(null);
        pane_add_new_staff.setEffect(null);
        pane_send_notification.setEffect(null);
        pane_plan.setEffect(null);
        after_saving_member_data_textfeilds();
        button_conn_idfr_add_new_member.setDisable(false);
        button_conn_idfr_add_new_staff.setDisable(false);
        after_sending_notification();
        after_add_new_plan();
    }

    @FXML
    private void btn_cancel_in_save_update_delete(ActionEvent event) {
          hide_all_pane();
        pane_member_optian.visibleProperty().set(true);   
        after_saving_member_data_textfeilds();
        after_delete_member_data_textfeilds();
        
    }
    
    
    @FXML
    private void btn_cancel_in_save_update_delete_staff(ActionEvent event) {
          hide_all_pane();
        pane_staff_optian.visibleProperty().set(true);   
        after_saving_member_data_textfeilds();
         after_delete_member_data_textfeilds();
        
    }
    
    
    

    @FXML
    private void button_staff(ActionEvent event) {
         hide_all_pane();
        pane_staff_optian.visibleProperty().set(true);
    }

    @FXML
    private void button_add_new_staff(MouseEvent event) {
         hide_all_pane();
        hbox_save_new_staff.setVisible(true);
        hbox_update_staff.setVisible(false);
        hbox_delete_staff.setVisible(false);
        after_saving_member_data_textfeilds();
        pane_add_new_staff.visibleProperty().set(true);
        
         Image im = new Image("img/defult_user_profile.png",false);
         if (!im.isError()){
         circle_image_stuff_add_update_delete.setFill(new ImagePattern(im));}
    }

    @FXML
    private void conn_id_reader_for_search_update_staff(ActionEvent event) {
         Get_RFID_Code get_RFID_Code = new Get_RFID_Code();    
        get_RFID_Code.connect_aruno(tx_id_card_num_update_staff_search, imageview_card_update_staff,button_conn_idfr_update_staff,button_conn_idfr_delete_staff);
        label_search_update_staff_err.setVisible(false);
        tx_phone_num_update_staff_search.setText("");
    }

    @FXML
    private void Search_staff_data_for_update(ActionEvent event) {
        
      
           Search_show_staff_data search_show_staff_data  = new Search_show_staff_data();
           search_show_staff_data.Search_get_staff_data(
                tx_phone_num_update_staff_search,
                tx_id_card_num_update_staff_search,
                label_search_update_staff_err,
                tx_database_id_staff,
                tx_staff_fullName,
                tx_staff_phoneNumber,
                tx_staff_username,
                tx_staff_userpassword,
                tx_staff_birthdate,
                tx_staff_startDate,
                tx_staff_JopTitle,
                tx_staff_User_privileges,
                radio_staff_male,
                radio_staff_female,
                tx_staff_address,
                tx_staff_hint,
                circle_image_stuff_add_update_delete,
                tx_id_card_num_add_new_staff);
        
        if(search_show_staff_data.Is_there_any_data()){   
         hide_all_pane();
        hbox_save_new_staff.setVisible(false);
        hbox_update_staff.setVisible(true);
        hbox_delete_staff.setVisible(false);
        pane_add_new_staff.visibleProperty().set(true);      
              
        tx_id_card_num_update_staff_search.setText("");
        tx_id_card_num_delete_staff_search.setText("");
        tx_phone_num_update_staff_search.setText("");
        tx_phone_num_delete_staff_search.setText("");
        imageview_card_update_staff.setImage(new Image ("img/rfid_card_standbuy.gif"));
        imageview_card_delete_staff.setImage(new Image ("img/rfid_card_standbuy.gif"));
        label_search_update_staff_err.setVisible(false);
        label_search_delete_staff_err.setVisible(false);
        }
        
    }

    @FXML
    private void conn_id_reader_for_search_delete_staff(ActionEvent event) {
        
        Get_RFID_Code get_RFID_Code = new Get_RFID_Code();    
        get_RFID_Code.connect_aruno(tx_id_card_num_delete_staff_search, imageview_card_delete_staff,button_conn_idfr_delete_staff,button_conn_idfr_update_staff);
        label_search_delete_staff_err.setVisible(false);
        tx_phone_num_delete_staff_search.setText("");
    }

    @FXML
    private void Search_staff_data_for_delete(ActionEvent event) {
        
           Search_show_staff_data search_show_staff_data  = new Search_show_staff_data();
        search_show_staff_data.Search_get_staff_data(
                tx_phone_num_delete_staff_search,
                tx_id_card_num_delete_staff_search,
                label_search_delete_staff_err,
                tx_database_id_staff,
                tx_staff_fullName,
                tx_staff_phoneNumber,
                tx_staff_username,
                tx_staff_userpassword,
                tx_staff_birthdate,
                tx_staff_startDate,
                tx_staff_JopTitle,
                tx_staff_User_privileges,
                radio_staff_male,
                radio_staff_female,
                tx_staff_address,
                tx_staff_hint,
                circle_image_stuff_add_update_delete,
                tx_id_card_num_add_new_staff);
        
        
        if(search_show_staff_data.Is_there_any_data()){   
         hide_all_pane();
        hbox_save_new_staff.setVisible(false);
        hbox_update_staff.setVisible(false);
        hbox_delete_staff.setVisible(true);
        pane_add_new_staff.visibleProperty().set(true);      
        
         button_conn_idfr_add_new_member.setDisable(true);
        button_conn_idfr_add_new_staff.setDisable(true);
        
        tx_id_card_num_update_staff_search.setText("");
        tx_id_card_num_delete_staff_search.setText("");
        tx_phone_num_update_staff_search.setText("");
        tx_phone_num_delete_staff_search.setText("");
        imageview_card_update_staff.setImage(new Image ("img/rfid_card_standbuy.gif"));
        imageview_card_delete_staff.setImage(new Image ("img/rfid_card_standbuy.gif"));
        label_search_update_staff_err.setVisible(false);
        label_search_delete_staff_err.setVisible(false);
        }
        
        
    }

    @FXML
    private void save_new_staff_datat(ActionEvent event) {
        
        if(is_all_new_staff_data_valid()){
            
            if(chick_if_rfid_card_not_in_use_for_new_staff()){
      
     //check the val of the checkbox if male or female
    String staff_gender=""; 
    
    if(radio_staff_male.isSelected()){
        staff_gender="male"; 
    }
       
    if(radio_staff_female.isSelected()){
        staff_gender="female"; 
    }

    String staff_fullName =tx_staff_fullName.getText();
    String staff_phoneNumber=tx_staff_phoneNumber.getText();
    String staff_username =tx_staff_username.getText();
    String staff_userpassword=tx_staff_userpassword.getText();
    String staff_birthdate = tx_staff_birthdate.getValue().toString();
    String staff_startdate = tx_staff_startDate.getValue().toString();
    String staff_joptitel = tx_staff_JopTitle.getTypeSelector();
    String staff_UserPrivileges = tx_staff_User_privileges.getTypeSelector();

    String staff_address =tx_staff_address.getText();
    String staff_hint=tx_staff_hint.getText();
    String staff_imageTitel ="34";
    String staff_imagepath =links.default_new_member_profile_img_server_link();
    String RFID =tx_id_card_num_add_new_staff.getText() ;

    
 //send data to members table on database 
MYDatabase.insert_staff_data(
        staff_fullName, 
        staff_phoneNumber,
        staff_username,
        staff_userpassword,
        staff_birthdate,
        staff_startdate,
        staff_joptitel,
        staff_UserPrivileges,
        staff_gender,  
        staff_address,
        staff_hint,
        staff_imageTitel,
        staff_imagepath,
        RFID);
        
        pane_add_new_staff.setEffect(new GaussianBlur());
        pane_done.setVisible(true);
        
            }
            else{
            fontaw_staff_rfid.setVisible(true);
           lab_err_frid_card_in_use_staff.setVisible(true);
            
            }
       }       
    }
    
    
      public boolean is_all_new_staff_data_valid(){
        int validation = 0 ;
        boolean validation_state = false ;
        
        if(tx_staff_fullName.getText().equals("")){fontaw_fullname_staff.setVisible(true);}else{fontaw_fullname_staff.setVisible(false);validation++;}
        if(tx_staff_phoneNumber.getText().equals("")){fontaw_phonenum_staff.setVisible(true);}else{fontaw_phonenum_staff.setVisible(false);validation++;}
        
        if(tx_staff_username.getText().equals("")){fontaw_staff_username.setVisible(true);}else{fontaw_staff_username.setVisible(false);validation++;}
        if(tx_staff_userpassword.getText().equals("")){fontaw_staff_userpassword.setVisible(true);}else{fontaw_staff_userpassword.setVisible(false);validation++;}
        
        if(tx_staff_birthdate.getValue()== null){fontaw_birthdate_staff.setVisible(true);}else{fontaw_birthdate_staff.setVisible(false);validation++;}

        if(tx_staff_startDate.getValue()== null){fontaw_startdate_staff.setVisible(true);}else{fontaw_startdate_staff.setVisible(false);validation++;}
           
        if(tx_staff_JopTitle.getTypeSelector()== null){fontaw_joptitle.setVisible(true);}else{fontaw_joptitle.setVisible(false);validation++;}
        if(tx_staff_User_privileges.getTypeSelector()== null){fontaw_userprivi.setVisible(true);}else{fontaw_userprivi.setVisible(false);validation++;}
        
        if(radio_staff_female.isSelected() == false && radio_staff_male.isSelected() == false )
          {fontaw_staff_gender.setVisible(true);}else{fontaw_staff_gender.setVisible(false);validation++;}
               
        if(tx_staff_address.getText().equals("")){fontaw_address_staff.setVisible(true);}else{fontaw_address_staff.setVisible(false);validation++;}
        
        
        if(tx_staff_hint.getText().equals("")){fontaw_hint_staff.setVisible(true);}else{fontaw_hint_staff.setVisible(false);validation++;}
        
        if(tx_id_card_num_add_new_staff.getText().equals("")){fontaw_staff_rfid.setVisible(true);}else{fontaw_staff_rfid.setVisible(false);validation++;}
         
        if(validation == 12){
           validation_state =true ;}
        
       
        return validation_state;
        
    }
      
     
      

    @FXML
    private void conn_id_reader_add_new_staff(ActionEvent event) {
        Get_RFID_Code get_RFID_Code = new Get_RFID_Code();
        get_RFID_Code.connect_aruno(tx_id_card_num_add_new_staff, imgview_card_add_new_staff,button_conn_idfr_add_new_staff,button_conn_idfr_update_member); 
        fontaw_staff_rfid.setVisible(false);
        lab_err_frid_card_in_use_staff.setVisible(false);
    }

    

    @FXML
    private void delete_staff_datat(ActionEvent event) {
        MYSql_DBConnection Delete = new MYSql_DBConnection();
        Delete.Delete_Data("staff_data", tx_database_id_staff.getText());
        pane_add_new_staff.setEffect(new GaussianBlur());
        pane_done.setVisible(true);
        after_delete_member_data_textfeilds();
    }
    
    @FXML
    private void whene_typing_tx_phone_num_update_staff_search(MouseEvent event) {
         label_search_update_staff_err.setVisible(false);
        tx_id_card_num_update_staff_search.setText("");
        imageview_card_update_staff.setImage(new Image ("img/rfid_card_standbuy.gif"));
    }

    @FXML
    private void whene_typing_tx_phone_num_delete_staff_search(MouseEvent event) {
        label_search_delete_staff_err.setVisible(false);
        tx_id_card_num_delete_staff_search.setText("");
        imageview_card_delete_staff.setImage(new Image ("img/rfid_card_standbuy.gif"));
    }

    @FXML
    private void update_staff_datat(ActionEvent event) {
        
          if(is_all_new_staff_data_valid()){
              if(chick_if_rfid_card_not_in_use_for_update_staff()){
        
        String staff_gender=""; 
    
    if(radio_staff_male.isSelected()){
        staff_gender="male"; 
    }
       
    if(radio_staff_female.isSelected()){
        staff_gender="female"; 
    }
        
        MYSql_DBConnection Update= new MYSql_DBConnection();
        Update.Update_staff_data("staff_data",
                tx_staff_fullName.getText(),
                tx_staff_phoneNumber.getText(),
                tx_staff_username.getText(),
                tx_staff_userpassword.getText(),               
                tx_staff_birthdate.getValue().toString(),
                tx_staff_startDate.getValue().toString(),
                tx_staff_JopTitle.getTypeSelector(),
                tx_staff_User_privileges.getTypeSelector(),
                staff_gender,
                tx_staff_address.getText(),
                tx_staff_hint.getText(),
                tx_id_card_num_add_new_staff.getText(),
                tx_database_id_staff.getText());
        
        pane_add_new_staff.setEffect(new GaussianBlur());       
        pane_done.setVisible(true);
              }
              else{
              fontaw_staff_rfid.setVisible(true);
           lab_err_frid_card_in_use_staff.setVisible(true);
              
              }
        }
        
        
    }
    
    
    public void load_number_of_member_at_the_gym(){
    MYSql_DBConnection bConnection = new MYSql_DBConnection();
    String member_at_gym = Integer.toString(bConnection.row_index_count_for_members_at_the_gym());
    
    txtv_number_of_member_at_the_gym.setText(member_at_gym);
    
    }
    
    
    
    public void load_card_data(){
    
        MYDatabase.get_member_at_the_gym_data(card_count+1, lab_member_name, cir_profile_photo,lab_member_start_tranning_time,lab_member_plane,lab_start_member_date, lab_end_member_date, lab_workout_1_name, workout_1_img, lab_workout_2_name, workout_2_img,btn_next_card_data,btn_previous_card_data,vbox_card,txtv_card_num_1);
        MYDatabase.get_member_at_the_gym_data(card_count+2, lab_member_name1, cir_profile_photo1, lab_member_start_tranning_time_1,lab_member_plane_1,lab_start_member_date_1,lab_end_member_date1, lab_workout_1_name1, workout_1_img1, lab_workout_2_name1, workout_2_img1,btn_next_card_data,btn_previous_card_data,vbox_card1,txtv_card_num_2);
        MYDatabase.get_member_at_the_gym_data(card_count+3, lab_member_name11, cir_profile_photo11,lab_member_start_tranning_time_2,lab_member_plane_2,lab_start_member_date_2, lab_end_member_date11, lab_workout_1_name11, workout_1_img11, lab_workout_2_name11, workout_2_img11,btn_next_card_data,btn_previous_card_data,vbox_card11,txtv_card_num_3);
        MYDatabase.get_member_at_the_gym_data(card_count+4, lab_member_name111, cir_profile_photo111,lab_member_start_tranning_time_3,lab_member_plane_3,lab_start_member_date_3, lab_end_member_date111, lab_workout_1_name111, workout_1_img111, lab_workout_2_name111, workout_2_img111,btn_next_card_data,btn_previous_card_data,vbox_card111,txtv_card_num_4);

    }
    
    

    @FXML
    private void log_in_on_enter(KeyEvent event) {
    }

    @FXML
    private void connect_aruno(MouseEvent event) {
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
    private void NotificationTitelKeyRelease(KeyEvent event) {
       lab_Notif_titel.setText(edtxt_Notif_titel.getText());
       lab_notification_err.setVisible(false);
    }

    @FXML
    private void NotificationARTEXTKeyRelease(KeyEvent event) {
        lab_Notif_body_ar.setText(edtxt_AR_text.getText());
        lab_notification_err.setVisible(false);
    }

    @FXML
    private void NotificationENTEXTKeyRelease(KeyEvent event) {    
        lab_Notif_body_en.setText(edtxt_EN_text.getText());
        lab_notification_err.setVisible(false);
    }

    @FXML
    private void NotificationLINKSKeyRelease(KeyEvent event) {   
        lab_Notif_body_links.setText(edtxt_links_text.getText());
        lab_notification_err.setVisible(false);
    }

    @FXML
    private void btn_notification(ActionEvent event) {
         hide_all_pane();
        pane_send_notification.visibleProperty().set(true);   
    }
    
    String icon_name = "";
    @FXML
    private void ComboBoxGetNotificationIcon(ActionEvent event) {
         icon_name = combo_notification_icon.getValue();
         lab_notification_err.setVisible(false);
        
        if(icon_name.equals("Product")){
            Image im = new Image("img/icon_product.png",false);
            circle_image_notification_icon.setFill(new ImagePattern(im)); 
            
        }
        
        if(icon_name.equals("Card")){
            Image Card = new Image("img/icon_card.png",false);
            circle_image_notification_icon.setFill(new ImagePattern(Card));  
        }
        
        if(icon_name.equals("Caution")){
           Image Caution = new Image("img/icon_caution.png",false);
           circle_image_notification_icon.setFill(new ImagePattern(Caution)); 
        }
        
        if(icon_name.equals("Idea")){
          Image Idea = new Image("img/icon_idea.png",false);
          circle_image_notification_icon.setFill(new ImagePattern(Idea)); 
        }
        
        if(icon_name.equals("Info")){
          Image Info = new Image("img/icon_info.png",false);
                circle_image_notification_icon.setFill(new ImagePattern(Info)); 
        }
        
        if(icon_name.equals("Question")){
          Image Question = new Image("img/icon_question.png",false);
          circle_image_notification_icon.setFill(new ImagePattern(Question)); 
        }
        
        if(icon_name.equals("Sale")){
          Image Sale = new Image("img/icon_sale.png",false);
          circle_image_notification_icon.setFill(new ImagePattern(Sale));
        }
            
    }

    @FXML
    private void SendNotification(ActionEvent event) {
        String AR = lab_Notif_body_ar.getText();
        String EN = lab_Notif_body_en.getText();
        String links = lab_Notif_body_links.getText();
        String BODY = AR+EN+links ; 
        
        
        if(lab_Notif_titel.getText().equals("")||icon_name.equals("")||BODY.equals("")){       
        lab_notification_err.setVisible(true);
        }
        
        else{    
        BODY = AR +System.lineSeparator()+EN+System.lineSeparator()+links ;
        lab_notification_err.setVisible(false);
        MYSql_DBConnection bConnection = new MYSql_DBConnection();
        bConnection.insert_notification(lab_Notif_titel.getText(),BODY,Time_date(), icon_name);
        pane_send_notification.setEffect(new GaussianBlur());       
        pane_done.setVisible(true);
        }
    }
    
    
    public void after_sending_notification(){
        edtxt_Notif_titel.setText("");
        lab_Notif_titel.setText("");
        
        combo_notification_icon.setValue("");
        circle_image_notification_icon.setFill(Color.valueOf("#060f14"));
        
        edtxt_AR_text.setText("");
        lab_Notif_body_ar.setText("");
        
        edtxt_EN_text.setText("");
        lab_Notif_body_en.setText("");
        
        edtxt_links_text.setText("");
        lab_Notif_body_links.setText("");
    
    
    }
     


  
       public String Time_date(){
    
    DateFormat df = new SimpleDateFormat("dd-MMMM HH:mm a");
  //  DateFormat df = new SimpleDateFormat("hh:mm aa");
    Date date = new Date(System.currentTimeMillis());
    String time = df.format(date);
    
    
    return time ;
    }
       
       
       
       
    public boolean chick_if_rfid_card_not_in_use_for_new_member(){
      boolean avalabel = true ;    
        MYSql_DBConnection DB_connection = new MYSql_DBConnection();
        String[][] get_Data = DB_connection.Search_member_data_database();    
        for (int i = 0; i < get_Data.length; i++) {
            if (tx_id_card_num_add_new_member.getText().equals(get_Data[i][15])) {
                avalabel = false;
                fontaw_rfid.setVisible(true);
                lab_err_frid_card_in_use.setVisible(true);
            }
    }
     return avalabel ;   
    }
    
    
    public boolean chick_if_plan_name_not_in_use_for_new_plan(){
      boolean avalabel = true ;    
        String[][] get_Data = MYDatabase.Search_plan_data_database();    
        for (int i = 0; i < get_Data.length; i++) {
            if (txt_plan_name.getText().equals(get_Data[i][1])) {
                avalabel = false;
                lab_plan_err.setVisible(true);
                lab_plan_err.setText("please use another plan name this name is already in use");
            }
    }
     return avalabel ;   
    }
    
    
     public boolean chick_if_plan_name_not_in_use_for_update_plan(){
      boolean avalabel = true ;    
        MYSql_DBConnection DB_connection = new MYSql_DBConnection();
        String[][] get_Data = DB_connection.Search_plan_data_database();    
        
        String plan_name = DB_connection.get_plan_name_by_id(plan_id);
        
        for (int i = 0; i < get_Data.length; i++) {
            if (txt_plan_name.getText().equals(get_Data[i][1]) && !txt_plan_name.getText().equals(plan_name) ) {
                avalabel = false;
               lab_plan_err.setVisible(true);
                lab_plan_err.setText("please use another plan name this name is already in use");
            }
    }
     return avalabel ;   
    }
    
    
    
    
    
    
    
    
     public int plan_in_use_status(String plan_name){
      int use_count = 0 ;    
        String[][] get_Data = MYDatabase.Search_member_data_database();    
        for (int i = 0; i < get_Data.length; i++) {
            if (plan_name.equals(get_Data[i][6])) {
                use_count = use_count+1;
            }
    }
     return use_count ;   
    }
    
    
    
     public boolean chick_if_rfid_card_not_in_use_for_update_member(){
      boolean avalabel = true ;    
        MYSql_DBConnection DB_connection = new MYSql_DBConnection();
        String[][] get_Data = DB_connection.Search_member_data_database();    
        
        String user_rfid = DB_connection.get_member_rfid_by_id(tx_database_id.getText());
        
        for (int i = 0; i < get_Data.length; i++) {
            if (tx_id_card_num_add_new_member.getText().equals(get_Data[i][15]) && !tx_id_card_num_add_new_member.getText().equals(user_rfid) ) {
                avalabel = false;
                fontaw_rfid.setVisible(true);
                lab_err_frid_card_in_use.setVisible(true);
            }
    }
     return avalabel ;   
    }
     
     

     public boolean chick_if_rfid_card_not_in_use_for_new_staff(){
      boolean avalabel = true ;    
        MYSql_DBConnection DB_connection = new MYSql_DBConnection();
        String[][] get_Data = DB_connection.Search_staff_data_database();    
        for (int i = 0; i < get_Data.length; i++) {
            if (tx_id_card_num_add_new_staff.getText().equals(get_Data[i][14])) {
                avalabel = false;
                fontaw_staff_rfid.setVisible(true);
                lab_err_frid_card_in_use_staff.setVisible(true);
            }
    }
     return avalabel ;   
    }
    
     public boolean chick_if_rfid_card_not_in_use_for_update_staff(){
      boolean avalabel = true ;    
        MYSql_DBConnection DB_connection = new MYSql_DBConnection();
        String[][] get_Data = DB_connection.Search_staff_data_database();    
        
        String user_rfid = DB_connection.get_staff_rfid_by_id(tx_database_id_staff.getText());
        
        for (int i = 0; i < get_Data.length; i++) {
            if (tx_id_card_num_add_new_staff.getText().equals(get_Data[i][14]) && !tx_id_card_num_add_new_staff.getText().equals(user_rfid) ) {
                avalabel = false;
                fontaw_staff_rfid.setVisible(true);
                lab_err_frid_card_in_use_staff.setVisible(true);
            }
    }
     return avalabel ;   
    }

    @FXML
    private void button_plans_manager(ActionEvent event) {
        hide_all_pane();
        pane_plan.visibleProperty().set(true);       
        table_plan.setItems(generateDataInMap());
        table_plan.getSelectionModel().clearSelection();
        after_add_new_plan();
        button_update_plan.setDisable(true);
        button_delete_plan.setDisable(true);
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
     
     
     String plan_img = "";
     String plan_duration = "";
     int total_choose_plan_image_count = 0 ;
     public void Show_and_Hide_choose_plan_image(ImageView imageView){
      
        if(!imageView.isVisible()&&total_choose_plan_image_count < 1){
        imageView.setVisible(true);

        if(plan_img.equals("")){
        plan_img = imageView.getId();
        
        switch (plan_img) {
       
        case "img_chos_1mon":
        plan_duration = "1";
        break;
        case "img_chos_2mon":
        plan_duration = "2";
        break;
        case "img_chos_3mon":
        plan_duration = "3";
        break;
        case "img_chos_4mon":
        plan_duration = "4";
        break;
        case "img_chos_5mon":
        plan_duration = "5";
        break;
        case "img_chos_6mon":
        plan_duration = "6";
        break;
        case "img_chos_7mon":
        plan_duration = "7";
        break;
        case "img_chos_8mon":
        plan_duration = "8";
        break;
        case "img_chos_9mon":
        plan_duration = "9";
        break;
        case "img_chos_10mon":
        plan_duration = "10";
        break;
        case "img_chos_11mon":
        plan_duration = "11";
        break;
        case "img_chos_12mon":
        plan_duration = "12";
        break;
        }
        
        }
       

        
        total_choose_plan_image_count = total_choose_plan_image_count + 1 ;
          
        }else if(imageView.isVisible()){
             imageView.setVisible(false);
            total_choose_plan_image_count = total_choose_plan_image_count - 1 ;  
            plan_img = "";
            plan_duration = "";
            
          
            
        }
       
        if(total_choose_plan_image_count == 0){
        plan_img = "";
        plan_duration = "";
       
        }
        
        
  
    }
     
     
     
     


    @FXML
    private void save_new_plan_datat(ActionEvent event) {
        
        String plan_available = "";
        String plan_name ="";
        String plan_description ="";
        String plan_duration ="";
        String plan_price ="";
        
        if(checkbox_plan_available.isSelected()){plan_available = "Yes";}else{plan_available = "No";}
        plan_name = txt_plan_name.getText();
        plan_description = txt_plan_desc.getText();
        plan_duration = this.plan_duration ;
        plan_price = txt_plan_price.getText();
        
        
        if(chick_if_plan_name_not_in_use_for_new_plan()){
        
        
        
        if(plan_available.equals("") || plan_name.equals("") || plan_description.equals("") || plan_duration.equals("") || plan_price.equals(""))
        {
        
        lab_plan_err.setVisible(true);
        lab_plan_err.setText("complete all required fields");

        }
        else if(plan_name.contains(",") || plan_name.substring(0,1).equals(" ")){ 
         lab_plan_err.setVisible(true);
        lab_plan_err.setText("plan name can only contains letters , numbers and can't start with space");       
        }
        else if(!plan_price.matches("[0-9]+")){
        lab_plan_err.setVisible(true);
        lab_plan_err.setText("plan price can only contains numbers");     
        }
        else if (!plan_name.matches("^[a-zA-Z0-9 ]+$") || !plan_description.matches("^[a-zA-Z0-9 ]+$")){
        lab_plan_err.setVisible(true);
        lab_plan_err.setText("plan name and description can only contains letters and numbers");        
        }
        else{
        
            MYDatabase.insert_plan_data(plan_name, plan_description, plan_duration, plan_price, plan_available);
            
             // after saving new plan   
             pane_plan.setEffect(new GaussianBlur());       
             pane_done.setVisible(true);
 
        }
        }
           
    }
    
    
    
    
    public void after_add_new_plan(){
        
             lab_plan_err.setVisible(false);
             lab_plan_err.setText("");
             
             button_update_plan.setDisable(true);
             button_delete_plan.setDisable(true);
              
             checkbox_plan_available.selectedProperty().set(true);
             txt_plan_name.setText("");
             txt_plan_desc.setText("");
             txt_plan_price.setText("");
             this.plan_duration = "" ;
             plan_img = "" ;
             img_chos_1mon.setVisible(false);
             img_chos_2mon.setVisible(false);
             img_chos_3mon.setVisible(false);
             img_chos_4mon.setVisible(false);
             img_chos_5mon.setVisible(false);
             img_chos_6mon.setVisible(false);
             img_chos_7mon.setVisible(false);
             img_chos_8mon.setVisible(false);
             img_chos_9mon.setVisible(false);
             img_chos_10mon.setVisible(false);
             img_chos_11mon.setVisible(false);
             img_chos_12mon.setVisible(false);
             
             plan_img = "";
             plan_duration = "";
             total_choose_plan_image_count = 0 ;         
    }
    
    
    
    

    @FXML
    private void choose_1_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_1mon);
    }

    @FXML
    private void choose_2_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_2mon);
    }

    @FXML
    private void choose_3_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_3mon);
    }

    @FXML
    private void choose_4_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_4mon);
    }

    @FXML
    private void choose_5_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_5mon);
    }

    @FXML
    private void choose_6_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_6mon);
    }

    @FXML
    private void choose_7_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_7mon);
    }

    @FXML
    private void choose_8_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_8mon);
    }

    @FXML
    private void choose_9_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_9mon);
    }

    @FXML
    private void choose_10_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_10mon);
    }

    @FXML
    private void choose_11_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_11mon);
    }

    @FXML
    private void choose_12_month_plan(MouseEvent event) {
        Show_and_Hide_choose_plan_image(img_chos_12mon);
    }

    @FXML
    private void btn_cancel_plan(ActionEvent event) {
          hide_all_pane();
        pane_home.visibleProperty().set(true); 
        after_add_new_plan();
    }

    @FXML
    private void btn_delete_plan(ActionEvent event) {
        if(chick_if_plan_name_not_in_use_for_update_plan()){
        MYSql_DBConnection delete = new MYSql_DBConnection();
        delete.Delete_plan(txt_plan_name.getText());
        table_plan.setItems(generateDataInMap());
        after_add_new_plan();
        }
    }

    @FXML
    private void btn_update_plan(ActionEvent event) {
        
        
          
        String plan_available = "";
        String plan_name ="";
        String plan_description ="";
        String plan_duration ="";
        String plan_price ="";
        
        if(checkbox_plan_available.isSelected()){plan_available = "Yes";}else{plan_available = "No";}
        plan_name = txt_plan_name.getText();
        plan_description = txt_plan_desc.getText();
        plan_duration = this.plan_duration ;
        plan_price = txt_plan_price.getText();
        
        
        if(chick_if_plan_name_not_in_use_for_update_plan()){
        
        
        
        if(plan_available.equals("") || plan_name.equals("") || plan_description.equals("") || plan_duration.equals("") || plan_price.equals(""))
        {
        
        lab_plan_err.setVisible(true);
        lab_plan_err.setText("complete all required fields");

        }
        else if(plan_name.contains(",") || plan_name.substring(0,1).equals(" ")){ 
         lab_plan_err.setVisible(true);
        lab_plan_err.setText("plan name can only contains letters , numbers and can't start with space");       
        }
        else if(!plan_price.matches("[0-9]+")){
        lab_plan_err.setVisible(true);
        lab_plan_err.setText("plan price can only contains numbers");     
        }
        else if (!plan_name.matches("^[a-zA-Z0-9 ]+$") || !plan_description.matches("^[a-zA-Z0-9 ]+$")){
        lab_plan_err.setVisible(true);
        lab_plan_err.setText("plan name and description can only contains letters and numbers");        
        }
        else{
        MYSql_DBConnection dBConnection = new MYSql_DBConnection();
            dBConnection.Update_plan_data(plan_name, plan_description, plan_duration, plan_price, plan_available,plan_id);  
            after_add_new_plan();
            table_plan.setItems(generateDataInMap());
 
        }
        }
                
    }

    @FXML
    private void update_plan_available_checkbox_database(MouseEvent event) {
        
        if(checkbox_plan_available.isSelected()){
        MYDatabase.update_plan_status(txt_plan_name.getText(), "Yes");
        table_plan.setItems(generateDataInMap());
        }
        else{
        MYDatabase.update_plan_status(txt_plan_name.getText(), "No");
        table_plan.setItems(generateDataInMap());
        }
          
        
           
    }

  
    
    @FXML
    private void when_choose_plan_from_combobox(ActionEvent event) {
        //  combobox_member_plane.getSelectionModel().selectFirst();
        if(combobox_member_plane.getSelectionModel().getSelectedItem() != null){
            
            String paln_name  = combobox_member_plane.getSelectionModel().getSelectedItem().toString();
                       
            if(i_update){
            MYDatabase.get_plan_data_to_update(paln_name, txt_plan_total_price, lab_plan_month, lab_plan_days); 
            i_update = false ;
            }
            else{
            MYDatabase.calc_plan_duration(paln_name, txt_plan_total_price ,lab_tx_member_startDate, lab_tx_member_endDate,lab_plan_month,lab_plan_days);
            }
            
         
                               
            
            
           
        
        
        }
        
    }


    

    
    }
    
    
    
    
    
   
