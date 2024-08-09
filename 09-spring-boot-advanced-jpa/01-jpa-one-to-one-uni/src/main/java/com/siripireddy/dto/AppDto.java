package com.siripireddy.dto;

import com.siripireddy.entity.Instructor;

public interface AppDto {

   void save(Instructor instructor);

   Instructor readInstructor(int id);

   void deleteInstructor(int id);
}
