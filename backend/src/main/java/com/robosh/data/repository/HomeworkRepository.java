package com.robosh.data.repository;

import com.robosh.data.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {

    List<Homework> findByGroupId(Long id);
    List<Homework> findByTeacherId(Long id);
    List<Homework> findByUserIdAndSubjectId(Long userId, Long subjectId);
}
