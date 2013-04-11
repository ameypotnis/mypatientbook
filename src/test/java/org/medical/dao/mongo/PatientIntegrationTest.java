package org.medical.dao.mongo;


import org.junit.Before;
import org.junit.Test;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.query.Criteria.where;

public class PatientIntegrationTest extends AbstractIntegrationTest {

	@Override @Before
    public void setUp() {
		super.setUp();
		operations.insertAll(patients);
	}

	@Test
	public void lookupPatientByIdWithQueryBuilder() throws Exception {
		Query build = new Query(where("_id").is(sample1.getId()));
		assertSingleSagarPatient(build);
	}


	@Test
	public void lookupPatientByIdUsingJson() throws Exception {
		Query query = parseQuery("{'_id' : { '$oid' : '%s' }}", sample1.getId());
		assertSingleSagarPatient(query);
	}


	@Test
	public void lookupPatientByFirstnameUsingJson() throws Exception {
		Query query = parseQuery("{'firstname' : 'Kunal'}");
		assertSingleKunalPatient(query);
	}


	@Test
	public void lookupPatientByFirstNameUsingQueryBuilder() {
		Query spec = new Query(where("firstname").is("Kunal"));
		assertSingleKunalPatient(spec);
	}

	private Query parseQuery(String query, Object... arguments) {
		return new BasicQuery(String.format(query, arguments));
	}

}
