package com.siripireddy;

import com.siripireddy.dto.AppDto;
import com.siripireddy.entity.Course;
import com.siripireddy.entity.Instructor;
import com.siripireddy.entity.InstructorDetail;
import com.siripireddy.entity.Review;
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
         // saveCourseWithReviews(appDto);
           // getCourseAndReviews(appDto);
            deleteCourseAndReviews(appDto);


        };
    }

    private void deleteCourseAndReviews(AppDto appDto) {
        int id=10;
        appDto.deleteCourseById(id);
        System.out.println("done");
    }

    private void getCourseAndReviews(AppDto appDto) {

        int id=10;
        Course course=appDto.findCourseAndReviewsByCourseId(id);
        System.out.println("Course is ");
        System.out.println(course);
        System.out.println("Reviews are ");
        System.out.println(course.getReviews());


    }

    private void saveCourseWithReviews(AppDto appDto) {

        Course course=new Course("DSA Course");
        course.addReview(new Review("this is awesome course"));
        course.addReview(new Review("this is super course"));
        course.addReview(new Review("this is dump course, you are an idiot"));
        System.out.println("Saving Course with Reviews");
        appDto.saveCourse(course);
        System.out.println(course);
        System.out.println(course.getReviews());
        System.out.println("done");

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
        Instructor instructor=new Instructor("sai11","siripireddy11","sai@gmail.com");
        InstructorDetail instructorDetail=new InstructorDetail("www.hemanth/yoututube","circket11");
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

    private void deleteInstructor(AppDto appDto) {
        int id=3;
        System.out.println("Deleting Instructor");
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
