package in.hcl.coursecategorymanagement.service;

import in.hcl.coursecategorymanagement.exception.CourseNotFoundException;
import in.hcl.coursecategorymanagement.model.Course;

public interface CourseService {

	void createCourse(Course course);
	void updateCourse(Course course);
	void removeCourse(Long id)throws CourseNotFoundException;
	void showAllCourse();
}
