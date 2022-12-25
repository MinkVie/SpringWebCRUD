package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.CreateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.service.UserService;

import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService = new UserService();

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<CreateUserRequestDTO> userList = userService.getListUser();
        return ResponseEntity.ok(userList);
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
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
