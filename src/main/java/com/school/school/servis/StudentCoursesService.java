package com.school.school.servis;


import com.school.school.dto.StudentCourseDto;
import com.school.school.entities.StudentCoursesEntitiy;

import com.school.school.entities.StudentDetailsEntitiy;
import com.school.school.entities.StudentEntity;
import com.school.school.repository.StudentCoursesRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentCoursesService {



    private final StudentService studentService;

    private  final StudentCoursesRepository studentCoursesRepository;

    public List<StudentCoursesEntitiy> getAllStudent() {
        return studentCoursesRepository.findAll();
    }

  // public StudentCoursesEntitiy getByIdStudentCourses(Long stId) {
  //     return studentCoursesRepository.findById(stId).orElse(null);
  // }
    public StudentCoursesEntitiy getByIdStudentCourses(Long stId) {
        return (StudentCoursesEntitiy) studentCoursesRepository.getByIdStudentCourses(stId);
    }

    public StudentCoursesEntitiy createOneCourse(StudentCourseDto newCourseDto) {
        StudentEntity users = studentService.getStudentById(newCourseDto.getStudentId());//boyle bı student var mı
        if (users == null)
            return null;
        StudentCoursesEntitiy toSaveCourse = new StudentCoursesEntitiy();
        toSaveCourse.setId(newCourseDto.getId());
        toSaveCourse.setLessonName(newCourseDto.getLessonName());
        toSaveCourse.setLessonTime(newCourseDto.getLessonTime());
        //toSaveCourse.setStudentEntity(List.of(users));
        return studentCoursesRepository.save(toSaveCourse);
    }

    public void deleteOneCourse(Long studentId) {
        studentCoursesRepository.deleteById(studentId);
    }

 //  public StudentCoursesEntitiy getByIdCourses(Long stId) {
 //      return (StudentCoursesEntitiy) studentCoursesRepository.getByIdCourses(stId);
    }



