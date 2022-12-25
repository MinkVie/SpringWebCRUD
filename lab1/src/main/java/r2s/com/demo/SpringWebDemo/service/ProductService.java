package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.CreateProductRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateUserRequestDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductService {
    public List<CreateProductRequestDTO> getListProduct(){
        List<CreateProductRequestDTO> productList= new ArrayList<>();
        CreateProductRequestDTO product1= new CreateProductRequestDTO(1,"ban chai danh rang ",1000,"Nguyen Minh Vy",false,1);
        CreateProductRequestDTO product2= new CreateProductRequestDTO(2,"ban chai danh rang ",1000,"Nguyen Minh Vy",false,1);
        productList.add(product1);
        productList.add(product2);
        return productList;
    }
}
