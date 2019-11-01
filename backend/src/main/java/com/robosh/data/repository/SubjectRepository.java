package com.robosh.data.repository;

import com.robosh.data.entity.Subject;
import com.robosh.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query(value =
            "SELECT DISTINCT subject.id_subject, subject.name FROM subject" +
                    " JOIN schedule" +
                    " ON schedule.id_subject = subject.id_subject" +
                    " WHERE schedule.id_group = ?1",
            nativeQuery = true)
    List<Subject> findSubjectsByGroupId(Long id);
}
