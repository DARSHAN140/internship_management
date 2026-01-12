package com.school.internship.internship_management.rest;

import com.school.internship.internship_management.entity.Internship;
import com.school.internship.internship_management.service.InternshipService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/internships")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class InternshipResource {

    @Inject
    private InternshipService internshipService;

    // CREATE : /internships?studentId=1&companyId=1
    @POST
    public Response create(@QueryParam("studentId") Long studentId,
                           @QueryParam("companyId") Long companyId,
                           Internship internship) {

        Internship created = internshipService.create(studentId, companyId, internship);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    // READ ONE
    @GET
    @Path("/{id}")
    public Internship findById(@PathParam("id") Long id) {
        return internshipService.findById(id);
    }

    // READ internships by student
    @GET
    @Path("/student/{studentId}")
    public List<Internship> findByStudent(@PathParam("studentId") Long studentId) {
        return internshipService.findByStudent(studentId);
    }

    // UPDATE
    @PUT
    @Path("/{id}")
    public Internship update(@PathParam("id") Long id, Internship internship) {
        internship.setId(id);
        return internshipService.update(internship);
    }

    // DELETE
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        internshipService.delete(id);
        return Response.noContent().build();
    }
}
