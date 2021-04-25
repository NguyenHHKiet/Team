module com.mycompany.htbanve {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;

    opens com.mycompany.htbanve to javafx.fxml;
    exports com.mycompany.htbanve;
}
