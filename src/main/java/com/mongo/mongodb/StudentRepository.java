package com.mongo.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface  StudentRepository extends MongoRepository<Student, String> {

    Optional<Student> findStudentByLastName(String lastname);
}
