module com.pmt.pmt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pmt.pmt to javafx.fxml;
    exports com.pmt.pmt;
}