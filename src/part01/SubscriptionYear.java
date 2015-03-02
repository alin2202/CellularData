package part01;
/**
 * @author alotfulina
 * Class Subscription Year takes in year and number of subscriptions for the year
 * and keeps track of these two values
 * Class consists of class constructor and following methods:
 * - setYear(int year) : setter method for class variable "year"
 * - setSubscriptions(double numOfSubscritions) : setter method for class variable "subscriptions"
 * - getYear() : getter method for class variable "year"
 * - getSubscriptions() : getter method for class variable "subscriptions"
 * - toString() : string representation of the class (year)
 */
public class SubscriptionYear implements Cloneable{
	
	private int year;
	private double subscriptions;
	
	// class constructor
	public SubscriptionYear(int year, double numOfSubscriptionsForYear){
		this.year = year;
		this.subscriptions = numOfSubscriptionsForYear;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public void setSubscriptions(double numOfSubscritions){
		this.subscriptions = numOfSubscritions;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public double getSubscriptions(){
		return this.subscriptions;
	}
	
	public String toString(){
		return Integer.toString(this.year); 
	}
	
	public Object clone(){
		SubscriptionYear copy = 
				new SubscriptionYear(this.year, this.subscriptions);
		return copy;
	}

}
