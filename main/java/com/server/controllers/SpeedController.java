package com.server.controllers;


import com.server.entitties.SpeedRecord;
import com.server.services.SpeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("speed")
public class SpeedController {

    @Autowired
    private SpeedService service;
    @GetMapping({"","/"})
    public List<SpeedRecord> root(){
        List<SpeedRecord> speedRecords = service.list();
        return speedRecords;
    }


    @PostMapping( value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity update(@RequestBody SpeedRecord speedRecord){
        SpeedRecord update = service.update(speedRecord);
        System.out.println("SpeedRecord updated. "+update);
        return new ResponseEntity(HttpStatus.OK);
    }
}



