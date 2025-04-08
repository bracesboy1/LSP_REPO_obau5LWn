package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerSetTest {

    @Test
    @DisplayName("Test case for clear()")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.length()); // Ensure length is 0 after clear
    }

    @Test
    @DisplayName("Test case for length()")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("Test case for equals()")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1); set1.add(2);
        set2.add(2); set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("Test case for contains()")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertTrue(set.contains(5));
        assertFalse(set.contains(10));
    }

    @Test
    @DisplayName("Test case for largest() with exception")
    public void testLargestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> set.largest());
    }

    @Test
    @DisplayName("Test case for largest()")
    public void testLargest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(10); set.add(7);
        assertEquals(10, set.largest());
    }

    @Test
    @DisplayName("Test case for smallest() with exception")
    public void testSmallestException() {
        IntegerSet set = new IntegerSet();
        assertThrows(IntegerSetException.class, () -> set.smallest());
    }

    @Test
    @DisplayName("Test case for smallest()")
    public void testSmallest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(3); set.add(1); set.add(5);
        assertEquals(1, set.smallest());
    }

    @Test
    @DisplayName("Test case for add()")
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(4);
        set.add(4);  // duplicate should be ignored
        assertEquals(1, set.length());
        assertTrue(set.contains(4));
    }

    @Test
    @DisplayName("Test case for remove()")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.remove(3);
        assertFalse(set.contains(3));
    }

    @Test
    @DisplayName("Test case for union()")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(3);

        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertEquals(3, set1.length());
    }

    @Test
    @DisplayName("Test case for union() with identical sets")
    public void testUnionWithIdenticalSets() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(1); set2.add(2);

        set1.union(set2);
        assertEquals(2, set1.length());  // Length should remain 2, not 4
    }

    @Test
    @DisplayName("Test case for intersect()")
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(4);

        set1.intersect(set2);
        assertEquals(1, set1.length());
        assertTrue(set1.contains(2));
    }

    @Test
    @DisplayName("Test case for intersect() with no common elements")
    public void testIntersectWithNoCommonElements() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(3); set2.add(4);

        set1.intersect(set2);
        assertTrue(set1.isEmpty());  // Set should be empty after intersection
    }

    @Test
    @DisplayName("Test case for diff()")
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2); set1.add(3);

        IntegerSet set2 = new IntegerSet();
        set2.add(2); set2.add(4);

        set1.diff(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(3));
        assertFalse(set1.contains(2));
    }

    @Test
    @DisplayName("Test case for diff() where first set is a subset of the second")
    public void testDiffWithSubset() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);

        IntegerSet set2 = new IntegerSet();
        set2.add(1); set2.add(2); set2.add(3);

        set1.diff(set2);
        assertTrue(set1.isEmpty());  // Set1 should become empty after diff
    }

    @Test
    @DisplayName("Test case for complement()")
    public void testComplement() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1); set1.add(2);

        IntegerSet universalSet = new IntegerSet();
        universalSet.add(1); universalSet.add(2); universalSet.add(3); universalSet.add(4);

        set1.complement(universalSet);
        assertTrue(set1.contains(3));
        assertTrue(set1.contains(4));
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
    }

    @Test
    @DisplayName("Test case for isEmpty()")
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Test case for toString()")
    public void testToString() {
        IntegerSet set = new IntegerSet();
        set.add(5); set.add(10);
        String result = set.toString();
        assertTrue(result.contains("5") && result.contains("10"));
    }
}

