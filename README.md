# Programming Assignment 2

**COMP 1050 — Computer Science II**

Complete all three programs in `src/main/java`. You may use any Java IDE, but course demonstrations use IntelliJ IDEA. Do not rename the classes or change the supplied public method signatures because Gradescope calls them directly.

## Part A — Credit Card Validation

Complete `PA2a.java`. Implement the helper methods in their listed order, then use them in `isValid` and `main`. Card input must contain 13–16 numeric digits, use a prefix of `4`, `5`, `37`, or `6`, and pass the Luhn checksum. Print exactly one of these status messages:

- `Status: Input is too short`
- `Status: Input is too long`
- `Status: Non-numeric input`
- `Status: Invalid prefix`
- `Status: card is valid`
- `Status: card is invalid`

## Part B — Longest Repeating Sequence

Complete `PA2b.java`. First implement `hasSequence`, then use it to help implement `maxConsecutiveLength`. The maximum for an empty array is 0; an array with values always has a maximum of at least 1.

## Part C — Matrix File Multiplication

Complete `PA2c.java`. Implement `canMultiply`, `readMatrix`, `matrixMultiply`, `printMatrix`, and `writeMatrix` before completing `main`. A matrix file contains its row count, column count, and integer entries in row-major order. Sample files are in `sample_files`.

## Open and run in IntelliJ IDEA

1. Download and extract the ZIP. Do not work inside the compressed ZIP.
2. In IntelliJ IDEA, select **File → Open** and choose the extracted folder containing `pom.xml`.
3. Choose **Trust Project** and **Load Maven Project** if prompted.
4. Select JDK 17 or newer under **File → Project Structure → Project SDK**.
5. Run each test class in `src/test/java`. Run each program separately to check its console behavior.

## Gradescope submission

Submit `PA2a.java`, `PA2b.java`, and `PA2c.java` to Gradescope. You may submit the three Java files directly or place them in one ZIP. Do not submit `.class` files. Confirm that Gradescope finds all three files and displays an autograder result before leaving the page.
