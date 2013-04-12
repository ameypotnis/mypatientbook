package org.medical.service.impl;

import com.mysema.query.types.Predicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.medical.dao.mongo.PatientDao;
import org.medical.model.mongo.Patient;
import org.medical.service.PatientManager;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PatientManagerImplTest extends BaseManagerMockTestCase {
	@Mock
    PatientDao repository;
	@Mock Predicate predicate;
	@InjectMocks
    PatientManager manager = new PatientManagerImpl();
	
	@Test public void addShouldCallRepositorySave() {
		Patient patient = new Patient("Sagar", "Naniv");
        manager.add(patient);
		verify(repository).save(patient);
	}

	@Test(expected = IllegalArgumentException.class) public void addShouldThrowExceptionForInvalidLastName() {
		Patient patient = new Patient("Sagar", "");
		verify(repository, never()).save(patient);
	}

	@Test(expected = IllegalArgumentException.class) public void addShouldThrowExceptionForInvalidFirstName() {
		Patient patient = new Patient(null, "Naniv");
		verify(repository, never()).save(patient);
	}

}
