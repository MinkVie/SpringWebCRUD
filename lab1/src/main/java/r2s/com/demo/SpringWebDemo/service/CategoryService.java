package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.CreateCategoryRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public List<CreateCategoryRequestDTO> getListCategory(){
        List<CreateCategoryRequestDTO> categoryList= new ArrayList<>();
        CreateCategoryRequestDTO cate1= new CreateCategoryRequestDTO(1,"Thoi trang nam");
        CreateCategoryRequestDTO cate2= new CreateCategoryRequestDTO(2,"Thoi rang nu");
        categoryList.add(cate1);
        categoryList.add(cate2);
        return categoryList;
    }
}
