package CellularData;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Tests the LinkedList class by creating multiple objects of type Node<T>.
 * Creates one object of type CSVReader class, which reads input from a CSV
 * file. Uses the attributes stored in CSVReader object to create objects of
 * type Country class. Then adds the newest country read into the singly linked
 * list.
 */
public class TestGenericList {

	// /**
	// * Builds a list of countries to debug.
	// */
	// private void debugListOfCountries(Country [] allCountries)
	// {
	// // TO COMPLETE
	// }

	private void testIterator(Country[] allCountries) {
		System.out.println("\nTest Iterator implementation:\n");
		int requestedSize = 5;
		
		// Build the list out of a random selection of countries.
		Random random = new Random();
		LinkedList<Country> selectedCountries = new LinkedList<Country>();
		for (int i = 0; i < requestedSize; i++) {
			int selectedIndex = random.nextInt(allCountries.length);
			selectedCountries.add(allCountries[selectedIndex]);
		}

		// Note: To debug your list, comment this line in
		System.out.println("List of countries: " + selectedCountries);
		
		// Use iterator to go through your country list and collect country names
		String countryNames = "";
		Iterator<Country> iterator = selectedCountries.iterator();
		while(iterator.hasNext()){
			countryNames += iterator.next().getName() + "\n";
		}
		
		System.out.println("\nCountry Names: ");
		System.out.println(countryNames);
	}

	/**
	 * Builds a random list of countries.
	 */
	private void testRandomListOfCountries(Country[] allCountries) {
		Scanner keyboard = new Scanner(System.in);
		System.out
				.println("How many countries do you want to add to the list?");
		int requestedSize = Integer.parseInt(keyboard.nextLine());

		// Build the list out of a random selection of countries.
		Random random = new Random();
		LinkedList<Country> selectedCountries = new LinkedList<Country>();
		for (int i = 0; i < requestedSize; i++) {
			int selectedIndex = random.nextInt(allCountries.length);
			selectedCountries.add(allCountries[selectedIndex]);
		}

		// Note: To debug your list, comment this line in
		System.out.println("List of countries: " + selectedCountries);

		// Check if the name of a country is in the list.
		// If the country is found, print the details.
		// Otherwise output not found.
		System.out.println("\nWhat country do you want to search for?");
		String countryToFind = keyboard.nextLine();
		Country foundCountry = selectedCountries.contains(new Country(
				countryToFind));
		if (foundCountry != null) {
			System.out.println("Country " + countryToFind
					+ " found with details:\n" + foundCountry);
		} else
			System.out.println("Country " + countryToFind + " not found.");

		keyboard.close();
	}

	/**
	 * Includes test examples for class LinkedList.
	 */
	public static void main(String[] args) {
		// Create and set objects of type Country
		//
		// final String FILENAME = "resources/cellular.csv"; // Directory path
		// for Mac OS X
		final String FILENAME = "resources\\cellular.csv"; // Directory path for
															// Windows OS (i.e.
															// Operating System)
		final int NUM_COUNTRIES_TO_TEST = 3; // Note: Include test cases in
												// addition to 3

		// Parse the CSV data file
		CSVReader parser = new CSVReader(FILENAME);

		String[] countryNames = parser.getCountryNames();
		int[] yearLabels = parser.getYearLabels();
		double[][] parsedTable = parser.getParsedTable();

		// Create and set objects of type Country
		Country[] countries;
		countries = new Country[NUM_COUNTRIES_TO_TEST];

		Country current;
		countries = new Country[countryNames.length];

		for (int countryIndex = 0; countryIndex < countries.length; countryIndex++) {
			int numberOfYears = yearLabels.length;

			// Note: Initially convert your CountryList to a generic LinkedList
			// and make sure that list builds
			// correctly using the original Country constructor which takes the
			// numberOfYears to setup
			// the array of subscriptions.
			// Note: Make sure to comment this out before submitting.
			// current = new Country(countryNames[countryIndex], numberOfYears);

			// Note: Once you are successful in creating a generic LinkedList of
			// countries, create a
			// LinkedList of SubscriptionYear in the Country class.
			// So, your Country class should no longer have an array of
			// SubscriptionYear objects.
			current = new Country(countryNames[countryIndex]);

			for (int yearIndex = 0; yearIndex < numberOfYears; yearIndex++) {
				double[] allSubscriptions = parsedTable[countryIndex];
				double countryData = allSubscriptions[yearIndex];
				current.addSubscriptionYear(yearLabels[yearIndex], countryData);
			}
			countries[countryIndex] = current;
		}

		TestGenericList application = new TestGenericList();

		// Note: Initially, to test your output you may hard code the number of
		// countries added, and the array positions selected.
		// However, make sure to comment this out before submitting your work.
		// application.debugListOfCountries(countries);

		application.testRandomListOfCountries(countries);
		application.testIterator(countries);
	}
}