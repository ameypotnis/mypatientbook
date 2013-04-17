package org.medical.service;

import org.medical.model.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentManager extends GenericManager<Appointment, Long> {
    public List<Appointment> findByDate(Date date);
}
