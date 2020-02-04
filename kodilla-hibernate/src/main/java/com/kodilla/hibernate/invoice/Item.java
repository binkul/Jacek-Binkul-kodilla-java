package com.kodilla.hibernate.invoice;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;

@NamedNativeQuery(
        name = "Item.retrieveCountOfAll",
        query = "Select * from items",
        resultClass = Item.class
)
@Entity
@Table(name = "items")
public class Item {
    private int id;

    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;
    private Product product;

    public Item() {
    }

    public Item(Invoice invoice, Product product, BigDecimal price, int quantity) {
        this.invoice = invoice;
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = price.multiply(new BigDecimal(quantity));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    public Product getProduct() {
        return product;
    }

    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    @NotNull
    public int getQuantity() {
        return quantity;
    }

    @NotNull
    public BigDecimal getValue() {
        return value;
    }

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    public Invoice getInvoice() {
        return invoice;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setProduct(Product product) {

        this.product = product;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void setValue(BigDecimal value) {
        this.value = value;
    }

    private void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }}
