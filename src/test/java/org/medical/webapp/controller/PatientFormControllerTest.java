
package org.medical.webapp.controller;

import org.junit.Test;
import org.medical.model.mongo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import static org.junit.Assert.assertNotNull;

public class PatientFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private PatientFormController form;
    private Patient patient;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/patientform");
        request.addParameter("id", "Kunal");

        patient = form.showForm(request);
        assertNotNull(patient);
    }
}