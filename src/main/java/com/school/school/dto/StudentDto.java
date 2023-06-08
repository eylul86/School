package com.school.school.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.List;


@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private List <Long> courses;
}
