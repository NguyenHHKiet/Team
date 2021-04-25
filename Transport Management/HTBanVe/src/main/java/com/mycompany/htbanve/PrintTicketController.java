/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.PrintTicket;
import com.mycompany.htbanve.pojo.QLBV;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author Tuan Anh
 */
public class PrintTicketController {
    @FXML Label idLabel;
    @FXML Label tencxLabel;
    @FXML Label bsxLabel;
    @FXML Label ngaykhLabel;
    @FXML Label giokhLabel;
    @FXML Label gheLabel;
    @FXML Label giaLabel;
    @FXML Label tenkhLabel;
    @FXML Label sdtLabel;
    @FXML Label tennvLabel;
    @FXML Label ngayinLabel;
    @FXML Label gioinLabel;
    
    public void setPrint(QLBV pt){
        idLabel.setText(pt.getId());
        tencxLabel.setText(pt.getTencx());
        bsxLabel.setText(pt.getBsx());
        ngaykhLabel.setText(pt.getNgaykh());
        giokhLabel.setText(pt.getGiokh());
        gheLabel.setText(pt.getGhe());
        giaLabel.setText(pt.getGiave());
        tenkhLabel.setText(pt.getTenkh());
        sdtLabel.setText(pt.getSdtkh());
        tennvLabel.setText(pt.getTennv());
        ngayinLabel.setText(LocalDate.now().toString());
        gioinLabel.setText(LocalTime.now().toString().substring(0, 5));
    }
    
    public void QuayLaiQLBV(ActionEvent e) throws IOException {
        Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("QuanLyVeXe.fxml"));
        Parent qlbvViewParent = loader.load();
        Scene scene = new Scene(qlbvViewParent);
        stage.setScene(scene);
    } 
}
