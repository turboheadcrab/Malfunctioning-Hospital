package service;

import dao.impl.ClientDao;
import model.Client;

import java.util.List;

/**
 * Сервис для DAO пациента
 */
public class ClientService {

    private static ClientDao clientDao;

    public ClientService() {
        clientDao = new ClientDao();
    }

    public void persist(Client client) {
        clientDao.openCurrentSessionWithTransaction();
        clientDao.persist(client);
        clientDao.closeCurrentSessionWithTransaction();
    }

    public void update(Client client) {
        clientDao.openCurrentSessionWithTransaction();
        clientDao.update(client);
        clientDao.closeCurrentSessionWithTransaction();
    }

    public Client findById(Integer id) {
        clientDao.openCurrentSession();
        Client client = clientDao.findById(id);
        clientDao.closeCurrentSession();
        return client;
    }

    public List<Client> findAll() {
        clientDao.openCurrentSession();
        List<Client> clients = clientDao.findAll();
        clientDao.closeCurrentSession();
        return clients;
    }

    public void deleteAll() {
        clientDao.openCurrentSessionWithTransaction();
        clientDao.deleteAll();
        clientDao.closeCurrentSessionWithTransaction();
    }

    public static ClientDao getClientDao() {
        return clientDao;
    }
}
