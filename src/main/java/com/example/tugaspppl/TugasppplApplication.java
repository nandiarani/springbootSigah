package com.example.tugaspppl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@SpringBootApplication
@EnableJpaRepositories("com.example.tugaspppl.dao")
@EntityScan("com.example.tugaspppl.model")
public class TugasppplApplication{

	public static void main(String[] args) {
		SpringApplication.run(TugasppplApplication.class, args);
	}
}
