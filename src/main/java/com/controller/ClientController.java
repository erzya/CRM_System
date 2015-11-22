package com.controller;

import com.model.Client;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseBody
    @RequestMapping(value = "/clients/list", method = RequestMethod.GET)
    public List<Client> getClientList(Model model) {
        List<Client> clientList = clientService.getClients();
        return clientList;
    }

    @ResponseBody
    @RequestMapping(value = "/clients/{clientId}", method = RequestMethod.GET)
    public Client getClient(@PathVariable("clientId") int id_cl) {
        Client client = clientService.getClient(id_cl);
        return client;
    }

    @RequestMapping(value = "/clients/create/{client}", method = RequestMethod.POST)
    public void createClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @RequestMapping(value = "/clients/update/{client}", method = RequestMethod.POST)
    public void updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }

    @RequestMapping(value = "/clients/delete/{client}", method = RequestMethod.POST)
    public void deleteClient(@RequestBody int id_cl) {
        clientService.deleteClient(id_cl);
    }
}