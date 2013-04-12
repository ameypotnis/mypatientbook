package org.medical.service.impl;

import org.bson.types.ObjectId;
import org.medical.dao.mongo.ReferenceDao;
import org.medical.model.mongo.QReference;
import org.medical.model.mongo.Reference;
import org.medical.service.ReferenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.ws.rs.PathParam;
import java.util.List;

@Service("referenceManager")
@WebService(serviceName = "ReferenceService", endpointInterface = "org.medical.service.ReferenceManager")
public class ReferenceManagerImpl implements ReferenceManager {
	
	@Autowired
    ReferenceDao repository;
	QReference reference = QReference.reference;

    @Override
    public void add(Reference reference) {
        repository.save(reference);
    }

    @Override
    public void remove(@PathParam("id") String id) {
       repository.delete(new ObjectId(id));
    }

    @Override
    public List<Reference> findAll(@PathParam("searchId") String searchString) {
        return null;
    }
}
