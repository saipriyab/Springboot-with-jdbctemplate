package com.example.jdbctemplate;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jdbctemplate.dao.PersonJdbcDao;
import com.example.jdbctemplate.entity.Person;

@SpringBootApplication
public class SpringbootWithJdbctemplateApplication implements CommandLineRunner {

	@Autowired
	private PersonJdbcDao personJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithJdbctemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(personJdbcDao.findAll());
		System.out.println("id " + personJdbcDao.findById(10001));
		System.out.println("deleting 10002" + personJdbcDao.deleteById(10002));
		System.out.println("inserting 10004" + personJdbcDao.insert(new Person(10004, "mno", "abc", new Date())));
		System.out.println("updating 10004" + personJdbcDao.update(new Person(10004, "mnop", "abc", new Date())));
		System.out.println("custom row mapper"+personJdbcDao.findAllByCustomRowMapper());
	}

}
