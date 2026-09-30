import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LA2 {

	/**
	 * Converts to lower case and removes anything that is not a letter
	 * @param token The word you want cleaned
	 * @return The cleaned word
	 */
    public static String cleanWord(String token)
    {
    	//converts all letters to lower case
    	token = token.toLowerCase();
    	
    	// replaces everything that is not a lowercase latter with a blank string
    	token = token.replaceAll("[^a-z]", "");
    	
        return token;
    }

    /**
     * If the word exists in the array, it returns the index otherwise -1
     * @param word The word you are looking for
     * @param wordArray The array of words to search through
     * @return The index if it exists, else -1
     */
    public static int findWord(String word, ArrayList<String> wordArray)
    {
    	for(int i = 0; i < wordArray.size(); i++)
    	{
    		if(word.equals(wordArray.get(i))) return i;
    	}
    	
        return -1;
    }

    /**
     * Builds the reports and returns is as a string
     * @param filename The name of the file
     * @return The report
     * @throws FileNotFoundException If the filename is invalid
     */
    public static String buildReport(String filename) throws FileNotFoundException
    {
    	// parallel arrays
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();
        
        Scanner wordFile = new Scanner(new File(filename));
        
        // a word is defined as a string separated by whitespace, whitespace including newline
        wordFile.useDelimiter(Pattern.compile("[\s\n]"));
        
        // loops through every word
        while(wordFile.hasNext())
        {
        	String currentWord = cleanWord(wordFile.next());
        	
        	int wordIndex = findWord(currentWord, words);
        	
        	// adds the word if it isnt already in there
        	if(wordIndex == -1)
        	{
        		words.add(currentWord);
        		// magic because this should be the first instance of this word
        		counts.add(1);
        	}
        	// adds to the count if it does already exist
        	else
        	{
        		int newCount = counts.get(wordIndex) + 1;
        		
        		counts.add(wordIndex, newCount);
        		
        		counts.remove(wordIndex + 1);
        	}
        	
        }
        
        wordFile.close();

        StringBuilder report = new StringBuilder();
        report.append("Word Frequency Report\n");
        report.append("----------------------\n");

        // TODO 13: Append each word and count in first-appearance order.
        // Required format: word: count
        
        for(int i = 0; i < words.size(); i++)
        {
        	report.append(words.get(i));
        	report.append(": ");
        	report.append(counts.get(i));
        	report.append("\n");
        }

        return report.toString().trim();
    }

    public static void main(String[] args)
    {
    	
    	cleanWord("");
    	
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the input filename: ");
        String filename = input.nextLine();

        try
        {
            String report = buildReport(filename);
            
            System.out.println(report);
            
            PrintWriter output = new PrintWriter("output.txt");
            
            output.append(report);
            
            output.close();
            
            System.out.println("Report written to output.txt");
        }
        catch (FileNotFoundException exception)
        {
            System.out.println("Invalid file name");
        }
    }
}
