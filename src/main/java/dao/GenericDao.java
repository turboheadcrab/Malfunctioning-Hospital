package dao;

import java.util.List;

/**
 * Обобщённые методы DAO
 */
public interface GenericDao<Entity> {

    void persist(Entity entity);

    void update(Entity entity);

    Entity findById(Integer id);

    void delete(Entity entity);

    List<Entity> findAll();

    void deleteAll();
}
