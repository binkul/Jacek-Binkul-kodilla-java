package com.kodilla.good.patterns.food.product;

import java.io.*;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class ProductDaoFile extends ProductDaoCommon implements ProductDao {
    private final String path;

    public ProductDaoFile(String path) {
        super();
        this.path = path;
    }

    private String getPath(String path) {
        ClassLoader loader = getClass().getClassLoader();
        Object object = loader.getResource(path);
        if (object != null) {
            return object.toString().replaceAll("%20", " ").replaceAll("file:/", "");
        } else {
            return "";
        }
    }

    @Override
    public Map<Product, Integer> createProducts() {
        Map<Product, Integer> result = new HashMap<>();
        File file = new File(getPath(path));
        int id = 1;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String readLine = bufferedReader.readLine();

            while(readLine != null) {
                AbstractMap.SimpleEntry<Product, Integer> entry = createProduct(readLine);
                result.put(entry.getKey(), entry.getValue());
                readLine = bufferedReader.readLine();
                id++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File: '" + file + "' not found.");
        } catch (IOException ex) {
            System.out.println("Error while reading file: '" + file + "'.");
        }
        return result;
    }
}
