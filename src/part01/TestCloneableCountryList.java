package part01;
import java.util.Random;

/**
 *  Tests the Cloneable class CountryList by creating an object of type CountryList.
 *  Then, cloning the object and modifying the cloned object.
 */
public class TestCloneableCountryList {

	private static final int LIST_SIZE = 4;
	
	/**
	 * Builds a list of countries to debug.
	 */
	private void debugListOfCountries(Country [] allCountries)
	{
		// TO COMPLETE
	}
	
	/**
	 * Creates a list of randomly selected countries
	 */
	private CountryList createCloneableList(Country [] allCountries, int selectionSize)
	{	
		Random random = new Random();
		CountryList selectedCountries = new CountryList();
		for (int i = 0; i < selectionSize; i++)
		{
			int selectedIndex = random.nextInt(allCountries.length);
			selectedCountries.add(allCountries[selectedIndex]);
		}
				
		return selectedCountries;
	}
	
	/**
	 * modifies one or more countries print the updated list of countries
	 */
	private CountryList testCloneableList(CountryList listOfCountries)
	{
		CountryList clonedList = null;
		
		// TO COMPLETE
		
		return clonedList;
	}

	/**
	 * Includes test examples for class GraphView.
	 */
	public static void main(String[] args) 
	{

		final String FILENAME = "resources/cellular.csv";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS (i.e. Operating System)

		

		// Parse the CSV data file
		//
		CSVReader parser = new CSVReader(FILENAME);

		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		

		
		// Create and set objects of type Country 
		//
		Country [] countries;
		countries = new Country[countryNames.length];
		Country current;

		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++)
		{
			int numberOfYears = yearLabels.length;   // OR numberOfYears = dataTable[countryIndex].length;

			current = new Country(countryNames[countryIndex], numberOfYears);
					
			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++)
			{
				double [] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}
			countries[countryIndex] = current;
		}
			
		TestCloneableCountryList application = new TestCloneableCountryList();
	
		CountryList listOfCountries = application.createCloneableList(countries, TestCloneableCountryList.LIST_SIZE);
	
		// Output the countries added to the CountryList
		System.out.println("\nList of countries: ");
		System.out.println(listOfCountries);
		
		
		// Clone and modify the list of nodes
		// TO COMPLETE: Complete the implementation of "testCloneableList" to:
		// 				- Create a clone of your linked list.
		//				- Modify two or more countries in the cloned linked list.
		CountryList clonedAndModifiedList;
		clonedAndModifiedList = application.testCloneableList(listOfCountries);

		
		// NOTE REGARDING OUTPUT
		// The difference between the original and the modified node(s) in the cloned list must be apparent.
		System.out.println("\n\nOriginal list of countries: ");
		System.out.println(listOfCountries);
		
		System.out.println("\n\nModified cloned list of countries: ");
		System.out.println(clonedAndModifiedList);
	}
}