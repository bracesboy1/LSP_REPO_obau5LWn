package org.howard.edu.lsp.assignment6;

// Custom exception for IntegerSet
public class IntegerSetException extends Exception {
    // Constructor without message
    public IntegerSetException() {
        super();
    }

    // Constructor with a custom message
    public IntegerSetException(String message) {
        super(message);
    }
}

