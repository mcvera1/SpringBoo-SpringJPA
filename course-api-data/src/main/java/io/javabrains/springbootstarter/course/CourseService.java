package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRespository courseRespository;
	

	public List<Course> getAllCourses(String topicId){
		List<Course> courses =  new ArrayList<>();
		courseRespository.findByTopicId(topicId)
			.forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id){
		return courseRespository.findOne(id);
	}

	public void addCourse(Course course) {
		courseRespository.save(course);
		
	}

	public void updateCourse(Course course) {
		courseRespository.save(course);
	}

	public void deleteCourse(String id) {
		courseRespository.delete(id);
	}
}
