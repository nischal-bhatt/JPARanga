package ranga.jpa.project.repository;
import ranga.jpa.project.entity.Course;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
    
	@Autowired
	EntityManager em;
	
	public Course findById(Long id)
	{
		return em.find(Course.class, id);
	}
	
	public Course save(Course course)
	{
		if (course.getId()==null)
		{
			em.persist(course);
		}else
		{
			em.merge(course);
		}
		return course;
	}
	
	public void deleteById(Long id)
	{
		Course course = this.findById(id);
		em.remove(course);
	}
}
