package com.kodilla.good.patterns.food;

import com.kodilla.good.patterns.food.information.MailService;
import com.kodilla.good.patterns.food.repo.MsSqlService;
import com.kodilla.good.patterns.food.supplier.ExtraFoodShop;
import com.kodilla.good.patterns.food.supplier.GlutenFreeShop;
import com.kodilla.good.patterns.food.supplier.HealthyShop;
import com.kodilla.good.patterns.food.supplier.SupplierProcess;

public class Application {

    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        SupplierProcess supplierProcess = new HealthyShop(new MailService(), new MsSqlService(), new ProductOrderService());
        supplierProcess.process(orderRequest);
    }
}
