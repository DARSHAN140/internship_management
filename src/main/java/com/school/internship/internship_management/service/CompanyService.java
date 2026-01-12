package com.school.internship.internship_management.service;

import com.school.internship.internship_management.dao.CompanyDAO;
import com.school.internship.internship_management.entity.Company;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class CompanyService {

    @Inject
    private CompanyDAO companyDAO;

    public Company create(Company company) {
        return companyDAO.save(company);
    }

    public Company update(Company company) {
        return companyDAO.save(company);
    }

    public Optional<Company> findById(Long id) {
        return companyDAO.findById(id);
    }

    public List<Company> findAll() {
        return companyDAO.findAll();
    }

    public void delete(Long id) {
        companyDAO.deleteById(id);
    }
}
