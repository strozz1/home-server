package com.server.repositories;

import com.server.entitties.ServiceRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceRecord,Integer> {
}
