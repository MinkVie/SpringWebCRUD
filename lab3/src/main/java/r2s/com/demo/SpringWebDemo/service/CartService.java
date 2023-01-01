package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.InsertCartRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCartDatabase();

    Cart insertCart(InsertCartRequestDTO requestDTO);
}
