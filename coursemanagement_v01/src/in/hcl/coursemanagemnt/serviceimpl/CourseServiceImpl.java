package in.hcl.coursemanagemnt.serviceimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.hcl.coursemanagemnt.daoimpl.CategoryDAOImpl;
import in.hcl.coursemanagemnt.daoimpl.CourseDAOImpl;
import in.hcl.coursemanagemnt.exception.CourseNotFoundException;
import in.hcl.coursemanagemnt.model.Course;
import in.hcl.coursemanagemnt.service.CourseService;

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
