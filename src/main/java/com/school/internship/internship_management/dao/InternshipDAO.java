package com.school.internship.internship_management.dao;

import com.school.internship.internship_management.entity.Internship;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class InternshipDAO extends GenericDAO<Internship> {

    public InternshipDAO() {
        super(Internship.class);
    }

    public List<Internship> findByStudentId(Long studentId) {
        TypedQuery<Internship> query = em.createQuery(
                "SELECT i FROM Internship i WHERE i.student.id = :studentId",
                Internship.class
        );
        query.setParameter("studentId", studentId);
        return query.getResultList();
    }
}
