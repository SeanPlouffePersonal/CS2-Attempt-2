import java.util.Scanner;

public class PA1b
{
	
	private static final double PENNY = 0.01;
	private static final double NICKEL = 0.05;
	private static final double DIME = 0.10;
	private static final double QUARTER = 0.25;
	
	public static final Scanner USER_INPUT = new Scanner(System.in);
	
    public static void main(String[] args)
    {
    	System.out.println("Enter number of quarters:");
        int quarters = integerInput();
        System.out.println("Enter number of dimes:");
        int dimes = integerInput();
    	System.out.println("Enter number of nickels:");
        int nickels = integerInput();
    	System.out.println("Enter number of pennies:");
        int pennies = integerInput();
        
        System.out.printf("You have $%.2f in coins.", coinsToDollars(pennies, nickels, dimes, quarters));
    }
    
    /**
     * @param pennies - The amount of pennies you have
     * @param nickels - The amount of nickels you have
     * @param dimes - The amount of dimes you have
     * @param quarters - The amount of quarters you have
     * @return - The value in dollars
     */
    private static double coinsToDollars(int pennies, int nickels, int dimes, int quarters)
    {
    	return (pennies * PENNY)+(nickels * NICKEL)+(dimes * DIME)+(quarters * QUARTER);
    }

    /**
     * Prompts the user to enter an integer.
     * @return Returns the input integer
     */
    private static int integerInput()
    {
    	int input = 0;
    	try
    	{
    		input = USER_INPUT.nextInt();
    	}
    	catch(NumberFormatException e)
    	{
    		//If the user inputs anything but a number, this catches and yells at them
    		System.out.println("Enter a whole number");
    		return integerInput();
    	}
    	
    	return input;
    }
    
}
