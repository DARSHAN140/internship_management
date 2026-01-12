package com.school.internship.internship_management.rest;

import com.school.internship.internship_management.entity.Company;
import com.school.internship.internship_management.service.CompanyService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/companies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyResource {

    @Inject
    private CompanyService companyService;

    @POST
    public Response create(Company company) {
        Company created = companyService.create(company);
        return Response.status(Response.Status.CREATED).entity(created).build();
    }

    @GET
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @GET
    @Path("/{id}")
    public Company findById(@PathParam("id") Long id) {
        return companyService.findById(id)
                .orElseThrow(() -> new NotFoundException("Entreprise non trouvée"));
    }

    @PUT
    @Path("/{id}")
    public Company update(@PathParam("id") Long id, Company company) {
        company.setId(id);
        return companyService.update(company);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        companyService.delete(id);
        return Response.noContent().build();
    }
}
