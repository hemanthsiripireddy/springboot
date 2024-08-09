package com.siripireddy.dto;

import com.siripireddy.entity.Instructor;
import com.siripireddy.entity.InstructorDetail;
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

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }
}
