/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social_gym;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author SafiSoft
 */
public class MYSql_DBConnection {
    
    private Connection con ;
    private Statement st ;
    public ResultSet rs ;
    public boolean conn ;
    public Timer  timer_ad_pic ;
    
    Server_Links links = new Server_Links() ;
    
    String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
    
    
   
    
    
    public MYSql_DBConnection(){
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");   
           // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_gym","root",""); 
            //   con = DriverManager.getConnection("jdbc:mysql://localhost/Social_Gym"+unicode,"root",""); 
             con = DriverManager.getConnection(links.DataBase_link()+unicode,links.DataBase_user_name(),links.DataBase_password()); 


            st = con.createStatement();  
            conn = true;
            
        } catch (Exception ex) {
            
            System.out.println("nott net"+ex);
            conn = false;
            
            
        }
       
    }
    
 
    
    public Connection MYSql_DBConnectionn(){
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");   
           // con = DriverManager.getConnection("jdbc:mysql://localhost:3306/social_gym","root",""); 
        con = DriverManager.getConnection(links.DataBase_link()+unicode,links.DataBase_user_name(),links.DataBase_password()); 
            st = con.createStatement();  
            conn = true;
            
        } catch (Exception ex) {
            
            System.out.println("not net");
            conn = false;
            
            
        }
        return null;
    }
    
    
    
    private int row_index_count_for_staff(){       
        int index = 0 ;       
        try {
            String query = "select * from staff_data ";
            rs =st.executeQuery(query);
            rs.last();         
            index = rs.getRow() ;           
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return index ;
    
    }
    
    

    public int row_index_count_for_members(){       
        int index = 0 ;       
        try {
            String query = "select * from member_data ";
            rs =st.executeQuery(query);
            rs.last();         
            index = rs.getRow() ;           
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return index ;
    
    }
    
    
     public int row_index_count_for_plan(){       
        int index = 0 ;       
        try {
            String query = "select * from plan_data ";
            rs =st.executeQuery(query);
            rs.last();         
            index = rs.getRow() ;           
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return index ;
    
    }
    
    
    
    
    
      public String [][] Search_staff_data_database(){ 
         String[][] all_staff_data = new String[row_index_count_for_staff()][15];
        try {            
            String query = "select * from staff_data ";
            rs =st.executeQuery(query);          
            int count =0 ;
            while(rs.next()){             
             all_staff_data[count][0]=rs.getString("_id");
             all_staff_data[count][1]=rs.getString("full_name");
             all_staff_data[count][2]=rs.getString("phone_number");
             all_staff_data[count][3]=rs.getString("user_name");
             all_staff_data[count][4]=rs.getString("user_password");  
             all_staff_data[count][5]=rs.getString("staff_birthdate");
             all_staff_data[count][6]=rs.getString("staff_start_date");
             all_staff_data[count][7]=rs.getString("jop_title");
             all_staff_data[count][8]=rs.getString("user_privileges");         
             all_staff_data[count][9]=rs.getString("gender");
             all_staff_data[count][10]=rs.getString("staff_address");
             all_staff_data[count][11]=rs.getString("staff_hint");
             all_staff_data[count][12]=rs.getString("image_titel");
             all_staff_data[count][13]=rs.getString("image");
             all_staff_data[count][14]=rs.getString("RFID"); 
             count++ ;
            }
            //con.close();             
        } catch (Exception e) {
            System.err.println(e);
        }
     
    return all_staff_data ;
    }
    
    
     public String [][] Search_member_data_database(){ 
         String[][] all_member_data = new String[row_index_count_for_members()][16];
        try {            
            String query = "select * from member_data ";
            rs =st.executeQuery(query);          
            int count =0 ;
            while(rs.next()){             
             all_member_data[count][0]=rs.getString("_id");
             all_member_data[count][1]=rs.getString("full_name");
             all_member_data[count][2]=rs.getString("phone_number");
             all_member_data[count][3]=rs.getString("registration_date");
             all_member_data[count][4]=rs.getString("start_date");  
             all_member_data[count][5]=rs.getString("end_date");
             all_member_data[count][6]=rs.getString("plane");
             all_member_data[count][7]=rs.getString("gender");
             all_member_data[count][8]=rs.getString("weight_kg");
             all_member_data[count][9]=rs.getString("height_cm");          
             all_member_data[count][10]=rs.getString("birthdate");
             all_member_data[count][11]=rs.getString("address");
             all_member_data[count][12]=rs.getString("hint");
             all_member_data[count][13]=rs.getString("img_title");
             all_member_data[count][14]=rs.getString("image"); 
             all_member_data[count][15]=rs.getString("RFID"); 
             count++ ;
            }
            //con.close();             
        } catch (Exception e) {
            System.err.println(e);
        }
     
    return all_member_data ;
    }

     
     
     public String [][] Search_plan_data_database(){ 
         String[][] all_plan_data = new String[row_index_count_for_plan()][6];
        try {            
            String query = "select * from plan_data ";
            rs =st.executeQuery(query);          
            int count =0 ;
            while(rs.next()){             
             all_plan_data[count][0]=rs.getString("_id");
             all_plan_data[count][1]=rs.getString("plan_name");
             all_plan_data[count][2]=rs.getString("plan_description");
             all_plan_data[count][3]=rs.getString("plan_duration");
             all_plan_data[count][4]=rs.getString("plan_price");  
             all_plan_data[count][5]=rs.getString("plan_available");
             count++ ;
            }
            //con.close();             
        } catch (Exception e) {
            System.err.println(e);
        }
     
    return all_plan_data ;
    }
     
     
     
    public String [][] Search_member_at_the_gym_data_database(){ 
         String[][] all_member_at_gym_rfid = new String[row_index_count_for_members_at_the_gym()][4];
        try {            
            String query = "select * from members_at_the_gym ";
            rs =st.executeQuery(query);          
            int count =0 ;
            while(rs.next()){             
             all_member_at_gym_rfid[count][0]=rs.getString("rfid");
             all_member_at_gym_rfid[count][1]=rs.getString("_id");
             all_member_at_gym_rfid[count][2]=rs.getString("member_photo");
             all_member_at_gym_rfid[count][3]=rs.getString("member_name");
             count++ ;
            }
            //con.close();             
        } catch (Exception e) {
            System.err.println(e);
        }
     
    return all_member_at_gym_rfid ;
    }
    
    
   
     
    
    
    
    public void close_database_conection(){
    
        try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println("SQLException Finally: - " + e);
            }

    }
    
    
    
    //add member data to "member_data" tabel include image
    public void insert_member_data(String FullName,String PhoneNumber,String RegistrationDate,String StartDate,String EndDate,String Plane,String Gender,String WeightKg,String HeightCm,String Birthdate,String Address,String Hint,String ImgTitel,String image_path,String RFID) {
 
        try {
            PreparedStatement pstmt= con.prepareStatement("insert into member_data("
                    + "full_name,phone_number,registration_Date,"
                    + "start_Date,end_Date,plane,"
                    + "gender,weight_Kg,height_Cm,"
                    + "birthdate,address,hint,img_title, image,RFID) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                   
            pstmt.setString(1,FullName);
            pstmt.setString(2, PhoneNumber);
            pstmt.setString(3, RegistrationDate);
            pstmt.setString(4, StartDate);
            pstmt.setString(5, EndDate);
            pstmt.setString(6, Plane);
            pstmt.setString(7, Gender);
            pstmt.setString(8, WeightKg);
            pstmt.setString(9, HeightCm);
            pstmt.setString(10, Birthdate);
            pstmt.setString(11, Address);
            pstmt.setString(12, Hint);
            pstmt.setString(13, ImgTitel);
            pstmt.setString(14, image_path);
            pstmt.setString(15, RFID);
 
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
 
        
        }
           
    }
    
    
    
    
     public void insert_plan_data(String PlanName,String PlanDescription,String PlanDuration,String PlanPrice,String PlanAvailable) {
 
        try {
            PreparedStatement pstmt= con.prepareStatement("insert into plan_data("
                    + "plan_name,plan_description,plan_duration,plan_price, plan_available) " + "values(?,?,?,?,?)");
                   
            pstmt.setString(1,PlanName);
            pstmt.setString(2, PlanDescription);
            pstmt.setString(3, PlanDuration);
            pstmt.setString(4, PlanPrice);
            pstmt.setString(5, PlanAvailable);
           
            
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
 
        
        }
           
    }
     
     
    public void update_plan_status(String plan_name,String PlanAvailable_status) { 
        try {
            PreparedStatement pstmt= con.prepareStatement("UPDATE plan_data SET plan_available = ? WHERE plan_name = ?");                  
            pstmt.setString(1,PlanAvailable_status);
            pstmt.setString(2,plan_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {      
        }
    }
    
     public void Update_member_data(String tabel_name,
             String full_name,
             String phone_number,
             String registration_date,
             String start_date,
             String end_date,
             String plane,
             String gender,
             String weight,
             String height,
             String birthdate,
             String address,
             String hint,
             String rfid,
             String _id){
         
         String sql = "UPDATE "+tabel_name+" SET full_name = ? , "
                + "phone_number = ?, "
                + "registration_date = ?, "
                + "start_date = ?, "
                + "end_date = ?, "
                + "plane = ?, "
                + "gender = ?, "
                + "weight_kg = ?, "
                + "height_cm = ?, "
                + "birthdate = ?, "
                + "address = ?, "
                + "hint = ?, "
                + "rfid = ? "
                + "WHERE _id = ?";
         
          try (Connection conn = this.con;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, full_name);
            pstmt.setString(2, phone_number);
            pstmt.setString(3, registration_date);
            pstmt.setString(4, start_date);
            pstmt.setString(5, end_date);
            pstmt.setString(6, plane);
            pstmt.setString(7, gender);
            pstmt.setString(8, weight);
            pstmt.setString(9, height);
            pstmt.setString(10, birthdate);
            pstmt.setString(11, address);
            pstmt.setString(12, hint);
            pstmt.setString(13, rfid);
            pstmt.setString(14, _id);

            // update 
            pstmt.executeUpdate();
            System.out.println("updatee data done");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
         
     
     }
    
    

    
    
     public void insert_staff_data(
             String FullName,
             String PhoneNumber,
             String UserName,
             String UserPassword,
             String StaffBirthdate,
             String StaffStartDate,
             String JopTitel,
             String UserPrivileges,
             String Gender,
             String StaffAddess,
             String StaffHint,
             String image_titel,
             String image_path,
             String RFID) {
      
             
 
        try {
             
            PreparedStatement pstmt= con.prepareStatement("insert into staff_data("
                    + "full_name,phone_number,user_name,"
                    + "user_password,staff_birthdate,staff_start_date,"
                    + "jop_title,user_privileges,gender,"
                    + "staff_address,staff_hint,image_titel,image,RFID) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                   
            pstmt.setString(1,FullName);
            pstmt.setString(2, PhoneNumber);
            pstmt.setString(3, UserName);
            pstmt.setString(4, UserPassword);
            pstmt.setString(5, StaffBirthdate);
            pstmt.setString(6, StaffStartDate);
            pstmt.setString(7, JopTitel);
            pstmt.setString(8, UserPrivileges);
            pstmt.setString(9, Gender);
            pstmt.setString(10, StaffAddess);
            pstmt.setString(11, StaffHint);        
            pstmt.setString(12, image_titel);
            pstmt.setString(13, image_path);
            pstmt.setString(14, RFID);
 
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
 
        
        }
           
    }
    
    
    
     public void Delete_Data(String tabel_name ,String rfid) {
        String sql = "DELETE FROM "+tabel_name+" WHERE _id = ?";
 
        try (Connection conn = this.con;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1,rfid);
            // execute the delete statement
            pstmt.executeUpdate();
            
            System.out.println("data deleted");
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
     
     
     public void Delete_plan(String plan_name) {
        String sql = "DELETE FROM plan_data WHERE plan_name = ?";
        try (Connection conn = this.con;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,plan_name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
     
     
     
     
     
     public void Update_plan_data(
             String plan_name,
             String plan_description,
             String plan_duration,
             String plan_price,
             String plan_available,
             String _id){
         
         String sql = "UPDATE plan_data SET plan_name = ? , "
                + "plan_description = ?, "
                + "plan_duration = ?, "
                + "plan_price = ?, "
                + "plan_available = ? "
                + "WHERE _id = ?";
         
          try (Connection conn = this.con;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, plan_name);
            pstmt.setString(2, plan_description);
            pstmt.setString(3, plan_duration);
            pstmt.setString(4, plan_price);
            pstmt.setString(5, plan_available);
            pstmt.setString(6, _id);

            // update 
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
         
     
     }
     
     
       public void Update_staff_data(String tabel_name,
             String FullName,
             String PhoneNumber,
             String UserName,
             String UserPassword,
             String StaffBirthdate,
             String StaffStartDate,
             String JopTitel,
             String UserPrivileges,
             String Gender,
             String StaffAddess,
             String StaffHint,
             String RFID,
             String _id){
         
         String sql = "UPDATE "+tabel_name+" SET full_name = ? , "
                + "phone_number = ?, "
                + "user_name = ?, "
                + "user_password = ?, "
                + "staff_birthdate = ?, "
                + "staff_start_date = ?, "
                + "jop_title = ?, "
                + "user_privileges = ?, "
                + "gender = ?, "
                + "staff_address = ?, "
                + "staff_hint = ?, "
                + "RFID = ? "
                + "WHERE _id = ?";
         
          try (Connection conn = this.con;
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, FullName);
            pstmt.setString(2, PhoneNumber);
            pstmt.setString(3, UserName);
            pstmt.setString(4, UserPassword);
            pstmt.setString(5, StaffBirthdate);
            pstmt.setString(6, StaffStartDate);
            pstmt.setString(7, JopTitel);
            pstmt.setString(8, UserPrivileges);
            pstmt.setString(9, Gender);
            pstmt.setString(10, StaffAddess);
            pstmt.setString(11, StaffHint);
            pstmt.setString(12, RFID);
            pstmt.setString(13, _id);

            // update 
            pstmt.executeUpdate();
            System.out.println("updatee data done");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
         
     
     }
       
       
       
       
       
   
   
 
   public void Ads_pic(ImageView imageView_ads){      
        try {
            String q="SELECT * FROM ads_pics";            
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);
            rs.next();  
             int ad_time = rs.getInt("ad_time"); 
           timer_ad_pic = new Timer();
           timer_ad_pic.schedule(new TimerTask() {            
        @Override
        public void run() {
            Platform.runLater(() -> {                
                try{
                if (rs.next()) {

                 Image im = new Image(links.Server_url()+rs.getString("ad_img"));
                  if (!im.isError()){
                  imageView_ads.setImage(im); 
                  }
                } 
                else if(!rs.next()){rs.beforeFirst();}
        }catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }                    
            });            
        }       
    },5000    //firt start
     ,ad_time);//repet  
          
               
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }  
   }
   
   
   
   
    public void get_user_profile_data(String RFID ,Circle circle_image_member_add_update_delete,Label lab_user_name,Label lab_Start_date,Label lab_end_date,Label lab_plane,Label Registration ){
           
        
        try {            
            String q="SELECT * FROM member_data WHERE _id="+RFID;          
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);
            
            
            if (rs.next()) {
               
                 
                  
                  
                              Image im = new Image(links.Server_url()+rs.getString("image"));
                                if (!im.isError()){
                                circle_image_member_add_update_delete.setFill(new ImagePattern(im));}
                  
                  
               

                  Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            lab_user_name.setText(rs.getString("full_name"));
                                            lab_Start_date.setText(rs.getString("start_date"));
                                            lab_end_date.setText(rs.getString("end_date"));
                                            lab_plane.setText(rs.getString("plane"));
                                            Registration.setText(rs.getString("registration_date"));
                                            
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });

            } 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
   }
    
    
    
    
     public void insert_member_at_the_gym_data(String ID,String workout_one_name,String workout_two_name,String enter_time,String enter_date) {
      
        try {

            String q="SELECT * FROM member_data WHERE _id="+ID;          
             Connection conn = this.con;
             PreparedStatement st = conn.prepareStatement(q);
             ResultSet rs = st.executeQuery(q);
             rs.next();
            
 
            PreparedStatement pstmt= con.prepareStatement("insert into members_at_the_gym("
                    + "member_name,member_photo,member_start_date,"
                    + "member_end_date,plane,workout_one_name,workout_two_name,enter_member_time_date,rfid,enter_member_date)"
                  
                    + "values(?,?,?,?,?,?,?,?,?,?)");
                   
            pstmt.setString(1,rs.getString("full_name"));
            pstmt.setString(2,rs.getString("image"));
            pstmt.setString(3,rs.getString("start_date") );
            pstmt.setString(4,rs.getString("end_date") );
            pstmt.setString(5,rs.getString("plane") );
            pstmt.setString(6, workout_one_name); 
            pstmt.setString(7, workout_two_name);
            pstmt.setString(8, enter_time);
            pstmt.setString(9, rs.getString("RFID"));
            pstmt.setString(10, enter_date);
           
            pstmt.executeUpdate();
 
        } 
        catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
 
        
        }
           
    }
     
     
     
    
     public void insert_member_workout_history(String ID,String end_workout_time,String workout_time_duration,String workout_rate,String workout_sign_out_mode) {
        try {

            String q="SELECT * FROM members_at_the_gym WHERE _id="+ID;          
             Connection conn = this.con;
             PreparedStatement st = conn.prepareStatement(q);
             ResultSet rs = st.executeQuery(q);
             rs.next();
            
            PreparedStatement pstmt= con.prepareStatement("insert into members_workout_history("
                    + "member_name,member_photo,workout_one_name,"
                    + "workout_two_name,start_workout_date,start_workout_time,end_workout_time,workout_time_duration,workout_rate,workout_sign_out_mode,rfid)"
                  
                    + "values(?,?,?,?,?,?,?,?,?,?,?)");
                   
            pstmt.setString(1,rs.getString("member_name"));
            pstmt.setString(2,rs.getString("member_photo"));
            pstmt.setString(3,rs.getString("workout_one_name") );
            pstmt.setString(4,rs.getString("workout_two_name") );
            pstmt.setString(5,rs.getString("enter_member_date") );
            pstmt.setString(6, rs.getString("enter_member_time_date"));
            pstmt.setString(7, end_workout_time);
            pstmt.setString(8, workout_time_duration);
            pstmt.setString(9, workout_rate);
            pstmt.setString(10, workout_sign_out_mode);
            pstmt.setString(11, rs.getString("rfid"));

  
            pstmt.executeUpdate();
 
        } 
        catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
 
        
        }
           
    }
    
    
     
     
     
     
        public int row_index_count_for_members_at_the_gym(){       
        int index = 0 ;       
        try {
            String query = "SELECT * FROM members_at_the_gym";
            rs =st.executeQuery(query);
            rs.last();         
            index = rs.getRow() ;           
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return index ;
    
    }
        
        
     public String member_at_the_gym_start_traning_time(String id){
         String start_traning_time = null ;
         
        try {     
            String q="SELECT * FROM members_at_the_gym  WHERE _id="+id;
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);
            rs.next();
            
            start_traning_time = rs.getString("enter_member_time_date");
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     return start_traning_time ;
     }
     
     
      public void calc_plan_duration(String plan_name,JFXTextField plan_price_Field,Label start_member_plan,Label end_member_plan,Label lab_month,Label lab_days){   
        try {     
            String q="SELECT * FROM plan_data WHERE plan_name='"+plan_name + "'";
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);
            rs.next();
            
            String plan_duration = rs.getString("plan_duration");
            String plan_price = rs.getString("plan_price");
                    
        Date currentDate = new Date();
        
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        c.add(Calendar.YEAR, 0);
        c.add(Calendar.MONTH, Integer.parseInt(plan_duration));
        c.add(Calendar.DATE, 0); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.HOUR, 0);
        c.add(Calendar.MINUTE, 0);
        c.add(Calendar.SECOND, 0);

        Date currentDatePlusOne = c.getTime();   
              Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        plan_price_Field.setText(plan_price);
                                        LocalDate end_date = currentDatePlusOne.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                                      
                                        end_member_plan.setText(end_date.toString());
                                        start_member_plan.setText(currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString());
                                        
                                        lab_month.setText(plan_duration);
                                        int days =  Integer.parseInt(plan_duration);
                                        days = days * 30 ;
                                        String Days_string = Integer.toString(days);
                                        lab_days.setText(Days_string);                                       
                                    }
                                });  
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
      
      
      
      public void get_plan_data_to_update(String plan_name,JFXTextField plan_price_Field,Label lab_month,Label lab_days){   
        try {     
            String q="SELECT * FROM plan_data WHERE plan_name='"+plan_name + "'";
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);
            rs.next();
            
            String plan_duration = rs.getString("plan_duration");
            String plan_price = rs.getString("plan_price");
                        
              Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        plan_price_Field.setText(plan_price);                                       
                                        lab_month.setText(plan_duration);
                                        int days =  Integer.parseInt(plan_duration);
                                        days = days * 30 ;
                                        String Days_string = Integer.toString(days);
                                        lab_days.setText(Days_string);                                       
                                    }
                                });  
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     
     
     
     
     public String[][] get_memper_at_the_gym_starttime_id(){
         
           String[][] all_member_at_gym_starttime_id = new String[row_index_count_for_members_at_the_gym()][2];
        try {            
            String query = "select * from members_at_the_gym ";
            rs =st.executeQuery(query);          
            int count =0 ;
            while(rs.next()){             
             all_member_at_gym_starttime_id[count][0]=rs.getString("_id");
             all_member_at_gym_starttime_id[count][1]=rs.getString("enter_member_time_date");
            
             count++ ;
            }
            //con.close();             
        } catch (Exception e) {
            System.err.println(e);
        }
     
    return all_member_at_gym_starttime_id ;
   
     }
     
     
     
     
     
    
      public void get_member_at_the_gym_data(int count,Label lab_member_name,
              Circle circle_memeber_profile_img,
              Label lab_member_start_tranning_time,
              Label lab_member_plan,
              Label lab_start_member_date,
              Label lab_end_member_date,           
              Label lab_workout_one_name,
              ImageView workout_one_img,
              Label lab_workout_two_name,
              ImageView workout_two_img,
              JFXButton btn_next_card_data,
              JFXButton btn_previous_card_data,
              VBox vbox_card,Label txtv_card_num){
          
          
          //int min = count-4 ;
          
          String countS = Integer.toString(count);
          
          
          String Workout_one_image = "";
          String Workout_two_image = "";
          
       
        try {            
            String q="SELECT * FROM members_at_the_gym ";     
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);

            if (row_index_count_for_members_at_the_gym() >= count){
                btn_next_card_data.setDisable(false);
                vbox_card.setVisible(true);
                              
                txtv_card_num.setText(Integer.toString(count));

        //    for (int i = 0; i < count; i++) {
                
                rs.absolute(count);
            
 
                  Image im = new Image(links.Server_url()+rs.getString("member_photo"));
                  
                  if (!im.isError()){
                  circle_memeber_profile_img.setFill(new ImagePattern(im));}
               
                
                if(!rs.getString("workout_one_name").equals("")){              
                switch (rs.getString("workout_one_name")) {
                    case "Arm":
                    Workout_one_image = "img/anatomy_arm.png";
                    break;
                    case "Back":
                    Workout_one_image = "img/anatomy_back.png"; 
                    break;
                    case "Leg":
                    Workout_one_image = "img/anatomy_leg.png"; 
                    break;
                    case "Shoulders":
                    Workout_one_image = "img/anatomy_shoulder.png";
                    break;
                    case "Chest":
                    Workout_one_image = "img/anatomy_chest.png"; 
                    break;
                    case "Abs":
                    Workout_one_image = "img/anatomy_abs.png";
                    break;
                    case "Crossfit":
                    Workout_one_image = "img/anatomy_crossfit.png";
                    break;
                    case "Cardio":
                    Workout_one_image = "img/anatomy_cardio.png";
                    break;}
                    
     
                workout_one_img.setImage(new Image (Workout_one_image));workout_one_img.setVisible(true);}else{workout_one_img.setVisible(false);
                
                
                
                }
                


                if(!rs.getString("workout_two_name").equals("")){              
                switch (rs.getString("workout_two_name")) {
                    case "Arm":
                    Workout_two_image = "img/anatomy_arm.png";
                    break;
                    case "Back":
                    Workout_two_image = "img/anatomy_back.png"; 
                    break;
                    case "Leg":
                    Workout_two_image = "img/anatomy_leg.png"; 
                    break;
                    case "Shoulders":
                    Workout_two_image = "img/anatomy_shoulder.png";
                    break;
                    case "Chest":
                    Workout_two_image = "img/anatomy_chest.png"; 
                    break;
                    case "Abs":
                    Workout_two_image = "img/anatomy_abs.png";
                    break;
                    case "Crossfit":
                    Workout_two_image = "img/anatomy_crossfit.png";
                    break;
                    case "Cardio":
                    Workout_two_image = "img/anatomy_cardio.png";
                    break;}
                    
     
                workout_two_img.setImage(new Image (Workout_two_image));workout_two_img.setVisible(true);}else{workout_two_img.setVisible(false);
                
                
                
                }
               
                
                  Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            lab_member_name.setText(rs.getString("member_name"));
                                            lab_workout_one_name.setText(rs.getString("workout_one_name"));
                                            lab_workout_two_name.setText(rs.getString("workout_two_name"));
                                            lab_member_start_tranning_time.setText(rs.getString("enter_member_time_date"));
                                            lab_member_plan.setText(rs.getString("plane"));
                                            lab_start_member_date.setText(rs.getString("member_start_date"));
                                            lab_end_member_date.setText(rs.getString("member_end_date"));                                            
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });

         
        //    }
            }
            if(row_index_count_for_members_at_the_gym() < count){
            
                btn_next_card_data.setDisable(true);
                vbox_card.setVisible(false);
                txtv_card_num.setText("..");
            }
            
            if (count <=4){
                btn_previous_card_data.setDisable(true);            
            }
            else{btn_previous_card_data.setDisable(false);}
            

            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
   }
      
      
      
      
      
            public void get_plan_data_card(int count,
              Label lab_plan_name,         
              Label lab_plan_month,
              Label lab_plan_days,
              Label lab_plan_price,
              ImageView img_plan_lock,
              JFXButton btn_next_card_data,
              JFXButton btn_previous_card_data,
              VBox vbox_card){
          
        try {            
            String q="SELECT * FROM plan_data ";     
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);

            if (row_index_count_for_plan() >= count){
                btn_next_card_data.setDisable(false);
                vbox_card.setVisible(true);
                                             
                rs.absolute(count);
                            
                  Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            
                                            String available = rs.getString("plan_available");
                                            
                                            if(available.equals("No")){
                                            img_plan_lock.setVisible(true);
                                            }
                                            else{
                                            img_plan_lock.setVisible(false);
                                            }
                                            
                                            lab_plan_name.setText(rs.getString("plan_name"));
                                            lab_plan_price.setText(rs.getString("plan_price"));
                                            String duration = rs.getString("plan_duration");
                                            lab_plan_month.setText(duration);                                           
                                             
                                            int days =  Integer.parseInt(duration);
                                            days = days * 30 ;
                                            String Days_string = Integer.toString(days);
                                            lab_plan_days.setText(Days_string);  
                                            
                                            
                                                                                   
                                        } catch (SQLException ex) {
                                            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                });

            }
            if(row_index_count_for_plan() < count){            
                btn_next_card_data.setDisable(true);
                vbox_card.setVisible(false);
            }
            if (count <=4){
                btn_previous_card_data.setDisable(true);            
            }
            else{btn_previous_card_data.setDisable(false);}
          
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
   }
    
    
   
   
//   public int row_index_count_for_members_at_the_gym(){       
//        int index = 0 ;       
//        try {
//            String query = "SELECT * FROM members_at_the_gym";
//            rs =st.executeQuery(query);
//            rs.last();         
//            index = rs.getRow() ;           
//        } catch (SQLException ex) {
//            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    return index ;
//    
//    }
//   
//    public Object [][] get_member_at_the_gym_data_database(){ 
//         Object[][] all_member_at_gym_data = new String[row_index_count_for_members_at_the_gym()][3];
//        try {            
//            String query = "SELECT * FROM members_at_the_gym";
//            rs =st.executeQuery(query);          
//            int count =0 ;
//            while(rs.next()){        
//                
//             all_member_at_gym_data[count][0]=rs.getString("_id");
//             all_member_at_gym_data[count][1]=rs.getString("member_name");
// //            all_member_at_gym_data[count][2]=rs.getBlob("member_photo");
////             all_member_at_gym_data[count][3]=rs.getString("member_start_date");
////             all_member_at_gym_data[count][4]=rs.getString("member_end_date");  
////             all_member_at_gym_data[count][5]=rs.getString("plane");
////             all_member_at_gym_data[count][6]=rs.getString("workout_one_name");
////             all_member_at_gym_data[count][7]=rs.getBlob("workout_one_img");
////             all_member_at_gym_data[count][8]=rs.getString("workout_two_name");
////             all_member_at_gym_data[count][9]=rs.getBlob("workout_two_img");          
//            
//             count++ ;
//            }
//            //con.close();             
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//     
//    return all_member_at_gym_data ;
//    }

      
      
      
     public void insert_notification(String massage_head,String massage_body,String massage_time_date,String massage_icon) {

        try {
             
            PreparedStatement pstmt= con.prepareStatement("insert into notification("
                    + "massage_head,massage_body,massage_time_date,"
                    + "massage_icon)" + "values(?,?,?,?)");
                   
            pstmt.setString(1, massage_head);
            pstmt.setString(2, massage_body);
            pstmt.setString(3, massage_time_date);
            pstmt.setString(4, massage_icon);
            
 
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
 
        
        }
           
    }
     
     
     
    public String get_member_rfid_by_id(String id){
        String rfid ="";    
     try {     
            String q="SELECT * FROM member_data  WHERE _id="+id;
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);
            rs.next();            
            rfid = rs.getString("RFID");
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     return rfid ;
    }
    
    
     public String get_plan_name_by_id(String id){
        String plan_name ="";    
     try {     
            String q="SELECT * FROM plan_data  WHERE _id="+id;
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);
            rs.next();            
            plan_name = rs.getString("plan_name");
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     return plan_name ;
    }
    
    
     public String get_staff_rfid_by_id(String id){
        String rfid ="";
    
     try {     
            String q="SELECT * FROM staff_data  WHERE _id="+id;
            Connection conn = this.con;
            PreparedStatement st = conn.prepareStatement(q);
            ResultSet rs = st.executeQuery(q);
            rs.next();
            
            rfid = rs.getString("RFID");
        } catch (SQLException ex) {
            Logger.getLogger(MYSql_DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
     return rfid ;
    
    
    
    }
     
     
     
     
   
    
     
      
      
    
}
