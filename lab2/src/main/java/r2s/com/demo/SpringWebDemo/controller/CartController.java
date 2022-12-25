package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.CreateCartRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.CreateCategoryRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdateCartRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.CartResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.PagingCartListResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.UserResponseDTO;
import r2s.com.demo.SpringWebDemo.service.CartService;
import r2s.com.demo.SpringWebDemo.service.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value = "/cart")
public class CartController {
    private CartService cartService = new CartService();

    @GetMapping
    public ResponseEntity getAllCart(@RequestParam(value = "page", required = false) Integer page,
                                            @RequestParam(value = "size", required = false) Integer size,
                                            @RequestParam(value = "sort", required = false) String sort) {
        List<CartResponseDTO> cartList = cartService.getListCart();
        PagingCartListResponseDTO responseDTO = new PagingCartListResponseDTO();
        responseDTO.setCartResponseDTOList(cartList);
        responseDTO.setPage(page);
        responseDTO.setSize(size);
        responseDTO.setSort(sort);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/{cart-id}")
    public ResponseEntity getCartByCartId(@PathVariable(value = "cart-id") int cartID) {
        List<CartResponseDTO> response = cartService.getListCart()
                .stream()
                .filter(c -> c.getId() == cartID)
                .collect(Collectors.toList());
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity insertCart(@RequestBody CreateCartRequestDTO createCartRequestDTO) {
        int id = createCartRequestDTO.getId();
        int userId = createCartRequestDTO.getUserId();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(id)
                .append(userId)
                .toString();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{cart-id}")
    public ResponseEntity updateCart(@PathVariable(value = "cart-id") int cartID,
                                     @RequestBody UpdateCartRequestDTO updateCartRequestDTO) {
        CartResponseDTO response = new CartResponseDTO();
        response.setId(cartID);
        response.setUserId(updateCartRequestDTO.getUserId());


        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping("/{cart-id}")
    public ResponseEntity deleteCart(@PathVariable(value = "cart-id") int cartID) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
