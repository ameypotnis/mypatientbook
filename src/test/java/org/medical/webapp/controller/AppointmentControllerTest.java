package org.medical.webapp.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AppointmentControllerTest extends BaseControllerTestCase {
    @Autowired
    private AppointmentController controller;

    @Test
    public void testHandleRequest() throws Exception {
        ModelAndView mav = controller.handleRequest();
        ModelMap m = mav.getModelMap();
        assertNotNull(m.get("appointmentList"));
        assertTrue(((List) m.get("appointmentList")).size() > 0);
    }
}