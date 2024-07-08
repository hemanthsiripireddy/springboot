package com.hemanth.cruddemo.dao;

import com.hemanth.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class StudentDaoImpl implements StudentDao{

    // define entity manager class

    private EntityManager entityManager;

    //inject entity manger using constructor injection
    @Autowired
    public StudentDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    //save the student
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);

    }
}
