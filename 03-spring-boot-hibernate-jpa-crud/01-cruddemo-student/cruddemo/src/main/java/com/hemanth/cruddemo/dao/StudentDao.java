package com.hemanth.cruddemo.dao;

import com.hemanth.cruddemo.entity.Student;

public interface StudentDao {


     void save(Student student);

     Student findById(int id);
}
