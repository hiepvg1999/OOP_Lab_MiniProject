package visual;
import element.Dimensions;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

import algo.LinkedList;
public class LinkedListDrawing {
	private LinkedList list;
	private int xStart = 10;
	private int yStart =  50;
	private int height = 30;
    private int width = 30;
	private int arrow = 15;
	public LinkedListDrawing( LinkedList list  )
	  {
	    this.list = list;
	  } 
	  
	public int getxStart() {
		return xStart;
	}


	public void setxStart(int xStart) {
		this.xStart = xStart;
	}


	public int getyStart() {
		return yStart;
	}


	public void setyStart(int yStart) {
		this.yStart = yStart;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getArrow() {
		return arrow;
	}


	public void setArrow(int arrow) {
		this.arrow = arrow;
	}


	public void drawList( GraphicsContext gc )
	  {
	    gc.clearRect( 0, 0, Dimensions.PANE_WIDTH, Dimensions.PANE_HEIGHT );
	  
	    int x = xStart;
	    int y = yStart;
	    int i = 0;
	    drawHead(gc, x+width/2, y+height+arrow);
	    ArrayList<Integer> duplicateList = list.toArrayList( );
	    for ( int value : duplicateList )
	    {
	      drawNode( gc, value, x, y );
	      i++;
	      x = x +(width+arrow);
	    }
	    x=x+3;
	    if ( i > 0 )
	      drawNull( gc, x, y );
	  } 
	
	
	  public void drawNode( GraphicsContext gc, int value, int x, int y )
	  {

	      gc.setStroke( Color.BLACK );
	      gc.strokeRect(x, y, width, height);
	      gc.strokeLine(x+width, y+height/2+width, x+width+arrow, y+height/2+width+arrow);
	      int fontSize = 14;
	      Font font = new Font( "Courier New", fontSize );
	      String str = "" + value;
	      
	      gc.setFont( font );
	      gc.setFill( Color.BLUE );
	      gc.fillText( str, x + width / 3 - width / 6, y + height / 2  + height / 10 ); // data as a string

	  } 
	  
	 public void drawNull( GraphicsContext gc, int x, int y )
	 {
	      int fontSize = 14;
	      Font font = new Font( "Courier New", fontSize );
	      gc.setFont( font );
	      gc.setFill( Color.BLUE );
	      gc.fillText( "NULL", x, y);
	 }
	 
	 public void drawHead(GraphicsContext gc, int x,int y)
	 {
		 gc.setStroke(Color.BLACK);
		 gc.strokeRect(x, y, width/2, height/2);
		 gc.strokeLine(x+width/2, y, x+width/2, y-arrow);
		 int fontSize = 7;
		 Font font = new Font( "Courier New", fontSize );
	     gc.setFont( font );
	     gc.setFill( Color.BLUE );
	     gc.fillText("head", x+width/6, y+height/8);
	 }
}
