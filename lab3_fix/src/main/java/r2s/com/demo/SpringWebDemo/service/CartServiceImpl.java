package r2s.com.demo.SpringWebDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import r2s.com.demo.SpringWebDemo.dto.request.InsertCartRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.Cart;
import r2s.com.demo.SpringWebDemo.repository.CartRepository;

import java.util.List;
@Component
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCartDatabase() {
        Iterable<Cart> cartIterable = cartRepository.findAll();
        return (List<Cart>) cartIterable;
    }


    @Override
    public Cart insertCart(InsertCartRequestDTO requestDTO) {
        Cart cart= new Cart();
        cart.setUserId(requestDTO.getUserId());
        cartRepository.save(cart);
        return cart;
    }
}
