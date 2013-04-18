package org.medical.service;

import org.medical.model.mongo.Followup;
import org.medical.model.mongo.Patient;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

@WebService
@Path("/patients")
public interface PatientManager {
    @POST
	public void save(Patient patient);

    @DELETE
	public void remove(String id);

    @GET
    @Path("single/{id}")
	public Patient find(@PathParam("id") String searchString);

    @GET
    @Path("{searchString}")
    public List<Patient> findAll(@PathParam("searchString") String searchString);
}
