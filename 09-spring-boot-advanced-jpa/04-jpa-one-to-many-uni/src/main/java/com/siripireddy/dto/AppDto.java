package com.siripireddy.dto;

import com.siripireddy.entity.Course;
import com.siripireddy.entity.Instructor;
import com.siripireddy.entity.InstructorDetail;

import java.util.List;

public interface AppDto {

   void save(Instructor instructor);

   Instructor readInstructor(int id);

   void deleteInstructor(int id);

   InstructorDetail findInstructorDetailById(int id);

   void deleteInstructorDetailById(int id);

   List<Course> findCoursesByInstructorId(int id);

   Instructor findInstructorByIdJoinFetch(int id);


   void updateInstructor(Instructor instructor);

   Course findCourseById(int id);

   void updateCourse(Course course);

   void saveCourse(Course course);

   Course findCourseAndReviewsByCourseId(int id);

   void deleteCourseById(int id);
}
