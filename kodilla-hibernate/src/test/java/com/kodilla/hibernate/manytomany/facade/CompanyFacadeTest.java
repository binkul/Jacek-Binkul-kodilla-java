package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyFacadeTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyFacadeTest.class);

    @Autowired
    private CompanyFacade companyFacade;

    @Before
    public void printBefore() {
        System.out.println("\nTest start:");
    }

    @After
    public void printAfter() {
        System.out.println("Test finished\n");
    }

    @Test
    public void testFindAnyCompany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaSmithelin = new Employee("Linda", "Smithelin");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey dates Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaSmithelin);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaSmithelin);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaSmithelin.getCompanies().add(dataMaesters);
        lindaSmithelin.getCompanies().add(greyMatter);

        //When
        companyFacade.save(softwareMachine);
        companyFacade.save(dataMaesters);
        companyFacade.save(greyMatter);

        List<Company> resultA = null;
        try {
            resultA = companyFacade.findCompanies("dat");
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage() + "\n");
        }

        List<Company> resultB = null;
        try {
            resultB = companyFacade.findCompanies("war");
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage() + "\n");
        }

        List<Company> resultC = null;
        try {
            resultC = companyFacade.findCompanies("flot");
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage() + "\n");
        }

        // Then
        try {
            Assert.assertEquals(2, resultA.size());
            Assert.assertEquals(1, resultB.size());
            Assert.assertNull(resultC);
        } finally {
            companyFacade.deleteAll();
        }
    }

    @Test
    public void testFindAnyEmployee() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaSmithelin = new Employee("Linda", "Smithelin");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey dates Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaSmithelin);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaSmithelin);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaSmithelin.getCompanies().add(dataMaesters);
        lindaSmithelin.getCompanies().add(greyMatter);

        //When
        companyFacade.save(softwareMachine);
        companyFacade.save(dataMaesters);
        companyFacade.save(greyMatter);

        List<Employee> resultA = null;
        try {
            resultA = companyFacade.findEmployees("smi");
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage() + "\n");
        }

        List<Employee> resultB = null;
        try {
            resultB = companyFacade.findEmployees("jac");
        } catch (EntityNotFoundException e) {
            LOGGER.error(e.getMessage() + "\n");
        }

        // Then
        try {
            Assert.assertEquals(2, resultA.size());
            Assert.assertNull(resultB);
        } finally {
            companyFacade.deleteAll();
        }
    }
}