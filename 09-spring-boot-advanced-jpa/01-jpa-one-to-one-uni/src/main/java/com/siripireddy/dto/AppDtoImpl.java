package com.siripireddy.dto;

import com.siripireddy.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AppDtoImpl implements AppDto {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);

    }

    @Override
    public Instructor readInstructor(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructor(int id) {
        Instructor instructor=entityManager.find(Instructor.class,id);
        entityManager.remove(instructor);
    }
}
