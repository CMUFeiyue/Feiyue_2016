package examplePackage;

/**
 * Example reference class to test the setup of github,
 * demonstate typical class structure, and provide an
 * example of Javadoc documentation.
 * @author Val Kozina
 */

public class ExampleClass {
	
	/**
	 * Example types and class variables
	 */
	private static int myInt;
	
	/**
	 * Example main function
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	/**
	 * Example getter function
	 * @return The integer value stored by this class
	 */
	public static int getMyInt() {
		return myInt;
	}
	
	/**
	 * Example setter function
	 * @param newInt The new integer value that needs to be stored
	 */
	public static void setMyInt(int newInt) {
		myInt = newInt;
	}
	
	
	

}
