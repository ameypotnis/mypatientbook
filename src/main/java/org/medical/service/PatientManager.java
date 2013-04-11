package org.medical.service;

import org.medical.model.mongo.Followup;
import org.medical.model.mongo.Patient;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@WebService
@Path("/patients")
public interface PatientManager {
	public void add(Patient patient);
	public void remove(Patient patient);
    @GET
    @Path("{searchId}")
	public List<Patient> findAll(@PathParam("searchId") String search);
	public void updatePersonalInfo(Patient patient);
	public void addFollowup(Followup followup);
	public Patient find(String code);
}
