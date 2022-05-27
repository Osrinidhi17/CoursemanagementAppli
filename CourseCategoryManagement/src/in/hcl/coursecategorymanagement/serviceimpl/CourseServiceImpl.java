package in.hcl.coursecategorymanagement.serviceimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.hcl.coursecategorymanagement.daoimpl.CategoryDAOImpl;
import in.hcl.coursecategorymanagement.daoimpl.CourseDAOImpl;
import in.hcl.coursecategorymanagement.exception.CourseNotFoundException;
import in.hcl.coursecategorymanagement.model.Course;
import in.hcl.coursecategorymanagement.service.CourseService;

public class CourseServiceImpl implements CourseService {

	ApplicationContext ctx2 = new ClassPathXmlApplicationContext("beans.xml");
	CourseDAOImpl courseDAOImpl = ctx2.getBean("courseDAOImpl",CourseDAOImpl.class);
	
	@Override
	public void createCourse(Course course) {
		courseDAOImpl.addCourse(course);
	}

	@Override
	public void updateCourse(Course course) {
		courseDAOImpl.updateCourse(course);
	}

	@Override
	public void removeCourse(Long id) throws CourseNotFoundException {
		try {
			courseDAOImpl.deleteCourse(id);
		} catch (Exception e) {
			throw new CourseNotFoundException(e.getMessage());
		}
	}

	@Override
	public void showAllCourse() {
		courseDAOImpl.showCourse();
	}

}
