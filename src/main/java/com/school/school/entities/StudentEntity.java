package com.school.school.entities;

import lombok.Data;
import lombok.ToString;


import javax.persistence.*;
import java.util.List;

@Table(name = "student")
@Data
@Entity
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mail")
    private String mail;

    @OneToMany(mappedBy ="studentEntity")
   List<StudentDetailsEntitiy> detailsEntitiyList;

    @ManyToMany
    @JoinTable(name = "student_new_course", joinColumns = @JoinColumn(name="student_entitiy_id"),inverseJoinColumns = @JoinColumn(name="student_courses_entitiy_id"))
    private List<StudentCoursesEntitiy> studentCoursesEntitiyList;
}
