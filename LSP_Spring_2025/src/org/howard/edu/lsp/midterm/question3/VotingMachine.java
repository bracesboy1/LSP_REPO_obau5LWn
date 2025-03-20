package org.howard.edu.lsp.midterm.question3;

import java.util.*;

/**
 * Represents a simple electronic voting machine.
 */
public class VotingMachine {
    private final Map<String, Integer> votes;

    // Constructor
    public VotingMachine() {
        this.votes = new HashMap<>();
    }

    /**
     * Adds a candidate to the voting system.
     *
     * @param name The name of the candidate.
     */
    public void addCandidate(String name) {
        votes.putIfAbsent(name, 0);
    }

    /**
     * Casts a vote for a candidate.
     *
     * @param name The name of the candidate.
     * @return true if the vote was successful, false if the candidate does not exist.
     */
    public boolean castVote(String name) {
        if (votes.containsKey(name)) {
            votes.put(name, votes.get(name) + 1);
            return true;
        }
        return false;
    }

    /**
     * Determines and returns the winner of the election.
     *
     * @return A formatted string announcing the winner and their vote count.
     */
    public String getWinner() {
        return votes.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()) // Find candidate with max votes
                .map(entry -> entry.getKey() + " WINS with " + entry.getValue() + " votes!!")
                .orElse("No votes cast.");
    }
}
