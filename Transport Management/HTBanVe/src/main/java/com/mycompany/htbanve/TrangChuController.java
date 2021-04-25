package com.mycompany.htbanve;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class TrangChuController implements Initializable{

    @FXML
    public void SwitchtoLogin() throws IOException{
        App.setRoot("Login");
    }
    @FXML
    public void SwitchtoKH() throws IOException{
        App.setRoot("Muave");
    }

    
    @FXML
    public void ExitTC() throws IOException {
        System.exit(0);
    }
        
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        String a = LocalDate.now().toString();
//        tesst.setText(a);
    }
}