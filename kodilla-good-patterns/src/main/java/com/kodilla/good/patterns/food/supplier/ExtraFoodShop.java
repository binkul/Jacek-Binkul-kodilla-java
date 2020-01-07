package com.kodilla.good.patterns.food.supplier;

import com.kodilla.good.patterns.food.OrderDto;
import com.kodilla.good.patterns.food.OrderRequest;
import com.kodilla.good.patterns.food.OrderService;
import com.kodilla.good.patterns.food.information.InformationService;
import com.kodilla.good.patterns.food.product.Product;
import com.kodilla.good.patterns.food.product.ProductDao;
import com.kodilla.good.patterns.food.product.ProductDaoFile;
import com.kodilla.good.patterns.food.repo.OrderRepositoryService;

import java.util.Map;

public class ExtraFoodShop extends FoodCommon implements SupplierProcess {
    private final static String FIRST_NAME = "Jack";
    private final static String SECOND_NAME = "Thron";
    private final static String ADDRESS = "J.F.Kennedy Avenue, New York";

    private final Map<Product, Integer> products;
    private final InformationService informationService;
    private final OrderRepositoryService orderRepositoryService;
    private final OrderService orderService;
    private final Supplier supplier;

    public ExtraFoodShop(InformationService informationService,
                         OrderRepositoryService orderRepositoryService,
                         OrderService orderService) {
        this.informationService = informationService;
        this.orderRepositoryService = orderRepositoryService;
        this.orderService = orderService;
        this.supplier = new Supplier(FIRST_NAME, SECOND_NAME, ADDRESS);
        ProductDao productDao = new ProductDaoFile(SupplierList.EXTRA_FOOD_SHOP.getPath());
        this.products = productDao.createProducts();
    }

    @Override
    public OrderDto process(OrderRequest orderRequest) {

        printList();
        boolean isOrdered = orderService.order(orderRequest, getArticleByName(orderRequest.getProduct(), products),
                                                getAmountByName(orderRequest.getProduct(), products), supplier);

        if (isOrdered) {
            long id = orderRepositoryService.createOrder(supplier, orderRequest.getProduct(), orderRequest.getOrderDate());
            informationService.inform(supplier);
            return new OrderDto(id, orderRequest.getProduct(), true, supplier);
        } else {
            return new OrderDto(-1, orderRequest.getProduct(), false, supplier);
        }
    }

    private void printList() {
        System.out.println("\nAvailable articles from " + supplier.toString() + " company");
        printArticles(products);
    }
}
