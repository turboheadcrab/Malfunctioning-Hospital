package service;

import dao.impl.DoctorDao;
import model.Doctor;

import java.util.List;

/**
 * Сервис для DAO врача
 */
public class DoctorService {

    private static DoctorDao doctorDao;

    public DoctorService() {
        doctorDao = new DoctorDao();
    }

    public void persist(Doctor doctor) {
        doctorDao.openCurrentSessionWithTransaction();
        doctorDao.persist(doctor);
        doctorDao.closeCurrentSessionWithTransaction();
    }

    public void update(Doctor doctor) {
        doctorDao.openCurrentSessionWithTransaction();
        doctorDao.update(doctor);
        doctorDao.closeCurrentSessionWithTransaction();
    }

    public Doctor findById(Integer id) {
        doctorDao.openCurrentSession();
        Doctor doctor = doctorDao.findById(id);
        doctorDao.closeCurrentSession();
        return doctor;
    }

    public List<Doctor> findAll() {
        doctorDao.openCurrentSession();
        List<Doctor> doctors = doctorDao.findAll();
        doctorDao.closeCurrentSession();
        return doctors;
    }

    public void deleteAll() {
        doctorDao.openCurrentSessionWithTransaction();
        doctorDao.deleteAll();
        doctorDao.closeCurrentSessionWithTransaction();
    }

    public static DoctorDao getDoctorDao() {
        return doctorDao;
    }
}
