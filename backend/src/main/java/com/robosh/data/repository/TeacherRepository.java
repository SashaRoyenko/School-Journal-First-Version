package com.robosh.data.repository;

import com.robosh.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value =
            "SELECT DISTINCT * FROM user " +
                    " JOIN schedule" +
                    " ON schedule.id_teacher = user.id_person" +
                    " WHERE schedule.id_group = ?1",
            nativeQuery = true)
    List<Teacher> findTeachersByGroupId(Long id);
}
