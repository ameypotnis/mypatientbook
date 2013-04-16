package org.medical.dao;

import org.medical.model.Appointment;

import java.util.Date;
import java.util.List;

public interface AppointmentDao extends GenericDao<Appointment, Long> {
    public List<Appointment> findByDate(Date date);
}