package com.siripireddy;

import com.siripireddy.dto.AppDto;
import com.siripireddy.entity.Instructor;
import com.siripireddy.entity.InstructorDetail;
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
    public CommandLineRunner commandLineRunner(AppDto appDto) {
        return runner -> {
           //createUser(appDto);
            //readUser(appDto);
            deleteInstrcutor(appDto);
        };
    }

    private void deleteInstrcutor(AppDto appDto) {
        int id=1;
        appDto.deleteInstructor(id);
        System.out.println("done");
    }

    private void readUser(AppDto appDto) {
        int id =1;

        Instructor instructor=appDto.readInstructor(id);
        System.out.println("Instructor: "+ instructor.toString());
        System.out.println("Instructor Detail"+instructor.getInstructorDetail().toString());
    }

    private void createUser(AppDto appDto) {

//        Instructor instructor=new Instructor("hemanth","siripireddy","siripireddy@gmail.com");
//        InstructorDetail instructorDetail=new InstructorDetail("www.hemanth/yoututube","coding");
        Instructor instructor=new Instructor("sai","siripireddy","sai@gmail.com");
        InstructorDetail instructorDetail=new InstructorDetail("www.hemanth/yoututube","circket");
        instructor.setInstructorDetail(instructorDetail);
        appDto.save(instructor);
    }
}
