# Lab Assignment 2 — Anagrams
**COMP 1050 — Computer Science II**  
**Time:** 90 minutes  
**File to submit:** `LA2a.java`

## Goal
Write an anagram detector. Two phrases are anagrams when they contain the same number of each English letter, ignoring letter case, spaces, punctuation, and digits. For this lab, only A–Z and a–z are letters; all other characters are ignored. For example, `Anagrams!` and `__Ars Magna__` are anagrams.

## Open the project
Extract the ZIP, then open or drag this **folder** into IntelliJ IDEA. Select **Load Maven Project** if asked; choose JDK 17 or newer. Keep the default package (do not add a `package` line). Run `LA2aTest` with the green test arrow.

## Tasks and suggested pacing
1. **Plan:** Predict the counts for `"A-bA!"`: index 0 = 2, index 1 = 1, all other elements = 0.
2. **Count letters:** Implement `public static int[] countLetters(String phrase)`. Return a 26-element array. For each character, if it is between `A` and `Z` or between `a` and `z`, increment the corresponding element. Ignore every other character.
3. **Compare arrays:** Implement `public static boolean sameCounts(int[] first, int[] second)`. Return false for different lengths or any different value. Compare manually with a loop. Do not use `Arrays.equals` or another built-in array comparison.
4. **Finish main:** Read two complete lines using `Scanner.nextLine()`. Print the exact prompts and one of the result messages below. Call both methods rather than repeating their logic.
5. **Check and submit:** Run the provided JUnit tests and try `"Dormitory"` with `"Dirty room!!"`, a non-anagram pair, and strings containing digits. Submit `LA2a.java` to Gradescope. Save all code changes. No code documentation is required.

## Required console text
```
Enter phrase 1: 
Enter phrase 2: 
These phrases are anagrams.
These phrases are not anagrams.
```
The prompts appear before input; only one of the last two lines appears per run. Capitalization and punctuation in the result messages must match.

## Example
```
Enter phrase 1: cinema
Enter phrase 2: iceman
These phrases are anagrams.
```

The grader checks additional inputs beyond the visible tests. Submit the source file, not `.class` files. You may also submit a ZIP containing your Java source.
