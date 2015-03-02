package part01;
/**
 * @author alotfulina
 * Class CountryNode represents node object for Linked List "CountryList"
 * Methods:
 * A constructor that takes in an object of type Country as a parameter.
 * A constructor that takes in two parameters, an object of type Country and an object of type CountryNode.
 * Getter methods for country and next attributes.
 * A setter method for the attribute "next".
 * A method "equals()" which defines when objects of CountryNode are equal
 */
public class CountryNode implements Cloneable {
	
	Country country;
	CountryNode next;
	
	/**
	 * Class Constructor 1
	 */
	public CountryNode(Country country){
		this.country = country;
		this.next = null;
	}
	
	/**
	 * Class Constructor 2
	 */
	public CountryNode(Country country, CountryNode nextNode){
		this.country = country;
		this.next = nextNode;
	}
	
	
	/**
	 * Accessor methods for class attributes
	 */
	
	public void setNext(CountryNode nextNode){
		this.next = nextNode;
	}
	
	public CountryNode getNextNode(){
		return this.next;
	}
	
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
	}
	
	/**
	 * Clone method for creating a clone copy of class object
	 */
	public Object clone(){
		CountryNode copy = null; 
		if (this.next == null){
			copy = new CountryNode((Country) this.country.clone());
			return copy;
		}else{
			copy = new CountryNode((Country) this.country.clone(), (CountryNode) this.next.clone());
			return copy;
		}
	}
	
}
