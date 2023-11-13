package com.div.service;

import com.div.dto.UserDto;
import com.div.entity.User;
import com.div.mapper.UserMapper;
import com.div.repository.UserRepository;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;


    private final UserMapper map;

    public UserService(UserRepository userRepository, UserMapper map) {
        this.userRepository = userRepository;
        this.map = map;
    }


    public UserDto creatUser(UserDto userDto) {
        User user = map.toUser(userDto);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = map.toDto(savedUser);
       return savedUserDto;




        //   userRepository.save(map.toUser(userDto));
    }

    public List<UserDto> getAllUser() {

        List<User> users= userRepository.findAll();
        return  map.toUserDtoList(users);
    }

    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElse(null);


        return map.toDto(user);
    }

    public void updateUserById(Long id, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User olduser=userOptional.get();
            olduser.setName(userDto.getName());
            olduser.setSurname(userDto.getSurname());
            olduser.setBirthdate(userDto.getBirthdate());
            olduser.setPhoneNumber(userDto.getPhoneNumber());
            olduser.setActive(userDto.isActive());
            olduser.setEmail(userDto.getEmail());
            userRepository.save(olduser);
        }

    }

    public void deleteUser(Long id) {

    userRepository.deleteById(id);

    }
}
