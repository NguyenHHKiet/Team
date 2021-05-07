/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCX;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLCXsServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.GroupLayout.Group;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Tuan Anh
 */
public class AddChuyenXeController implements Initializable {
    @FXML
    private TableView<QLCX> tbvQLCX;
    @FXML
    private TableColumn<QLCX, Integer> colid;
    @FXML
    private TableColumn<QLCX, String> colNameCX;
    @FXML
    private TableColumn<QLCX, String> colbsx;
    @FXML
    private TableColumn<QLCX, String> colloaixe;
    @FXML
    private TableColumn<QLCX, String> colgiokh;
    @FXML
    private TableColumn<QLCX, DatePicker> colngaykh;
    @FXML
    private TableColumn<QLCX, String> colgiave;
    @FXML
    private TableColumn<QLCX, String> coltennv;
    @FXML
    private TableColumn<QLCX, String> colsdtnv;
    @FXML
    private TableColumn<QLCX, String> colghe;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txttencx;
    @FXML
    private TextField txtbsx;
    @FXML
    private DatePicker txtngaykh;
    @FXML
    private TextField txtgiokh;
    @FXML
    private TextField txttennv;
    @FXML
    private TextField txtsdtnv;  
    @FXML
    private TextField txtloaixe;   
    @FXML
    private TextField txtgiave;
    @FXML
    private TextField txtghe;   
    @FXML
    private TextField filterField;
    
    ObservableList<QLCX> dataList;   
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TextField txtBSX;
    

    @FXML
    public void QuayLai() throws IOException{
        App.setRoot("ChonChucNang");
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        conn = JdbcUtils.getConnection();
        ObservableList<QLCX> data = FXCollections.observableArrayList(QLCXsServices.getDataQLCX());
        tbvQLCX.setEditable(true);
        
        ResultSet rs = null;
        try {
            rs = conn.createStatement().executeQuery("select * from htbanve.qlcx");
        } catch (SQLException ex) {
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while(rs.next()){
                try {
                    data.add(new QLCX(rs.getInt("id"),rs.getString("tencx"),rs.getString("bsx"),rs.getString("loaixe")
                            ,rs.getString("giokh"),rs.getString("ngaykh"),rs.getString("giave"),rs.getString("tennv"),rs.getString("sdtnv"),rs.getString("ghe")));
                } catch (SQLException ex) {
                    Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tbvQLCX.getColumns().addAll(colid,colNameCX,colbsx,colloaixe,colgiokh,colngaykh,colgiave,coltennv,colsdtnv,colghe);
        TableColumn colid = new TableColumn("ID");
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn colNameCX = new TableColumn("Ten Chuyen Xe");
        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
        TableColumn colbsx = new TableColumn("Bien so xe");
        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
        TableColumn colloaixe = new TableColumn("Loai Xe");
        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
        TableColumn colgiokh = new TableColumn("Gio Khoi Hanh");
        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
        TableColumn colngaykh = new TableColumn("Ngay Khoi Hanh");
        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
        TableColumn colgiave = new TableColumn("Gia Ve");
        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
        TableColumn coltennv = new TableColumn("Ten NV");
        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
        TableColumn colsdtnv = new TableColumn("SDT NV");
        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
        TableColumn colghe = new TableColumn("Ghe xe");
        colghe.setCellValueFactory(new PropertyValueFactory<>("ghe"));
        
            
        this.tbvQLCX.setItems(data); 
        
        try {
            UpdateQLCX();
            FindCX();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @FXML
    void getSelected (MouseEvent event){
        index = tbvQLCX.getSelectionModel().getSelectedIndex();
        if(index <= -1){
            return;
        }
        txtid.setText(colid.getCellData(index).toString());
        txttencx.setText(colNameCX.getCellData(index));
        txtbsx.setText(colbsx.getCellData(index));
        txtloaixe.setText(colloaixe.getCellData(index));
        txtgiokh.setText(colgiokh.getCellData(index));
        txtgiave.setText(colgiave.getCellData(index));
        txttennv.setText(coltennv.getCellData(index));
        txtsdtnv.setText(colsdtnv.getCellData(index));
        txtghe.setText(colghe.getCellData(index));
        
    }
    public void UpdateQLCX() throws SQLException{
        conn = JdbcUtils.getConnection();
        ObservableList<QLCX> data = FXCollections.observableArrayList(QLCXsServices.getDataQLCX());
        
        
        ResultSet rs = conn.createStatement().executeQuery("select * from htbanve.qlcx");
        //tbvQLCX.setItems(data);
        
        
        /**/
        
        ArrayList<QLCX> qlcxList = new ArrayList();
        try{
            QLCX qlcx;
            while(rs.next()){
            //data.add(new QLCX(rs.getInt("id"),rs.getString("tencx"),rs.getString("bsx").toString(),rs.getString("loaixe").toString(),rs.getString("giokh").toString(),rs.getString("ngaykh").toString(),rs.getString("giave").toString(),rs.getString("tennv").toString(),rs.getString("sdtnv").toString(),rs.getString("ghe")));
            qlcx = new QLCX(rs.getInt("id"),rs.getString("tencx"),rs.getString("bsx"),rs.getString("loaixe"),rs.getString("giokh"),rs.getString("ngaykh"),rs.getString("giave"),rs.getString("tennv"),rs.getString("sdtnv"),rs.getString("ghe"));
            qlcxList.add(qlcx);
        }
        }
        catch(SQLException ex){
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /*public void show() throws SQLException{
        ArrayList<QLCX> list = UpdateQLCX();
        //DefaultTableModel model = (DefaultTableModel)tbvQLCX.getModel();
        ObservableList<QLCX> data = FXCollections.observableArrayList(QLCXsServices.getDataQLCX());
        Object[] row = new Object[10];
        for(int i =0 ;i < list.size();i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getTennv();
            row[2] = list.get(i).getBsx();
            row[3] = list.get(i).getLoaixe();
            row[4] = list.get(i).getGiokh();
            row[5] = list.get(i).getNgaykh();
            row[6] = list.get(i).getGiave();
            row[7] = list.get(i).getTennv();
            row[8] = list.get(i).getSdtnv();
            row[9] = list.get(i).getGhe();

        }
    }*/
    @FXML
    public void AddQLCX(){
         conn = JdbcUtils.getConnection();
        //date
        if ("".equals(txtid.getText()) || "".equals(txttencx.getText()) || "".equals(txtbsx.getText()) 
                || "".equals(txtgiokh.getText()) || (txtngaykh.getValue()) == null || "".equals(txtgiave.getText()) 
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText()) 
                || "".equals(txtghe.getText()))
        {           
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else{     
            try {
                QLCXsServices.addCX(txtid.getText(), txttencx.getText(), txtbsx.getText(), txtgiokh.getText(), txtngaykh.getValue().toString(), txtgiave.getText()
                        , txttennv.getText(), txtsdtnv.getText(), txtloaixe.getText(), txtghe.getText());
                JOptionPane.showMessageDialog(null, "Đã thêm chuyến xe thành công !!!");
                UpdateQLCX();
                FindCX();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }        
    }
    
    
    @FXML
    public void Edit(){
    if ("".equals(txtid.getText()) || "".equals(txttencx.getText()) || "".equals(txtbsx.getText()) 
            || "".equals(txtgiokh.getText()) || "".equals(txtngaykh.getValue()) || "".equals(txtgiave.getText()) 
            || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText()) 
            || "".equals(txtghe.getText()))
    {          
        JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
    }
    else{     
        try {
            QLCXsServices.EditCX(txtid.getText(), txttencx.getText(), txtbsx.getText(), txtloaixe.getText(), txtngaykh.getValue().toString()
                    , txtgiokh.getText(), txtgiave.getText(), txttennv.getText(), txtsdtnv.getText(), txtghe.getText());
            JOptionPane.showMessageDialog(null, "update");
            UpdateQLCX();
            FindCX();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
    @FXML
    public void DeleteQLCX(){
        try {
            QLCXsServices.DeleteCX(txtid.getText());
            JOptionPane.showMessageDialog(null, "delete");
            UpdateQLCX();
            FindCX();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    void FindCX() throws SQLException {

        dataList = QLCXsServices.getDataQLCX();
        tbvQLCX.setItems(dataList);
        FilteredList<QLCX> filteredData = new FilteredList<>(dataList, b -> true);
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
                                    }else if (person.getGiokh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getLoaixe().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getNgaykh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                            return true;
                                    }else if (person.getGiave().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
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
        SortedList<QLCX> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tbvQLCX.comparatorProperty());
        tbvQLCX.setItems(sortedData);
    }

    
}
