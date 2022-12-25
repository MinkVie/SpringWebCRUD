package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.CreateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.PagingUserListResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.UserResponseDTO;
import r2s.com.demo.SpringWebDemo.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService = new UserService();

    @GetMapping
    public ResponseEntity<?> getAllUser(@RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "size", required = false) Integer size,
                                        @RequestParam(value = "sort", required = false) String sort) {
        List<UserResponseDTO> userList = userService.getListUser();
        PagingUserListResponseDTO response = new PagingUserListResponseDTO();
        response.setUserResponseDTOList(userList);
        response.setPage(page);
        response.setSize(size);
        response.setSort(sort);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/{user-id}")
    public ResponseEntity getUserByUserId(@PathVariable(value = "user-id") int userId) {
        List<UserResponseDTO> response = userService.getListUser()
                .stream()
                .filter(c -> c.getId() == userId)
                .collect(Collectors.toList());
        return new ResponseEntity(response, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity insertUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        int id = createUserRequestDTO.getId();
        String name = createUserRequestDTO.getName();
        String password = createUserRequestDTO.getPassword();
        String phone = createUserRequestDTO.getPhone();
        String gender = createUserRequestDTO.getGender();
        String email = createUserRequestDTO.getEmail();
        Date birthday = createUserRequestDTO.getBirthday();
        StringBuilder stringBuilder = new StringBuilder();
        String response = stringBuilder.append(id)
                .append(name)
                .append(password)
                .append(phone)
                .append(gender)
                .append(email)
                .append(birthday)
                .toString();
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @PutMapping("/{user-id}")
    public ResponseEntity updateUser(@PathVariable(value = "user-id") int userId,
                                     @RequestBody UpdateUserRequestDTO updateUserRequestDTO) {
        UserResponseDTO response = new UserResponseDTO();
        response.setId(userId);
        response.setUsername(updateUserRequestDTO.getUsername());
        response.setName(updateUserRequestDTO.getName());
        response.setEmail(updateUserRequestDTO.getEmail());
        response.setPhone(updateUserRequestDTO.getPhone());
        response.setGender(updateUserRequestDTO.getGender());
        response.setBirthday(updateUserRequestDTO.getBirthday());

        return new ResponseEntity(response, HttpStatus.OK);
    }
    @DeleteMapping("/{user-id}")
    public ResponseEntity deleteUser(@PathVariable(value = "user-id") int userId) {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
