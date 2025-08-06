package com.skill.taskproject.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skill.taskproject.entity.Users;
import com.skill.taskproject.payload.UserDto;
import com.skill.taskproject.repository.UserRepository;
import com.skill.taskproject.service.UserService;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword (passwordEncoder.encode(userDto.getPassword()));
        Users users = userDtoToUser(userDto);
        Users savedUser = userRepository.save(users);
        return userToUserDto(savedUser); 
    }
    private Users userDtoToUser(UserDto userDto) {
        Users users = new Users();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        return users;
    }
    private UserDto userToUserDto(Users users) {
        UserDto userDto = new UserDto();
        userDto.setId(users.getId());
        userDto.setName(users.getName());
        userDto.setEmail(users.getEmail());
        userDto.setPassword(users.getPassword());
        return userDto;
    }
}
