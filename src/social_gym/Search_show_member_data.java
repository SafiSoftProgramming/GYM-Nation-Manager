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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author root
 */
public class Search_show_member_data {
    
    
    boolean access = false;
    
    Server_Links links = new Server_Links();

    public void Search_get_member_data(JFXTextField tx_input_member_phone, JFXTextField tx_input_member_RFID,Label label_search_member_err,
            JFXTextField database_id,
            JFXTextField full_name,
            JFXTextField phone_number,
            JFXDatePicker registration_date,
            Label start_date,
            Label end_date,
            ComboBox plane,
            RadioButton radioB_male,      
            RadioButton radioB_female,
            JFXTextField weight_kg,
            JFXTextField height_cm,
            JFXDatePicker birthdate,
            JFXTextField address,
            JFXTextField hint,
            Circle circle_image_member_add_update_delete,
        
            JFXTextField RFID) {

        MYSql_DBConnection DB_connection = new MYSql_DBConnection();
        String[][] get_Data = DB_connection.Search_member_data_database();

        for (int i = 0; i < get_Data.length; i++) {

            if (tx_input_member_RFID.getText().equals(get_Data[i][15]) || tx_input_member_phone.getText().equals(get_Data[i][2])) {

                access = true;

                 database_id.setText(get_Data[i][0]);
                 full_name.setText(get_Data[i][1]);
                 phone_number.setText(get_Data[i][2]);
                 
                 String registration_date_st = get_Data[i][3];
                 LocalDate registration_date_val = LocalDate.parse(registration_date_st);     
                 registration_date.setValue(registration_date_val);
                 
                 String start_date_st = get_Data[i][4];
                 LocalDate start_date_val = LocalDate.parse(start_date_st);
                 start_date.setText(start_date_val.toString());
                 
                 String end_date_st = get_Data[i][5];
                 LocalDate end_date_val = LocalDate.parse(end_date_st);
                 end_date.setText(end_date_val.toString());
                 
               
                 
                 plane.setValue(get_Data[i][6]);
                
                 
                 String gender = get_Data[i][7];
                 if (gender.equals("male")){radioB_male.setSelected(true);radioB_female.setSelected(false);}
                 if (gender.equals("female")){radioB_female.setSelected(true);radioB_male.setSelected(false);}
                
                 weight_kg.setText(get_Data[i][8]);
                 height_cm.setText(get_Data[i][9]);
                                              
                 String birthdate_st = get_Data[i][10];
                 LocalDate birthdate_val = LocalDate.parse(birthdate_st);
                 birthdate.setValue(birthdate_val);
                                                 
                 address.setText(get_Data[i][11]);
                 hint.setText(get_Data[i][12]);
                 
                 
                 
                  Image im = new Image(links.Server_url()+get_Data[i][14]);
                  if (!im.isError()){
                  circle_image_member_add_update_delete.setFill(new ImagePattern(im));
                  }
                 
                 
                
                 RFID.setText(get_Data[i][15]);
             
                try {
                    DB_connection.rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Search_show_member_data.class.getName()).log(Level.SEVERE, null, ex);
                }
               

            }
        }
        if (access == false) {
           label_search_member_err.setVisible(true);
           
            access = false;
        }
        
       

    }
    
    
    
    
   public boolean Is_there_any_data(){
        return access;
   }
 

}
