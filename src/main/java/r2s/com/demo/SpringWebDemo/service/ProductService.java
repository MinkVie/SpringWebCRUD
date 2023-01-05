package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.InsertProductRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductDatabase();

    Product insertProduct(InsertProductRequestDTO requestDTO);
}
