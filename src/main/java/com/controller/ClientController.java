package com.controller;

import com.model.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by erzyasd on 12.11.15.
 */
@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService ClientService){
        this.ClientService = ClientService;
    }

    @ResponseBody
    @RequestMapping(value = "/clients/list",method = RequestMethod.GET)
    public List<Client> getClientList(Model model){
        List<Client> clientList = clientService.getClients();
        return clientList;
    }
    @ResponseBody
    @RequestMapping(value = "/clients/{clientId}",method = RequestMethod.GET)
    public Client getClient(@PathVariable("clientId") Integer clientId){
        Client client = clientService.getClient();
        return client;
    }
    @RequestMapping(value = "/clients/create/{client}",method = RequestMethod.POST)
    public void createClient(@RequestBody Client client){
        clientService.addClient(client);
    }
    @RequestMapping(value = "/clients/update/{client}",method = RequestMethod.POST)
    public void deleteClient(@RequestBody Client client){
        clientService.updateClient(client);
    }
    @RequestMapping(value = "/clients/delete/{client}",method = RequestMethod.POST)
    public void deleteClient(@RequestBody Client client){
        clientService.deleteClient(client);
    }

}
