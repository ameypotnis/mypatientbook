package org.medical.dao.mongo;

import org.bson.types.ObjectId;
import org.medical.model.mongo.Reference;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ReferenceDao extends CrudRepository<Reference, ObjectId>, QueryDslPredicateExecutor<Reference> {
}
