package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Meeting;
import com.example.registrationlogindemo.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    User findByName(String name);
    User findById(int id);

    List<User> findAllUsers();
    List<Meeting> findAllMeetings(int id);
    void editUser(UserDto userDto, int userId);
}
