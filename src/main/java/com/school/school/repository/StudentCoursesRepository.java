package com.school.school.repository;
import com.school.school.entities.StudentCoursesEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public interface StudentCoursesRepository extends JpaRepository <StudentCoursesEntitiy, Long> {
   @Query("SELECT s FROM  StudentCoursesEntitiy s  WHERE s.lessonName = ?1")
  List<StudentCoursesEntitiy> getByIdStudentCourses(Long stId);

}
