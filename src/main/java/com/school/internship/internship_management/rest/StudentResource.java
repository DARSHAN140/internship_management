package com.school.internship.internship_management.rest;

import com.school.internship.internship_management.entity.Student;
import com.school.internship.internship_management.service.StudentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

    @Inject
    private StudentService studentService;

    // CREATE
    @POST
    public Response create(Student student) {
        Student created = studentService.create(student);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    // READ ALL
    @GET
    public List<Student> findAll() {
        return studentService.findAll();
    }

    // READ ONE
    @GET
    @Path("/{id}")
    public Student findById(@PathParam("id") Long id) {
        return studentService.findById(id)
                .orElseThrow(() -> new NotFoundException("Étudiant non trouvé"));
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public Student update(@PathParam("id") Long id, Student student) {
        student.setId(id);
        return studentService.update(student);
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        studentService.delete(id);
        return Response.noContent().build();
    }
}
