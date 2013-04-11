package org.medical.dao.mongo;

import org.bson.types.ObjectId;
import org.medical.model.mongo.Patient;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, ObjectId>, QueryDslPredicateExecutor<Patient> {
	List<Patient> findByLastname(String name);
	List<Patient> findByFirstnameLike(String name);
	List<Patient> findByFirstnameLikeOrLastnameLike(String firstname, String lastname);
}
