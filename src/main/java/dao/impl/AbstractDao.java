package dao.impl;

import dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * Общая логика работы с сессией и транзакциями вынесена в абстрактный класс
 */
public abstract class AbstractDao<Entity> implements GenericDao<Entity> {

    private Session currentSession;

    private Transaction currentTransaction;

    public AbstractDao() {
    }

    public Session openCurrentSession() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        currentSession = HibernateUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
}
