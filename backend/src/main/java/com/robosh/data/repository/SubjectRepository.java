package com.robosh.data.repository;

import com.robosh.data.entity.Subject;
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

    @Query(value =
            "SELECT subject.id, subject.name" +
                    " FROM subject" +
                    " JOIN schedule" +
                    " ON schedule.id_subject = subject.id" +
                    " WHERE schedule.id_teacher = ?1",
            nativeQuery = true)
    List<Subject> findSubjectByTeacherId(Long id);

    @Query(value =
            "SELECT DISTINCT subject.id_subject, subject.name FROM schedule" +
                    " JOIN subject" +
                    " ON schedule.id_subject = subject.id_subject" +
                    " JOIN user" +
                    " ON schedule.id_teacher = user.id_person" +
                    " WHERE schedule.id_teacher = ?1 AND schedule.id_class = ?2",
            nativeQuery = true)
    List<Subject> findSubjectByTeacherIdAndGroupId(Long teacherId, Long groupId);

}
