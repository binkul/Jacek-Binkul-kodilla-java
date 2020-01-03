package com.kodilla.good.patterns.food;

import com.kodilla.good.patterns.food.product.Product;
import com.kodilla.good.patterns.food.supplier.Supplier;

import java.util.Optional;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(OrderRequest orderRequest, Optional<Product> product, Integer amount, Supplier supplier) {
        return product.map(value -> isPresent(orderRequest, value, amount, supplier)).orElseGet(() -> isNotPresent(orderRequest));
    }

    private boolean isPresent(OrderRequest orderRequest, Product product, Integer amount, Supplier supplier) {
        if (orderRequest.getAmount() <= amount) {
            System.out.format("\nProduct '%s' in price of %.2f %s has been ordered from %s company, at %tF \n", product.getName(), product.getPrice(), product.getCurrency(),
                    supplier.toString(), orderRequest.getOrderDate());
            return true;
        } else {
            System.out.format("\nInsufficient amount of product '%s' on the stock. Required: %d, available: %d.\n", product.getName(), orderRequest.getAmount(), amount);
            return false;
        }
    }

    private boolean isNotPresent(OrderRequest orderRequest) {
        System.out.format("\nProduct/Article '%s' does not exist on our stock!\n", orderRequest.getProduct());
        return false;
    }
}
