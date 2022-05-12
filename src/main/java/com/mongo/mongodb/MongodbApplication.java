package com.mongo.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class MongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository, MongoTemplate template){
		return  args -> {
			Address address = new Address(
					"Kyrgyzstan",
					"Bishkek",
					"312"
			);
			ArrayList <String> list = new ArrayList<>();
			list.add("HELLO");
			list.add("World");
			String lastname = "Zhorobaeva12";
			Student student = new Student(
					"Nuriza",
					lastname,
					Gender.FEMALE,
					address,
					list,
					new BigDecimal(4568),
					new Date()
			);
			Query query = new Query();
			query.addCriteria(Criteria.where("lastname").is(lastname));
			List<Student> students=template.find(query, Student.class);

			if(students.size()>1){
				throw new IllegalStateException("Repeated lines" + lastname );
			}
			if(students.isEmpty())
				repository.insert(student);
			else System.out.println("The Stident exist " + student);
		};
	}
}
