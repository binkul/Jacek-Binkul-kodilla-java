package com.kodilla.good.patterns.food;

import com.kodilla.good.patterns.food.product.Product;
import com.kodilla.good.patterns.food.supplier.Supplier;

import java.util.Optional;

public interface OrderService {
    boolean order(OrderRequest orderRequest, Optional<Product> product, Integer amount, Supplier supplier);
}
