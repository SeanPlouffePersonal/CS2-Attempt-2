import java.util.Scanner;
import java.util.Arrays;

public class LA2a
{
	
	public static final int a_ASCII = 97;
	
    public static int[] countLetters(String phrase)
    {
        int[] counts = new int[26];
        
        for(char letter : phrase.toCharArray())
        {
        	letter = Character.toLowerCase(letter);
        	
        	int charIndex = (int)letter - a_ASCII;
        	
        	if(charIndex >= 0 && charIndex < 26)
        	{
        		counts[charIndex]++;
        	}
        }
        
        return counts;
    }

    public static boolean sameCounts(int[] first, int[] second)
    {
        if(first.length != second.length) return false;
        
        for(int i = 0; i < first.length; i++)
        {
        	if(first[i] != second[i])
        	{
        		return false;
        	}
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter phrase 1:");
        String phraseOne = input.nextLine();
        System.out.println("Enter phrase 2:");
        String phraseTwo = input.nextLine();
        
        int[] phraseOneCount = countLetters(phraseOne);
        int[] phraseTwoCount = countLetters(phraseTwo);
        
        System.out.println(sameCounts(phraseOneCount, phraseTwoCount)?
        		"These phrases are anagrams." : "These phrases are not anagrams.");
    }
}
