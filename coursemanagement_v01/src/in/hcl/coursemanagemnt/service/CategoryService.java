package in.hcl.coursemanagemnt.service;

import in.hcl.coursemanagemnt.exception.CategoryNotFoundException;
import in.hcl.coursemanagemnt.model.Category;

public interface CategoryService {
	
	void createCategory(Category category);
	void updateCategory(Category category);
	void removeCategory(Long id)throws CategoryNotFoundException;
	void showAllCategory();
}
