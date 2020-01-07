package com.kodilla.good.patterns.food;

import com.kodilla.good.patterns.food.product.Product;
import com.kodilla.good.patterns.food.supplier.Supplier;

public interface OrderService {
    boolean order(OrderRequest orderRequest, Product product, Integer amount, Supplier supplier);
}
