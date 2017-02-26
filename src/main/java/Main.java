import model.Client;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import service.ClientService;

import javax.persistence.metamodel.EntityType;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        Client client1 = new Client("rotkes", "privet", "Кадыров",
                "Амир", "Айратович", "123456789");
        Client client2 = new Client("klevanso", "poka", "Хуснуллин",
                "Марат", "Ильгизович", "987654321");
        System.out.println("*** Persist - start ***");
        clientService.persist(client1);
        clientService.persist(client2);
        List<Client> clients1 = clientService.findAll();
        System.out.println("Clients Persisted are :");
        for (Client client :
                clients1) {
            System.out.println("-" + client.toString());
        }
        Client client3 = clientService.findById(2);
        System.out.println("Find by ID 2: " + client3.toString());
    }
}