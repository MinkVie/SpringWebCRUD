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



//    @PutMapping("/{user-id}")
//    public ResponseEntity updateUser(@PathVariable(value = "user-id") int userId,
//                                     @RequestBody UpdateUserRequestDTO updateUserRequestDTO) {
//        UserResponseDTO response = new UserResponseDTO();
//        response.setId(userId);
//        response.setUsername(updateUserRequestDTO.getUsername());
//        response.setName(updateUserRequestDTO.getName());
//        response.setEmail(updateUserRequestDTO.getEmail());
//        response.setPhone(updateUserRequestDTO.getPhone());
//        response.setGender(updateUserRequestDTO.getGender());
//        response.setPassword(updateUserRequestDTO.getPassword());
//        response.setBirthday(updateUserRequestDTO.getBirthday());
//
//        return new ResponseEntity(response, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{user-id}")
//    public ResponseEntity deleteUser(@PathVariable(value = "user-id") int userId) {
//        return new ResponseEntity(HttpStatus.NO_CONTENT);
//    }

}
