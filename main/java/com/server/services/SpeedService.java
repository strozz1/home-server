package com.server.services;

import com.server.entitties.SpeedRecord;
import com.server.repositories.SpeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpeedService {

    @Autowired
    private SpeedRepository repository;


    public SpeedRecord update(SpeedRecord speedRecord){

        SpeedRecord save = repository.save(speedRecord);
        return save;
    }

    public List<SpeedRecord> list(){
        List<SpeedRecord> records =new ArrayList<>();
        Iterable<SpeedRecord> all = repository.findAll();
        all.forEach(records::add);
        return records;
    }
}
