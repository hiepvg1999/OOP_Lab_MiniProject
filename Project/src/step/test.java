package step;
import javafx.animation.PathTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class test extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        Pane root = new Pane();

        Path path = new Path();
        path.getElements().add(new MoveTo(20,120));
        //path.getElements().add(new LineTo(50,120));
        path.getElements().add(new LineTo(50,200));
        StackPane shape = new StackPane();
        Circle circle = new Circle(20,120,10);
        circle.setFill(Color.CORAL);
        circle.setStroke(Color.BLACK);
        Text label = new Text("1");
        label.setFont(Font.font(12));
        shape.getChildren().addAll(circle,label);
        PathTransition ptr = new PathTransition();
        ptr.setDuration(Duration.seconds(3));
        ptr.setDelay(Duration.seconds(1));
        ptr.setPath(path);
        ptr.setNode(shape);
        ptr.setCycleCount(1);
        ptr.setAutoReverse(false);
        
        Path path1 = new Path();
        path1.getElements().add(new MoveTo(50,200));
        path1.getElements().add(new LineTo(100,200));

        Circle circle1 = new Circle(50, 200, 10);
        circle1.setFill(Color.CADETBLUE);

        PathTransition ptr1 = new PathTransition();

        ptr1.setDuration(Duration.seconds(3));
        ptr1.setDelay(Duration.seconds(1));
        ptr1.setPath(path1);
        ptr1.setNode(circle1);
        ptr1.setCycleCount(1);
        ptr1.setAutoReverse(false);
        
        SequentialTransition seqtr = new SequentialTransition();
        seqtr.getChildren().addAll(ptr1,ptr);
        seqtr.play();
        root.getChildren().addAll(path,shape,path1,circle1);

        Scene scene = new Scene(root, 450, 300);

        stage.setTitle("PathTransition");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}