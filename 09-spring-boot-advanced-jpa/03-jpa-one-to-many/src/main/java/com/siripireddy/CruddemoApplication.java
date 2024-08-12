package com.siripireddy;

import com.siripireddy.dto.AppDto;
import com.siripireddy.entity.Course;
import com.siripireddy.entity.Instructor;
import com.siripireddy.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
            //deleteInstrcutor(appDto);
           // findInstructorDetail(appDto);
           //deleteInstrcutorDetail(appDto);
           // createInstructorWithCourses(appDto);
            // findInstructorWithCourses(appDto);
           // findCoursesForInstructorId(appDto);
            //findInstructorWithCoursesJoinFetch(appDto);
         // updateInstructor(appDto);
            updateCourse(appDto);


        };
    }

    private void updateCourse(AppDto appDto) {

        int id=10;
        System.out.println("findind course by id");
        Course course= appDto.findCourseById(id);
        System.out.println("Updating course: ");
        course.setTitle("Java Awesome course");
        appDto.updateCourse( course);
        System.out.println("done");
    }

    private void updateInstructor(AppDto appDto) {

        int id=1;
        System.out.println("finding instructor");

        Instructor instructor=appDto.findInstructorByIdJoinFetch(id);

        System.out.println("updating instructor");

        instructor.setLastName("tester");


        System.out.println("saving instructor");
        appDto.updateInstructor(instructor);
        System.out.println("done");


    }

    private void findInstructorWithCoursesJoinFetch(AppDto appDto) {
        int id=1;
        Instructor instructor=appDto.findInstructorByIdJoinFetch(id);
        System.out.println(instructor);
        System.out.println(instructor.getCourses());
    }

    private void findCoursesForInstructorId(AppDto appDto) {
        int id=1;
        System.out.println("Reading instructor");
        Instructor instructor=appDto.readInstructor(id);
        System.out.println(instructor);

        System.out.println("finding  associated courses");
        List<Course> courseList=appDto.findCoursesByInstructorId(id);
        instructor.setCourses(courseList);
       // System.out.println(courseList);
       System.out.println(instructor.getCourses());


    }

    private void findInstructorWithCourses(AppDto appDto) {
        int id=1;
        Instructor instructor=appDto.readInstructor(id);
        System.out.println(instructor);
       System.out.println(instructor.getCourses());
    }

    private void createInstructorWithCourses(AppDto appDto) {
        Instructor instructor=new Instructor("sai","siripireddy","sai@gmail.com");
        InstructorDetail instructorDetail=new InstructorDetail("www.hemanth/yoututube","circket");
        Course course1=new Course("Java");
        Course course2=new Course("Python");
        instructor.addCourse(course1);
        instructor.addCourse(course2);
        instructor.setInstructorDetail(instructorDetail);
        appDto.save(instructor);

    }

    private void deleteInstrcutorDetail(AppDto appDto) {

        int id=3;

        appDto.deleteInstructorDetailById(id);
        System.out.println("Done");
    }

    private void findInstructorDetail(AppDto appDto) {
        int id=3;
        InstructorDetail instructorDetail=appDto.findInstructorDetailById(id);
        System.out.println(instructorDetail.toString());
        System.out.println(instructorDetail.getInstructor().toString());
    }

    private void deleteInstrcutor(AppDto appDto) {
        int id=3;
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
