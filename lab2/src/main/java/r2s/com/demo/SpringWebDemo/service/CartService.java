package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.CreateAddressRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateCartRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.CartResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    public List<CartResponseDTO> getListCart(){
        List<CartResponseDTO> cartList= new ArrayList<>();
        CartResponseDTO cart1= new CartResponseDTO(1,1);
        CartResponseDTO cart2= new CartResponseDTO(2,2);
        cartList.add(cart1);
        cartList.add(cart2);
        return cartList;
    }
}
