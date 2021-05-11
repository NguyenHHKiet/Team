package com.mycompany.htbanve;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TrangChuController implements Initializable{

    @FXML
    private Button KHbt;

    @FXML
    public void SwitchtoLogin() throws IOException{
        App.setRoot("Login");
    }
    @FXML
    public void SwitchtoKH() throws IOException{
        App.setRoot("MuaVe");
    }
    
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(loadFXML("TrangChu"), 600, 400);
        stage.setScene(scene);
        stage.show();
    }
    
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
    }

    private Parent loadFXML(String trangChu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}