package com.school.school.repository;

import com.school.school.entities.StudentCoursesEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentCoursesRepository extends JpaRepository<StudentCoursesEntitiy, Long> {
    @Query("SELECT s FROM  StudentCoursesEntitiy s  WHERE s.lessonName = ?1")
    List<StudentCoursesEntitiy> getByIdStudentCourses(Long studentId);

    @Query(value = "SELECT * FROM  student_courses s  WHERE s.lesson_name = :lessonName", nativeQuery = true)
    List<StudentCoursesEntitiy> getStudentCoursesByLessonName(@Param("lessonName") String lessonName);

    // List<StudentCoursesEntitiy> findByLessonName(String lessonName);
    @Query("SELECT s FROM  StudentCoursesEntitiy s  WHERE s.lessonTime = ?1")
    List<StudentCoursesEntitiy> getByIdStudentCoursesByLessonTime(Long studentId);

    @Query("SELECT s FROM  StudentCoursesEntitiy s  WHERE s.lessonName = 'Fizik'")
    List<StudentCoursesEntitiy> getByIdStudentCoursesLessonName(String lessonName);

    @Query("SELECT s FROM  StudentCoursesEntitiy s  WHERE s.lessonTime = ?1 and s.lessonName = ?2")
    List<StudentCoursesEntitiy> getByIdStudentCoursesLessonNameLessonTime(Long lessonTime, String lessonName);

    @Query(value = "SELECT * FROM  student_courses s  WHERE s.lesson_time = :lessonTime", nativeQuery = true)
    List<StudentCoursesEntitiy> getStudentCoursesByLessonTİME(@Param("lessonTime") Long lessonTime);

}


