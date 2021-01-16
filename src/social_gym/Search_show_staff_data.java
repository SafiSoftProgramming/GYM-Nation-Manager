/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social_gym;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author root
 */
public class Search_show_staff_data {
   boolean access = false;
    Server_Links links = new Server_Links();

    public void Search_get_staff_data(JFXTextField tx_input_staff_phone, JFXTextField tx_input_staff_RFID,Label label_search_staff_err,
            JFXTextField database_id,
            JFXTextField full_name,
            JFXTextField phone_number,
            JFXTextField staff_user_name,
            JFXTextField staff_password,
            JFXDatePicker birthdate,
            JFXDatePicker start_date,
            JFXComboBox staff_jop_title,
            JFXComboBox staff_user_privileges,
            RadioButton radioB_male,      
            RadioButton radioB_female,
            JFXTextField address,
            JFXTextField hint,  
            Circle circle_image_stuff_add_update_delete,
            JFXTextField RFID) {

        MYSql_DBConnection DB_connection = new MYSql_DBConnection();
        String[][] get_Data = DB_connection.Search_staff_data_database();

        for (int i = 0; i < get_Data.length; i++) {

            if (tx_input_staff_RFID.getText().equals(get_Data[i][14]) || tx_input_staff_phone.getText().equals(get_Data[i][2])) {

                access = true;

                 database_id.setText(get_Data[i][0]);
                 full_name.setText(get_Data[i][1]);
                 phone_number.setText(get_Data[i][2]);
                 staff_user_name.setText(get_Data[i][3]);
                 staff_password.setText(get_Data[i][4]);
                 
                 String birthdate_st = get_Data[i][5];
                 LocalDate birthdate_val = LocalDate.parse(birthdate_st);
                 birthdate.setValue(birthdate_val);
                                
                 String start_date_st = get_Data[i][6];
                 LocalDate start_date_val = LocalDate.parse(start_date_st);
                 start_date.setValue(start_date_val);
                
                 String gender = get_Data[i][9];
                 if (gender.equals("male")){radioB_male.setSelected(true);radioB_female.setSelected(false);}
                 if (gender.equals("female")){radioB_female.setSelected(true);radioB_male.setSelected(false);}
                
                /////
                
                                                 
                 address.setText(get_Data[i][10]);
                 hint.setText(get_Data[i][11]);
                 
                 
                 
                  Image im = new Image(links.Server_url()+get_Data[i][13]);
                  if (!im.isError()){
                  circle_image_stuff_add_update_delete.setFill(new ImagePattern(im));
                  }
                 
                 
                
                 RFID.setText(get_Data[i][14]);
             
                try {
                    DB_connection.rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Search_show_member_data.class.getName()).log(Level.SEVERE, null, ex);
                }
               

            }
        }
        if (access == false) {
           label_search_staff_err.setVisible(true);
           
            access = false;
        }
        
       

    }
    
    
    
    
   public boolean Is_there_any_data(){
        return access;
   }
 

}
