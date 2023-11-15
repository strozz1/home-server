package com.server.services;

import com.server.entitties.CpuRecord;
import com.server.repositories.CpuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CpuService {
    @Autowired
    CpuRepository cpuRepository;

    public CpuRecord saveRecord(CpuRecord record){
        record = cpuRepository.save(record);
        return record;
    }
    public List<CpuRecord> listRecord(){
        List<CpuRecord> records =new ArrayList<>();
        Iterable<CpuRecord> all = cpuRepository.findAll();
        all.forEach(records::add);
        return records;
    }
}
