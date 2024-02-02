package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Meeting;
import com.example.registrationlogindemo.entity.Role;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.RoleRepository;
import com.example.registrationlogindemo.repository.UserRepository;
import com.example.registrationlogindemo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        //user.setMeetings(userDto.);
        List<Meeting> meetings = userDto.getMeetings();
        user.setMeetings(meetings);

        userRepository.save(user);
    }

    @Override
    public void editUser(UserDto userDto, int userId){
        User user = userRepository.findById(userId);
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        List<Meeting> meetings = userDto.getMeetings();
        user.setMeetings(meetings);
        userRepository.save(user);

    }

    @Override
    public List<Meeting> findAllMeetings(int id){
        List<Meeting> meetings = userRepository.findById(id).getMeetings();
        return meetings;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findById(int id){
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        //return users.stream().map((user) -> convertEntityToDto(user))
          //      .collect(Collectors.toList());
        return users;
    }


    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        //String[] name = user.getName().split(" ");
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
