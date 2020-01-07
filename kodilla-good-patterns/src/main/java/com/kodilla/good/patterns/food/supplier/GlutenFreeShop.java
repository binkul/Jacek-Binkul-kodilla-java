package com.kodilla.good.patterns.food.supplier;

import com.kodilla.good.patterns.food.OrderDto;
import com.kodilla.good.patterns.food.OrderRequest;
import com.kodilla.good.patterns.food.OrderService;
import com.kodilla.good.patterns.food.information.InformationService;
import com.kodilla.good.patterns.food.product.Product;
import com.kodilla.good.patterns.food.product.ProductDao;
import com.kodilla.good.patterns.food.product.ProductDaoConst;
import com.kodilla.good.patterns.food.repo.OrderRepositoryService;

import java.util.Map;

public class GlutenFreeShop extends FoodCommon implements SupplierProcess {
    private final static String FIRST_NAME = "Timothy";
    private final static String SECOND_NAME = "Pumba";
    private final static String ADDRESS = "Mozambik, Africa";

    private final Map<Product, Integer> products;
    private final InformationService informationService;
    private final OrderRepositoryService orderRepositoryService;
    private final OrderService orderService;
    private final Supplier supplier;

    public GlutenFreeShop(InformationService informationService,
                         OrderRepositoryService orderRepositoryService,
                         OrderService orderService) {
        this.informationService = informationService;
        this.orderRepositoryService = orderRepositoryService;
        this.orderService = orderService;
        this.supplier = new Supplier(FIRST_NAME, SECOND_NAME, ADDRESS);
        ProductDao productDao = new ProductDaoConst(SupplierList.GLUTEN_FREE_SHOP.getProducts());
        this.products = productDao.createProducts();
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {
        System.out.println(supplier.getFullData());
        printArticles(products);
        return new OrderDto(3, orderRequest.getProduct(), true, supplier);
    }
}
