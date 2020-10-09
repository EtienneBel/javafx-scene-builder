import DBConnection.DBHandler;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXTextField password;

    @FXML
    private JFXButton btn_signIn;

    @FXML
    private ImageView progress;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement preparedStatement;

    public void initialize(URL location, ResourceBundle resources) {
        //progress.setVisible(false);
        handler = new DBHandler();
    }

    @FXML
    void signIn(ActionEvent event) throws IOException, SQLException {
//        progress.setVisible(true);
//        PauseTransition pauseTransition = new PauseTransition();
//        pauseTransition.setDuration(Duration.seconds(10));
//        pauseTransition.setOnFinished(new EventHandler<ActionEvent>() {
//            public void handle(ActionEvent ev) {
//                System.out.println("logged");
//            }
//        });
//        pauseTransition.play();

        String insert = "INSERT INTO user(username, password) VALUES (?,?)";
        connection = handler.getConnection();
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, username.getText());
            preparedStatement.setString(2, password.getText());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!connection.isClosed()) {
            btn_signIn.getScene().getWindow().hide();
            Stage home = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/home.fxml"));
            Scene scene = new Scene(root);
            home.setTitle("Welcome home");
            home.setScene(scene);
            home.setResizable(false);
            home.show();
        } else {
            System.err.println("bad connection");
        }
    }

}


