package org.medical.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.medical.model.mongo.Patient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PatientManagerTest extends BaseManagerTestCase {
    private Log log = LogFactory.getLog(UserManagerTest.class);
    @Autowired
    private PatientManager mgr;
    private Patient patient = new Patient("Sameer", "Lawson");

    @Before public void init() {
        mgr.save(patient);
    }

    @After public void tearDown() {
        mgr.remove(patient.getId().toString());
    }

    @Test public void testFind() throws Exception {
        patient = mgr.find("Sameer");
        assertNotNull(patient);
        log.debug(patient);
        assertEquals("Lawson", patient.getLastname());
    }

    @Test public void testFindAll() throws Exception {
        List<Patient> all = mgr.findAll("Sameer");
        Patient jakson = new Patient("Sameer", "Jakson");
        assertNotNull(all);
        log.debug(all);
        assertTrue(all.size() > 0);
        mgr.remove(jakson.getId().toString());
    }
}
