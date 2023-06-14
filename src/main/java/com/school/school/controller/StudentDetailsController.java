package com.school.school.controller;


import com.school.school.dto.StudentPost;
import com.school.school.entities.StudentDetailsEntitiy;
import com.school.school.entities.StudentEntity;
import com.school.school.servis.StudentDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/school")

public class StudentDetailsController {


    private final StudentDetailsService studentDetailsService;


    //  @GetMapping("/get-student-details/{studentName}")
    //  public List<StudentDetailsEntitiy> getAllStudent(@PathVariable(name="studentName") String studentName) {
    //      return studentDetailsService.getAllStudent(studentName);
    //  }

    @GetMapping("/get-student-details/{firstName}/{lastName}")
    public List<StudentDetailsEntitiy> getAllStudentByFirstNameAndLastName(@PathVariable(name = "firstName") String firstName, @PathVariable(name = "lastName") String lastName) {
        return studentDetailsService.getAllStudent(firstName, lastName);
    }

    @GetMapping("/get-student-details/{mail}")
    public List<StudentDetailsEntitiy> getAllStudentByMail(@PathVariable(name = "mail") String mail) {
        return studentDetailsService.getAllStudent(mail);

    }

    @GetMapping("/getDetails")
    public List<StudentDetailsEntitiy> getAllStudentDetails() {
        return studentDetailsService.getAllStudent();
    }


    @GetMapping("getDetails/{studentDetailsId}")
    public StudentDetailsEntitiy getByIdStudentDetails(@PathVariable Long studentDetailsId) {
        return studentDetailsService.getByIdStudentDetails(studentDetailsId);

    }

    @PostMapping("/postDetails")
    public StudentDetailsEntitiy createOneStudent(@RequestBody StudentPost newStudentpost) {
        return studentDetailsService.createOneStudent(newStudentpost);

    }

    @DeleteMapping("deleteDetails/{studentId}")
    public StudentDetailsEntitiy deleteOneStudent(@PathVariable Long studentId) {
        studentDetailsService.deleteOneStudent(studentId);


        return null;


    }
}


