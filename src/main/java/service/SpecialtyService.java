package service;

import dao.impl.SpecialtyDao;
import model.Specialty;

import java.util.List;

/**
 * Сервис для DAO специальности врача
 */
public class SpecialtyService {

    private static SpecialtyDao specialtyDao;

    public SpecialtyService() {
        specialtyDao = new SpecialtyDao();
    }

    public void persist(Specialty specialty) {
        specialtyDao.openCurrentSessionWithTransaction();
        specialtyDao.persist(specialty);
        specialtyDao.closeCurrentSessionWithTransaction();
    }

    public void update(Specialty specialty) {
        specialtyDao.openCurrentSessionWithTransaction();
        specialtyDao.update(specialty);
        specialtyDao.closeCurrentSessionWithTransaction();
    }

    public Specialty findById(Integer id) {
        specialtyDao.openCurrentSession();
        Specialty specialty = specialtyDao.findById(id);
        specialtyDao.closeCurrentSession();
        return specialty;
    }

    public List<Specialty> findAll() {
        specialtyDao.openCurrentSession();
        List<Specialty> specialties = specialtyDao.findAll();
        specialtyDao.closeCurrentSession();
        return specialties;
    }

    public void deleteAll() {
        specialtyDao.openCurrentSessionWithTransaction();
        specialtyDao.deleteAll();
        specialtyDao.closeCurrentSessionWithTransaction();
    }

    public SpecialtyDao getSpecialtyDao() {
        return specialtyDao;
    }
}
