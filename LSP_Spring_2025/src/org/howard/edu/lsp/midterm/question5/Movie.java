package org.howard.edu.lsp.midterm.question5;

/**
 * Class to represent movie content.
 * Implements the Streamable interface.
 */
public class Movie implements Streamable {
    private String movieTitle;

    public Movie(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    @Override
    public void play() {
        System.out.println("Playing movie: " + movieTitle);
    }

    @Override
    public void pause() {
        System.out.println("Paused movie: " + movieTitle);
    }

    @Override
    public void stop() {
        System.out.println("Stopped movie: " + movieTitle);
    }

    // Movie-specific behavior: Rewind
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + movieTitle + " by " + seconds + " seconds");
    }
}
