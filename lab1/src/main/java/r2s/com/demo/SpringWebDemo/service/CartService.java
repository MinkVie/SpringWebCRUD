package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.CreateAddressRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateCartRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    public List<CreateCartRequestDTO> getListCart(){
        List<CreateCartRequestDTO> cartList= new ArrayList<>();
        CreateCartRequestDTO cart1= new CreateCartRequestDTO(1,1);
        CreateCartRequestDTO cart2= new CreateCartRequestDTO(2,2);
        cartList.add(cart1);
        cartList.add(cart2);
        return cartList;
    }
}
