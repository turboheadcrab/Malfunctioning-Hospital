package dao;

import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * Отвечает за реализацию связи многие-к-одному.
 *
 * @param <Owner>      класс объекта, чье поле ссылается на зависимый объект.
 * @param <Dependency> класс зависимого объекта.
 */
public class ManyToOne<Owner extends Identifiable, Dependency extends Identifiable> {

    private DaoFactory<Connection> daoFactory;
    private Field field;
    private String name;
    private int hash;

    Dependency getDependency(Owner owner) throws IllegalAccessException {
        return (Dependency) field.get(owner);
    }

    void setDependency(Owner owner, Dependency dependency) throws IllegalAccessException {
        field.set(owner, dependency);
    }

    Identifiable persistDependency(Owner owner, Connection connection) throws IllegalAccessException, PersistException {
        return daoFactory.getDao(connection, field.getType()).persist(getDependency(owner));
    }


}
