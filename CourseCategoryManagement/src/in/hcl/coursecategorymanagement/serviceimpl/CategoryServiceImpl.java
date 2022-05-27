package in.hcl.coursecategorymanagement.serviceimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.hcl.coursecategorymanagement.daoimpl.CategoryDAOImpl;
import in.hcl.coursecategorymanagement.exception.CategoryNotFoundException;
import in.hcl.coursecategorymanagement.model.Category;
import in.hcl.coursecategorymanagement.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	ApplicationContext ctx1 = new ClassPathXmlApplicationContext("beans.xml");
	CategoryDAOImpl categoryDAOImpl = ctx1.getBean("categoryDAOImpl",CategoryDAOImpl.class);

	@Override
	public void createCategory(Category category) {
		categoryDAOImpl.addCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDAOImpl.updateCategory(category);
	}

	@Override
	public void removeCategory(Long id) throws CategoryNotFoundException {
		try {
			categoryDAOImpl.deleteCategory(id);
		}
		catch(Exception ex) {
			throw new CategoryNotFoundException(ex.getMessage());
		}
		
	}

	@Override
	public void showAllCategory() {
		categoryDAOImpl.showCategory();
	}

}
