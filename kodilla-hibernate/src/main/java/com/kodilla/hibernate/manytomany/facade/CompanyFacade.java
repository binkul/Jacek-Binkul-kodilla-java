package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public void deleteAll() {
        companyDao.deleteAll();
    }

    public void save(Company company) {
        companyDao.save(company);
    }

    public List<Company> findCompanies(String shortcut) throws EntityNotFoundException {
        return companyDao.retrieveCompanyByShortcut("%" + shortcut + "%")
                .orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.NOT_FOUND_COMPANY));
    }

    public List<Employee> findEmployees(String shortcut) throws EntityNotFoundException {
        return employeeDao.retrieveEmployeeByShortcut("%" + shortcut + "%")
                .orElseThrow(() -> new EntityNotFoundException(EntityNotFoundException.NOT_FOUND_EMPLOYEE));
    }
}
