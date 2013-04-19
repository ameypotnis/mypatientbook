package org.medical.webapp.controller;

import org.apache.commons.lang.StringUtils;
import org.medical.model.mongo.Patient;
import org.medical.service.PatientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/patientform*")
public class PatientFormController extends BaseFormController {
    private PatientManager patientManager = null;

    @Autowired
    public void setPatientManager(@Qualifier("patientManager") PatientManager patientManager) {
        this.patientManager = patientManager;
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Patient showForm(HttpServletRequest request)
            throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return patientManager.find(id);
        }

        return new Patient();
    }

    public PatientFormController() {
        setCancelView("redirect:patients");
        setSuccessView("redirect:patients");
    }
}