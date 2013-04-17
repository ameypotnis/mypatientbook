package org.medical.service.impl;

import org.medical.dao.AppointmentDao;
import org.medical.model.Appointment;
import org.medical.service.AppointmentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("appointmentManager")
public class AppointmentManagerImpl extends GenericManagerImpl<Appointment, Long> implements AppointmentManager {
    AppointmentDao appointmentDao;

    @Autowired
    public AppointmentManagerImpl(AppointmentDao appointmentDao) {
        super(appointmentDao);
        this.appointmentDao = appointmentDao;
    }

    public List<Appointment> findByDate(Date date) {
        return appointmentDao.findByDate(date);
    }
}