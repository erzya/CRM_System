package com.dao.impl;

import com.dao.ClientDao;
import com.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void addClient(Client client) {
        getCurrentSession().save(client);
    }

    public void deleteClient(int id_cl) {
        Client client = getClient(id_cl);
        if (client != null)
            getCurrentSession().delete(client);

    }

    public void updateClient(Client client) {
        Client clientToUpdate = getClient(client.getId_cl());
        clientToUpdate.setName(client.getName());
        clientToUpdate.setDetails(client.getDetails());
        clientToUpdate.setTelephone(client.getTelephone());
        clientToUpdate.setOrders(client.getOrders());
        getCurrentSession().update(clientToUpdate);

    }

    public Client getClient(int id_cl) {
        Client client = (Client) getCurrentSession().get(Client.class, id_cl);
        return client;
    }

    @SuppressWarnings("unchecked")
    public List<Client> getClients() {
        return getCurrentSession().createQuery("from Client").list();
    }
}
