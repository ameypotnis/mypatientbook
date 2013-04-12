package org.medical.dao.mongo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medical.model.mongo.QReference;
import org.medical.model.mongo.Reference;
import org.medical.model.mongo.ReferenceKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ReferenceRepositoryIntegrationTest {
	@Autowired
    ReferenceDao repository;
	
	@Before public void setUp() {
		repository.deleteAll();
	}

	@Test public void create() throws Exception {
		Reference entity = new Reference(ReferenceKey.DIAGNOSIS);
		entity.setValue("DIAGNOSIS1");
		entity.setValue("DIAGNOSIS2");
		repository.save(entity);
		Assert.assertNotNull(entity.getId());
	}

	@Test public void get() throws Exception {
		Reference entity = new Reference(ReferenceKey.DIAGNOSIS);
		entity.setValue("DIAGNOSIS1");
		repository.save(entity);
		entity = new Reference(ReferenceKey.DIAGNOSIS);
		entity.setValue("DIAGNOSIS2");
		repository.save(entity);
		QReference predicate = QReference.reference;
		Iterable<Reference> all = repository.findAll(predicate.key.eq(ReferenceKey.DIAGNOSIS));
	}

}
