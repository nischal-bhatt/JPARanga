package ranga.jpa.project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import ranga.jpa.project.RangaJpaProjectApplication;
import ranga.jpa.project.entity.Course;

@SpringBootTest(classes=RangaJpaProjectApplication.class)
class CourseRepositoryTest {

	@Autowired
	CourseRepository repo;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	public void findById_basic() {
		Course course = repo.findById(10002L);
		logger.info("Testubg us rybbubg");
		assertEquals("bhattura2",course.getName());
	}
	
	@Test
	@Transactional
	@DirtiesContext
	public void deleteById_basic() {
		repo.deleteById(10001L);
		logger.info("Testubg us rybbubg");
		//assertEquals("bhattura2",course.getName());
	      assertNull(repo.findById(10001L));
	}

	@Test
	@Transactional
	@DirtiesContext
	public void save_basic() {
		Course course = repo.findById(10001L);
		assertEquals("ranga karanam",course.getName());
		
		course.setName("changed!");
		repo.save(course);
		Course course1 = repo.findById(10001L);
		
		assertEquals("changed!",course1.getName());
		
	}
}
