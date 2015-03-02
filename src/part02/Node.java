package part02;
/**
 * @author alotfulina
 * Class Node, object of which holds information about Node of requested type
 * - A generic variable called "data".
 * - A parametrized variable called "next".
 * - A constructor that takes in a generic object as a parameter.
 * - A constructor that takes in two parameters, 
 * a generic object and an object of parametrized Node type.
 * - A setter method for the attribute "next".
 * - Getter methods for all other attributes: getData() getNextNode().
 * - A toString method that returns the string representation of "data".
 */
public class Node<T> {
	
	// A generic variable called "data".
	private T data;
	// A parametrized variable called "next".
	private Node<T> next;
	
	/**
	 * Class Constructor 1
	 */
	//A constructor that takes in a generic object as a parameter.
	public Node(T data){
		this.data = data;
	}
	
	/**
	 * Class Constructor 2
	 */
	// A constructor that takes in two parameters, a generic object and an object of parametrized Node type.
	public Node(T data, Node<T> next){
		this.data = data;
		this.next = next;
	}
	
	
	/**
	 * Accessor methods for class attributes
	 */
	
	//A setter method for the attribute "next".
	public void setNext(Node<T> nextNode){
		this.next = nextNode;
	}
	
	// Getter methods for all attributes.
	public T getData() {
		return this.data;
	}
	
	// Getter methods for all attributes.
	public Node<T> getNextNode(){
		return this.next;
	}

	// A toString method that returns the string representation of "data".
	public String toString(){
		String node = "";
		// COMPLETE	
		node += "[" + this.data.toString() + "]";
		return node;
	}
	
}
