package dao.impl;

import dao.GenericDao;
import model.Specialty;

import java.util.List;

/**
 * DAO специальности врача
 */
public class SpecialtyDao extends AbstractDao<Specialty> {

    @Override
    public void persist(Specialty specialty) {
        getCurrentSession().save(specialty);
    }

    @Override
    public void update(Specialty specialty) {
        getCurrentSession().update(specialty);
    }

    @Override
    public Specialty findById(Integer id) {
        return getCurrentSession().get(Specialty.class, id);
    }

    @Override
    public void delete(Specialty specialty) {
        getCurrentSession().delete(specialty);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Specialty> findAll() {
        return (List<Specialty>) getCurrentSession().createQuery("from Specialty").list();
    }

    @Override
    public void deleteAll() {
        List<Specialty> specialties = findAll();
        for (Specialty specialty :
                specialties) {
            delete(specialty);
        }
    }
}
