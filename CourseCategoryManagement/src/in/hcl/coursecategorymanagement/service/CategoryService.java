package in.hcl.coursecategorymanagement.service;

import in.hcl.coursecategorymanagement.exception.CategoryNotFoundException;
import in.hcl.coursecategorymanagement.model.Category;

public interface CategoryService {
	
	void createCategory(Category category);
	void updateCategory(Category category);
	void removeCategory(Long id)throws CategoryNotFoundException;
	void showAllCategory();
}
