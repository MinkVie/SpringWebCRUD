package r2s.com.demo.SpringWebDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import r2s.com.demo.SpringWebDemo.dto.request.InsertUserRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.User;
import r2s.com.demo.SpringWebDemo.service.UserService;

import java.util.List;

@RestController()
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<User> userList = userService.getAllUserDatabase();
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity insertUser(@RequestBody InsertUserRequestDTO requestDTO) {
        User user = userService.insertUser(requestDTO);
        return new ResponseEntity(user, HttpStatus.OK);
    }

}
