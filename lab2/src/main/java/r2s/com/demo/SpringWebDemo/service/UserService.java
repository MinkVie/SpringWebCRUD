package r2s.com.demo.SpringWebDemo.service;

import r2s.com.demo.SpringWebDemo.dto.response.UserResponseDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserService {

    
    public List<UserResponseDTO> getListUser(){
        List<UserResponseDTO> userList= new ArrayList<>();
        UserResponseDTO user1= new UserResponseDTO(1,"minhvy1", "Nguyen Minh Vy 1","111111","123456","Nam","vynguyen@gmail.com",new Date(2001,3,2));
        UserResponseDTO user2= new UserResponseDTO(2,"minhvy2", "Nguyen Minh Vy 2","111111","123456","Nam","vynguyen@gmail.com",new Date(2020,3,2));
        userList.add(user1);
        userList.add(user2);
        return userList;
    }
}
