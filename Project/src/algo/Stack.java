package algo;

import java.util.ArrayList;

import element.Element;

public class Stack implements Algorithm{
	private Element top;
	private int length=0;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public static Stack ourInstance = new Stack();
	public static Stack getInstance(){
		return ourInstance;
	}
	public Stack(){
		top= null;
	}
	public void insert(int value){
		Element e = new Element(value);
		length++;
		if(top == null){
			top= e;
		}else{
			e.setNextElement(top);
			top = e;
		}
	}
	public boolean delete(int value){
		return true;
	}
	public boolean delete(){
		if(top == null){
			return false;
		}else{
			Element tmp = top;
			top = tmp.getNextElement();
			length--;
		}
		return true;
	}
	public boolean search(int value){
		Element tmp =top;
		while(tmp!=null){
			if(tmp.getValue() == value){
				return true;
			}
			tmp= tmp.getNextElement();
		}
		return false;
	}
	public ArrayList<Integer> toArrayList(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		Element tmp = top;
		while(tmp!= null){
			result.add(tmp.getValue());
			tmp= tmp.getNextElement();
		}
		return result;
	}
	public String arrayString(){
		String result = "";
		Element tmp = top;
		while(tmp!= null){
			result+=tmp.getValue();
			result+=" ";
			tmp= tmp.getNextElement();
		}
		return result;
	}
	@Override
	public String toString(){
		return "Stack";
	}
}
