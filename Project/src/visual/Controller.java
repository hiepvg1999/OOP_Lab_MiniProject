package visual;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

import algo.Algorithm;
import algo.LinkedList;
import algo.Stack;
import element.Dimensions;
import element.Element;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import step.drawAnimation;

public class Controller implements Initializable {

	@FXML
	private AnchorPane anchorPane1;
	@FXML
	private Slider speedSlider;
	@FXML
	private ComboBox<Algorithm> comboBox;
	@FXML
	private RadioButton circleButton;
	@FXML
	private RadioButton squareButton;
	@FXML
	private AnchorPane anchorPane2;
	@FXML
	private TextField textField;
	@FXML
	private TextArea textArea;
	@FXML
	private Button insertButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button searchButton;
	@FXML
	private Pane mainPane;
	
	public static int timer;
	private LinkedList linkedList = new LinkedList();
	private Stack stack = new Stack();
	
	private int positionX=10;
	private int positionY=150;
	
	//private Pane NULL;
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Algorithm[] algos = {LinkedList.getInstance(),Stack.getInstance()};
		Objects.requireNonNull(algos);
		ObservableList<Algorithm> algoList = FXCollections.observableArrayList(Arrays.asList(algos));
		comboBox.getItems().addAll(algoList);
		speedSlider.setMax(6);
		speedSlider.setMin(1);
		circleButton.setSelected(true);
		circleButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                squareButton.setSelected(false);
            } else {
            	squareButton.setSelected(true);
            }
            
        });
		squareButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                circleButton.setSelected(false);
            } else {
            	circleButton.setSelected(true);
            }
            
        });
		speedSlider.valueProperty().addListener((observable,oldValue,newValue)->{
			timer = (int)(Dimensions.DURATION * newValue.doubleValue());
		});
		comboBox.getSelectionModel().select(0);
		speedSlider.setValue(3);
		//NULL = drawAnimation.drawNode(0,0, "null");
		//NULL.setLayoutX(10);
		//NULL.setLayoutY(150);
		insertButton.setText("Insert");
		deleteButton.setText("Delete");
		//mainPane.getChildren().addAll(NULL);
		comboBox.valueProperty().addListener((observable, oldValue, newValue)->{
			if(newValue.toString().compareTo("Linked List")==0){
				insertButton.setText("Insert");
				deleteButton.setText("Delete");
				mainPane.getChildren().remove(0, stack.getLength());
			}else if(newValue.toString().compareTo("Stack")==0){
				insertButton.setText("Push");
				deleteButton.setText("Pop");
				mainPane.getChildren().remove(0, linkedList.getLength());
			}
		});
	}
	
	public void handleInsertClicked(){
		String str = textField.getText();
		if(str.compareTo("")!=0){
		textArea.setText("Insert "+str);
		int value = Integer.parseInt(str);
		Element e;
		if(circleButton.isSelected()==true){
			e=drawAnimation.drawNode(0,0,value, 0);
		}else{
			e=drawAnimation.drawNode(0,0,value, 1);
		}
			
		e.getShape().setLayoutX(0);
		e.getShape().setLayoutY(0);
		if(comboBox.getSelectionModel().getSelectedIndex()==0){			
			PathTransition ptr = drawAnimation.makeAnimation(drawAnimation.makePath(positionX+Dimensions.R, 0, positionX+Dimensions.R, positionY+Dimensions.R), e.getShape());
			//PathTransition ptrNull = drawAnimation.makeAnimation(drawAnimation.makePath(Dimensions.WIDTH/2, Dimensions.HEIGHT/2,Dimensions.WIDTH, Dimensions.HEIGHT/2), NULL);
			SequentialTransition seqtr = new SequentialTransition();
			//System.out.println(NULL.getLayoutX()+" "+NULL.getLayoutY());
			seqtr.getChildren().addAll(ptr);
			seqtr.play();		
			mainPane.getChildren().addAll(e.getShape());
			e.setPositionX(positionX);
			e.setPositionY(positionY);
			linkedList.insert(e);
			positionX = positionX + Dimensions.R*3;
			//drawAnimation.updatePosition(NULL, NULL.getLayoutX()+Dimensions.WIDTH*1.5, NULL.getLayoutY());
			//System.out.println(NULL.getLayoutX()+" "+NULL.getLayoutY());
		}
		else if(comboBox.getSelectionModel().getSelectedIndex()==1){
			positionX =150;
			stack.insert(value);
			System.out.println(stack.arrayString());
			PathTransition ptr = drawAnimation.makeAnimation(drawAnimation.makePath(positionX,0, positionX, positionY+Dimensions.R*10), e.getShape());
			ptr.play();
			mainPane.getChildren().addAll(e.getShape());
			e.setPositionX(positionX);
			e.setPositionY(positionY);
			positionY = positionY-3*Dimensions.R;
		}
		}else {
			textArea.setText("No input");
		}
	}
	
	
	public void handleDeleteClicked(){
		if(comboBox.getSelectionModel().getSelectedIndex()==0){
		if(textField.getText().compareTo("")!=0){
		int value = Integer.parseInt(textField.getText());
		int i=0;
		ArrayList<Integer> arrayList;
		arrayList = linkedList.toArrayList();
		while (i<arrayList.size()){
			if(arrayList.get(i)==value){
				break;
			}
			i=i+1;
		}
		if(linkedList.search(value)==true){
		linkedList.delete(value);
		mainPane.getChildren().remove(i);
		System.out.println(linkedList.getLength());
		for (int j=i;j<linkedList.getLength();j++){
			double x=mainPane.getChildren().get(j).getTranslateX();
			mainPane.getChildren().get(j).setTranslateX(x-Dimensions.R*3);
		}
		positionX = positionX - Dimensions.R*3;
		textArea.setText("Delete element "+value+" successfully");
	    }else{
	    	textArea.setText("Element not found");
	    }
		}else {
			textArea.setText("Not input");
		}		
		}else if(comboBox.getSelectionModel().getSelectedIndex()==1){
			ArrayList<Integer> stackList = stack.toArrayList();
			int value;
			if(stackList.size()!=0){
				value=stackList.get(0);
				if(stack.delete()==true){
					mainPane.getChildren().remove(stack.getLength());
					System.out.println(stack.getLength());
					System.out.println(stack.arrayString());
					positionY = positionY+3*Dimensions.R;
					textArea.setText("Delete element "+value+" successful");
					}
			}else{
				textArea.setText("Delete fail");
			}
			
		}
}
	
	
	public void handleSearchClicked(){
		int value = Integer.parseInt(textField.getText());
		int i=0;
		int flag=0;
		ArrayList<Integer> arrayList;
		if(comboBox.getSelectionModel().getSelectedIndex()==0){
			i=0;
			arrayList = linkedList.toArrayList();
			while (i<arrayList.size()){
				if(arrayList.get(i)==value){
					flag=1;
					break;
				}
				i=i+1;
			}
			if(flag ==1){
				textArea.setText("Element "+value+" found");
				double x=mainPane.getChildren().get(i).getTranslateX();
				double y=mainPane.getChildren().get(i).getTranslateY();
				RotateTransition rotate = new RotateTransition();
				rotate.setAxis(Rotate.Z_AXIS);
				rotate.setByAngle(360);
				rotate.setCycleCount(1);
				rotate.setDuration(Duration.millis(1000));
				rotate.setDelay(Duration.millis(500));
				rotate.setNode(mainPane.getChildren().get(i));
				rotate.play();
			}
			else
				textArea.setText("Element "+value+" not found");
		}else if(comboBox.getSelectionModel().getSelectedIndex()==1){
			i=0;
			arrayList = stack.toArrayList();
			while (i<arrayList.size()){
				if(arrayList.get(i)==value){
					flag=1;
					break;
				}
				i=i+1;
			}
			if(flag ==1){
				textArea.setText("Element "+value+" found");
				double x=mainPane.getChildren().get(stack.getLength()-1-i).getTranslateX();
				double y=mainPane.getChildren().get(stack.getLength()-1-i).getTranslateY();
				RotateTransition rotate = new RotateTransition();
				rotate.setAxis(Rotate.Z_AXIS);
				rotate.setByAngle(360);
				rotate.setCycleCount(1);
				rotate.setDuration(Duration.millis(1000));
				rotate.setDelay(Duration.millis(500));
				rotate.setNode(mainPane.getChildren().get(stack.getLength()-1-i));
				rotate.play();
			}
			else
				textArea.setText("Element "+value+" not found");
		}		
		
		
	}
	public void minimize(ActionEvent e ) {
        ((Stage)((Button)e.getSource()).getScene().getWindow()).setIconified(true);
    }

    public void close() {
        System.exit(0);
    }
}
