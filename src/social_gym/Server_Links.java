/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social_gym;

/**
 *
 * @author root
 */
public class Server_Links {
    
    public String Server_url(){
    
        String link = "http://192.168.1.2/";
        return link ;
    
    }
    
    
    public String DataBase_link(){
     
        String link = "jdbc:mysql://localhost/Social_Gym";
     //   String link = "jdbc:mysql://remotemysql.com:3306/4bcR1bWbGA";
        
        return link ;
    
    }
    
    public String DataBase_user_name(){
     
        String link = "root";
        return link ;
    
    }
    
    
    public String DataBase_password(){
     
        String link = "";
        return link ;
    
    }
    
    
     public String default_new_member_profile_img_server_link(){ // the link for default new member profile img on the server 
        String link = "members_profile_imgs/defult_user_profile.png";
        return link;   
    }
     
     
    public  String connectArduino_Serialport(){        
        String link = "/dev/ttyACM0" ;
        return link; 
    }
    
    
    
    
    
    
    
}
