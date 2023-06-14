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


    private final StudentCoursesService studentCoursesService;

    @GetMapping("/getCourses")
    public List<StudentCoursesEntitiy> getAllStudentCourses() {
        return studentCoursesService.getAllStudent();
    }

    @GetMapping("/getCourses/lesson-id/{stId}")
    public List<StudentCoursesEntitiy> getByIdStudentCourses(@PathVariable Long stId) {
        return studentCoursesService.getByIdStudentCourses(stId);
    }

    @GetMapping("/getCourses/lesson-name/{lessonName}")
    public List<StudentCoursesEntitiy> getStudentCoursesByLessonName(@PathVariable String lessonName) {
        return studentCoursesService.getStudentCoursesByLessonName(lessonName);
    }
    @GetMapping("/getCourses/lesson-time/{lessonTime}")
    public List<StudentCoursesEntitiy> getByIdStudentCoursesByLessonTime(@PathVariable Long lessonTime) {
        return studentCoursesService.getByIdStudentCoursesByLessonTime(lessonTime);
    }

    @GetMapping("/getCourses/lesson-Name/{lessonName}")
    public List<StudentCoursesEntitiy> getByIdStudentCoursesLessonName(@PathVariable String lessonName) {
        return studentCoursesService.getStudentCoursesByLessonName(lessonName);
    }

    @GetMapping("/getCourses/lessonName-Time/{lessonTime}/{lessonName}")
    public List<StudentCoursesEntitiy> getByIdStudentCoursesLessonNameLessonTime(@PathVariable Long lessonTime,@PathVariable String lessonName) {
        return studentCoursesService.getByIdStudentCoursesLessonNameLessonTime(lessonTime,lessonName);
    }

    @GetMapping("/getCourses/lessonTime/{lessonTime}")
    public List<StudentCoursesEntitiy> getStudentCoursesByLessonTİME(@PathVariable Long lessonTime) {
        return studentCoursesService.getStudentCoursesByLessonTİME(lessonTime);
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