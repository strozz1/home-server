package com.server.controllers;


import com.server.entitties.SpeedRecord;
import com.server.services.service.ListUtil;
import com.server.services.service.SpeedRecordParser;
import com.server.services.SpeedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/services/speed")

public class SpeedController {
    @Value("${speed.manualscript}")
    private String manualSpeedScript;

    Logger log = LoggerFactory.getLogger(SpeedController.class);
    @Autowired
    private Environment env;
    @Autowired
    private SpeedService service;

    @GetMapping({"", "/"})
    public String root(Model model) {
        SpeedRecord speed = new SpeedRecord(1, LocalDateTime.now(), 124.4f, 23.f, 124.f);
        model.addAttribute("speed", speed);
        return "services/speed/speed";
    }

    @GetMapping("/list")
    public String list(Model model, @RequestParam(required = false, defaultValue = "desc", value = "order-date") String orderDate) {
        ListUtil.Order order = ListUtil.parseOrder(orderDate);

        List<SpeedRecord> speedRecords= service.list();
        speedRecords = ListUtil.order(speedRecords, order);

        model.addAttribute("records", speedRecords);
        model.addAttribute("nextorder", ListUtil.swap(order));
        return "services/speed/list";
    }

    @GetMapping("/test-now")
    public String testNow(Model model) {
        if (!model.containsAttribute("result"))
            model.addAttribute("result", new SpeedRecord(null, null, null, null));
        return "services/speed/test-now";
    }

    @PostMapping("/test-now-send")
    public String testNowSend(Model model, RedirectAttributes redirectAttributes) {

        SpeedRecord record = null;
        try {
            record = SpeedRecordParser.parse(manualSpeedScript);
        } catch (Exception e) {
            System.err.println("Error!!: " + e.getMessage());
            return "redirect:/speed/test-now";
        }
        service.update(record);
        model.addAttribute("result", record);
        redirectAttributes.addFlashAttribute("result", record);
        return "redirect:/services/speed/test-now";
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity update(@RequestBody SpeedRecord speedRecord) {
        SpeedRecord update = service.update(speedRecord);
        log.info("SpeedRecord updated. " + update);
        return new ResponseEntity(HttpStatus.OK);
    }
}



