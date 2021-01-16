/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package social_gym;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author root
 */
public class Member_at_the_gym_cardController implements Initializable {
    @FXML
    private VBox vbox_card;
    @FXML
    private Circle cir_profile_photo;
    @FXML
    private Label lab_member_name;
    @FXML
    private ImageView workout_1_img;
    @FXML
    private ImageView workout_2_img;
    @FXML
    private Label lab_workout_1_name;
    @FXML
    private Label lab_workout_2_name;
    @FXML
    private Label lab_end_member_date;

    /**
     * Initializes the controller class.
     */
    
    
    //Receive message from scene 1
    public void transferMessage(String message) {
        //Display the message
        lab_member_name.setText(message);
    }
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

//        MYSql_DBConnection connection = new MYSql_DBConnection();
//        Object[][] card_data = connection.get_member_at_the_gym_data_database();
//        Opening_Scene_Controller osc = new Opening_Scene_Controller();
//        int val = osc.i_val;
//        
//        System.out.println(val);
//        
//        lab_member_name.setText(card_data[val][1].toString());
        
        
        
//        
//        Member_at_the_gym_cardController controller = new Member_at_the_gym_cardController();              
//        FXMLLoader Relay_Output_Loader = new FXMLLoader(getClass().getResource("Member_at_the_gym_card.fxml"));  //Get FXML Loader
//        try {pane_home=  Relay_Output_Loader.load();                                                          //Get default Pane
//        } catch (IOException ex) { Logger.getLogger(Opening_Scene_Controller.class.getName()).log(Level.SEVERE, null, ex); }
//         hbox_member_cards.getChildren().add(pane_home);
//         
        

     }    
    
    
 
   
}


