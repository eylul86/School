package com.school.school.controller;


import com.school.school.dto.StudentDto;
import com.school.school.entities.StudentEntity;
import com.school.school.servis.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/school")

public class StudentController {


    private final StudentService studentService;

    @GetMapping("/get-student")
    public List<StudentEntity> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/post-student")
    public StudentEntity createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @GetMapping("get-student/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);

    }

    @DeleteMapping("delete-student/{id}")
    public StudentEntity deleteStudentId(@PathVariable Long id) {
        studentService.deleteStudentId(id);

        return null;
    }
    @PutMapping("put-student/{id}")
    public ResponseEntity<StudentEntity> updateStudentById(@PathVariable(name = "id") Long id, @RequestBody StudentEntity studentEntity) {
        StudentEntity st = studentService.updateStudentById(id, studentEntity);
        return ResponseEntity.ok(st);

    }
}