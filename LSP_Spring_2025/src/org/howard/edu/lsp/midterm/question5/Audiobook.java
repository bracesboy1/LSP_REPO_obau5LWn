package org.howard.edu.lsp.midterm.question5;

/**
 * Class to represent audiobook content.
 * Implements the Streamable interface.
 */
public class Audiobook implements Streamable {
    private String audiobookTitle;

    public Audiobook(String audiobookTitle) {
        this.audiobookTitle = audiobookTitle;
    }

    @Override
    public void play() {
        System.out.println("Playing audiobook: " + audiobookTitle);
    }

    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + audiobookTitle);
    }

    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + audiobookTitle);
    }

    // Audiobook-specific behavior: Set playback speed
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + audiobookTitle + " " + speed + "x");
    }
}

