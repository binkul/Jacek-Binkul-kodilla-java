package com.kodilla.good.patterns.food.product;

import java.util.Objects;

public class Product {
    private final String name;
    private final double price;
    private final Currency currency;
    private final double bonus;
    private final String certificate;
    private final String description;

    public Product(String name, double price, Currency currency,double bonus, String certificate, String description) {
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.bonus = bonus;
        this.certificate = certificate;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBonus() {
        return bonus;
    }

    public String getCertificate() {
        return certificate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price + " " + currency +
                ", bonus=" + bonus +
                ", certificate='" + certificate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return  Double.compare(product.price, price) == 0 &&
                Double.compare(product.bonus, bonus) == 0 &&
                Objects.equals(name, product.name) &&
                Objects.equals(currency, product.currency) &&
                Objects.equals(certificate, product.certificate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, currency, bonus, certificate);
    }
}
