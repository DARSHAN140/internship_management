package com.school.internship.internship_management.service;

import com.school.internship.internship_management.dao.StudentDAO;
import com.school.internship.internship_management.entity.Student;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class StudentService {

    @Inject
    private StudentDAO studentDAO;

    public Student create(Student student) {
        // règle métier : email unique
        studentDAO.findByEmail(student.getEmail()).ifPresent(s -> {
            throw new RuntimeException("Email déjà utilisé");
        });
        return studentDAO.save(student);
    }

    public Student update(Student student) {
        return studentDAO.save(student);
    }

    public Optional<Student> findById(Long id) {
        return studentDAO.findById(id);
    }

    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    public void delete(Long id) {
        studentDAO.deleteById(id);
    }
}
