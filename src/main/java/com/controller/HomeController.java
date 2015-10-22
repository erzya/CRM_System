package com.controller;



import com.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by erzyasd on 22.10.15.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String listAll(Model model){
        Item item = new Item();
        item.setName("BRRRRRRRRRRR");

        model.addAttribute("itemn", item);
        return "index";
    }

}
