module com.melissadata.globalname {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires com.google.gson;
    requires jdk.crypto.ec;
    requires java.xml;

    opens com.melissadata.globalname to javafx.fxml;
    opens com.melissadata.globalname.model to javafx.fxml;
    opens com.melissadata.globalname.view to javafx.fxml;
    exports com.melissadata.globalname;
}
