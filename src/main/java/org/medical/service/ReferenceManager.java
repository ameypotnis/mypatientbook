package org.medical.service;

import org.medical.model.mongo.Reference;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;

@WebService
@Path("/references")
public interface ReferenceManager {
    @POST
	public void add(Reference reference);

    @DELETE
    @Path("/{id}")
	public void remove(@PathParam("id") String id);

    @GET
    @Path("/findAll/{searchId}")
    public List<Reference> findAll(@PathParam("searchId") String searchString);
}
