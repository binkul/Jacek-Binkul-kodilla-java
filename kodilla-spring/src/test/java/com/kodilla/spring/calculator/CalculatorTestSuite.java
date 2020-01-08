package com.kodilla.spring.calculator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Before
    public void before() {
        System.out.println("Test Case: begin");
    }

    @After
    public void after() {
        System.out.println("Test Case: end");
    }

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);

        //When
        double addition = calculator.add(4, 5);
        double subtraction = calculator.sub(22.5, 11.4);
        double multiplication = calculator.mul(3.5, 2.7);
        double division = calculator.div(15, 3);

        //Then
        Assert.assertEquals(addition, 9, 0.0001);
        Assert.assertEquals(11.1, subtraction, 0.0001);
        Assert.assertEquals(9.45, multiplication, 0.0001);
        Assert.assertEquals(5, division, 0.0001);
    }

    @Test
    public void testDividingByZero() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = (Calculator)context.getBean("calculator");

        //When
        double division = calculator.div(15, 0);

        //Then
        Assert.assertTrue(Double.isNaN(division));
    }
}
