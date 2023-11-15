package com.server.controllers;

import com.server.entitties.ServiceRecord;
import com.server.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/services")
public class ServiceController {

    @Autowired
    ServiceService service;

    @GetMapping({"/",""})
    public String root(Model model){
        List<ServiceRecord> list = service.list();
        System.out.println(list);
        model.addAttribute("services",list);

        return "services/services";
    }
}
