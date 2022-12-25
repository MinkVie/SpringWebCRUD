package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdateProductRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.PagingProductListResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.ProductResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.UserResponseDTO;
import r2s.com.demo.SpringWebDemo.service.ProductService;
import r2s.com.demo.SpringWebDemo.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value = "/product")
public class ProductController {
    private ProductService productService = new ProductService();

    @GetMapping
    public ResponseEntity<?> getAllProduct(@RequestParam(value = "page", required = false) Integer page,
                                           @RequestParam(value = "size", required = false) Integer size,
                                           @RequestParam(value = "sort", required = false) String sort) {
        List<ProductResponseDTO> productList = productService.getListProduct();
        PagingProductListResponseDTO responseDTO = new PagingProductListResponseDTO();
        responseDTO.setProductResponseDTOList(productList);
        responseDTO.setPage(page);
        responseDTO.setSize(size);
        responseDTO.setSort(sort);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{product-id}")
    public ResponseEntity getProductByProductId(@PathVariable(value = "product-id") int productID) {
        List<ProductResponseDTO> responseDTOList = productService.getListProduct()
                .stream()
                .filter(e -> e.getId() == productID)
                .collect(Collectors.toList());
        return new ResponseEntity(responseDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity insertProduct(@RequestBody CreateProductRequestDTO createProductRequestDTO) {
        int id = createProductRequestDTO.getId();
        String name = createProductRequestDTO.getName();
        long price = createProductRequestDTO.getPrice();
        String salerName = createProductRequestDTO.getSalerName();
        int categoryId = createProductRequestDTO.getCategoryId();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(id)
                .append(name)
                .append(price)
                .append(salerName)
                .append(categoryId)
                .toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{product-id}")
    public ResponseEntity updateUser(@PathVariable(value = "product-id") int productID,
                                     @RequestBody UpdateProductRequestDTO updateProductRequestDTO) {
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(productID);
        response.setName(updateProductRequestDTO.getName());
        response.setPrice(updateProductRequestDTO.getPrice());
        response.setSalerName(updateProductRequestDTO.getSalerName());
        response.setDeleted(updateProductRequestDTO.isDeleted());
        response.setCategoryId(updateProductRequestDTO.getCategoryId());

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity deleteUser(@PathVariable(value = "product-id") int productID) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
