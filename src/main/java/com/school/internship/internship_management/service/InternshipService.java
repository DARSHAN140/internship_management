package com.school.internship.internship_management.service;

import com.school.internship.internship_management.dao.InternshipDAO;
import com.school.internship.internship_management.dao.StudentDAO;
import com.school.internship.internship_management.dao.CompanyDAO;
import com.school.internship.internship_management.entity.Company;
import com.school.internship.internship_management.entity.Internship;
import com.school.internship.internship_management.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class InternshipService {

    @Inject
    private InternshipDAO internshipDAO;

    @Inject
    private StudentDAO studentDAO;

    @Inject
    private CompanyDAO companyDAO;

    public Internship create(Long studentId, Long companyId, Internship internship) {

        Student student = studentDAO.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Étudiant introuvable"));

        Company company = companyDAO.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));

        internship.setStudent(student);
        internship.setCompany(company);

        return internshipDAO.save(internship);
    }

    public Internship update(Internship internship) {
        return internshipDAO.save(internship);
    }

    public Internship findById(Long id) {
        return internshipDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Stage introuvable"));
    }

    public List<Internship> findByStudent(Long studentId) {
        return internshipDAO.findByStudentId(studentId);
    }

    public void delete(Long id) {
        internshipDAO.deleteById(id);
    }
}
