package part02;
/**
 * @author alotfulina
 * Class Subscription consists of class constructor and following methods:
 * - setYear(int year) : setter method for class variable "year"
 * - setSubscriptions(double numOfSubscritions) : setter method for class variable "subscriptions"
 * - getYear() : getter method for class variable "year"
 * - getSubscriptions() : getter method for class variable "subscriptions"
 * - equals(Object other) : returns true if year and subscriptions values of SubscriptionYear objects are equal
 * - toString() : string representation of the class object
 */

public class SubscriptionYear {
	
	private int year;
	private double subscriptions;
	
	/**
	 * Class constructor
	 * @param year
	 * @param numOfSubscriptionsForYear
	 */
	public SubscriptionYear(int year, double numOfSubscriptionsForYear){
		this.year = year;
		this.subscriptions = numOfSubscriptionsForYear;
	}
	
	/**
	 * Setter method for year
	 * @param year
	 */
	public void setYear(int year){
		this.year = year;
	}
	
	/**
	 * Setter method for subscriptions
	 * @param numOfSubscritions
	 */
	public void setSubscriptions(double numOfSubscritions){
		this.subscriptions = numOfSubscritions;
	}
	
	/**
	 * Getter method for year 
	 * @return int year
	 */
	public int getYear(){
		return this.year;
	}
	
	/**
	 * Getter method for subscriptions
	 * @return double subscriptions
	 */
	public double getSubscriptions(){
		return this.subscriptions;
	}
	
	/**
	 * Equals method: 
	 * defines whether two SubscriptionYear objects are equal or not
	 */
	public boolean equals(Object other){
		// checking if object is of type SubscriptionYear
		if (other instanceof SubscriptionYear){
			// creating object of SubscriptionYear
			SubscriptionYear ref = (SubscriptionYear)other;
			// comparing year and number of subscriptions
			if (this.year == ref.year && this.subscriptions == ref.subscriptions){
				return true;
			}
		}
		return false;		
	}
	
	/**
	 * Method that defines string representation of class object
	 */
	public String toString(){
		return Integer.toString(this.year); 
	}

}
