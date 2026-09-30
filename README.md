# Lab Assignment 3 — Word Frequency Analyzer

**COMP 1050 — Computer Science II**  
**Estimated time:** 1 hour and 30 minutes  
**Required submission:** `LA2.java`

## Objective

Create a program that reads a text file, counts each distinct word, prints a frequency report, and writes the same report to `output.txt`. Word matching must ignore capitalization and punctuation. Words must appear in the report in the order in which they first appear in the input file.

## Open the starter project

1. Download and extract `Lab3_Student_Starter.zip`. Do not work inside the ZIP file.
2. Open IntelliJ IDEA and select **Open**.
3. Select the extracted `Lab3_Student_Starter` folder.
4. Choose **Load Maven Project** if IntelliJ prompts you, and use Java 17 or newer.
5. Open `src/main/java/LA2.java`. Complete each TODO without changing the required class or method names.
6. Run `src/test/java/LA2Test.java` with the green test arrow.

The supplied `index.txt` file is located in the project’s main folder. Enter `index.txt` when the program asks for a filename.

## Required methods

- `public static String cleanWord(String token)` converts a token to lowercase and removes every character that is not an English letter from `a` through `z`.
- `public static int findWord(String word, ArrayList<String> words)` returns the index of a word in the list or `-1` if the word is absent.
- `public static String buildReport(String filename) throws FileNotFoundException` reads the file and returns the complete report. Use parallel `ArrayList` objects to store words and counts.
- `public static void main(String[] args)` prompts for the input filename, prints the report, writes it to `output.txt`, and handles a missing file.

Use this exact missing-file message:

```text
Error: File not found.
```

## Submission

Make sure the provided tests pass, save your work, and submit **only `LA2.java`** to Gradescope. Confirm that Gradescope displays the latest version of the file and review the autograder feedback before leaving the submission page.
