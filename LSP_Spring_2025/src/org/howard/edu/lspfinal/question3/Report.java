package org.howard.edu.lspfinal.question3;

// https://www.geeksforgeeks.org/template-method-design-pattern/

/**
 * Abstract base class representing a report.
 * Implements the template method pattern to define the workflow for report generation.
 */
public abstract class Report {

    /**
     * Template method defining the overall report generation workflow.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Loads data for the report. To be implemented by subclasses.
     */
    protected abstract void loadData();

    /**
     * Formats the loaded data. To be implemented by subclasses.
     */
    protected abstract void formatData();

    /**
     * Prints the final report. To be implemented by subclasses.
     */
    protected abstract void printReport();
}
