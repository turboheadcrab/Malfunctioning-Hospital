package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Работа с SessionFactory вынесена в отдельный класс
 */
public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Создаём SessionFactory из hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Записываем ошибку, потому что она может быть проглочена
            System.err.println("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        // Закрываем кэши и пулы соединения
        getSessionFactory().close();
    }
}
