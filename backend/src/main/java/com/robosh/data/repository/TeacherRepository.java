package com.robosh.data.repository;

import com.robosh.data.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(value =
            "SELECT DISTINCT * FROM user " +
                    " JOIN schedule" +
                    " ON schedule.id_teacher = user.id_person" +
                    " WHERE schedule.id_class = ?1",
            nativeQuery = true)
    List<Teacher> findTeacherByGroupId(Long id);

    Teacher findTeacherByEmail(String email);
}
