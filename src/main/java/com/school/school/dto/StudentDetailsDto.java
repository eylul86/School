package com.school.school.dto;

import com.school.school.entities.StudentEntity;
import lombok.Data;

import javax.persistence.Column;
@Data
public class StudentDetailsDto {


    private Long id;
    private String phoneNumber;
    private String address;
    private String city;
    private String country;
    private Long studentId;
}


