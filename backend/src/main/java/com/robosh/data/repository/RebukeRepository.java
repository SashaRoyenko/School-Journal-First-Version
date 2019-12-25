package com.robosh.data.repository;

import com.robosh.data.entity.Rebuke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RebukeRepository extends JpaRepository<Rebuke, Long> {
    List<Rebuke> findByStudentId(Long id);
}
