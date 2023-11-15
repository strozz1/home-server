package com.server.repositories;

import com.server.entitties.SpeedRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeedRepository extends CrudRepository<SpeedRecord,Integer> {

    @Query(value = "SELECT * FROM speed limit 20",nativeQuery = true)
    Iterable<SpeedRecord> find20();
}
