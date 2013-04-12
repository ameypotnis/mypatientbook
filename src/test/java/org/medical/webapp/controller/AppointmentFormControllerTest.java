package org.medical.webapp.controller;

import org.junit.Test;
import org.medical.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import static org.junit.Assert.*;

public class AppointmentFormControllerTest extends BaseControllerTestCase {
    @Autowired
    private AppointmentFormController form;
    private Appointment appointment;
    private MockHttpServletRequest request;

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        request = newGet("/appointmentform");
        request.addParameter("id", "1");

        appointment = form.showForm(request);
        assertNotNull(appointment);
    }

    @Test
    public void testSave() throws Exception {
        request = newGet("/appointmentform");
        request.addParameter("id", "1");

        appointment = form.showForm(request);
        assertNotNull(appointment);

        request = newPost("/appointmentform");

        appointment = form.showForm(request);
        // update required fields
        appointment.setCaseNumber("Homer");
        appointment.setName("Simpson");

        BindingResult errors = new DataBinder(appointment).getBindingResult();
        form.onSubmit(appointment, errors, request, new MockHttpServletResponse());
        assertFalse(errors.hasErrors());
        assertNotNull(request.getSession().getAttribute("successMessages"));
    }

   /* @Test
    public void testRemove() throws Exception {
        request = newPost("/appointmentform");
        request.addParameter("delete", "");
        appointment = new Appointment();
        appointment.setId(2L);

        BindingResult errors = new DataBinder(appointment).getBindingResult();
        form.onSubmit(appointment, errors, request, new MockHttpServletResponse());

        assertNotNull(request.getSession().getAttribute("successMessages"));
    }*/
}