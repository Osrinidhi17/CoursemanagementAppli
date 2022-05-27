package in.hcl.coursecategorymanagement.util;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.hcl.coursecategorymanagement.exception.CategoryNotFoundException;
import in.hcl.coursecategorymanagement.exception.CourseNotFoundException;
import in.hcl.coursecategorymanagement.model.Category;
import in.hcl.coursecategorymanagement.model.Course;
import in.hcl.coursecategorymanagement.service.CategoryService;
import in.hcl.coursecategorymanagement.service.CourseService;
import in.hcl.coursecategorymanagement.serviceimpl.CategoryServiceImpl;
import in.hcl.coursecategorymanagement.serviceimpl.CourseServiceImpl;

public class MenuUtil {

	private CategoryService categoryService;
	private CourseService courseService;

	public MenuUtil() {
		categoryService = new CategoryServiceImpl();
		courseService = new CourseServiceImpl();
	}

	Scanner sc = new Scanner(System.in);

	public void start() {		
		int menuChoice;
		String continueChoice;
		do {
			showMenu();
			System.out.println("Enter your choice:(1,2,3,4,5,0) : ");
			menuChoice = sc.nextInt();
			sc.nextLine();
			switch (menuChoice) {
			case 1:
				Category category = new Category();
				System.out.println("----------------Category Creation-------------");
				System.out.println("Enter CategoryName");
				category.setCategoryName(sc.nextLine());
				System.out.println("Enter CategoryNumber");
				category.setCategoryNumber(sc.nextLine());
				System.out.println("Enter CategoryType");
				category.setCategoryType(sc.nextLine());
				System.out.println("Enter Description");
				category.setDescription(sc.nextLine());
				sc.nextLine();

				categoryService.createCategory(category);
				break;
			case 2:
				Category category1 = new Category();
				System.out.println("-------------------Category Updation--------------------");
				System.out.println("Enter CategoryID");
				category1.setId(sc.nextLong());
				sc.nextLine();

				System.out.println("Enter CategoryName");
				category1.setCategoryName(sc.nextLine());
				System.out.println("Enter CategoryNumber");
				category1.setCategoryNumber(sc.nextLine());
				System.out.println("Enter CategoryType");
				category1.setCategoryType(sc.nextLine());
				System.out.println("Enter Description");
				category1.setDescription(sc.nextLine());
				sc.nextLine();

				categoryService.updateCategory(category1);
				break;
			case 3:
				System.out.println("----------------------Removing Category---------------------");	
				System.out.println("Enter EmployeeID");
				Long remId = sc.nextLong();	
				try {
					categoryService.removeCategory(remId);
				} catch (CategoryNotFoundException e) {
					System.out.println("Problem : "+e.getMessage());
				}
				break;

			case 4:
				System.out.println("--------------------Displaying Categories---------------------");
				categoryService.showAllCategory();
				break;
			case 5:
				System.out.println("--------------------Course Menu----------------------------");
				course();
				break;
			case 0:
				System.exit(0);
				break;				
			default:
				System.out.println("Wrong choice");
				break;
			}
			System.out.println("Do you want to continue(yes/no)");
			continueChoice = sc.next();
		} while (continueChoice.equals("yes"));
		sc.close();
	}

	public void course() {
		showCourseMenu();
		int menuChoice1;
		System.out.println("Enter your choice:(1,2,3,4,0) : ");
		menuChoice1 = sc.nextInt();
		sc.nextLine();
		switch (menuChoice1) {
		case 1:
			Course course = new Course();
			System.out.println("---------------------Course Creation--------------------------");
			System.out.println("Enter CourseName");
			course.setCourseName(sc.nextLine());
			System.out.println("Enter CourseDescription");
			course.setDescription(sc.nextLine());
			System.out.println("Enter Course Start-date");
			course.setStartDate(sc.nextLine());
			System.out.println("Enter Course End-date");
			course.setEndDate(sc.nextLine());
			sc.nextLine();

			courseService.createCourse(course);
			break;
		case 2:
			Course course1 = new Course();
			System.out.println("----------------Course Updation--------------");
			System.out.println("Enter Course ID");
			course1.setId(sc.nextLong());
			sc.nextLine();

			System.out.println("Enter CourseName");
			course1.setCourseName(sc.nextLine());
			System.out.println("Enter CourseDescription");
			course1.setDescription(sc.nextLine());
			System.out.println("Enter Course Start-date");
			course1.setStartDate(sc.nextLine());
			System.out.println("Enter Course End-date");
			course1.setEndDate(sc.nextLine());
			sc.nextLine();				

			courseService.updateCourse(course1);
			break;
		case 3:
			System.out.println("-----------------------Removing Course--------------------");	
			System.out.println("Enter CourseID");
			Long remId = sc.nextLong();	
			try {
				courseService.removeCourse(remId);
			} catch (CourseNotFoundException e) {
				System.out.println("Problem : "+e.getMessage());
			}
			break;

		case 4:
			System.out.println("-------------------Displaying Courses---------------------");
			courseService.showAllCourse();
			break;

		default:
			System.out.println("Wrong choice");
			break;
		}
	}

	private void showMenu() {
		System.out.println("Course Management System");
		System.out.println("1. Add Category");
		System.out.println("2. Update Category");
		System.out.println("3. Delete Category");
		System.out.println("4. Display Category");
		System.out.println("5. Course Menu");
		System.out.println("0 to exit");
	}

	private void showCourseMenu() {
		System.out.println("1. Add Course");
		System.out.println("2. Update Course");
		System.out.println("3. Delete Course");
		System.out.println("4. Display Course");
		System.out.println("0 to exit");
	}

}
