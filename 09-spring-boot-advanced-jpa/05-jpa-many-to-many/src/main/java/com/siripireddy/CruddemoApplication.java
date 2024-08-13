package com.siripireddy;

import com.siripireddy.dto.AppDto;
import com.siripireddy.entity.*;
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
          //  saveCourseAndStudents(appDto);
            //getCourseAndStudents(appDto);
           // getStudentAndCourses(appDto);
           // updateStudentAndCourses(appDto);
           // deleteCourseAndReviews(appDto);
            deleteStudent(appDto);

        };
    }

    private void deleteStudent(AppDto appDto) {
        int id=1;
        appDto.deleteStudentById(id);
        System.out.println("done");
    }

    private void updateStudentAndCourses(AppDto appDto) {

        int id=2;
        Student student=appDto.findStudentAndCoursesByStudentId(id);

        Course course2=new Course("SpringBoot");
        Course course3=new Course("DevOps");
        student.addCourse(course2);
        student.addCourse(course3);
        appDto.updateStudent(student);
        System.out.println("updating student: "+student);
        System.out.println("added courses are"+ student.getCourses());
    }

    private void getStudentAndCourses(AppDto appDto) {

        int id=1;
        Student student=appDto.findStudentAndCoursesByStudentId(id);
        System.out.println("Student: ");
        System.out.println(student);
        System.out.println("Courses: "+student.getCourses() );
    }

    private void getCourseAndStudents(AppDto appDto) {

        int id=10;
        Course course=appDto.findCourseAndStudentsByCourseId(id);
        System.out.println("loaded course: "+course);
        System.out.println("Loaded students "+ course.getStudents());
    }

    private void saveCourseAndStudents(AppDto appDto) {

        Course course=new Course("Pacman-how to gain million points");
        Student student1=new Student("hemanth","siripireddy","hemanth@gmail.com");
        Student student2=new Student("sai","siripireddy","sai@gmail.com");
        course.addStudent(student1);
        course.addStudent(student2);
        System.out.println("Saving course with students");
        appDto.saveCourse(course);
        System.out.println("done");
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
