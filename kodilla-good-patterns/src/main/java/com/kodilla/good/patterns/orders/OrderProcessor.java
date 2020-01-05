package com.kodilla.good.patterns.orders;

import com.kodilla.good.patterns.orders.information.InformationService;
import com.kodilla.good.patterns.orders.order.OrderService;
import com.kodilla.good.patterns.orders.repository.OrderRepositoryService;

public class OrderProcessor {
    private InformationService informationService;
    private OrderRepositoryService orderRepositoryService;
    private OrderService orderService;

    public OrderProcessor(final InformationService informationService,
                          final OrderRepositoryService orderRepositoryService,
                          final OrderService orderService) {
        this.informationService = informationService;
        this.orderRepositoryService = orderRepositoryService;
        this.orderService = orderService;
    }

    public OrderDTO process(OrderRequest orderRequest) {
        long id = -1;
        boolean isOrdered = orderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderDate());

        if (isOrdered) {
            id = orderRepositoryService.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderDate());
            informationService.inform(orderRequest.getUser());
            printOrderDetail(id);
            return new OrderDTO(id, orderRequest.getUser(), true);
        } else {
            return new OrderDTO(id, orderRequest.getUser(), false);
        }
    }

    private void printOrderDetail(long id) {
        System.out.println("Id of order = " + id);
    }
}
