package service;

import dao.impl.AppointmentDao;
import model.Appointment;

import java.util.List;

/**
 * Сервис для DAO приёма
 */
public class AppointmentService {

    private static AppointmentDao appointmentDao;

    public AppointmentService() {
        appointmentDao = new AppointmentDao();
    }

    public void persist(Appointment appointment) {
        appointmentDao.openCurrentSessionWithTransaction();
        appointmentDao.persist(appointment);
        appointmentDao.closeCurrentSessionWithTransaction();
    }

    public void update(Appointment appointment) {
        appointmentDao.openCurrentSessionWithTransaction();
        appointmentDao.update(appointment);
        appointmentDao.closeCurrentSessionWithTransaction();
    }

    public Appointment findById(Integer id) {
        appointmentDao.openCurrentSession();
        Appointment appointment = appointmentDao.findById(id);
        appointmentDao.closeCurrentSession();
        return appointment;
    }

    public List<Appointment> findAll() {
        appointmentDao.openCurrentSession();
        List<Appointment> appointments = appointmentDao.findAll();
        appointmentDao.closeCurrentSession();
        return appointments;
    }

    public void deleteAll() {
        appointmentDao.openCurrentSessionWithTransaction();
        appointmentDao.deleteAll();
        appointmentDao.closeCurrentSessionWithTransaction();
    }

    public static AppointmentDao getAppointmentDao() {
        return appointmentDao;
    }
}
