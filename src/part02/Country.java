package part02;

/**
 * @author alotfulina
 * Class keeps track of subscriptions for given country
 * takes in countryName and numberOfCountries
 * Consists of class constructor and following methods:
 * - addSubscriptionYear(int year, double subscription) : 
 * creates a new SubscriptionYear object and save it in subscriptions linked list
 * - getName() : getter method for country name
 * - getNumSubscriptionsForPeriod(int startYear, int endYear) : 
 * returns a type double for the total number of subscriptions between start and end years
 * - equals(Object other) : returns true if country names are equal
 * - toString() : returns string representation of class object
 */

public class Country {
	
	private String name; // country name
	private LinkedList<SubscriptionYear> subscriptions; //subscriptions data for the country

//  Constructor is no longer needed after converting subscriptions into LinkedList
//	public Country(String countryName, int numOfCountries){
//		this.name = countryName;
//		this.subscriptions = new LinkedList<SubscriptionYear>();
//	}
	
	/**
	 * Class Constructor
	 * @param countryName
	 */
	public Country(String countryName){
		this.name = countryName;
		this.subscriptions = new LinkedList<SubscriptionYear>();
	}
	
	/**
	 * Method that creates a new SubscriptionYear object 
	 * and adds it to a linked list of subscriptions
	 * @param year
	 * @param subscription
	 */
	public void addSubscriptionYear(int year, double subscription){
		SubscriptionYear newSubscription = 
				new SubscriptionYear(year, subscription);
		this.subscriptions.add(newSubscription);
	}
	
	/**
	 * Getter method for Country name
	 * @return String name
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * Method that returns total number of subscriptions
	 * between start and end years
	 * @param startYear
	 * @param endYear
	 * @return double numSubscriptions
	 */
	public double getNumSubscriptionsForPeriod(int startYear, int endYear){
		int listLength = this.subscriptions.getLength();
		int firstYear = this.subscriptions.getElementAtIndex(0).getYear();
		int lastYear = subscriptions.getElementAtIndex(listLength - 1).getYear();
		double numSubscriptions = 0;
		
		int startYearIndex = startYear - firstYear;
		int endYearIndex = endYear - firstYear;
		try{
			// exclude requested year errors
			if (startYearIndex < 0){
				throw new Exception ("ERROR: requested year " + startYear
						+ " is less than starting year " + firstYear + ":");
			}
			
			if (endYearIndex > listLength){
				throw new Exception ("ERROR: requested year " + endYear
						+ " is greater than end year " 
						+ lastYear + ":");
			}
			
			if (endYear < startYear){
				throw new Exception("ERROR: requested end year " + endYear 
						+ " is earlier than requested start year " + startYear + ":");
			}
			
			// add each year subscriptions to numSubscriptions for country
			for (int index = startYearIndex; index <= endYearIndex; index++){
				double current =  this.subscriptions.getElementAtIndex(index).getSubscriptions();
				numSubscriptions += current;
			}
			
		}catch(Exception error){
			System.out.println(error.getMessage());
		}
		return numSubscriptions;
	}
	
	/**
	 * Equals method: 
	 * returns true if two County objects are equal
	 * countries are considered to be equal if they have the same name
	 */
	public boolean equals(Object other){
		// checking if object is of type Country
		if (other instanceof Country){
			// creating object of Country
			Country ref = (Country)other;
			// comparing country names
			if (this.name.equals(ref.name)){
				return true;
			}
		}
		return false;		
	}
	
	/**
	 * String representation of County class object
	 */
	public String toString(){
		String subscriptionsText = "";
		subscriptionsText += String.format("%-25s", this.name);
		for (int i = 0; i < this.subscriptions.getLength(); i++) {
			if(this.subscriptions.getElementAtIndex(i)==null){
				subscriptionsText += " " + String.format("%6s", "n/a");
			}else{
				double currentYearSubscriptions = this.subscriptions.getElementAtIndex(i).getSubscriptions();
				subscriptionsText += " " + String.format("%6.2f", currentYearSubscriptions);
			}		
		}
		return subscriptionsText;
	}
}
