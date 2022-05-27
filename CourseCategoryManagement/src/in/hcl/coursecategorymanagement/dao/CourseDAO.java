package in.hcl.coursecategorymanagement.dao;

import in.hcl.coursecategorymanagement.exception.CourseNotFoundException;
import in.hcl.coursecategorymanagement.model.Course;

public interface CourseDAO {
	
	int addCourse(Course course);
	int deleteCourse(Long id) throws CourseNotFoundException;
	int updateCourse(Course course);
	void showCourse();
}
