package dao.impl.jdbc;

import java.io.Serializable;
import java.util.List;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 *
 * @param <T>  тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public interface GenericDao<T extends Identifiable<PK>, PK extends Serializable> {

    // Создает новую запись и соответствующий ей объект
    T add(PK primaryKey) throws PersistException;

    // Создает новую запись, соответствующую объекту object
    T persist(T object) throws PersistException;

    //Возвращает объект соответствующий записи с первичным ключом
    T getByPk(PK primaryKey) throws PersistException;

    // Сохраняет состояние объекта в базе данных
    void update(T object) throws PersistException;

    // Удаляет запись об объекте из базы данных
    void delete(T object) throws PersistException;

    // Возвращает список объектов соответствующих всем записям в базе данных
    List<T> getAll() throws PersistException;
}
