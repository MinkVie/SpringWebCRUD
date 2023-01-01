package r2s.com.demo.SpringWebDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import r2s.com.demo.SpringWebDemo.dto.request.InsertCategoryRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Category;
import r2s.com.demo.SpringWebDemo.repository.CategoryRepository;

import java.util.List;
@Component
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategoryDatabase() {
        Iterable<Category> categoryIterable = categoryRepository.findAll();
        return (List<Category>) categoryIterable;
    }


    @Override
    public Category insertCategory(InsertCategoryRequestDTO requestDTO) {
        Category category= new Category();
        category.setName(requestDTO.getName());
        categoryRepository.save(category);
        return category;
    }
}
