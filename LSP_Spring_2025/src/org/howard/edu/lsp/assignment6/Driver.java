package org.howard.edu.lsp.assignment6;

/**
 * The Driver class is used to test the functionality of the IntegerSet class.
 * It performs various operations such as adding elements, finding the smallest and largest elements,
 * performing union, intersection, difference, and complement operations on sets.
 */
public class Driver {

    /**
     * Default constructor for the Driver class.
     * This constructor is used to create an instance of the Driver class for testing purposes.
     */
    public Driver() {
        // No initialization required for this class
    }

    /**
     * The main method is used to run tests on the IntegerSet class.
     * It demonstrates how to use different methods of the IntegerSet class and outputs the results.
     *
     * @param args the command-line arguments (not used in this case)
     */
    public static void main(String[] args) {
        // Test add and toString
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Value of Set1 is: " + set1.toString());

        // Test smallest and largest with exception handling
        try {
            System.out.println("Smallest value in Set1 is: " + set1.smallest());
            System.out.println("Largest value in Set1 is: " + set1.largest());
        } catch (IntegerSetException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Test union
        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Value of Set2 is: " + set2.toString());

        System.out.println("Union of Set1 and Set2");
        set1.union(set2);
        System.out.println("Result of union of Set1 and Set2: " + set1.toString());

        // Test intersect
        IntegerSet set3 = new IntegerSet();
        set3.add(2);
        set3.add(3);
        set1.intersect(set3);
        System.out.println("Result of intersection of Set1 and Set3: " + set1.toString());

        // Test diff
        IntegerSet set4 = new IntegerSet();
        set4.add(1);
        set4.add(2);
        set1.diff(set4);
        System.out.println("Result of difference of Set1 and Set4: " + set1.toString());

        // Test complement
        IntegerSet set5 = new IntegerSet();
        set5.add(3);
        set5.add(4);
        set5.add(5);
        set1.complement(set5);
        System.out.println("Result of complement of Set1 and Set5: " + set1.toString());
    }
}
