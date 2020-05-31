package element;


import javafx.scene.layout.Pane;

public class Element {
    private int value;

    private int index;

    Pane shape;
    
    Element nextElement;
    
    private double positionX;
    private double positionY;
    public Element(){
    	
    }
    public Element(int value){
    	this.value = value;
    	//nextElement = null;
    }
    public Element(int value, int index) {
        this.value = value;
        this.index = index;
        nextElement = null;
    }
    public Element(int value, Element nextElement){
    	this.value = value;
    	this.nextElement = nextElement;
    }
    
    public double getPositionX() {
		return positionX;
	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	public Element getNextElement() {
		return nextElement;
	}
    
	public void setNextElement(Element nextElement) {
		this.nextElement = nextElement;
	}
	public Pane getShape() {
        return shape;
    }
	public Element setShape(Pane shape){
		this.shape = shape;
		return this;
	}
    public int getValue() {
        return value;
    }
    public void setValue(int value){
    	this.value = value;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public enum Type {
        CIRCLE, SQUARE
    }

}

