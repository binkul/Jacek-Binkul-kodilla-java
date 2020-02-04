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
        Product product1 = new Product("Socks");
        Product product2 = new Product("Sweater");
        Product product3 = new Product("Pants");
        Product product4 = new Product("Gloves");

        Item item1 = new Item(new BigDecimal("120"), 2);
        Item item2 = new Item(new BigDecimal("10"), 4);
        Item item3 = new Item(new BigDecimal("15"), 7);
        Item item4 = new Item(new BigDecimal("120"), 8);
        Item item5 = new Item(new BigDecimal("2"), 9);
        Item item6 = new Item(new BigDecimal("23"), 10);
        Item item7 = new Item(new BigDecimal("11"), 11);
        Item item8 = new Item(new BigDecimal("47"), 12);

        String invoiceNr = "HK/B/30.01.2020";
        Invoice invoice = new Invoice(invoiceNr);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);
        item5.setInvoice(invoice);
        item6.setInvoice(invoice);
        item7.setInvoice(invoice);
        item8.setInvoice(invoice);

        item1.setProduct(product1);
        item2.setProduct(product1);
        item3.setProduct(product2);
        item4.setProduct(product2);
        item5.setProduct(product3);
        item6.setProduct(product4);
        item7.setProduct(product4);
        item8.setProduct(product4);

        product1.setItems(Arrays.asList(item1, item2));
        product2.setItems(Arrays.asList(item3, item4));
        product3.addItem(item5);
        product4.setItems(Arrays.asList(item6, item7, item8));

        invoice.setItems(Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8));

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        int idProduct = product4.getId();

        Invoice readInvoice = invoiceDao.findByNumber(invoiceNr);
        long productCount = productDao.count();
        long itemCount = itemDao.count();
        long invoiceCount = invoiceDao.count();
        List<Item> items = itemDao.findByProduct_Id(idProduct);

        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertEquals(invoiceNr, readInvoice.getNumber());
        Assert.assertEquals(1, invoiceCount);
        Assert.assertEquals(4, productCount);
        Assert.assertEquals(8, itemCount);
        Assert.assertEquals(3, items.size());

        //CleanUp
        try {
            invoiceDao.deleteAll();
            productDao.deleteAll();
            itemDao.deleteAll();
        } catch (Exception ex) {

        }



    }

}
