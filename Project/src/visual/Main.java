package visual;

import element.Dimensions;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ViewController.fxml"));
        primaryStage.setTitle("OOP lab");
        Scene scene =new Scene(root,Dimensions.SCENE_WIDTH,Dimensions.SCENE_HEIGHT);
        scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
        primaryStage.setScene(scene);
    
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        root.setOnMousePressed(e -> {
            x = e.getSceneX();
            y = e.getSceneY();
        });

        root.setOnMouseDragged(e -> {
            primaryStage.setX(e.getScreenX() - x);
            primaryStage.setY(e.getScreenY() - y);
        });

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
