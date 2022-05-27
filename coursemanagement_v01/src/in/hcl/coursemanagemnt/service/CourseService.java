package in.hcl.coursemanagemnt.service;

import in.hcl.coursemanagemnt.exception.CourseNotFoundException;
import in.hcl.coursemanagemnt.model.Course;

public interface CourseService {

	void createCourse(Course course);
	void updateCourse(Course course);
	void removeCourse(Long id)throws CourseNotFoundException;
	void showAllCourse();
}
