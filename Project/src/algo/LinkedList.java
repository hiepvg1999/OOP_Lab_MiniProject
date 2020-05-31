package algo;
import java.util.ArrayList;
import element.Element;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import step.drawAnimation;
public class LinkedList implements Algorithm {
	private Element head;
	private int length=0;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	private static LinkedList ourInstance = new LinkedList();
	public static LinkedList getInstance() {
        return ourInstance;
    }
	public LinkedList(){
		head = null;
	}
	public void insert(int value){
	Element node = new Element(value,length);
	if(head == null){
		head = node;
	}else{
		Element current = head;
		Element previous = null;
		while(current != null){
			previous = current;
			current = current.getNextElement();
		}
		if ( current == head ) // insert at beginning
	      {
	        node.setNextElement(head);
	        head = node;
	      }
	      else // insert between previous and current
	      {
	        node.setNextElement( current );
	        previous.setNextElement( node );
	      } 
	}
	}
	public void insert(Element node){
		if(head == null){
			head = node;
		}else{
			Element current = head;
			Element previous = null;
			while(current != null){
				previous = current;
				current = current.getNextElement();
			}
			if ( current == head ) // insert at beginning
		      {
		        node.setNextElement(head);
		        head = node;
		      }
		      else // insert between previous and current
		      {
		        node.setNextElement( current );
		        previous.setNextElement( node );
		      } 
		}
		length++;
		}
	public boolean delete(int value){
		 Element current = head;
		 Element previous = null;
		    while ( current != null )
		    {
		      if ( current.getValue() == value )
		        break;
		      previous = current;
		      current = current.getNextElement();
		    }
		    
		    if ( current == null ) // not found
		      return false;
		    else if ( previous == null ){ // delete the first node
		      head = head.getNextElement();
		      length--;
		    }
		    else{ // delete between previous and current
		      previous.setNextElement( current.getNextElement());
		      length--;
		    }
		    return true;
	}
	public boolean search(int value){
		Element current = head;
		Element previous = null;
		    while ( current != null )
		    {
		      if ( current.getValue() == value )
		        break;
		      previous = current;
		      current = current.getNextElement();
		    }
		if(current == null)
			return false;
		return true;
	}
	public Element getElementbyIndex(int index){
		Element current= head;
		int i=0;
		while(i!= index-1){
			current = current.getNextElement();
			i++;
		}
		return current;
	}
	public ArrayList<Integer> toArrayList( )
	  {
	    ArrayList<Integer> result = new ArrayList<Integer>( );
	    Element current = head;
	    while ( current != null )
	    {
	      result.add( current.getValue( ) );
	      current = current.getNextElement();
	    }
	    return result;
	  }
	@Override
	public String toString(){
		return "Linked List";
	}
	
}
