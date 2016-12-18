package dao.impl.jdbc;

import dao.DaoFactory;
import dao.GenericDao;
import dao.Identifiable;
import dao.PersistException;

import java.io.Serializable;
import java.sql.*;
import java.util.List;

/**
 * Created by Apraxin Vladimir on 18.12.16.
 * Абстрактный класс предоставляющий базовую реализацию CRUD операций с использованием JDBC.
 * <br>
 *
 * @param <T>  тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public abstract class AbstractJDBCDao<T extends Identifiable<PK>, PK extends Serializable> implements GenericDao<T, PK> {

    private Connection connection;
    private DaoFactory<Connection> parentFactory;

    /**
     * Возвращает sql запрос для получения всех записей.
     * <p/>
     * SELECT * FROM [Table]
     */
    public abstract String getSelectQuery();

    /**
     * Возвращает sql запрос для вставки новой записи в базу данных.
     * <p/>
     * INSERT INTO [Table] ([column, column, ...]) VALUES (?, ?, ...);
     */
    public abstract String getCreateQuery();

    /**
     * Возвращает sql запрос для обновления записи.
     * <p/>
     * UPDATE [Table] SET [column = ?, column = ?, ...] WHERE id = ?;
     */
    public abstract String getUpdateQuery();

    /**
     * Возвращает sql запрос для удаления записи из базы данных.
     * <p/>
     * DELETE FROM [Table] WHERE id= ?;
     */
    public abstract String getDeleteQuery();

    /**
     * Разбирает ResultSet и возвращает список объектов соответствующих содержимому ResultSet.
     */
    protected abstract List<T> parseResultSet(ResultSet resultSet) throws PersistException;

    /**
     * Устанавливает аргументы insert запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForInsert(PreparedStatement preparedStatement, T object)
        throws PersistException;

    /**
     * Устанавливает аргументы update запроса в соответствии со значением полей объекта object.
     */
    protected abstract void prepareStatementForUpdate(PreparedStatement preparedStatement, T object)
        throws PersistException;

    @Override
    public T add(PK primaryKey) throws PersistException {
        return null;
    }

    @Override
    public T persist(T object) throws PersistException {
        return null;
    }

    @Override
    public T getByPk(PK primaryKey) throws PersistException {
        return null;
    }

    @Override
    public void update(T object) throws PersistException {

    }

    @Override
    public void delete(T object) throws PersistException {

    }

    @Override
    public List<T> getAll() throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            list = parseResultSet(resultSet);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }
}
