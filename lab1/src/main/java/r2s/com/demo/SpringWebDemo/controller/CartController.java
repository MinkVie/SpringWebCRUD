package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.CreateCartRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateCategoryRequestDTO;
import r2s.com.demo.SpringWebDemo.service.CartService;
import r2s.com.demo.SpringWebDemo.service.CategoryService;

import java.util.List;

@RestController()
@RequestMapping(value = "/cart")
public class CartController {
    private CartService cartService = new CartService();

    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        List<CreateCartRequestDTO> cartList = cartService.getListCart();
        return ResponseEntity.ok(cartList);
    }

    @PostMapping
    public ResponseEntity insertcaegory(@RequestBody CreateCartRequestDTO createCartRequestDTO) {
        int id = createCartRequestDTO.getId();
        int userId = createCartRequestDTO.getUserId();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(id)
                .append(userId)
                .toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
