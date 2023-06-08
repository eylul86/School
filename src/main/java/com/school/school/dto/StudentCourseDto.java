package com.school.school.dto;


import lombok.Data;



@Data
public class StudentCourseDto {


    private Long id;
    private String lessonName;
    private Long lessonTime;
    private Long studentId;

  //  List<StudentEntity> studentEntityList;
}
