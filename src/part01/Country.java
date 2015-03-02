package part01;
/**
 * @author alotfulina
 * Class keeps track of subscriptions for given country
 * takes in countryName and numberOfCountries
 * Consists of class constructor and following methods:
 * - addSubscriptionYear(int year, double subscription) : 
 * creates a new SubscriptionYear object and save it in â€œsubscriptionsâ€� array
 * - getNumSubscriptionsForPeriod(int startYear, int endYear) : 
 * returns a type double for the total number of subscriptions between start and end years
 * - toString() : returns string representation of class object
 */
public class Country implements Cloneable{
	
	private String name; // country name
	private SubscriptionYear[] subscriptions; //subscriptions data for the country
	
	public Country(String countryName, int numOfCountries){
		this.name = countryName;
		this.subscriptions = new SubscriptionYear[numOfCountries];
	}
	
	// additional constructor
	public Country(String countryName){
		this.name = countryName;
	}
	
	// method creates a new SubscriptionYear object and save it in â€œsubscriptionsâ€� array
	public void addSubscriptionYear(int year, double subscription){
		SubscriptionYear currentYearSubscription = 
				new SubscriptionYear(year, subscription);
		for (int i = 0; i < this.subscriptions.length; i++){
			if (subscriptions[i]==null){
				subscriptions[i] = currentYearSubscription;
				break;
			}
		}
	}
	
	public void removeCurrentSubscriptions(){
		for(int i = 0; i < this.subscriptions.length; i++){
			subscriptions[i] = null;
		}	
	}
	
	/*
	 * Accessor method "getName()" for Country name
	 */
	public String getName(){
		return this.name;
	}
	
	public void setName(String newName){
		this.name = newName;
	}
	
	// returns a type double for the total number of subscriptions between start and end years
	public double getNumSubscriptionsForPeriod(int startYear, int endYear){
		double numSubscriptions = 0;
		int firstYear = this.subscriptions[0].getYear();
		int startYearIndex = startYear - firstYear;
		int endYearIndex = endYear - firstYear;
		try{
			// exclude requested year errors
			if (startYearIndex < 0){
				throw new Exception ("ERROR: requested year " + startYear
						+ " is less than starting year " + firstYear + ":");
			}
			
			if (endYearIndex > subscriptions.length){
				throw new Exception ("ERROR: requested year " + endYear
						+ " is greater than end year " 
						+ this.subscriptions[subscriptions.length - 1].getYear() + ":");
			}
			
			if (endYear < startYear){
				throw new Exception("ERROR: requested end year " + endYear 
						+ " is earlier than requested start year " + startYear + ":");
			}
			
			// add each year subscriptions to numSubscriptions for country
			for (int index = startYearIndex; index <= endYearIndex; index++){
				double current =  this.subscriptions[index].getSubscriptions();
				numSubscriptions += current;
			}
			
		}catch(Exception error){
			System.out.println(error.getMessage());
		}
		return numSubscriptions;
	}
	
	/**
	 * Equals method: 
	 * defines whether two CountyNode objects are equal or not
	 */
	public boolean equals(Object other){
		// checking if object is of type CountryNode
		if (other instanceof Country){
			// creating object of CountryNode
			Country ref = (Country)other;
			// comparing country
			if (this.name.equals(ref.name)){
				return true;
			}
		}
		return false;		
	}
	
	public Object clone(){
		// create new country object
		Country copy = new Country(this.name, this.subscriptions.length);
		// clone subscriptions values
		for (int i = 0; i < this.subscriptions.length; i++){
			copy.subscriptions[i] = (SubscriptionYear) this.subscriptions[i].clone();
		}
		// return cloned object
		return copy;
	}
	
	public String toString(){
		String subscriptionsText = "";
		subscriptionsText += String.format("%-25s", this.name);
		for (int i = 0; i < this.subscriptions.length; i++) {
			if(this.subscriptions[i]==null){
				subscriptionsText += " " + String.format("%6s", "n/a");
			}else{
				double currentYearSubscriptions = this.subscriptions[i].getSubscriptions();
				subscriptionsText += " " + String.format("%6.2f", currentYearSubscriptions);
			}		
		}
		return subscriptionsText;
	}
}
