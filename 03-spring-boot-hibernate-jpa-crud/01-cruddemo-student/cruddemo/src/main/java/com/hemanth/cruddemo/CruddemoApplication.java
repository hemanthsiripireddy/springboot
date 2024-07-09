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
          // createStudent(studentDao);
            //createMultipleStudents(studentDao);
           // readStudent(studentDao);
        };
    }

    private void readStudent(StudentDao studentDao) {

        //creating a student object
        System.out.println("Creating a Student Object");
        Student student=new Student("paul","doa","paul@gmail.com");
        //saving the student object
        System.out.println("Saving the Student Object");
        studentDao.save(student);
        //display saved student id: generated id
        int theId=student.getId();
        System.out.println("Generated ID: "+ theId);
        //retrieve the object based on the id
        Student myStudent=studentDao.findById(theId);
        //display the found object
        System.out.println("Found object: "+ myStudent);
    }

    private void createMultipleStudents(StudentDao studentDao) {

        //create the student
        System.out.println("Creating a student object");

        Student student1=new Student("sai","Siripireddy","sai@gmail.com");
        Student student2=new Student("venky","mama","venky@gmail.com");
        Student student3=new Student("kiran","Siripireddy","kiran@gmail.com");
        //save the student
        System.out.println("Saving the student object");
        studentDao.save(student1);
        studentDao.save(student2);
        studentDao.save(student3);
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
