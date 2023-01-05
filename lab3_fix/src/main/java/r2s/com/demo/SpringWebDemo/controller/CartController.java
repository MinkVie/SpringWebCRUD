package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.InsertCartRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Cart;
import r2s.com.demo.SpringWebDemo.service.CartService;

import java.util.List;

@RestController()
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<?> getAllCart() {
        List<Cart> cartList = cartService.getAllCartDatabase();
        return new ResponseEntity(cartList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity insertCart(@RequestBody InsertCartRequestDTO requestDTO) {
        Cart cart = cartService.insertCart(requestDTO);
        return new ResponseEntity(cart, HttpStatus.OK);
    }




}
