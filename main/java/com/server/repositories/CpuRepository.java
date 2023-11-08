package com.server.repositories;
import com.server.CpuRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CpuRepository extends CrudRepository<CpuRecord,Integer> {
}
