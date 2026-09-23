import java.util.Scanner;

public class PA1c {

	private static final double PENNY = 1.0;
	private static final double NICKEL = 5.0;
	private static final double DIME = 10.0;
	private static final double QUARTER = 25.0;
	
	public static final Scanner USER_INPUT = new Scanner(System.in);
	
    public static int convertToInt(double num)
    {
        return (int)(num*100);
    }
    
    /**
     * 
     * @param cents The amount you are converting
     * @param coinValue the value of the coin
     * @return the max coins needed for the amount
     */
    private static int getMaxCoin(int cents, int coinValue)
    {
    	int leftovers = cents % coinValue;
    	
    	cents -= leftovers;
    	
    	return (int) ((double)cents / (double) coinValue);
    }
    
    private static int getMaxQuarters(int cents)
    {
    	return getMaxCoin(cents, (int)QUARTER);
    }
    private static int getMaxDimes(int cents)
    {
    	return getMaxCoin(cents, (int)DIME);
    }
    private static int getMaxNickels(int cents)
    {
    	return getMaxCoin(cents, (int)NICKEL);
    }
    private static int getMaxPennies(int cents)
    {
    	return getMaxCoin(cents, (int)PENNY);
    }
    
    /**
     * gets input from the user and outputs it as a double.
     * @return
     */
    private static double doubleInput()
    {
    	double input = 0;
    	try
    	{
    		input = USER_INPUT.nextDouble();
    	}
    	catch(NumberFormatException e)
    	{
    		//If the user inputs anything but a number, this catches and yells at them
    		System.out.println("Enter a decimal");
    		return doubleInput();
    	}
    	
    	return input;
    }
    
    public static void main(String[] args)
    {
    	System.out.println("Enter total amount:");
    	double amount = doubleInput();
    	
    	int cents = convertToInt(amount);
    	
    	cents = cents > 0? cents : 0;
    	
    	int amtQuarters = getMaxQuarters(cents);
    	cents -= amtQuarters*QUARTER;
    	
    	int amtDimes = getMaxDimes(cents);
    	cents -= amtDimes*DIME;
    	
    	int amtNickels = getMaxNickels(cents);
    	cents -= amtNickels*NICKEL;
    	
    	int amtPennies = cents;
    	
    	System.out.printf("You have %d quarters, %d dimes, %d nickels, %d pennies", amtQuarters, amtDimes, amtNickels, amtPennies);
    	
    }
}
