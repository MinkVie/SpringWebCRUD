package r2s.com.demo.SpringWebDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import r2s.com.demo.SpringWebDemo.dto.request.InsertProductRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.InsertProductRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Product;
import r2s.com.demo.SpringWebDemo.entity.Product;
import r2s.com.demo.SpringWebDemo.repository.ProductRepository;

import java.util.List;
@Component
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProductDatabase() {
        Iterable<Product> productIterable = productRepository.findAll();
        return (List<Product>) productIterable;
    }


    @Override
    public Product insertProduct(InsertProductRequestDTO requestDTO) {
        Product product= new Product();
        product.setName(requestDTO.getName());
        product.setCategoryId(requestDTO.getCategoryId());
        product.setDeleted(requestDTO.isDeleted());
        product.setPrice(requestDTO.getPrice());
        product.setSalerName(requestDTO.getSalerName());
        productRepository.save(product);
        return product;
    }
}
