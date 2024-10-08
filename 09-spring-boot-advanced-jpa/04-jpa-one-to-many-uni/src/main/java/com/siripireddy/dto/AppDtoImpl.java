package com.siripireddy.dto;

import com.siripireddy.entity.Course;
import com.siripireddy.entity.Instructor;
import com.siripireddy.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

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

        List<Course> courses=instructor.getCourses();
        for(Course course:courses){
            course.setInstructor(null);
        }
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

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id=:data",Course.class);
        query.setParameter("data",id);
        List<Course> res=query.getResultList();
        return res;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query=entityManager.createQuery(
                "select i from Instructor i "
                +" join fetch i.courses "
                +" join fetch i.instructorDetail "
                +" where i.id=:data",Instructor.class

        );
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {

        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {

        entityManager.merge(course);

    }

    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course> query=entityManager.createQuery(
                " select c from Course c "
                        +" join fetch c.reviews  where c.id=:data",Course.class
        );
        query.setParameter("d",id);
            return query.getSingleResult();
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course =entityManager.find(Course.class,id);
        entityManager.remove(course);

    }
}
