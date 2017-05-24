package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRespository extends CrudRepository<Course, String>{
	
	public List<Course> findByTopicId(String topicId);
	
}
