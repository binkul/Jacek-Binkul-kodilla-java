package com.kodilla.good.patterns.food.supplier;

import com.kodilla.good.patterns.food.OrderDto;
import com.kodilla.good.patterns.food.OrderRequest;

public interface SupplierProcess {
    OrderDto process(OrderRequest orderRequest);
}
