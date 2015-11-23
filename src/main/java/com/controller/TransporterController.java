package com.controller;

import com.model.Transporter;
import com.service.TransporterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransporterController {
    private TransporterService transporterService;

    @Autowired
    public TransporterController(TransporterService transporterService){
        this.transporterService = transporterService;
    }

    @ResponseBody
    @RequestMapping(value = "/transporters",method = RequestMethod.GET)
    public List<Transporter> getTransporterList(){
        List<Transporter> transporterList = transporterService.getTransporters();
        return transporterList;
    }

    @ResponseBody
    @RequestMapping(value = "/transporters/{transporterId}",method = RequestMethod.GET)
    public Transporter getTransporter(@PathVariable("transporterId") Integer transporterId){
        Transporter transporter = transporterService.getTransporter(transporterId);
        return transporter;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/transporters/new",method = RequestMethod.POST)
    public void createTransporter(@RequestBody Transporter transporter){
        transporterService.addTransporter(transporter);
    }

    @RequestMapping(value = "/transporters/update/{transporterId}",method = RequestMethod.POST)
    public void deleteTransporter(@RequestBody Transporter transporter){
        transporterService.updateTransporter(transporter);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/transporters/del/{transporterId}",method = RequestMethod.POST)
    public void deleteTransporter(@PathVariable("transporterId") Integer transporterId){
        transporterService.deleteTransporter(transporterId);
    }
}
