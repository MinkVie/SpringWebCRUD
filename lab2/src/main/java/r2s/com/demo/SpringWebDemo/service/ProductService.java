package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.ProductResponseDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductService {
    public List<ProductResponseDTO> getListProduct(){
        List<ProductResponseDTO> productList= new ArrayList<>();
        ProductResponseDTO product1= new ProductResponseDTO(1,"ban chai danh rang ",1000,"Nguyen Minh Vy",false,1);
        ProductResponseDTO product2= new ProductResponseDTO(2,"ban chai danh rang ",1000,"Nguyen Minh Vy",false,1);
        productList.add(product1);
        productList.add(product2);
        return productList;
    }
}
