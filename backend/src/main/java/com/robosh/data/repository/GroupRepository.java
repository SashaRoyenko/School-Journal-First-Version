package com.robosh.data.repository;

import com.robosh.data.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByGroupCode(String code);

    @Query(value =
            "SELECT DISTINCT class.id_class, class.class_code FROM schedule" +
                    " JOIN class" +
                    " ON schedule.id_class = class.id_class" +
                    " WHERE schedule.id_teacher = ?1",
            nativeQuery = true)
    List<Group> findGroupByTeacherId(Long id);
}
