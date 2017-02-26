package dao.impl;

import model.Client;

import java.util.List;

/**
 * DAO пациента
 */
public class ClientDao extends AbstractDao<Client> {

    @Override
    public void persist(Client client) {
        getCurrentSession().save(client);
    }

    @Override
    public void update(Client client) {
        getCurrentSession().update(client);
    }

    @Override
    public Client findById(Integer id) {
        return getCurrentSession().get(Client.class, id);
    }

    @Override
    public void delete(Client client) {
        getCurrentSession().delete(client);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Client> findAll() {
        return (List<Client>) getCurrentSession().createQuery("from Client").list();
    }

    @Override
    public void deleteAll() {
        List<Client> clients = findAll();
        for (Client client :
                clients) {
            delete(client);
        }
    }
}
