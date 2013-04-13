package org.medical.webapp.controller;

import org.apache.commons.lang.StringUtils;

import org.medical.model.Appointment;
import org.medical.service.GenericManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;

@Controller
@RequestMapping("/appointmentform*")
public class AppointmentFormController extends BaseFormController {
    private GenericManager<Appointment, Long> appointmentManager = null;

    @Autowired
    public void setAppointmentManager(@Qualifier("appointmentManager") GenericManager<Appointment, Long> appointmentManager) {
        this.appointmentManager = appointmentManager;
    }

    public AppointmentFormController() {
        setCancelView("redirect:appointments");
        setSuccessView("redirect:appointments");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Appointment showForm(HttpServletRequest request)
            throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return appointmentManager.get(new Long(id));
        }

        Appointment appointment = new Appointment();
        appointment.setDate(new Date(Calendar.getInstance().getTimeInMillis()));

        return appointment;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Appointment appointment, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
            throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(appointment, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "appointmentform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (appointment.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            appointmentManager.remove(appointment.getId());
            saveMessage(request, getText("appointment.deleted", locale));
        } else {
            appointmentManager.save(appointment);
            String key = (isNew) ? "appointment.added" : "appointment.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:appointmentform?id=" + appointment.getId();
            }
        }

        return success;
    }
}