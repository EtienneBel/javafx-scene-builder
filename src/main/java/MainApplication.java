import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("login.css");

        primaryStage.setTitle("Login Management");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
