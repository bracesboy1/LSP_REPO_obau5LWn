package org.howard.edu.lspfinal.question3;

/**
 * Driver class for demonstrating the reporting system using the template method pattern.
 */
public class Driver {
    public static void main(String[] args) {
        Report sales = new SalesReport();
        Report inventory = new InventoryReport();

        sales.generateReport();
        System.out.println();
        inventory.generateReport();
    }
}



