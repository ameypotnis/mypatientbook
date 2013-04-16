package org.medical.dao;

import org.junit.Test;
import org.medical.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class AppointmentDaoTest extends BaseDaoTestCase {
    @Autowired private AppointmentDao appointmentDao;

    @Test
    public void testFindAppointmentByDate() throws Exception {
        List<Appointment> appointments = appointmentDao.findByDate(new Date());
        assertTrue(appointments.size() > 0);
    }
}