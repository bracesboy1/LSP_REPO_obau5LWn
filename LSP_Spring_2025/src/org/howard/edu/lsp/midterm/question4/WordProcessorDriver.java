package org.howard.edu.lsp.midterm.question4;

import java.util.List;

/**
 * Driver class to test the WordProcessor class.
 */
public class WordProcessorDriver {
    public static void main(String[] args) {
        // Test case 1: Sentence with a single longest word
        WordProcessor wp1 = new WordProcessor("This is a test with amazing results amazing achievements");
        List<String> longestWords1 = wp1.findLongestWords();
        System.out.println("Test 1 - Longest words: " + formatOutput(longestWords1));
        // Expected Output: ["achievements"]

        // Test case 2: Sentence with multiple occurrences of the same longest word
        WordProcessor wp2 = new WordProcessor("Java is a powerful powerful tool");
        List<String> longestWords2 = wp2.findLongestWords();
        System.out.println("Test 2 - Longest words: " + formatOutput(longestWords2));
        // Expected Output: ["powerful", "powerful"]

        // Test case 3: Sentence with multiple longest words
        WordProcessor wp3 = new WordProcessor("apple orange banana");
        List<String> longestWords3 = wp3.findLongestWords();
        System.out.println("Test 3 - Longest words: " + formatOutput(longestWords3));
        // Expected Output: ["orange", "banana"]

        // Test case 4: Sentence with single-character words
        WordProcessor wp4 = new WordProcessor("A B C D E");
        List<String> longestWords4 = wp4.findLongestWords();
        System.out.println("Test 4 - Longest words: " + formatOutput(longestWords4));
        // Expected Output: ["A", "B", "C", "D", "E"]

        // Test case 5: Empty string input
        WordProcessor wp5 = new WordProcessor("");
        List<String> longestWords5 = wp5.findLongestWords();
        System.out.println("Test 5 - Longest words: " + formatOutput(longestWords5));
        // Expected Output: []
    }

   
    private static String formatOutput(List<String> words) {
        if (words.isEmpty()) {
            return "[]";  // Return empty list format if no words found
        }
        StringBuilder formattedOutput = new StringBuilder("[");
        for (int i = 0; i < words.size(); i++) {
            formattedOutput.append("\"").append(words.get(i)).append("\"");
            if (i < words.size() - 1) {
                formattedOutput.append(", ");
            }
        }
        formattedOutput.append("]");
        return formattedOutput.toString();
    }
}


