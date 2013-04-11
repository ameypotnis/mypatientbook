package org.medical.dao.mongo;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.medical.model.mongo.Followup;
import org.medical.model.mongo.History;
import org.medical.model.mongo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public abstract class AbstractIntegrationTest {

	static final String COLLECTION = "patient";
	@Autowired
	MongoOperations operations;

	Patient sample1;
	Patient sample2;
	List<Patient> patients;

	@Before
	public void setUp() {
		operations.dropCollection(COLLECTION);
	}

	public AbstractIntegrationTest() {
		patients = new ArrayList<Patient>();
		sample1 = new Patient("Sagar", "Naniv");
		History history = new History();
		history.addAttributes("Sample1", "false");
		history.addAttributes("Sample2", "false");
		sample1.setHistory(history);
		Followup followup = new Followup();
		sample1.addFollowups(followup);
		patients.add(sample1);
		sample2 = new Patient("Kunal", "Chan");
		patients.add(sample2);
	}

	protected void assertSingleSagarPatient(Query query) {
		List<Patient> result = operations.find(query, Patient.class, COLLECTION);
		assertThat(result, is(notNullValue()));
		assertThat(result.size(), is(1));
		assertSingleSagarPatient(result.get(0));
	}

	protected void assertSingleSagarPatient(Patient patient) {
		assertThat(patient, is(notNullValue()));
		assertThat(patient.getId(), is(sample1.getId()));
		assertThat(patient.getFirstname(), is(sample1.getFirstname()));
		assertThat(patient.getLastname(), is(sample1.getLastname()));
	}

	protected void assertSingleKunalPatient(Query query) {
		List<Patient> result = operations.find(query, Patient.class, COLLECTION);
		assertThat(result, is(notNullValue()));
		assertThat(result.size(), is(1));
		assertSingleKunalPatient(result.get(0));
	}
	
	protected void assertSingleKunalPatient(Patient patient) {
		assertThat(patient, is(notNullValue()));
		assertThat(patient.getId(), is(sample2.getId()));
		assertThat(patient.getFirstname(), is(sample2.getFirstname()));
		assertThat(patient.getLastname(), is(sample2.getLastname()));
	}

}
