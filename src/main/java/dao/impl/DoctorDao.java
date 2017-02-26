package dao.impl;

import model.Doctor;

import java.util.List;

/**
 * DAO врача
 */
public class DoctorDao extends AbstractDao<Doctor> {

    @Override
    public void persist(Doctor doctor) {
        getCurrentSession().save(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        getCurrentSession().update(doctor);
    }

    @Override
    public Doctor findById(Integer id) {
        return getCurrentSession().get(Doctor.class, id);
    }

    @Override
    public void delete(Doctor doctor) {
        getCurrentSession().delete(doctor);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Doctor> findAll() {
        return (List<Doctor>) getCurrentSession().createQuery("from Doctor").list();
    }

    @Override
    public void deleteAll() {
        List<Doctor> doctors = findAll();
        for (Doctor doctor :
                doctors) {
            delete(doctor);
        }
    }
}
