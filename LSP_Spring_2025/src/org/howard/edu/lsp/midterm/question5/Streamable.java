package org.howard.edu.lsp.midterm.question5;

/**
 * Interface to represent streamable content.
 * Defines common behaviors for all types of media.
 */
public interface Streamable {
    void play();   // Play the content
    void pause();  // Pause the content
    void stop();   // Stop the content
}
