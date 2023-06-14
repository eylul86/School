package com.school.school.servis;


import com.school.school.dto.StudentPost;
import com.school.school.entities.StudentDetailsEntitiy;
import com.school.school.entities.StudentEntity;
import com.school.school.repository.StudentDetailsRepository;
import com.school.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StudentDetailsService {


    private final StudentRepository studentRepository;
    private final StudentDetailsRepository studentDetailsRepository;
    private final StudentService studentService;


    public List<StudentDetailsEntitiy> getAllStudent(String studentName, String lastName) {
        return studentDetailsRepository.findByStudentEntity_FirstNameAndStudentEntity_LastName(studentName, lastName);
    }

    public List<StudentDetailsEntitiy> getAllStudent(String studentMail) {
        return studentDetailsRepository.findByStudentEntity_Mail(studentMail);
    }

    public StudentDetailsEntitiy getByIdStudentDetails(Long studentDetailsId) {
        return studentDetailsRepository.findById(studentDetailsId).orElse(null);
    }

    public StudentDetailsEntitiy createOneStudent(StudentPost newStudentPost) {

        // StudentEntity studentt = studentService.getStudentById(newStudentDto.getStudentId()); // boyle bı student var mı
        // if (studentt == null)
        //     return null;
        // StudentDetailsEntitiy toSave = new StudentDetailsEntitiy();
        // toSave.setId(newStudentDto.getStudentId());
        // toSave.setPhoneNumber(newStudentDto.getPhoneNumber());
        // toSave.setCountry(newStudentDto.getCountry());
        // toSave.setCity(newStudentDto.getCity());
        // toSave.setAddress(newStudentDto.getAddress());
        // toSave.setStudentEntity(studentt);
        // return studentDetailsRepository.save(toSave);

        StudentEntity user = studentService.getStudentById(newStudentPost.getStudentDetailsId());  //boyle bı student var mı
        if (user == null)
            return null;
        StudentDetailsEntitiy toSave = new StudentDetailsEntitiy();
        toSave.setId(newStudentPost.getId());
        toSave.setCity(newStudentPost.getCity());
        toSave.setCountry(newStudentPost.getCountry());
        toSave.setPhoneNumber(newStudentPost.getPhoneNumber());
        toSave.setAddress(newStudentPost.getAddress());
        toSave.setStudentEntity(user);
        return studentDetailsRepository.save(toSave);

    }
    public List<StudentDetailsEntitiy> getAllStudent() {
        return studentDetailsRepository.findAll();
    }
    public void deleteOneStudent(Long studentId) {
        studentDetailsRepository.deleteById(studentId);

    }
}








