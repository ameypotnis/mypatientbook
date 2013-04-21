package org.medical.service;

import org.medical.model.mongo.Reference;
import org.medical.model.mongo.ReferenceKey;

import javax.jws.WebService;
import javax.ws.rs.*;
import java.util.List;
import java.util.Set;

@WebService
@Path("/references")
public interface ReferenceManager {
    @POST
	public void add(Reference reference);

    @DELETE
    @Path("/{id}")
	public void remove(@PathParam("id") String id);

    @GET
    @Path("{searchId}")
    public List<Reference> findAll(@PathParam("searchId") String searchString);

    void add(ReferenceKey history, Set<String> strings);
}
