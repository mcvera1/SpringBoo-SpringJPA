package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses") //listar
	public List<Course> getAllCourses(@PathVariable("id")String id){
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{TopicId}/courses/{id}") //buscar
	public Course getCourse(@PathVariable("id") String id){ //si el parametro en el request param es diferente se pone entre parentesis despues del pathvariable
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses") //insertar
	public void addCourse(@RequestBody Course course, @PathVariable String topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}") //actualizar
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable("id") String id){
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}") //eliminar
	public void deleteTopic(@PathVariable("id") String id){
		courseService.deleteCourse(id);
	}
	
}
