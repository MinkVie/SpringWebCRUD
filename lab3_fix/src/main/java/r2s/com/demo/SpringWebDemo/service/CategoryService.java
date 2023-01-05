package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.InsertCategoryRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategoryDatabase();

    Category insertCategory(InsertCategoryRequestDTO requestDTO);
}
