package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Main extends Application {

    @Override
    public void init() {
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = new File("src/main/resources/CalculatorView.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Basic Calculator");
        primaryStage.setScene(new Scene(root, 400, 600));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void stop()  {
    }

}