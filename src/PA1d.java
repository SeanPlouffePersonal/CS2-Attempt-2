import java.util.Scanner;

public class PA1d
{
	
	public static final Scanner USER_INPUT = new Scanner(System.in);
	
	private static final String INVALID_WEIGHT = "The package cannot be shipped!";
	
	/**
	 * calculates the shipping cost
	 * @param weight the weight of the packaged
	 * @return the cost in dollars
	 */
    public static double shippingCost(double weight)
    {
        if(weight > 0 && weight <= 1)
        {
        	return 3.5;
        }
        else if(weight > 1 && weight <= 3)
        {
        	return 5.50;
        }
        else if(weight > 3 && weight <= 10)
        {
        	return 8.5;
        }
        else if(weight > 10 && weight <= 20)
        {
        	return 10.5;
        }
        else
        {
        	return -1.0;
        }
        
    }
    
    /**
     * gets input from the user and returns it as a double
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
        System.out.println("Enter package weight:");
        double weight = doubleInput();
        
        double cost = shippingCost(weight);
        
        if(cost < 0)
        {
        	System.out.println(INVALID_WEIGHT);
        }
        else
        {
        	System.out.printf("It will cost $%.2f to ship this package.", cost);
        }
    }
}