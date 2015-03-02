package part01;

/**
 * @author alotfulina Cloneable "CountryList" holds linked list of CountryNode
 *         objects, that can store as many objects as the user might want to add
 *         to it. Methods: A constructor that creates an empty CountryList
 *         object. A method â€œadd()â€� that takes a Country object as parameter
 *         and adds that new object to the end of the list. A method "contains"
 *         that takes a Country object as parameter and checks if the name of
 *         the country can be found in the list . A method â€œtoString()â€�
 *         which returns a string containing information about every country in
 *         the list.
 */

public class CountryList implements Cloneable {

	private CountryNode head;
	private int length;

	/**
	 * Class constructor
	 */
	public CountryList() {
		this.head = null;
		this.length = 0;
	}

	/**
	 * Accessor method for list length
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Setter method for list length
	 */
	public void setLength(int listLength) {
		this.length = listLength;
	}

	/**
	 * method that adds new object to the end of the list
	 */
	public void add(Country country) {
		// set current node to firstNode
		CountryNode current = this.head;
		// create new country node for country we're trying to add
		CountryNode newCountry = new CountryNode(country);
		// if firstNode is null, assign new country to it
		if (this.head == null) {
			this.head = newCountry;
			this.head.setNext(null);
		} else {
			// search for last available (empty) node
			while (current.getNextNode() != null) {
				current = current.getNextNode();
			}
			// assign country to it and set next node to null
			current.setNext(newCountry);
			current.getNextNode().setNext(null);
		}
		// update list length
		this.length++;
	}

	/**
	 * method that adds new object to the requested index of the list
	 */
	public void addCountryAtIndex(Country country, int requestedIndex) {
		// set current node to firstNode
		CountryNode current = this.head;
		// create new country node for country we're trying to add
		CountryNode newCountry = new CountryNode(country);
		// check if index exists in current List
		// return error message if requested index is out of range
		if (requestedIndex > this.length) {
			System.out.println("ERROR: Index " + requestedIndex
					+ " doesn't exists. " + "Number of list items is "
					+ this.length
					+ "\nFollowing country won't be added to the list.: "
					+ country.getName());
		} else {
			// find previous to requested index
			int currentIndex = 0;
			CountryNode elementAtIndex;
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
	public Country getElementAtIndex(int requestedIndex) {
		Country elementFound = null;
		// set current node to firstNode
		CountryNode current = this.head;
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
			elementFound = current.getCountry();
		}
		return elementFound;
	}

	/**
	 * Method that checks if the name of the country is already in the list
	 * 
	 * @return
	 */
	public Country contains(Country requestedCountry) {
		CountryNode current = this.head;
		// CountryNode requested = new CountryNode(country);
		Country countryFound = null;
		// check if country is already in the list, return country
		while (current != null) {
			Country currentCountry = current.getCountry();
			if (currentCountry.equals(requestedCountry)) {
				countryFound = currentCountry;
				break;
			}
			current = current.getNextNode();
		}
		// if country is not in the list, return null
		return countryFound;
	}

	/**
	 * Clone method for cloning class objects
	 */
	public Object clone() {
		// create new country object
		CountryList copy = new CountryList();
		// set object length
		copy.setLength(this.length);
		try {
			// if head is null, throw exception
			if (this.head == null) {
				throw new CloneNotSupportedException(
						"List is empty. Clone not supported.");
				// clone class object variables
			} else {
				copy.head = (CountryNode) this.head.clone();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// return cloned object
		return copy;
	}

	/**
	 * Method returns list of countries with their info
	 */
	public String toString() {
		CountryNode current = this.head;
		String list = "";
		while (current != null) {
			list += current.getCountry().toString() + "\n";
			current = current.getNextNode();
		}
		return list;
	}
}
