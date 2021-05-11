/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.htbanve;

import com.mycompany.htbanve.App;
import com.mycompany.htbanve.pojo.QLBV;
import com.mycompany.htbanve.pojo.QLCX;
import com.mycompany.htbanve.service.JdbcUtils;
import com.mycompany.htbanve.service.QLBVServices;
import com.mycompany.htbanve.service.QLCXsServices;
import com.mycompany.htbanve.service.Utils;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Tuan Anh
 */
public class MuaVeController implements Initializable{
    @FXML
    private TextField txttencx;
    @FXML
    private TextField txtbsx;
    @FXML
    private TextField txtgiokh;
    @FXML
    private TextField txttenkh;
    @FXML
    private TextField txtsdtkh;
    @FXML
    private TextField txttennv;
    @FXML
    private TextField txtsdtnv;
    @FXML
    private TextField txtloaixe;
    @FXML
    private TextField txtgiave;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtngaykh; 
    @FXML
    private TextField txtghe;
    private TextField txtMaGhe;
    @FXML
    private TableView<QLCX> tbvMuaVe;
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
    private TableColumn<QLCX, String> colngaykh;
    @FXML
    private TableColumn<QLCX, String> colgiave;
    @FXML
    private TableColumn<QLCX, String> coltenkh;
    @FXML
    private TableColumn<QLCX, String> colsdtkh;
    @FXML
    private TableColumn<QLCX, String> coltennv;
    @FXML
    private TableColumn<QLCX, String> colsdtnv;
    @FXML
    private TableColumn<QLCX, String> colghe;
    @FXML
    private TextField filterField;
    
    ObservableList<QLCX> dataList;
    int index = -1;   
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst;
    @FXML
    private TextField txtBSX;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try{
            conn = JdbcUtils.getConnection();
            tbvMuaVe.setEditable(true);
            
            loadTables();
            loadQLBVData("");
            this.filterField.textProperty().addListener((obj) -> {
                loadQLBVData(this.filterField.getText());
            });
            
            UpdateQLBV();
            FindCX();
            
        } catch (SQLException ex) {
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
      
    @FXML
    public void QuayLai() throws IOException {
        App.setRoot("TrangChu");
    }

    
    // Load dl len table view
    public void UpdateQLBV() throws SQLException{    
        conn = JdbcUtils.getConnection();
        ObservableList<QLBV> data = FXCollections.observableArrayList();
       

    }   // Lay du lieu tu table view vao textfield
    @FXML
    public void getSelected (MouseEvent event){
   
                    QLCX i = this.tbvMuaVe.getSelectionModel().getSelectedItem();
                     
                    txtid.setText(String.valueOf(i.getId()));
                    txttencx.setText(i.getTencx());
                    txtbsx.setText(i.getBsx());
                    txtloaixe.setText(i.getLoaixe());
                    txtngaykh.setText(i.getNgaykh());
                    txtgiokh.setText(i.getGiokh());
                    txtgiave.setText(i.getGiave());
                    txtghe.setText(i.getGhe());
                    txttennv.setText(i.getTennv());
                    txtsdtnv.setText(i.getSdtnv());
                    
//                    String sDate1 = i.getNgaykh();  
//                    txtngaykh.toString() = SimpleDateFormat(i.getNgaykh()).parse(sDate1); 
    }
    // them ve vao csdl
    public void AddQLBV() throws SQLException{
         conn = JdbcUtils.getConnection();
        //date
        // dieu kien k cho phep de trong o dl
        if ( "".equals(txttencx.getText()) || "".equals(txtbsx.getText()) 
                || "".equals(txtgiokh.getText()) || "".equals(txtngaykh.getText())  || "".equals(txtgiave.getText()) 
                || "".equals(txttenkh.getText()) || "".equals(txtsdtkh.getText()) || "".equals(txtloaixe.getText()) 
                || "".equals(txttennv.getText()) || "".equals(txtsdtnv.getText()) || "".equals(txtghe.getText()))
        {            
            JOptionPane.showMessageDialog(null, "Chua nhap du thong tin","about",JOptionPane.INFORMATION_MESSAGE);
        }
        else if("0".equals(txtghe.getText())){
            JOptionPane.showMessageDialog(null, "Chuyến xe đã hết ghế trống\n Mời bạn chọn chuyến xe khác");  
                  
        }else
        {                 
            
                String rm = UUID.randomUUID().toString(); 
                
//                DateFormat df = new SimpleDateFormat("dd MM yyyy");
//                LocalDate localDate = txtngaykh.getValue();
//                Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
//                Date date = (Date) Date.from(instant);
                //12
                         
                try {
                    
                    int a = Integer.parseInt(txtghe.getText()) - 1;
                    String value1 = String.valueOf(a);
                    String value2 = txtid.getText();
                    QLBVServices.GiamGhe(value1, value2);
                    QLBVServices.addVe(rm,txttencx.getText() , txtbsx.getText(), txtloaixe.getText(), txtngaykh.getText(),txtgiokh.getText()
                         , txtgiave.getText(),txtghe.getText()
                         , txttennv.getText(), txtsdtnv.getText(), txttenkh.getText(), txtsdtkh.getText()
                         ); 
                    
                    
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                JOptionPane.showMessageDialog(null, "Quý khách đã đặt vé thành công. \n"
                        + " Lưu ý : Hãy đến quầy nhân viên để nhận vé trong 30p trước giờ khởi hành.\n"
                        + "Quá 30p trước giờ khởi hành vé sẽ bị hủy.\n"
                        + "Chân thành cảm ơn quý khách.");
                UpdateQLBV();
                FindCX();
            loadQLBVData("");
        }        
    }
    
    
    void FindCX() throws SQLException {
        dataList = QLCXsServices.getDataQLCX();
        tbvMuaVe.setItems(dataList);
        FilteredList<QLCX> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(person -> {
                                    if (newValue == null || newValue.isEmpty()){
                                        return true;
                                    }
                                    String lowerCaSeFilter = newValue.toLowerCase();

                                    if (person.getTencx().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
                                        return true; 
                                    }
//                                    } else if (person.getBsx().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
//                                        return true;
//                                    }else if (person.getLoaixe().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
//                                            return true;
//                                    }else if (person.getGiokh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
//                                            return true;
//                                    }else if (person.getNgaykh().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
//                                            return true;
//                                    }else if (person.getGiave().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
//                                            return true;        
//                                    }else if (person.getTennv().toLowerCase().indexOf(lowerCaSeFilter) != -1) {
//                                            return true; 
//                                    }else 
//                                       if ( person.getSdtnv().toLowerCase().indexOf(lowerCaSeFilter) != -1)
//                                           return true;

                                         else
                                                return false;
            });                                                                             
        });
        SortedList<QLCX> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tbvMuaVe.comparatorProperty());
        tbvMuaVe.setItems(sortedData);
    }
    
    
//khach hàng không được tự dộng xóa vé
    

//    private Parent loadFXML(String trangChu) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public void loadTables(){
        
        TableColumn colid = new TableColumn("ID");
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        
        TableColumn colNameCX = new TableColumn("Tên chuyến xe");
        colNameCX.setCellValueFactory(new PropertyValueFactory<>("tencx"));
        
        TableColumn colbsx = new TableColumn("Biển số xe");
        colbsx.setCellValueFactory(new PropertyValueFactory<>("bsx"));
        
        TableColumn colloaixe = new TableColumn("Loại xe");
        colloaixe.setCellValueFactory(new PropertyValueFactory<>("loaixe"));
        
        TableColumn colngaykh = new TableColumn("Ngày khởi hành");
        colngaykh.setCellValueFactory(new PropertyValueFactory<>("ngaykh"));
        
        TableColumn colgiokh = new TableColumn("Giờ khởi hành");
        colgiokh.setCellValueFactory(new PropertyValueFactory<>("giokh"));
         
        TableColumn colgiave = new TableColumn("Giá vé");
        colgiave.setCellValueFactory(new PropertyValueFactory<>("giave"));
        
        TableColumn colghe = new TableColumn("Số ghế");
        colghe.setCellValueFactory(new PropertyValueFactory<>("ghe"));
        
        TableColumn coltennv = new TableColumn("Tên nhân viên");
        coltennv.setCellValueFactory(new PropertyValueFactory<>("tennv"));
        
        TableColumn colsdtnv = new TableColumn("SDT nv");
        colsdtnv.setCellValueFactory(new PropertyValueFactory<>("sdtnv"));
        
        

        this.tbvMuaVe.getColumns().addAll(colNameCX, colbsx, colloaixe, colngaykh, colgiokh, colgiave, colghe, coltennv, colsdtnv);

    }
    public void loadQLBVData(String kw) {
        try {
            this.tbvMuaVe.getItems().clear();

            Connection conn = JdbcUtils.getConnection();
            QLCXsServices qls = new QLCXsServices(conn);

            this.tbvMuaVe.setItems(FXCollections.observableList(qls.getDataQLCXs(kw)));//(kw)

            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(AddChuyenXeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}