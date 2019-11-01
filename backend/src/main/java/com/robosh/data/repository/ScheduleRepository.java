package com.robosh.data.repository;

import com.robosh.data.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "SELECT * FROM `e-journal`.schedule WHERE id_group = ?1",
            nativeQuery = true)
    List<Schedule> findByGroupId(Long id);

}
