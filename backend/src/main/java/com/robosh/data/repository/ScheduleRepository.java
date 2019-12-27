package com.robosh.data.repository;

import com.robosh.data.entity.Schedule;
import com.robosh.data.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByGroupId(Long id);

    List<Schedule> findScheduleByTeacherId(Long id);
}
