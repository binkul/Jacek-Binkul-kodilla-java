package com.kodilla.good.patterns.orders;

import com.kodilla.good.patterns.orders.information.SmsService;
import com.kodilla.good.patterns.orders.order.ProductOrderService;
import com.kodilla.good.patterns.orders.repository.MSSqlService;

public class Application {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new SmsService(), new MSSqlService(), new ProductOrderService());
        orderProcessor.process(orderRequest);
    }
}
