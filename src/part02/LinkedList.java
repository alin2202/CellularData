package part02;

import java.util.Iterator;

/**
 * LinkedList generic list that can hold list of elements of specified object type.
 * Class contains default constructor and following methods:
 * - A getter method getLength() for list length; 
 * - A method add() that takes a generic object as parameter 
 * and adds that new object to the end of the list.
 * - A method addElementAtIndex() that adds new object to the requested index of the list 
 * - A method getElementAtIndex() that returns element at requested index 
 * - A method contains() that takes a generic object as parameter 
 * and checks if the object can be found in the linked list. 
 * - A method toString() which returns a string containing information about every country in the list. 
 * - A method iterator() that returns object of type ListIterator. 
 * - An inner class ListIterator that is used to traverse the collection of objects in the list
 */

public class LinkedList<T> implements Iterable<T> {

	private Node<T> head;
	private int length;

	/**
	 * Class constructor that creates an empty LinkedList object.
	 */
	public LinkedList() {
		this.head = null;
		this.length = 0;
	}

	/**
	 * A method iterator() that returns object of type ListIterator.
	 */
	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}

	/**
	 * ListIterator An inner class of LinkedList that is used to traverse the
	 * collection of objects in the list. Class includes: - A generic field
	 * called current that keeps track of the current location being traversed.
	 * - A constructor that initializes current to the beginning of the list. -
	 * A method nasNext() that determines whether there is a next element in the
	 * list - A method next()that returns the next object in the list.
	 */
	private class ListIterator implements Iterator<T> {
		private Node<T> current;

		/**
		 * Inner class constructor that initializes current to the beginning of
		 * the list
		 */
		public ListIterator() {
			current = head;
		}

		/**
		 * Method that returns true if there is a next element in the list and
		 * false if current the element is at the end of the list
		 */
		public boolean hasNext() {
			if (current == null)
				return false;
			return true;
		}

		/**
		 * Method that returns the next object in the list
		 */
		public T next() {
			if (current == null) {
				throw new java.util.NoSuchElementException();
			}
			T data = current.getData();
			current = current.getNextNode();
			return data;
		}
	}

	/**
	 * Accessor method for list length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * A method add() that takes a generic object as parameter and adds that new
	 * object to the end of the list.
	 */
	public void add(T nodeElement) {
		// set current node to firstNode
		Node<T> current = this.head;
		// create new country node for country we're trying to add
		Node<T> newNode = new Node<T>(nodeElement);
		// if firstNode is null, assign new country to it
		if (this.head == null) {
			this.head = newNode;
			this.head.setNext(null);
		} else {
			// search for last available (empty) node
			while (current.getNextNode() != null) {
				current = current.getNextNode();
			}
			// assign country to it and set next node to null
			current.setNext(newNode);
			current.getNextNode().setNext(null);
		}
		// update list length
		this.length++;
	}

	/**
	 * Method addElementAtIndex that adds new object to the requested index of
	 * the list
	 */
	public void addElementAtIndex(T country, int requestedIndex) {
		// set current node to firstNode
		Node<T> current = this.head;
		// create new country node for country we're trying to add
		Node<T> newCountry = new Node<T>(country);
		// check if index exists in current List
		// return error message if requested index is out of range
		if (requestedIndex > this.length) {
			System.out.println("ERROR: Index " + requestedIndex
					+ " doesn't exist. " + "Number of list items is "
					+ this.length
					+ "\nRequested country can't be added to the list. ");
		} else {
			// find previous to requested index
			int currentIndex = 0;
			Node<T> elementAtIndex;
			if (requestedIndex == 0) {
				// store head in temporary variable
				elementAtIndex = current;
				// add element to 0 index
				current = newCountry;
				// set temp to be next element
				current.setNext(elementAtIndex);
				// reset head
				this.head = current;
			} else {
				while (currentIndex != requestedIndex - 1) {
					current = current.getNextNode();
					currentIndex++;
				}
				// move current element at index to temporary variable
				elementAtIndex = current.getNextNode();
				// set our new country as next node to
				// country at previous index
				current.setNext(newCountry);
				// move node one step forward (to requested index)
				current = current.getNextNode();
				// assign new country to requested node
				current = newCountry;
				// set next to temporary variable created before
				current.setNext(elementAtIndex);
			}
			// increment list length
			this.length++;
		}
	}

	/**
	 * Method getElementAtIndex() that returns element at requested index
	 */
	public T getElementAtIndex(int requestedIndex) {
		T elementFound = null;
		// set current node to firstNode
		Node<T> current = this.head;
		// check if index exists in current List
		// return error message if requested index is out of range
		if (requestedIndex > this.length) {
			System.out.println("ERROR: Index " + requestedIndex
					+ " doesn't exist. " + "Number of list items is "
					+ this.length);
		} else {
			// find element at requested index
			// and write it onto elementFound varialbe
			int currentIndex = 0;
			while (currentIndex != requestedIndex) {
				current = current.getNextNode();
				currentIndex++;
			}
			elementFound = current.getData();
		}
		return elementFound;
	}

	/**
	 * A method contains() that takes a generic object as parameter and checks
	 * if the object can be found in the linked list.
	 */
	public T contains(T requestedObject) {
		Node<T> current = this.head;
		T objectFound = null;
		// check if requested object is already in the list, return country
		while (current != null) {
			T currentObject = current.getData();
			if (currentObject.equals(requestedObject)) {
				objectFound = currentObject;
				break;
			}
			current = current.getNextNode();
		}
		// if requested object is not in the list, return null
		return objectFound;
	}

	/**
	 * A method toString() which returns a string containing information about
	 * every country in the list.
	 */
	public String toString() {
		Node<T> current = this.head;
		String list = "";
		while (current != null) {
			list += "\n" + current.getData().toString();
			current = current.getNextNode();
		}
		return list;
	}
}
