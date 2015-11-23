package com.controller;

import com.model.Client;
import com.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @ResponseBody
    @RequestMapping(value = "/clients",method = RequestMethod.GET)
    public List<Client> getClientList(){
        List<Client> clientList = clientService.getClients();
        return clientList;
    }

    @ResponseBody
    @RequestMapping(value = "/clients/{clientId}",method = RequestMethod.GET)
    public Client getClient(@PathVariable("clientId") Integer clientId){
        Client client = clientService.getClient(clientId);
        return client;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/clients/new",method = RequestMethod.POST)
    public void createClient(@RequestBody Client client){
        clientService.addClient(client);
    }

    @RequestMapping(value = "/clients/update/{clientId}",method = RequestMethod.POST)
    public void deleteClient(@RequestBody Client client){
        clientService.updateClient(client);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/clients/del/{clientId}",method = RequestMethod.POST)
    public void deleteClient(@PathVariable("clientId") Integer clientId){
        System.out.println(clientId);
        clientService.deleteClient(clientId);
    }
}