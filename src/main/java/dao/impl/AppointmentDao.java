package dao.impl;

import model.Appointment;

import java.util.List;

/**
 * DAO приёма пациента у врача
 */
public class AppointmentDao extends AbstractDao<Appointment> {

    @Override
    public void persist(Appointment appointment) {
        getCurrentSession().save(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        getCurrentSession().update(appointment);
    }

    @Override
    public Appointment findById(Integer id) {
        return getCurrentSession().get(Appointment.class, id);
    }

    @Override
    public void delete(Appointment appointment) {
        getCurrentSession().delete(appointment);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Appointment> findAll() {
        return (List<Appointment>) getCurrentSession().createQuery("from Appointment").list();
    }

    @Override
    public void deleteAll() {
        List<Appointment> appointments = findAll();
        for (Appointment appointment :
                appointments) {
            delete(appointment);
        }
    }
}
