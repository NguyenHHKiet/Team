/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;
import com.mycompany.htbanve.pojo.PrintTicket;
import com.mycompany.htbanve.pojo.QLBV;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLBVServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 *
 * @author Tuan Anh
 */
public class QuanLyVeXeController implements Initializable {
    @FXML
    private TextField txttencx;

    @FXML
    private TextField txtbsx;

    @FXML
    private TextField txtloaixe;

    @FXML
    private TextField txtngaykh;

    @FXML
    private TextField txtgiokh;

    @FXML
    private TextField txtgiave;

    @FXML
    private TextField txttennv;

    @FXML
    private TextField txtsdtnv;
    @FXML
    private TextField txttenkh;
    @FXML
    private TextField txtsdtkh;
    @FXML
    private TextField txtsoghe;
    @FXML
    private TextField txtidrandom;
    private TextField txtngayht;
    private TextField txtgioht;
    private TableView<QLBV> tbvQLBV;
    @FXML
    private TableColumn<QLBV, String> colNameCX;
    @FXML
    private TableColumn<QLBV, String> colbsx;
    @FXML
    private TableColumn<QLBV, String> colloaixe;
    @FXML
    private TableColumn<QLBV, String> colngaykh;
    @FXML
    private TableColumn<QLBV, String> colgiokh;
    @FXML
    private TableColumn<QLBV, String> colgiave;
    @FXML
    private TableColumn<QLBV, String> coltennv;
    @FXML
    private TableColumn<QLBV, String> colsdtnv;
    private TableColumn<QLBV, String> coltenkh;
    @FXML
    private TableColumn<QLBV, String> colghe;
    private TableColumn<QLBV, String> colsdtkh;
    private TextField filterField;
    private TableColumn<QLBV, String> colidrandom;
    private TableColumn<QLBV, String> colidphanbiet;
    private TextField txtidht;
    
    int index = -1;
    ObservableList<QLBV> dataList;
    Connection conn = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    PreparedStatement pst = null;
    @FXML
    private TableView<?> tbvQLCX;
    @FXML
    private TableColumn<?, ?> colid;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // lay ham bo vao main tu dong load
            UpdateQLBV();
            FindCX();
            txtngayht.setText(LocalDate.now().toString());
            txtgioht.setText(LocalTime.now().toString().substring(0, 5));
            
        } catch (SQLException ex) {
            Logger.getLogger(MuaVeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @FXML
    public void QuayLaiTC() throws IOException{
        App.setRoot("ChonChucNang");
    }
    // Load dl len table view
    public void UpdateQLBV() throws SQLException{
        ObservableList<QLBV> data = FXCollections.observableArrayList(QLBVServices.getDataQLBV2()); 
        tbvQLBV.setItems(data);
        colidrandom.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
        coltenkh.setCellValueFactory(new PropertyValueFactory<>("tenkh"));
        colsdtkh.setCellValueFactory(new PropertyValueFactory<>("sdtkh"));
        colghe.setCellValueFactory(new PropertyValueFactory<>("ghe"));
        colidphanbiet.setCellValueFactory(new PropertyValueFactory<>("idphanbiet"));
    }
    // Lay du lieu tu table view vao textfield
    @FXML
    void getSelected (MouseEvent event){
        index = tbvQLBV.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtidrandom.setText(colidrandom.getCellData(index));
        txttencx.setText(colNameCX.getCellData(index));
        txtbsx.setText(colbsx.getCellData(index));
        txtloaixe.setText(colloaixe.getCellData(index));
        txtngaykh.setText(colngaykh.getCellData(index));
        txtgiokh.setText(colgiokh.getCellData(index));
        txtgiave.setText(colgiave.getCellData(index));
        txttenkh.setText(coltenkh.getCellData(index));
        txtsdtkh.setText(colsdtkh.getCellData(index));
        txttennv.setText(coltennv.getCellData(index));
        txtsdtnv.setText(colsdtnv.getCellData(index));
        txtsoghe.setText(colghe.getCellData(index));
        txtidht.setText(colidphanbiet.getCellData(index));
        
    }
    @FXML
    public void Edit(){
        if ( "".equals(txttenkh.getText()) || "".equals(txtsdtkh.getText()) 
                || "".equals(txtsoghe.getText()) )
        {           
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else{     
        try {
            QLBVServices.updateQLBV(txttenkh.getText(), txtsdtkh.getText(), txtsoghe.getText(), txtidrandom.getText());
            JOptionPane.showMessageDialog(null, "update");
            UpdateQLBV();
            FindCX();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }
    public void DeleteQLBV(){
        try { 
            QLBVServices.XoaVe(txtidrandom.getText(), txtidht.getText());
            UpdateQLBV();
            FindCX();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    void FindCX() throws SQLException {
        dataList = QLBVServices.getDataQLBV2();
        tbvQLBV.setItems(dataList);
        FilteredList<QLBV> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(person -> {
                                    if (newValue == null || newValue.isEmpty()){
                                        return true;
                                    }
                                    String lowerCaSeFilter = newValue.toLowerCase();

                                    if (person.getTencx().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                        return true;
                                    } else if (person.getBsx().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                        return true;
                                    }else if (person.getLoaixe().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getGiokh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getNgaykh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getGiave().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getTenkh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true; 
                                    }else if (person.getSdtkh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true; 
                                    }else if (person.getTennv().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getGhe().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else 
                                       if ( person.getSdtnv().toLowerCase().indexOf(lowerCaSeFilter) != -1)
                                           return true;

                                           else
                                                return false;
            });                                                                             
        });
        SortedList<QLBV> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tbvQLBV.comparatorProperty());
        tbvQLBV.setItems(sortedData);

    }
   public void Print(ActionEvent e) throws IOException{
//       PrintTicket pt = new PrintTicket(txtidrandom.getText(), txttencx.getText(), txtbsx.getText(), 
//               txtngaykh.getText(), txtgiokh.getText(), txtsoghe.getText(), txtgiave.getText(), 
//               txttenkh.getText(), txtsdtkh.getText(), txttennv.getText(), txtngayht.getText());
//      App.setRoot("PrintTicket");
//    UpdateQLBV();
    Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("PrintTicket.fxml"));
    Parent printViewParent = loader.load();
    Scene scene = new Scene(printViewParent);
    PrintTicketController controller = loader.getController();
    QLBV qlbv = tbvQLBV.getSelectionModel().getSelectedItem();
    controller.setPrint(qlbv);
    stage.setScene(scene);
    
   }
}
