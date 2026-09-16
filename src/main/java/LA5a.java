import java.util.Scanner;

public class LA5a
{

    public static int[] add(int[] first, int[] second)
    {
        int numerator = first[0] * second[1] + second[0] * first[1];
        int denominator = first[1] * second[1];
        
        return simplify(new int[]{numerator, denominator});
    }

    public static int[] subtract(int[] first, int[] second)
    {
    	int numerator = first[0] * second[1] - second[0] * first[1];
        int denominator = first[1] * second[1];
        
        return simplify(new int[]{numerator, denominator});
    }

    public static int[] multiply(int[] first, int[] second)
    {
        int numerator = first[0] * second[0];
        int denominator = first[1] * second[1];
        
        return simplify(new int[]{numerator, denominator});
    }

    public static int[] divide(int[] first, int[] second)
    {
        if(second[0] == 0) return null;
        
        //why rewrite code when it's already there. and we don't have to worry about garbage.
        return multiply(first, new int[] {second[1], second[0]});
    }

    public static int[] simplify(int[] fraction)
    {
        if (fraction[1] == 0) {
            throw new IllegalArgumentException("A denominator cannot be zero.");
        }
        if (fraction[0] == 0) {
            return new int[]{0, 1};
        }

        int divisor = gcd(Math.abs(fraction[0]), Math.abs(fraction[1]));
        int numerator = fraction[0] / divisor;
        int denominator = fraction[1] / divisor;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        return new int[]{numerator, denominator};
    }

    public static int gcd(int first, int second)
    {
        while (second != 0) {
            int remainder = first % second;
            first = second;
            second = remainder;
        }
        return Math.abs(first);
    }

    public static String formatFraction(int[] fraction)
    {
        return fraction[1] == 1? String.format("%d", fraction[0]) : String.format("%d/%d", fraction[0], fraction[1]);
    }
    
    public static int integerInput(Scanner userInput)
    {
    	int number = 0;
    	
    	try
    	{
    		number = userInput.nextInt();
    	}
    	catch(NumberFormatException e)
    	{
    		System.out.println("NAN");
    		
    		integerInput(userInput);
    	}
    	
    	return number;
    }

    public static char inputOperator(Scanner userInput)
    {
    	String operator = userInput.nextLine();
    	switch(operator.charAt(0))
    	{
    		case '+': return '+';
    		case '-': return '-';
    		case '*': return '*';
    		case '/': return '/';
    		default: System.out.println("Improper operator");
    				 return inputOperator(userInput);
    	}
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first numerator");
        int firstNumerator = integerInput(input);
        
        System.out.println("Enter the first denominator");
        int firstDenominator = integerInput(input);
        
        System.out.println("Enter the second numerator");
        int secondNumerator = integerInput(input);
        
        System.out.println("Enter the second denominator");
        int secondDenominator = integerInput(input);
        
        input.nextLine();
        
        System.out.println("Enter and operator (+-*/)");
        char operation = inputOperator(input);

        // TODO: Validate the operation, denominators, and division by zero.

        while(firstDenominator == 0)
        {
        	System.out.println("Enter non 0 number for first denominator");
        	firstDenominator = integerInput(input);
        }
        
        while(secondDenominator == 0)
        {
        	System.out.println("Enter non 0 number for first denominator");
        	secondDenominator = integerInput(input);
        }
        
        int[] first = {firstNumerator, firstDenominator};
        int[] second = {secondNumerator, secondDenominator};
        
        int[] result = {0, 1};
        
        switch(operation)
        {
        	case '+': result = add(first, second); break;
        	case '-': result = subtract(first, second); break;
        	case '*': result = multiply(first, second); break;
        	case '/': result = divide(first, second); break;
        	default: System.out.println("Something bad happend man"); break;
        }

        System.out.printf("%s + %s = %s",formatFraction(first), formatFraction(second), formatFraction(result));
    }
}
