package com.kodilla.good.patterns.food.supplier;

import com.kodilla.good.patterns.food.OrderDto;
import com.kodilla.good.patterns.food.OrderRequest;
import com.kodilla.good.patterns.food.OrderService;
import com.kodilla.good.patterns.food.information.InformationService;
import com.kodilla.good.patterns.food.product.Product;
import com.kodilla.good.patterns.food.product.ProductDao;
import com.kodilla.good.patterns.food.product.ProductDaoConst;
import com.kodilla.good.patterns.food.product.ProductDaoFile;
import com.kodilla.good.patterns.food.repo.OrderRepositoryService;

import java.util.Map;

public class HealthyShop extends FoodCommon implements SupplierProcess {
    private final static String FIRST_NAME = "Johnny";
    private final static String SECOND_NAME = "Bravo";
    private final static String ADDRESS = "Cartoon Network, USA";

    private final Map<Product, Integer> products;
    private final InformationService informationService;
    private final OrderRepositoryService orderRepositoryService;
    private final OrderService orderService;
    private final Supplier supplier;

    public HealthyShop(InformationService informationService,
                          OrderRepositoryService orderRepositoryService,
                          OrderService orderService) {
        this.informationService = informationService;
        this.orderRepositoryService = orderRepositoryService;
        this.orderService = orderService;
        this.supplier = new Supplier(FIRST_NAME, SECOND_NAME, ADDRESS);
        ProductDao productDao = new ProductDaoFile(SupplierList.HEALTHY_SHOP.getPath());
        this.products = productDao.createProducts();
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {

        System.out.println(supplier.getFullData());
        printArticles(products);

        if (orderService.order(orderRequest, getArticleByName(orderRequest.getProduct(), products),
                getAmountByName(orderRequest.getProduct(), products), supplier)) {

            long id = orderRepositoryService.createOrder(supplier, orderRequest.getProduct(), orderRequest.getOrderDate());
            informationService.inform(supplier);
            return new OrderDto(id, orderRequest.getProduct(), true, supplier);
        } else {
            return new OrderDto(-1, orderRequest.getProduct(), false, supplier);
        }
    }
}
