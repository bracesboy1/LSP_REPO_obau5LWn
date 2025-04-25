package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for ShoppingCary
 */

public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    public void setup() {
        cart = new ShoppingCart();
    }

    @Test
    @DisplayName("Test for adding valid item")
    public void testAddValidItem() {
        assertDoesNotThrow(() -> cart.addItem("Apple", 1.50));
        assertEquals(1.50, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    public void testAddItemZeroPrice() {
        assertDoesNotThrow(() -> cart.addItem("Free Sample", 0.0));
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.addItem("Banana", -2.0);
        });
        assertEquals("Price cannot be negative.", exception.getMessage());
    }

    @Test
    @DisplayName("Test for applying 'SAVE10'")
    public void testApplyDiscountSave10() {
        cart.applyDiscountCode("SAVE10");
        assertEquals(10.0, cart.getDiscountPercentage(), 0.001);
    }

    @Test
    @DisplayName("Test for applying 'SAVE20'")
    public void testApplyDiscountSave20() {
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.001);
    }

    @Test
    @DisplayName("Test for applying invalid code (expect exception)")
    public void testApplyInvalidDiscountCode() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.applyDiscountCode("SAVE50");
        });
        assertEquals("Invalid discount code.", exception.getMessage());
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        cart.addItem("Laptop", 1000.0);
        cart.addItem("Mouse", 50.0);
        assertEquals(1050.0, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        cart.addItem("Chair", 200.0);
        cart.addItem("Desk", 300.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(450.0, cart.getTotalCost(), 0.001);  // 10% of 500 = 50 → 500 - 50 = 450
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostEmptyCart() {
        assertEquals(0.0, cart.getTotalCost(), 0.001);
    }
    @Test
    @DisplayName("Test for removing existing item")
    public void testRemoveExistingItem() {
        cart.addItem("Book", 10.0);
        cart.removeItem("Book");
        assertEquals(0.0, cart.getTotalCost(), 0.001);
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test for removing non-existent item (expect exception)")
    public void testRemoveNonExistentItem() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("NotInCart");
        });
        assertEquals("Item does not exist in the cart.", exception.getMessage());
    }

    @Test
    @DisplayName("Test cart size updates correctly after add/remove")
    public void testCartSizeUpdates() {
        cart.addItem("Item1", 10.0);
        cart.addItem("Item2", 20.0);
        assertEquals(2, cart.getCartSize());

        cart.removeItem("Item1");
        assertEquals(1, cart.getCartSize());
    }

}
