package com.school.school.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

import java.util.List;

@Table(name = "student_courses")
@Data
@Entity
@ToString
public class StudentCoursesEntitiy {


    @Id
    private Long id;

    @ManyToMany(mappedBy = "studentCoursesEntitiyList")
    @JsonIgnore
    private List<StudentEntity> studentEntity;

    @Column(name = "lessonName")
    private String lessonName;

    @Column(name = "lessonTime")
    private Long lessonTime;


}
