package com.siripireddy.dto;

import com.siripireddy.entity.Instructor;
import com.siripireddy.entity.InstructorDetail;

public interface AppDto {

   void save(Instructor instructor);

   Instructor readInstructor(int id);

   void deleteInstructor(int id);

   InstructorDetail findInstructorDetailById(int id);

   void deleteInstructorDetailById(int id);
}
