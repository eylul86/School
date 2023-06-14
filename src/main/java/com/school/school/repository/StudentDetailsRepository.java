package com.school.school.repository;
import com.school.school.entities.StudentDetailsEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface StudentDetailsRepository extends JpaRepository <StudentDetailsEntitiy, Long> {

    List<StudentDetailsEntitiy> findByStudentEntity_FirstName(String firstName);
    List<StudentDetailsEntitiy> findByStudentEntity_FirstNameAndStudentEntity_LastName(String firstName,String lastName);
    List<StudentDetailsEntitiy> findByStudentEntity_Mail(String mail);
    List<StudentDetailsEntitiy> findByStudentEntity_Id(Long id);

}