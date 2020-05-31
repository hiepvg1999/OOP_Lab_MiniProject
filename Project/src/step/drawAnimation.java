package step;

import element.Dimensions;
import element.Element;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import visual.Controller;

public class drawAnimation extends Element {
	public drawAnimation(){
		super();
	}
	public static Element drawNode(int x,int y,int value,int flag){
		Element node = new Element(value);
		if(flag==0){
			Circle circle = new Circle(x,y,Dimensions.R);
			circle.setFill(Color.CORAL);
			circle.setStroke(Color.BLACK);
			String string =""+value;
			Text txt = new Text(string);
			txt.setFont(Font.font(12));
			StackPane shape = new StackPane();
			shape.getChildren().addAll(circle,txt);
			node.setShape(shape);
			return node;			
		}
		else {
			Rectangle square = new Rectangle(x,y,Dimensions.WIDTH,Dimensions.HEIGHT);
			square.setFill(Color.CORAL);
			square.setStroke(Color.BLACK);
			String string =""+value;
			Text txt = new Text(string);
			StackPane shape = new StackPane();
			shape.getChildren().addAll(square,txt);
			node.setShape(shape);
			return node;
		}
	}
	public static Pane drawNode(int x,int y,String string){
			Rectangle square = new Rectangle(x,y,Dimensions.WIDTH,Dimensions.HEIGHT);
			square.setFill(Color.CORAL);
			square.setStroke(Color.BLACK);
			Text txt = new Text(string);
			StackPane shape = new StackPane();
			shape.getChildren().addAll(square,txt);
			return shape;

	}
	public static Path makePath(int x1,int y1,int x2,int y2){
		Path path = new Path();
		path.getElements().add(new MoveTo(x1,y1));
		path.getElements().add(new LineTo(x2,y2));
		return path;
	}
	public static PathTransition makeAnimation(Path path,Pane p){
		PathTransition ptr = new PathTransition();
		ptr.setDuration(Duration.seconds(Controller.timer));
        ptr.setDelay(Duration.seconds(Controller.timer/3));
        ptr.setPath(path);
        ptr.setNode(p);
        ptr.setCycleCount(1);
        ptr.setAutoReverse(false);
        return ptr;
	}
	public static Pane updatePosition(Pane p,double x,double y){
		p.setLayoutX(x);
		p.setLayoutY(y);
		return p;
	}
	
}
