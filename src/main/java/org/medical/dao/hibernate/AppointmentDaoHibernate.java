package org.medical.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.medical.dao.AppointmentDao;
import org.medical.model.Appointment;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository("appointmentDao")
public class AppointmentDaoHibernate extends GenericDaoHibernate<Appointment, Long> implements AppointmentDao {

    public AppointmentDaoHibernate() {
        super(Appointment.class);
    }

    @Override
    public List<Appointment> findByDate(Date date) {
        Criteria crit = getSession().createCriteria(Appointment.class);
//        crit.add(Restrictions.eq("date", new Date()));
        return crit.list();
    }
}