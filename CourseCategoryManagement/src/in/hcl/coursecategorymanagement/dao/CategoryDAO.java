package in.hcl.coursecategorymanagement.dao;

import in.hcl.coursecategorymanagement.exception.CategoryNotFoundException;
import in.hcl.coursecategorymanagement.model.Category;

public interface CategoryDAO {
	
	int addCategory(Category category);
	int deleteCategory(Long id) throws CategoryNotFoundException;
	int updateCategory(Category category);
	void showCategory();
}
