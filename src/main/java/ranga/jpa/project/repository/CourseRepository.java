package ranga.jpa.project.repository;
import ranga.jpa.project.entity.Course;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
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
	
	public void playWithEntityManager()
	{
		logger.info("play with entity anager start");
	}
}
