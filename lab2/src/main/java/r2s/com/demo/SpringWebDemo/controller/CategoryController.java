package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.CreateCategoryRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdatCategoryRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.CategoryResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.PagingCategoryListResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.UserResponseDTO;
import r2s.com.demo.SpringWebDemo.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value = "/category")
public class CategoryController {
    private CategoryService categoryService = new CategoryService();

    @GetMapping
    public ResponseEntity<?> getAllCategory(@RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "size", required = false) Integer size,
                                            @RequestParam(value = "sort", required = false) String sort) {
        List<CategoryResponseDTO> categoryList = categoryService.getListCategory();
        PagingCategoryListResponseDTO responseDTO = new PagingCategoryListResponseDTO();
        responseDTO.setCategoryResponseDTOList(categoryList);
        responseDTO.setPage(page);
        responseDTO.setSize(size);
        responseDTO.setSort(sort);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity insertcaegory(@RequestBody CreateCategoryRequestDTO categoryRequestDTO) {
        int id = categoryRequestDTO.getId();
        String name = categoryRequestDTO.getName();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(id)
                .append(name)
                .toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{category-id}")
    public ResponseEntity getCategoryByCategoryId(@PathVariable(value = "category-id") int categoryID) {
        List<CategoryResponseDTO> responseDTOList = categoryService.getListCategory()
                .stream()
                .filter(e -> e.getId() == categoryID)
                .collect(Collectors.toList());
        return new ResponseEntity(responseDTOList, HttpStatus.OK);
    }

    @PutMapping("/{category-id}")
    public ResponseEntity updateCategory (@PathVariable(value = "category-id") int categoryID,
                                     @RequestBody UpdatCategoryRequestDTO updatCategoryRequestDTO) {
        CategoryResponseDTO responseDTO = new CategoryResponseDTO();
        responseDTO.setId(categoryID);
        responseDTO.setName(updatCategoryRequestDTO.getName());

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{category-id}")
    public ResponseEntity deleteCategory (@PathVariable(value = "category-id") int categoryID) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
