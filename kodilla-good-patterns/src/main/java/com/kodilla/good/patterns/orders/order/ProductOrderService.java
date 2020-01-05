package com.kodilla.good.patterns.orders.order;

import com.kodilla.good.patterns.orders.User;
import com.kodilla.good.patterns.orders.products.Articles;
import com.kodilla.good.patterns.orders.products.StockStatus;

import java.time.LocalDate;

public class ProductOrderService implements OrderService{

    @Override
    public boolean order(User user, String product, LocalDate localDate) {
        Articles article = Articles.getArticle(product);

        if (article != null) {
            return isPresent(user, article, localDate);
        } else {
            return isNotPresent(product);
        }
    }

    private boolean isPresent(User user, Articles article, LocalDate localDate) {
        if (article.getStockStatus() == StockStatus.PRESENT) {
            System.out.format("\nProduct '%s' in price of %.2f has been ordered by %s, at %tF \n", article.getName(), article.getPrice(), user.toString(), localDate);
            return true;
        } else {
            System.out.format("\nProduct '%s' is not available at the moment. \n", article.getName());
            return false;
        }
    }

    private boolean isNotPresent(String product) {
        System.out.format("\nProduct/Article '%s' does not exist on our stock! \n", product);
        return false;
    }
}
