package in.hcl.coursemanagemnt.dao;

import in.hcl.coursemanagemnt.exception.CourseNotFoundException;
import in.hcl.coursemanagemnt.model.Course;

public interface CourseDAO {
	
	int addCourse(Course course);
	int deleteCourse(Long id) throws CourseNotFoundException;
	int updateCourse(Course course);
	void showCourse();
}
