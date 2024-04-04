package DataAO;
import com.Project.Category;

import java.util.List;


public interface CategoryDAO {
    Category getCategoryById(int categoryId);
    
    List<Category> getAllCategories();
    
    void addCategory(Category category);
    
    void updateCategory(Category category);
    
    void deleteCategory(int categoryId);

	List<Category> getAllCategory();

	boolean delete(int deleteCategoryId);

	void create(Category newCategory);

	void update(Category existingCategory);

	

}
