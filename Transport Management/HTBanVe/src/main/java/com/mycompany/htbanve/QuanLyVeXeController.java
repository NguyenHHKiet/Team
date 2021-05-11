/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;
import com.mycompany.htbanve.pojo.PrintTicket;
import com.mycompany.htbanve.pojo.QLBV;
import com.mycompany.htbanve.pojo.QLCX;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLBVServices;
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
    private TextField txtghe;
    @FXML
    private TextField txtidrandom;
    @FXML
    private TableView<QLBV> tbvQLBV;
    @FXML
    private TableColumn<QLBV, String> colidrandom;
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
    private TableColumn<QLBV, String> colghe;
    @FXML
    private TableColumn<QLBV, String> coltenkh;
    @FXML
    private TableColumn<QLBV, String> colsdtkh;
    @FXML
    private TableColumn<QLBV, String> coltennv;
    @FXML
    private TableColumn<QLBV, String> colsdtnv;
    @FXML
    private TableColumn<QLBV, String> colidphanbiet;
    @FXML
    private TextField filterField;
    
    private TextField txtidht;
    
    int index = -1;
    ObservableList<QLBV> dataList;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs1 = null;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = JdbcUtils.getConnection();
        tbvQLBV.setEditable(true);
            
        loadTables();
        loadQLBVData("");

        try {
            UpdateQLBV();
            FindCX();
            
        } catch (SQLException ex) {
            Logger.getLogger(MuaVeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @FXML
    public void QuayLaiTC() throws IOException{
        App.setRoot("ChonChucNang");
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
        
        TableColumn coltenkh = new TableColumn("Tên Khách Hàng");
        coltenkh.setCellValueFactory(new PropertyValueFactory("tenkh"));
        
        TableColumn colsdtkh = new TableColumn("SĐT Khách Hàng");
        colsdtkh.setCellValueFactory(new PropertyValueFactory("sdtkh"));
        this.tbvQLBV.getColumns().addAll(colid, colNameCX, colbsx, colloaixe, colngaykh, colgiokh, colgiave, colghe, coltennv, colsdtnv, coltenkh, colsdtkh);

    }

    public void loadQLBVData(String kw) {
        try {
            this.tbvQLBV.getItems().clear();
            Connection conn = JdbcUtils.getConnection();
            QLBVServices qls = new QLBVServices(conn);
            this.tbvQLBV.setItems(FXCollections.observableList(qls.getDataQLBV(kw)));
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    // Load dl len table view
    public void UpdateQLBV() throws SQLException{
        conn = JdbcUtils.getConnection();
        ObservableList<QLBV> data = FXCollections.observableArrayList();
    }
    // Lay du lieu tu table view vao textfield
    @FXML
    public void getSelected (MouseEvent event){
        
        QLBV i = this.tbvQLBV.getSelectionModel().getSelectedItem();

        txtidrandom.setText(String.valueOf(i.getId()));
        txttencx.setText(i.getTencx());
        txtbsx.setText(i.getBsx());
        txtloaixe.setText(i.getLoaixe());
        txtngaykh.setText(i.getNgaykh());
        txtgiokh.setText(i.getGiokh());
        txtgiave.setText(i.getGiave());
        txtghe.setText(i.getGhe());
        txttennv.setText(i.getTennv());
        txtsdtnv.setText(i.getSdtnv());
        txttenkh.setText(i.getTenkh());
        txtsdtkh.setText(i.getSdtkh());
        
    }
    
  
    
    @FXML
    public void Edit(){
        if ( "".equals(txttenkh.getText()) || "".equals(txtsdtkh.getText()) 
                || "".equals(txtghe.getText()) )
        {           
            JOptionPane.showMessageDialog(null, "Chưa nhập đủ thông tin.","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else{     
        try {
            QLBVServices.updateQLBV(txttenkh.getText(), txtsdtkh.getText(), txtghe.getText(), txtidrandom.getText());
            JOptionPane.showMessageDialog(null, "Sửa thông tin vé xe thành công.");
            UpdateQLBV();
            FindCX();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        }
    }
    public void DeleteQLBV(){
        try { 
            QLBVServices.XoaVe(txtidrandom.getText());
            UpdateQLBV();
            FindCX();
            JOptionPane.showMessageDialog(null, "Xóa vé thành công.");
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
                                    }else if (person.getTenkh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                        return true; 
                                    }else
                                        return false;
            });                                                                             
        });
        SortedList<QLBV> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tbvQLBV.comparatorProperty());
        tbvQLBV.setItems(sortedData);

    }
    
   @FXML
   public void Print(ActionEvent e) throws IOException{
    PrintTicket pt = new PrintTicket(txtidrandom.getText(), txttencx.getText(), txtbsx.getText(), 
            txtngaykh.getText(), txtgiokh.getText(), txtgiave.getText(), txtghe.getText(), 
            txttenkh.getText(), txtsdtkh.getText(), txttennv.getText());
   
    
    
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
