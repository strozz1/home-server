package com.server.controllers;


import com.server.entitties.CpuRecord;
import com.server.entitties.ServiceRecord;
import com.server.services.CpuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Controller("/")
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    CpuService service;

    @GetMapping
    public String root() {
        return "index";
    }

    @GetMapping("/status")
    public List<CpuRecord> status() {
        List<CpuRecord> cpuRecords = service.listRecord();
        cpuRecords.add(new CpuRecord(1234, LocalDateTime.now(),123.0f));

        return cpuRecords;
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public CpuRecord updateCPU(@RequestBody CpuRecord record) {
        record = service.saveRecord(record);
        return record;
    }

}
