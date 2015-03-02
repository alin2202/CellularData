/** CellularData Project:**/
Created for filtering and analyzing large amount of data about cellular subscriptions for a wide range of years
Also contains test class for testing main program functionality.

/** CSVReader Class **/
* CSVReader Class reads data about cellular subscriptions for countries from .csv file
* Class contains class constructor that takes in String filename (path to file)
* Class also contains following methods:
* - parseData() : reads .csv file data and assigns data to class variables
* - getCountryNames() : accessor method for countryNames class variable
* - getYearLabels() : accessor method for yearLabels class variable
* - getYearLabels() : accessor method for yearLabels class variable
* - getParsedTable() : accessor method for cellularDataTable class variable
* - getNumberOfYears() : accesor method for numberOfYears class variable

/** SubscriptionYear Class **/
 * Class Subscription consists of class constructor and following methods:
 * - setYear(int year) : setter method for class variable "year"
 * - setSubscriptions(double numOfSubscritions) : setter method for class variable "subscriptions"
 * - getYear() : getter method for class variable "year"
 * - getSubscriptions() : getter method for class variable "subscriptions"
 * - equals(Object other) : returns true if year and subscriptions values of SubscriptionYear objects are equal
 * - toString() : string representation of the class object
 
 /** Country Class **/
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

 /** LinkedList Class **/
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
 
 /** Node Class **/
 * Class Node, object of which holds information about Node of requested type
 * - A generic variable called "data".
 * - A parametrized variable called "next".
 * - A constructor that takes in a generic object as a parameter.
 * - A constructor that takes in two parameters, 
 * a generic object and an object of parametrized Node type.
 * - A setter method for the attribute "next".
 * - Getter methods for all other attributes: getData() getNextNode().
 * - A toString method that returns the string representation of "data".
 
 /** TestGenericList Class **/
 * Tests the LinkedList class by creating multiple objects of type Node<T>.
 * Creates one object of type CSVReader class, which reads input from a CSV file. 
 * Uses the attributes stored in CSVReader object to create objects of type Country class. 
 * Then adds the newest country read into the singly linked list.
 * Class also contains test of iterator method implementation
 */
 
 /** cellular.csv **/
 * File that contains test data (data for subscriptions by country per year)
 
 /** RUN.txt **/
 * Text file with TestCellularData Class console output
 
 /** .gitignore **/
 * List of project files that should be ignored during code submission process