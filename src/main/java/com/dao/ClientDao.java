package com.dao;

import com.model.Client;

import java.util.List;

public interface ClientDao {

    public void addClient(Client client);

    public void deleteClient(int id_cl);

    public void updateClient(int id_cl);

    public Client getClient(int id_cl);

    public List<Client> getClients();


}
