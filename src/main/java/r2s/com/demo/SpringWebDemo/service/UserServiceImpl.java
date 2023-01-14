package r2s.com.demo.SpringWebDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import r2s.com.demo.SpringWebDemo.dto.request.InsertUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.request.UpdateUserRequestDTO;
import r2s.com.demo.SpringWebDemo.dto.response.AddressResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.PageResponseDTO;
import r2s.com.demo.SpringWebDemo.dto.response.UserResponseDTO;
import r2s.com.demo.SpringWebDemo.entity.Address;
import r2s.com.demo.SpringWebDemo.entity.User;
import r2s.com.demo.SpringWebDemo.mapper.AddressMapper;
import r2s.com.demo.SpringWebDemo.mapper.UserMapper;
import r2s.com.demo.SpringWebDemo.repository.UserRepository;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<User> getAllUserDatabase() {
        Iterable<User> userIterable = userRepository.findAll();
        return (List<User>) userIterable;
    }

    @Override
    public PageResponseDTO getUserPaging() {
        Pageable pageable = Pageable.ofSize(2).withPage(0);
        Page<User> userPage = userRepository.findAll(pageable)
                .orElseThrow(() -> new RuntimeException("Can't get user by paging"));

        PageResponseDTO pageResponseDTO = new PageResponseDTO();

        pageResponseDTO.setPage(userPage.getNumber());
        pageResponseDTO.setSize(userPage.getSize());
        pageResponseDTO.setTotalPages(userPage.getTotalPages());
        pageResponseDTO.setTotalRecord(userPage.getTotalElements());

        List<UserResponseDTO> userResponseDTOS = userMapper.convertEntityToResponseDtos(userPage.getContent());
        pageResponseDTO.setData(userResponseDTOS);

        return pageResponseDTO;
    }
    
    @Override
    @Transactional
    public User insertUser(InsertUserRequestDTO requestDTO) {
        User user = new User();

        user.setName(requestDTO.getName());
        user.setPhone(requestDTO.getPhone());
        user.setPassword(requestDTO.getPassword());
        user.setBirthday(requestDTO.getBirthday());
        user.setGender(requestDTO.getGender());
        user.setUsername(requestDTO.getUsername());
        user.setEmail(requestDTO.getEmail());

        userRepository.save(user);

        return user;
    }

    @Override
    public UserResponseDTO getUserbyId(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't get user by this id"));

        UserResponseDTO userResponseDTOS = userMapper.convertEntityToResponseDto(user);

        return userResponseDTOS;
    }

    @Override
    @Transactional
    public UserResponseDTO updateUser(UpdateUserRequestDTO requestDTO, Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't update user by this id"));

        user.setName(requestDTO.getName());
        user.setPhone(requestDTO.getPhone());
        user.setPassword(requestDTO.getPassword());
        user.setBirthday(requestDTO.getBirthday());
        user.setGender(requestDTO.getGender());
        user.setUsername(requestDTO.getUsername());
        user.setEmail(requestDTO.getEmail());

        userRepository.save(user);

        UserResponseDTO userResponseDTO = userMapper.convertEntityToResponseDto(user);

        return userResponseDTO;
    }

    @Override
    @Transactional
    public void deleteUserbyId(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't delete user by this id"));

        userRepository.delete(user);
    }
}
