package com.service;

import com.model.Client;

import java.util.List;

public interface ClientService {

    public void addClient(Client client);

    public void deleteClient(int id_cl);

    public void updateClient(Client client);

    public Client getClient(int id_cl);

    public List<Client> getClients();
}
