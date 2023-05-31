package com.school.school.repository;

import com.school.school.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface StudentRepository extends JpaRepository <StudentEntity, Long> {

}
