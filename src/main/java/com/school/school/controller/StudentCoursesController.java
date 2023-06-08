package com.school.school.controller;
import com.school.school.dto.StudentCourseDto;
import com.school.school.entities.StudentCoursesEntitiy;
import com.school.school.servis.StudentCoursesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/school")
public class StudentCoursesController {


    private  final StudentCoursesService studentCoursesService;


    @GetMapping("/getCourses")
    public List<StudentCoursesEntitiy> getAllStudentCourses() {
        return studentCoursesService.getAllStudent();
    }

    @GetMapping("/getCourses/{stId}")
    public StudentCoursesEntitiy getByIdStudentCourses(@PathVariable Long stId) {
        return studentCoursesService.getByIdStudentCourses(stId);

    }

    @PostMapping("/postCourses")
    public StudentCoursesEntitiy createOneCourse(@RequestBody StudentCourseDto newCourseDto) {
        return studentCoursesService.createOneCourse(newCourseDto);

    }

    @DeleteMapping("deleteCourses/{studentId}")
    public StudentCoursesEntitiy deleteOneCourse(@PathVariable Long studentId) {
        studentCoursesService.deleteOneCourse(studentId);

        return null;
    }


    }
































// @GetMapping("/getCourses/{StudentId}")
// public List<StudentCoursesEntitiy> getAllCourseByStudentId(@PathVariable(name = "StudentId") Long StudentId) {
//     return studentCoursesService.getAllCourseByStudentId(StudentId);