package com.server.controllers;


import com.server.CpuRecord;
import com.server.services.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class Controller {
    @Autowired
    CpuService service;

    @GetMapping("/")
    public String root() {
        return "hello";
    }

    @GetMapping("/status")
    public List<CpuRecord> status() {
        List<CpuRecord> cpuRecords = service.listRecord();

        return cpuRecords;
    }

    @PostMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public CpuRecord updateCPU(@RequestBody CpuRecord record) {
        record = service.saveRecord(record);
        return record;
    }

}
