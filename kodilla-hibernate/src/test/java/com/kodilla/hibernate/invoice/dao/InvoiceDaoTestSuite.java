package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ItemDao itemDao;
    @Autowired
    ProductDao productDao;

    @Test
    public void testInvoiceDaoSave() {

        //Given
        String number = "HK/B/01.02.2020";
        Invoice invoice = new Invoice(number);

        Product product1 = new Product("Socks");
        Product product2 = new Product("Pants");
        Product product3 = new Product("Shirt");

        Item item1 = new Item(invoice, product1, new BigDecimal(2.5), 25);
        Item item2 = new Item(invoice, product2, new BigDecimal(13.5), 40);
        Item item3 = new Item(invoice, product3, new BigDecimal(3.5), 25);

        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        //when
        invoiceDao.save(invoice);
        int id = invoice.getId();
        int idProduct1 = product1.getId();
        int numberOfItems = invoice.getItems().size();
        List<Item> readItems = itemDao.retrieveCountOfAll();
        Invoice invoiceRead = invoiceDao.findById(id);
        Product readProduct = productDao.findById(idProduct1);

        //then
        Assert.assertNotEquals(0, id);
        Assert.assertNotEquals(0, idProduct1);
        Assert.assertEquals(product1.getName(), readProduct.getName());
        Assert.assertEquals(3, numberOfItems);
        Assert.assertEquals(3, readItems.size());
        Assert.assertEquals(id, invoiceRead.getId());
        Assert.assertEquals(number, invoiceRead.getNumber());

        //CleanUp
        invoiceDao.deleteAll();
        productDao.deleteAll();
    }

}
