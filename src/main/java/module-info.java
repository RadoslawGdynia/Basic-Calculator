module Calculator {
    requires javafx.fxml;
    requires javafx.controls;
    requires slf4j.api;

    opens Controller;
    opens Main;
}