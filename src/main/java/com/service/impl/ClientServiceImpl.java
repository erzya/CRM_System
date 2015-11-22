package com.service.impl;

import com.dao.ClientDao;
import com.model.Client;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao clientDao;

    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public void deleteClient(int id_cl) {
        clientDao.deleteClient(id_cl);
    }

    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    public Client getClient(int id_cl) {
        return clientDao.getClient(id_cl);
    }

    public List<Client> getClients() {
        return clientDao.getClients();
    }
}
