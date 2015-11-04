package com.controller;



import com.model.Item;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erzyasd on 22.10.15.
 */

@Controller
public class HomeController {
    private Logger logger = Logger.getLogger(HomeController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String begin(Model model){
        return "index";
    }

    @RequestMapping(value = "/item",method = RequestMethod.GET)
    public @ResponseBody
    List<Item> listAll(Model model){
        List<Item> list = new ArrayList<Item>();

        logger.info("This is an info log entry");
        logger.error("This is an error log entry");

        Item item1 = new Item();
        item1.setName("BRRRRRRRRRRR");
        Item item2 = new Item();
        item2.setName("2BRRRR");
        Item item3 = new Item();
        item3.setName("3BR");

        list.add(item1);
        list.add(item2);
        list.add(item3);

        return list;
    }

}
