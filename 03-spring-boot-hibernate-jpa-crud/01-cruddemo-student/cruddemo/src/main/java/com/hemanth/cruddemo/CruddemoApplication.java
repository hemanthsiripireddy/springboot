package com.hemanth.cruddemo;

import com.hemanth.cruddemo.dao.StudentDao;
import com.hemanth.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
           createStudent(studentDao);
        };
    }

    private void createStudent(StudentDao studentDao) {

        //create the student
        System.out.println("Creating a student object");

        Student student=new Student("Hemanth","Siripireddy","hemanth@gmail.com");
        //save the student
        System.out.println("Saving the student object");
        studentDao.save(student);

        System.out.println("Id of saved Student is : "+student.getId());
        // get the id of saved student

        System.out.println();
    }
}
