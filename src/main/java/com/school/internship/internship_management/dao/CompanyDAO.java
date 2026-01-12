package com.school.internship.internship_management.dao;

import com.school.internship.internship_management.entity.Company;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyDAO extends GenericDAO<Company> {

    public CompanyDAO() {
        super(Company.class);
    }
}
