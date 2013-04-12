package org.medical.webapp.controller;

import org.medical.model.Appointment;
import org.medical.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/appointments*")
public class AppointmentController {
    private GenericManager<Appointment, Long> appointmentManager;

    @Autowired
    public void setAppointmentManager(@Qualifier("appointmentManager") GenericManager<Appointment, Long> appointmentManager) {
        this.appointmentManager = appointmentManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
            throws Exception {
        return new ModelAndView().addObject(appointmentManager.getAll());
    }
}