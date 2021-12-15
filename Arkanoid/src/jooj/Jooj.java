package jooj;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Jooj extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane root = new Game();
        root.setStyle("-fx-background-color: #363636");
        Scene scene = new Scene(root, 700, 550);
        primaryStage.setTitle("Árcanóide");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
        
        
    public static void main(String[] args) {
        launch(args);
    }
    
}
