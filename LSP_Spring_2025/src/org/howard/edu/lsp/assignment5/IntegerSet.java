package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a set of integers and provides various operations
 * on the set such as adding, removing, union, intersection, etc.
 */
public class IntegerSet {

    // Store the set elements in an ArrayList
    private List<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor for IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructor for IntegerSet with an already initialized set.
     *
     * @param set the ArrayList of integers to initialize the set with
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the length (size) of the set.
     *
     * @return the length of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this set with another set for equality.
     * Two sets are equal if they contain the same elements in any order.
     *
     * @param o the object to compare with
     * @return true if the sets are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerSet that = (IntegerSet) o;
        return set.containsAll(that.set) && that.set.containsAll(this.set);
    }

    /**
     * Returns true if the set contains the specified value.
     *
     * @param value the value to check for
     * @return true if the set contains the value, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest value in the set.
     *
     * @return the largest value in the set
     */
    public int largest() {
        return set.stream().max(Integer::compare).orElseThrow();
    }

    /**
     * Returns the smallest value in the set.
     *
     * @return the smallest value in the set
     */
    public int smallest() {
        return set.stream().min(Integer::compare).orElseThrow();
    }

    /**
     * Adds an item to the set. Does nothing if the item is already present.
     *
     * @param item the item to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set. Does nothing if the item is not present.
     *
     * @param item the item to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Performs the union of this set with another set.
     * The union contains all elements that are in either set.
     *
     * @param intSetb the set to union with
     */
    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            add(item);
        }
    }

    /**
     * Performs the intersection of this set with another set.
     * The intersection contains all elements that are in both sets.
     *
     * @param intSetb the set to intersect with
     */
    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    /**
     * Performs the difference of this set and another set (this - other).
     * The result contains all elements that are in this set but not in the other.
     *
     * @param intSetb the set to subtract from this set
     */
    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    /**
     * Performs the complement of this set with respect to another set.
     * The complement contains all elements that are not in this set but are in the other.
     *
     * @param intSetb the set to compute the complement with respect to
     */
    public void complement(IntegerSet intSetb) {
        List<Integer> complement = new ArrayList<>();
        for (int item : intSetb.set) {
            if (!set.contains(item)) {
                complement.add(item);
            }
        }
        set = complement;
    }

    /**
     * Returns true if the set is empty.
     *
     * @return true if the set is empty, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     *
     * @return a string representing the set
     */
    @Override
    public String toString() {
        return "Set: " + set.toString();
    }
}
