package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * Processes a sentence to find the longest words.
 */
public class WordProcessor {
    private String sentence;

    /**
     * Constructor initializes the sentence.
     *
     * @param sentence The input sentence.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * Finds all longest words in the sentence.
     *
     * @return A list of the longest words in the order they appear.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // Return empty list if input is empty
        }

        String[] words = sentence.split("\\s+"); // Splitting words with varying whitespace
        int maxLength = 0;

        for (String word : words) {
            int length = word.length();
            if (length > maxLength) {
                maxLength = length;
                longestWords.clear(); // Reset list if a new max length is found
            }
            if (length == maxLength) {
                longestWords.add(word); // Add word if it matches the max length
            }
        }

        return longestWords;
    }
}

