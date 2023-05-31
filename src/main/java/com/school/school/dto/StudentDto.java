package com.school.school.dto;

import lombok.Data;

import javax.persistence.Column;



@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String mail;

}
