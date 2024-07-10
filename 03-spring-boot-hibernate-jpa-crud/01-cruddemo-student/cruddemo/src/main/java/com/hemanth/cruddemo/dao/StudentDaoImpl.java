package com.hemanth.cruddemo.dao;

import com.hemanth.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {


        TypedQuery theQuery =entityManager.createQuery("from Student order by lastName desc",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery typedQuery=entityManager.createQuery("from Student where lastName=:theData ",Student.class);
        typedQuery.setParameter("theData",lastName);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {


        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {

        //retrieve the student
        Student student=entityManager.find(Student.class,id);

        //delete the student
        entityManager.remove(student);


    }

    @Override
    @Transactional
    public int deleteAll() {

        int numberOfRowDeleted=entityManager.createQuery("delete from Student").executeUpdate();
        return numberOfRowDeleted;
    }
}
