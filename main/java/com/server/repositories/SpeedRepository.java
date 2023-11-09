package com.server.repositories;

import com.server.entitties.SpeedRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeedRepository extends CrudRepository<SpeedRecord,Integer> {
}
