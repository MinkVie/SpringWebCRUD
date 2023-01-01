package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.InsertProductRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Product;
import r2s.com.demo.SpringWebDemo.service.ProductService;

import java.util.List;

@RestController()
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProduct() {
        List<Product> productList = productService.getAllProductDatabase();
        return new ResponseEntity(productList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertProduct(@RequestBody InsertProductRequestDTO requestDTO) {
        Product product = productService.insertProduct(requestDTO);
        return new ResponseEntity(product, HttpStatus.OK);
    }


//    @PutMapping("/{product-id}")
//    public ResponseEntity updateProduct(@PathVariable(value = "product-id") int productId,
//                                        @RequestBody UpdateProductRequestDTO updateProductRequestDTO) {
//        ProductResponseDTO response = new ProductResponseDTO();
//        response.setId(productId);
//        response.setName(updateProductRequestDTO.getName());
//        response.setPrice(updateProductRequestDTO.getPrice());
//        response.setCategoryId(updateProductRequestDTO.getCategoryId());
//        response.setSalerName(updateProductRequestDTO.getSalerName());
//        response.setDeleted(updateProductRequestDTO.isDeleted());
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{product-id}")
//    public ResponseEntity deleteProduct(@PathVariable(value = "product-id") int productId) {
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }
}
