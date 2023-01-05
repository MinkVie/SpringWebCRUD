package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.request.InsertUserRequestDTO;
import r2s.com.demo.SpringWebDemo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUserDatabase();

    User insertUser(InsertUserRequestDTO requestDTO);
}
