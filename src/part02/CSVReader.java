package part02;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {

	private String[] countryNames;
	private int[] yearLabels;
	private double[][] cellularDataTable;
	private int numberOfYears;
	private String fileName;
	private int numberOfCountries;

	/* Class constructor */
	public CSVReader(String FileName) {
		this.fileName = FileName;
		parseData();
	}

	private void parseData() {
		// create new file instance
		File file = new File(this.fileName);
		String[] parsedLine = null;
		int numOfCountriesInArray = 0;

		try {
			// create new scanner instance
			Scanner input = new Scanner(file);
			// while there is stil lines in file
			while (input.hasNextLine()) {
				// get next line from file,
				// split by "," and assign values to String array
				parsedLine = input.nextLine().split(",");
				// check first element of string array and:
				if (parsedLine[0].equals("World Development Indicators")) {
					// skip this line
				} else if (parsedLine[0].equals("Number of countries")) {
					// assign number of countries to class variable
					this.numberOfCountries = Integer.parseInt(parsedLine[1]);
					// initialize countryNames array with size = numberOfCountries
					this.countryNames = new String[this.numberOfCountries];
				} else if (parsedLine[0].equals("Country Name")) {
					// assign length of the line to numberOfYears class var.
					this.numberOfYears = parsedLine.length - 1;
					// initialize yearLabels array size
					this.yearLabels = new int[numberOfYears];
					// initialize cellularDataTable array size
					this.cellularDataTable = new double[this.numberOfCountries][this.yearLabels.length];
					// assign years to yearLabels array
					for (int i = 0; i < parsedLine.length - 1; i++) {
						this.yearLabels[i] = Integer.parseInt(parsedLine[i+1]);
					}
				} else {
					// assign first element of parsed array to countryNames array
					for (int i = numOfCountriesInArray; i < numberOfCountries; i++) {
						if (this.countryNames[i] == null) {
							this.countryNames[i] = parsedLine[0];
							// assign other elements of parsed array to cellularDataTable array
							for (int col = 0; col < this.yearLabels.length; col++) {
								cellularDataTable[i][col] = Double.parseDouble(parsedLine[col+1]);
							}
							numOfCountriesInArray++;
							break;
						}
					}
				}
			}
			input.close();

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: file not found");
			e.printStackTrace();
		}
	}

	/* method which returns “countryNames” */
	public String[] getCountryNames() {
		return countryNames;
	}

	/* method that returns “yearLabels” */
	public int[] getYearLabels() {
		return yearLabels;
	}

	/* method that returns “cellularDataTable” */
	public double[][] getParsedTable() {
		return cellularDataTable;
	}

	/* method that returns “numberOfYears” */
	public int getNumberOfYears() {
		return numberOfYears;
	}

}
