package in.hcl.coursemanagemnt.dao;

import in.hcl.coursemanagemnt.exception.CategoryNotFoundException;
import in.hcl.coursemanagemnt.model.Category;

public interface CategoryDAO {
	
	int addCategory(Category category);
	int deleteCategory(Long id) throws CategoryNotFoundException;
	int updateCategory(Category category);
	void showCategory();
}
