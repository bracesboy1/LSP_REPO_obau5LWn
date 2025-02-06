package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ETL_Pipeline {
    public static void main(String[] args) {
        String inputFilePath = Paths.get("data", "products.csv").toString();
        String outputFilePath = Paths.get("data", "transformed_products.csv").toString();
        
        List<String[]> data = extract(inputFilePath);
        if (data != null) {
            List<String[]> transformedData = transform(data);
            load(transformedData, outputFilePath);
        }
    }
    
    private static List<String[]> extract(String filePath) { // Extract Method
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                if (!line.isEmpty()) { // Keep empty lines
                    data.add(line.split(",", -1));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return null;
        }
        return data;
    }
    
    private static List<String[]> transform(List<String[]> data) { // Transform Method
        List<String[]> transformedData = new ArrayList<>();
        transformedData.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});
        
        for (String[] row : data) {
            if (row.length != 4) { // Ensure row has all required fields
                System.err.println("Skipping malformed row: " + Arrays.toString(row));
                continue;
            }

            try {
                int productId = Integer.parseInt(row[0].trim()); // Name Standardization
                String name = row[1].trim().toUpperCase();
                String priceStr = row[2].trim();
                String category = row[3].trim();

                if (priceStr.isEmpty()) {
                    System.err.println("Skipping row with missing price: " + Arrays.toString(row));
                    continue;
                }

                double price = Double.parseDouble(priceStr);

                if (category.equals("Electronics")) { // 10% discount on electronics
                    price *= 0.9;
                    price = Math.round(price * 100.0) / 100.0;
                }

                if (price > 500 && category.equals("Electronics")) {
                    category = "Premium Electronics";
                }

                String priceRange; // Added new field "Price Range"
                if (price <= 10) {
                    priceRange = "Low";
                } else if (price <= 100) {
                    priceRange = "Medium";
                } else if (price <= 500) {
                    priceRange = "High";
                } else {
                    priceRange = "Premium";
                }

                transformedData.add(new String[]{
                    String.valueOf(productId), 
                    name, 
                    String.format("%.2f", price), 
                    category, 
                    priceRange
                });

            } catch (NumberFormatException e) {
                System.err.println("Skipping row due to invalid number format: " + Arrays.toString(row));
            }
        }
        return transformedData;
    }
    
    private static void load(List<String[]> data, String filePath) { // Load Method
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
            System.out.println("Transformation completed. Output saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }
    }
}
