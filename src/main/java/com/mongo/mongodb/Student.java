package com.mongo.mongodb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;


@Data
@Document
public class Student {
    @Id
    private String id;
    private String firstName;

    @Indexed(unique = true)
    private String lastName;
    private Gender gender;
    private Address address;
    private List<String> favoriteSubjects;
    private BigDecimal totalSpentInBooks;
    private Date created;

    public Student(String firstName, String lastName, Gender gender, Address address, List<String> favoriteSubjects, BigDecimal totalSpentInBooks, Date created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.favoriteSubjects = favoriteSubjects;
        this.totalSpentInBooks = totalSpentInBooks;
        this.created = created;
    }
}
