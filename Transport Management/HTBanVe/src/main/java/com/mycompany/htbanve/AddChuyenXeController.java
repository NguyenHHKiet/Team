/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.pojo.QLCX;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLCXsServices;
import com.mycompany.htbanve.service.Utils;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
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

        try {

            conn = JdbcUtils.getConnection();

//        try{
//            ObservableList<QLCX> data = FXCollections.observableArrayList(QLCXsServices.getDataQLCXs(this.filterField.getText()));
//              QLCXsServices.getDataQLCXs(this.filterField.getText()).forEach(i ->System.out.println(i.getId()));
//        }catch (Exception e){
//            
//        }
            tbvQLCX.setEditable(true);

//        ResultSet rs = null;
//        try {
//            rs = conn.createStatement().executeQuery("select * from qlcx");
//        } catch (SQLException ex) {
//            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            while(rs.next()){
//                try {
//                    data.add(new QLCX(rs.getInt("id"),rs.getString("tencx"),rs.getString("bsx"),rs.getString("loaixe")
//                            ,rs.getString("giokh"),rs.getString("ngaykh"),rs.getString("giave"),rs.getString("tennv"),rs.getString("sdtnv"),rs.getString("ghe")));
//                } catch (SQLException ex) {
//                    Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
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
// this.tbvQLCX.setItems(data);
        } catch (SQLException ex) {
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // this.tbvQLCX.setItems(data); 
    }

    @FXML
    public void getSelected (MouseEvent event){
        
        
//        this.tbvQLCX.setRowFactory(obj -> {
//            TableRow row = new TableRow();
//            
//            row.setOnMouseClicked(evt -> {
                try {
                    QLCX i = this.tbvQLCX.getSelectionModel().getSelectedItem();
                     
                    txtid.setText(String.valueOf(i.getId()));
                    txttencx.setText(i.getTencx());
                    txtbsx.setText(i.getBsx());
                    txtloaixe.setText(i.getLoaixe());
                    txtgiokh.setText(i.getGiokh());
                    txtgiave.setText(i.getGhe());
                    txttennv.setText(i.getTennv());
                    txtsdtnv.setText(i.getSdtnv());
                    txtghe.setText(i.getGhe());
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
                }
//            });
//            
//            return row;
//        });
    }
    // Load dl len table view
    public void UpdateQLCX() throws SQLException {
        conn = JdbcUtils.getConnection();
        ObservableList<QLCX> data = FXCollections.observableArrayList();
//        QLCXsServices results = new QLCXsServices();
//        List<QLCX> rs = results.getDataQLCXs();
//        rs.forEach(c->{
//            QLCX QLCXDetails = new QLCX();
//            QLCXDetails.setId(c.getId());
//            QLCXDetails.setTencx(c.getTencx());
//            QLCXDetails.setBsx(c.getBsx());
//            QLCXDetails.setLoaixe(c.getLoaixe());
//            QLCXDetails.setGiokh(c.getGiokh());
//            QLCXDetails.setNgaykh(c.getNgaykh());
//            QLCXDetails.setGiave(c.getGiave());
//            QLCXDetails.setTennv(c.getTennv());
//            QLCXDetails.setSdtnv(c.getSdtnv());
//            QLCXDetails.setGhe(c.getGhe());
//            
//             data.add(QLCXDetails)
//        });
//        tbvQLCX.setItems(data);    
//        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
//        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
//        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
//        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
//        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
//        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
//        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
//        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
//        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
//        colghe.setCellValueFactory(new PropertyValueFactory<>("ghe"));
//       
//        ResultSet rs = conn.createStatement().executeQuery("select * from htbanve.qlcx");
//        //tbvQLCX.setItems(data);
//        
//        
//        /**/
//        
//        ArrayList<QLCX> qlcxList = new ArrayList();
//        try{
//            QLCX qlcx;
//            while(rs.next()){
//            //data.add(new QLCX(rs.getInt("id"),rs.getString("tencx"),rs.getString("bsx").toString(),rs.getString("loaixe").toString(),rs.getString("giokh").toString(),rs.getString("ngaykh").toString(),rs.getString("giave").toString(),rs.getString("tennv").toString(),rs.getString("sdtnv").toString(),rs.getString("ghe")));
//            qlcx = new QLCX(rs.getInt("id"),rs.getString("tencx"),rs.getString("bsx"),rs.getString("loaixe"),rs.getString("giokh"),rs.getString("ngaykh"),rs.getString("giave"),rs.getString("tennv"),rs.getString("sdtnv"),rs.getString("ghe"));
//            qlcxList.add(qlcx);
//        }
//        }
//        catch(SQLException ex){
//            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
//        }

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
    public void AddQLCX() throws SQLException {
        conn = JdbcUtils.getConnection();
        //date
        if ("".equals(txtid.getText()) || "".equals(txttencx.getText()) || "".equals(txtbsx.getText())
                || "".equals(txtgiokh.getText()) || (txtngaykh.getValue()) == null || "".equals(txtgiave.getText())
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtloaixe.getText())
                || "".equals(txtghe.getText())) {
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin", "about", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                QLCXsServices.addCX(txtid.getText(), txttencx.getText(), txtbsx.getText(), txtgiokh.getText(), txtngaykh.getValue().toString(), txtgiave.getText(),
                         txttennv.getText(), txtsdtnv.getText(), txtloaixe.getText(), txtghe.getText());
                JOptionPane.showMessageDialog(null, "Đã thêm chuyến xe thành công !!!");
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
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin", "about", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                QLCXsServices.EditCX(txtid.getText(), txttencx.getText(), txtbsx.getText(), txtloaixe.getText(), txtngaykh.getValue().toString(),
                         txtgiokh.getText(), txtgiave.getText(), txttennv.getText(), txtsdtnv.getText(), txtghe.getText());
                JOptionPane.showMessageDialog(null, "update");
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
                Utils.getBox("SUCCESSFUL", Alert.AlertType.INFORMATION).show();
                loadQLCXData("");
            } else {
                Utils.getBox("FAILED", Alert.AlertType.ERROR).show();
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
                } else if (person.getBsx().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                    return true;
                } else if (person.getGiokh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                    return true;
                } else if (person.getLoaixe().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                    return true;
                } else if (person.getNgaykh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                    return true;
                } else if (person.getGiave().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                    return true;
                } else if (person.getTennv().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                    return true;
                } else if (person.getGhe().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                    return true;
                } else if (person.getSdtnv().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
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

        TableColumn colgiokh = new TableColumn("Giờ Khởi Hành");
        colgiokh.setCellValueFactory(new PropertyValueFactory("giokh"));

        TableColumn colngaykh = new TableColumn("Ngày Khởi Hành");
        colngaykh.setCellValueFactory(new PropertyValueFactory("ngaykh"));

        TableColumn colgiave = new TableColumn("Giá Vé");
        colgiave.setCellValueFactory(new PropertyValueFactory("giave"));

        TableColumn coltennv = new TableColumn("Tên Nhân Viên");
        coltennv.setCellValueFactory(new PropertyValueFactory("tennv"));

        TableColumn colsdtnv = new TableColumn("SĐT Nhân Viên");
        colsdtnv.setCellValueFactory(new PropertyValueFactory("sdtnv"));

        TableColumn colghe = new TableColumn("Ghế");
        colghe.setCellValueFactory(new PropertyValueFactory("ghe"));
//        TableColumn colid = new TableColumn("ID");
//        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
//        TableColumn colNameCX = new TableColumn("Tên chuyến xe");
//        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
//        TableColumn colbsx = new TableColumn("Biển số xe");
//        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
//        TableColumn colloaixe = new TableColumn("Loại xe");
//        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
//        TableColumn colgiokh = new TableColumn("Gời khởi hành");
//        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
//        TableColumn colngaykh = new TableColumn("Ngày khởi hành");
//        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
//        TableColumn colgiave = new TableColumn("Giá vé");
//        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
//        TableColumn coltennv = new TableColumn("Tên nhân viên");
//        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
//        TableColumn colsdtnv = new TableColumn("SDT nv");
//        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
//        TableColumn colghe = new TableColumn("Số ghế");
//        colghe.setCellValueFactory(new PropertyValueFactory<>("ghe"));
//        
        TableColumn colAction = new TableColumn();
        colAction.setCellFactory((obj) -> {
            Button btn = new Button("Xóa");
            
            btn.setOnAction(evt -> {
                Utils.getBox("Ban chac chan xoa khong?", Alert.AlertType.CONFIRMATION)
                     .showAndWait().ifPresent(bt -> {
                         if (bt == ButtonType.OK) {
                             try {
                                 TableCell cell = (TableCell) ((Button) evt.getSource()).getParent();
                                 QLCX p = (QLCX) cell.getTableRow().getItem();
                                 
                                 Connection conn = JdbcUtils.getConnection();
                                 QLCXsServices s = new QLCXsServices(conn);
                                 
                                 if (s.deleteQLCX(p.getId()) == true) {
                                     Utils.getBox("SUCCESSFUL", Alert.AlertType.INFORMATION).show();
                                     loadQLCXData("");
                                 } else
                                     Utils.getBox("FAILED", Alert.AlertType.ERROR).show();
                                 /**/
                                 conn.close();
                             } catch (SQLException ex) {
                                 
                                 ex.printStackTrace();
                                 Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
                             }
                         }
                     });
                
                
               
            });
            
            TableCell cell = new TableCell();
            cell.setGraphic(btn);
            return cell;
        });
        this.tbvQLCX.getColumns().addAll(colid, colNameCX, colbsx, colloaixe, colgiokh, colngaykh, colgiave, coltennv, colsdtnv, colghe);

    }

    public void loadQLCXData(String kw) {
        try {
            this.tbvQLCX.getItems().clear();

            Connection conn = JdbcUtils.getConnection();
            QLCXsServices qls = new QLCXsServices(conn);

            this.tbvQLCX.setItems(FXCollections.observableList(qls.getDataQLCXs(kw)));//(kw)

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
