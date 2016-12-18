package dao.impl.jdbc;

import java.io.Serializable;

/**
 * Интерфейс идентифицируемых объектов.
 */
public interface Identifiable<PK extends Serializable> {

    // Возвращает основной ключ объекта
    PK getPrimaryKey();
}
