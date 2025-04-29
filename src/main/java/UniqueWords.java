import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Utility to process a document to into sorted set of unique words
 * @author student name
 */
public class UniqueWords {
    /**
     * Read file one line at a time
     * Break input String into words
     * Store unique words sorted into alphabetic order
     * @param myfile input file
     * @return sorted set of unique words
     */
    public static Set<String> processDocument(File myfile) {
        // TreeSet is used to store words in sorted order and also automatically eliminate duplicates.
        Set<String> uniqueWords = new TreeSet<>();

        //Try-Catch is used for Error handling in case for a missing file.
        try (Scanner scanner = new Scanner(myfile)) { // It create a Scanner to read from the given file.
            while (scanner.hasNextLine()) { // Loop through each line of the file until there are no more lines.
                String line = scanner.nextLine().trim(); // Read the next line and remove leading/trailing white spaces.
                if (!line.isEmpty()) { // Proceed only if the line is not empty.
                    // Call the tokenize method (assumed it split the line into words) and store the result in an array.
                    String[] words = tokenize(line);
                    // Loop through each word in the array.
                    for (String word : words) {
                        // Add non-empty words to the set to ensure uniqueness and sorting.
                        if (!word.isEmpty()) {
                            uniqueWords.add(word);
                        }
                    }
                }
            }
            // If the file is not found, catch the exception and print an error message.
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + myfile.getName());
        }

        // Return the set of unique, sorted words.
        return uniqueWords;
    }

    /**
     * Remove all punctuation and numbers from String
     * Tokenize - break into individual words
     * Convert all words to lower case
     * @param str initial non-null String
     * @return array of words from initial String
     */
    public static String[] tokenize(String str) {
        str = str.replaceAll("[^a-zA-Z \n]"," ");
        String[] tok = str.split(" ");
        for (int i=0; i<tok.length; ++i) {
            tok[i] = tok[i].toLowerCase();
        }
        return tok;
    }
}
