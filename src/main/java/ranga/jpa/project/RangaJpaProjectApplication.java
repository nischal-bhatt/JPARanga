package ranga.jpa.project;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import ranga.jpa.project.entity.Course;
import ranga.jpa.project.repository.CourseRepository;

@SpringBootApplication
@Transactional
public class RangaJpaProjectApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(RangaJpaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10013L);
		logger.info("course is {}",course);
	    //repository.deleteById(10001L);
		Course course1 = new Course("microservices");
		repository.save(course1);
		course1.setName("changed!--");
		repository.save(course1);
	}

}
