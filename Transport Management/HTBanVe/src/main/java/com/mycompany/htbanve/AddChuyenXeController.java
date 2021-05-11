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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

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
    public void QuayLai() throws IOException {
        App.setRoot("ChonChucNang");
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = JdbcUtils.getConnection(); 
        tbvQLCX.setEditable(true);

        loadTables();
        loadQLCXData("");
        this.filterField.textProperty().addListener((obj) -> {
        loadQLCXData(this.filterField.getText());
    });
    try {
        UpdateQLCX();
        FindCX();

    } catch (SQLException ex) {
        Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @FXML
    public void getSelected (MouseEvent event){
        
        QLCX i = this.tbvQLCX.getSelectionModel().getSelectedItem();

        txtid.setText(String.valueOf(i.getId()));
        txttencx.setText(i.getTencx());
        txtbsx.setText(i.getBsx());
        txtloaixe.setText(i.getLoaixe());
        txtgiokh.setText(i.getGiokh());
        txtgiave.setText(i.getGiave());
        txtghe.setText(i.getGhe());
        txttennv.setText(i.getTennv());
        txtsdtnv.setText(i.getSdtnv());
        
    }
    // Load dl len table view
    public void UpdateQLCX() throws SQLException {
        conn = JdbcUtils.getConnection();
        ObservableList<QLCX> data = FXCollections.observableArrayList();
    }
    
    @FXML
    public void AddQLCX() throws SQLException {
        conn = JdbcUtils.getConnection();
        //date
        if ("".equals(txtid.getText()) || "".equals(txttencx.getText()) || "".equals(txtbsx.getText())
                || "".equals(txtgiokh.getText()) || (txtngaykh.getValue()) == null || "".equals(txtgiave.getText())
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText())
                || "".equals(txtghe.getText())) {
            JOptionPane.showMessageDialog(null, "Chưa nhập đủ thông tin.", "about", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                QLCXsServices.addCX(txtid.getText(), txttencx.getText(), txtbsx.getText(), txtloaixe.getText(), txtngaykh.getValue().toString(), txtgiokh.getText(), txtgiave.getText()
                         , txtghe.getText(), txttennv.getText(), txtsdtnv.getText());
                JOptionPane.showMessageDialog(null, "Đã thêm chuyến xe thành công.");
                UpdateQLCX();
                FindCX();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @FXML
    public void Edit() {
        if ("".equals(txtid.getText()) || "".equals(txttencx.getText()) || "".equals(txtbsx.getText())
                || "".equals(txtgiokh.getText()) || "".equals(txtngaykh.getValue()) || "".equals(txtgiave.getText())
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText())
                || "".equals(txtghe.getText())) {
            JOptionPane.showMessageDialog(null, "Chưa nhập đủ thông tin.", "about", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                QLCXsServices.EditCX(txtid.getText(), txttencx.getText(), txtbsx.getText(), txtloaixe.getText(), txtngaykh.getValue().toString(), txtgiokh.getText(), txtgiave.getText()
                         , txtghe.getText(), txttennv.getText(), txtsdtnv.getText());
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin chuyến xe thành công.");
                UpdateQLCX();
                FindCX();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @FXML
    public void DeleteQLCX() {
        try {
            
            QLCX p = this.tbvQLCX.getSelectionModel().getSelectedItem();
            
            Connection conn = JdbcUtils.getConnection();
            QLCXsServices s = new QLCXsServices(conn);
            if (s.deleteQLCX(p.getId()) == true  ) {
                JOptionPane.showMessageDialog(null, "Xóa chuyến xe thành công.");
//  /              Utils.getBox("SUCCESSFUL", Alert.AlertType.INFORMATION).show();
                
                UpdateQLCX();
                FindCX();
            } else {
                JOptionPane.showMessageDialog(null, "Xóa chuyến xe thất bại.");
             //   Utils.getBox("FAILED", Alert.AlertType.ERROR).show();
            }
            
            
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
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaSeFilter = newValue.toLowerCase();

                if (person.getTencx().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<QLCX> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tbvQLCX.comparatorProperty());
        tbvQLCX.setItems(sortedData);
    }

    private void loadTables() {
        TableColumn colid = new TableColumn("ID");
        colid.setCellValueFactory(new PropertyValueFactory("id"));

        TableColumn colNameCX = new TableColumn("Tên Chuyến Xe");
        colNameCX.setCellValueFactory(new PropertyValueFactory("tencx"));

        TableColumn colbsx = new TableColumn("Biển Số Xe");
        colbsx.setCellValueFactory(new PropertyValueFactory("bsx"));

        TableColumn colloaixe = new TableColumn("Loại Xe");
        colloaixe.setCellValueFactory(new PropertyValueFactory("loaixe"));
        
        TableColumn colngaykh = new TableColumn("Ngày Khởi Hành");
        colngaykh.setCellValueFactory(new PropertyValueFactory("ngaykh"));

        TableColumn colgiokh = new TableColumn("Giờ Khởi Hành");
        colgiokh.setCellValueFactory(new PropertyValueFactory("giokh"));

        TableColumn colgiave = new TableColumn("Giá Vé");
        colgiave.setCellValueFactory(new PropertyValueFactory("giave"));

        TableColumn colghe = new TableColumn("Ghế");
        colghe.setCellValueFactory(new PropertyValueFactory("ghe")); 

        TableColumn coltennv = new TableColumn("Tên Nhân Viên");
        coltennv.setCellValueFactory(new PropertyValueFactory("tennv"));

        TableColumn colsdtnv = new TableColumn("SĐT Nhân Viên");
        colsdtnv.setCellValueFactory(new PropertyValueFactory("sdtnv"));

// 
        this.tbvQLCX.getColumns().addAll(colid, colNameCX, colbsx, colloaixe, colngaykh, colgiokh, colgiave, colghe, coltennv, colsdtnv);

    }

    public void loadQLCXData(String kw) {
        try {
            this.tbvQLCX.getItems().clear();

            Connection conn = JdbcUtils.getConnection();
            QLCXsServices qls = new QLCXsServices(conn);

            this.tbvQLCX.setItems(FXCollections.observableList(qls.getDataQLCXs(kw)));

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
