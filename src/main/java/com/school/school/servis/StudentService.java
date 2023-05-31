package com.school.school.servis;

import com.school.school.dto.StudentDto;
import com.school.school.entities.StudentEntity;
import com.school.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<StudentEntity> getAllStudent() {

        return studentRepository.findAll();

    }

    public StudentEntity createStudent(StudentDto studentDto) {
        StudentEntity newStudent = new StudentEntity();
        newStudent.setFirstName(studentDto.getFirstName());
        newStudent.setLastName(studentDto.getLastName());
        newStudent.setMail(studentDto.getMail());
        return studentRepository.save(newStudent);


    }

    public StudentEntity getStudentById(Long id) {

        return studentRepository.findById(id).orElse(null);

    }

    public void deleteStudentId(Long id) {

        studentRepository.deleteById(id);

    }

    public StudentEntity updateStudentById(Long id, StudentEntity studentEntity) {


        Optional<StudentEntity> student = studentRepository.findById(id);
        if (student.isPresent()) {
            student.get().setFirstName(studentEntity.getFirstName());
            student.get().setLastName(studentEntity.getLastName());
            student.get().setMail(studentEntity.getMail());
            studentRepository.save(studentEntity);

            return student.get();
        }

        return null;

    }


}


