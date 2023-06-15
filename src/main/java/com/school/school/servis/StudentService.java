package com.school.school.servis;
import com.school.school.dto.StudentDto;
import com.school.school.entities.StudentCoursesEntitiy;
import com.school.school.entities.StudentEntity;
import com.school.school.repository.StudentCoursesRepository;
import com.school.school.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentCoursesRepository studentCoursesRepository;

    public List<StudentEntity> getAllStudent() {

        return studentRepository.findAll();
    }

    public StudentEntity createStudent(StudentDto studentDto) {
        StudentEntity newStudent = new StudentEntity();
        newStudent.setFirstName(studentDto.getFirstName());
        newStudent.setLastName(studentDto.getLastName());
        newStudent.setMail(studentDto.getMail());
        if (studentDto.getCourses() != null) {

            List<StudentCoursesEntitiy> studentCoursesEntitiyList = studentCoursesRepository.findAllById(studentDto.getCourses());
            newStudent.setStudentCoursesEntitiyList(studentCoursesEntitiyList);

        }
        return studentRepository.save(newStudent);
    }

    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(new StudentEntity());

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

            // List<StudentCoursesEntitiy> studentCoursesEntitiyList = studentCoursesRepository.findAllById(studentEntity.getStudentCoursesEntitiyList();

            return student.get();
        }
        return null;

    }

}



