import java.util.Scanner;

public class PA1e
{
	
	public static final Scanner USER_INPUT = new Scanner(System.in);
	
	/**
	 * counts how many upper case letters are in a string
	 * @param s string
	 * @return amount of upper case letters
	 */
    public static int numUpperCase(String s)
    {
    	int upper = 0;
    	
    	for(char letter : s.toCharArray())
    	{
    		upper = Character.isUpperCase(letter)? upper + 1 : upper;
    	}
    	
        return upper;
    }

    public static void main(String[] args)
    {
        System.out.println("Enter a string:");
        String sentence = USER_INPUT.nextLine();
        
        int uppercaseLetters = numUpperCase(sentence);
        
        System.out.println(uppercaseLetters > 0?
        		String.format("There are %d uppercase characters in the string.", uppercaseLetters) :
        		"There are no uppercase characters.");
    }

}
