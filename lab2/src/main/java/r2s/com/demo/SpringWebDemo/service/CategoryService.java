package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.CreateCategoryRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.CategoryResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public List<CategoryResponseDTO> getListCategory(){
        List<CategoryResponseDTO> categoryList= new ArrayList<>();
        CategoryResponseDTO cate1= new CategoryResponseDTO(1,"Thoi trang nam");
        CategoryResponseDTO cate2= new CategoryResponseDTO(2,"Thoi rang nu");
        categoryList.add(cate1);
        categoryList.add(cate2);
        return categoryList;
    }
}
