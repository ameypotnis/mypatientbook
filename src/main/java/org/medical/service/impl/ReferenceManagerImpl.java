package org.medical.service.impl;

import org.bson.types.ObjectId;
import org.medical.dao.mongo.ReferenceDao;
import org.medical.model.mongo.QReference;
import org.medical.model.mongo.Reference;
import org.medical.model.mongo.ReferenceKey;
import org.medical.service.ReferenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Iterator;
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
    public void remove(String id) {
       repository.delete(new ObjectId(id));
    }

    @Override
    public List<Reference> findAll(String searchString) {
        Iterator<Reference> iter = repository.findAll(this.reference.key.eq(ReferenceKey.valueOf(searchString))).iterator();
        List<Reference> copy = new ArrayList<Reference>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
    }
}
