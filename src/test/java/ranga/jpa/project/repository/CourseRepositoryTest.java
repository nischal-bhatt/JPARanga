package ranga.jpa.project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
