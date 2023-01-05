package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.InsertCategoryRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Category;
import r2s.com.demo.SpringWebDemo.service.CategoryService;

import java.util.List;

@RestController()
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        List<Category> categoryList = categoryService.getAllCategoryDatabase();
        return new ResponseEntity(categoryList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertCategory(@RequestBody InsertCategoryRequestDTO requestDTO) {
        Category category = categoryService.insertCategory(requestDTO);
        return new ResponseEntity(category, HttpStatus.OK);
    }

}
