import java.util.Scanner;

public class PA2a
{
    public static boolean isNumeric(String number)
    {
    	try
    	{
    		int i = Integer.parseInt(number);
    		return true;
    	}
    	catch(NumberFormatException ignore)
    	{
    		return false;
    	}
    }

    public static boolean hasValidPrefix(String number)
    {
        // TODO: Check for prefixes 4, 5, 37, or 6.
    	
    	int[] validPrefixes = {4, 5, 6, 37};
    	
    	String firstTwoLetters = number.substring(0, 2);
    	
    	try
    	{
    		int prefix = Integer.parseInt(firstTwoLetters);
    		
    		return contains(validPrefixes, prefix);
    	}
    	catch(NumberFormatException ignore)
    	{
    		try
    		{
    			int prefix = Integer.parseInt(firstTwoLetters.substring(0, 1));
    			
    			return contains(validPrefixes, prefix);
    		}
    		catch(NumberFormatException ignore2)
    		{
    			return false;
    		}
    	}
    }
    
    private static boolean contains(int[] array, int num)
    {
    	for(int element : array)
    	{
    		if(num == element) return true;
    	}
    	
    	return false;
    }

    //we shouldn't have to worry about negative numbers or numbers greater than 18
    public static int getDigit(int number)
    {
        if(number <= 9) return number;
        
        int firstDigit = number / 10;
        
        int secondDigit = number % 10;
    	
        return firstDigit + secondDigit;
    }

    public static int sumOfDoubleEvenPlace(String number)
    {
    	return sumOfXPlace(number, 0, 2, 2);
    }

    public static int sumOfOddPlace(String number)
    {
        return sumOfXPlace(number, 1, 2, 1);
    }
    
    private static int sumOfXPlace(String number, int start, int step, int multi)
    {
    	int finalNumber = 0;
    	
    	for(int i = start; i < number.length(); i += step)
    	{
    		int numberToAdd = Integer.parseInt(number.substring(i, i+1)) * multi;
    		
    		numberToAdd = getDigit(numberToAdd);
    		
    		finalNumber += numberToAdd;
    	}
    	
    	return finalNumber;
    }

    public static boolean isValid(String number)
    {
        // TODO: Verify length, numeric input, prefix, and the Luhn checksum.
    	
    	if(number.length() < 13 || number.length() > 16) return false;
    	
    	if(!isNumeric(number)) return false;
    	
    	if(!hasValidPrefix(number)) return false;
    	
    	if( (sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0) return true;
    	
        return false;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a credit card number: ");
        String card = input.nextLine();

        if(isValid(card))
        {
        	System.out.println("\nStatus: card is valid");
        }
        else
        {
        	if(card.length() < 13)
        	{
        		System.out.println("Status: Input is too short");
        	}
        	else if(card.length() > 16)
        	{
        		System.out.println("Status: Input is too long");
        	}
        	else if(!isNumeric(card))
        	{
        		System.out.println("Status: Non-numeric input");
        	}
        	else if(hasValidPrefix(card))
        	{
        		System.out.println("Status: Invalid prefix");
        	}
        }
        
        
        // TODO: Prompt for a card number and print the correct status message.
        // Validate in this order: too short, too long, non-numeric, invalid prefix, Luhn result.
    }
}
