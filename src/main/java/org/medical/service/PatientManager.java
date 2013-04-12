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
    @Path("/create")
	public void add(Patient patient);

    @DELETE
    @Path("/{id}")
	public void remove(@PathParam("id") String id);

    @PUT
    @Path("/{id}")
	public void update(@PathParam("id") String id, Patient patient);

    @GET
    @Path("/{searchId}")
	public Patient find(@PathParam("searchId") String searchString);

    @GET
    @Path("/findAll/{searchId}")
    public List<Patient> findAll(@PathParam("searchId") String searchString);
}
