package com.example.registrationlogindemo.dto;

import com.example.registrationlogindemo.entity.Meeting;
import com.example.registrationlogindemo.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto
{
    private Long id;
    @NotEmpty
    private String name;
    //@NotEmpty
    //private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    /*private List<User> users;

    public List<User> getUsers(){
        return users;
    }*/
    private List<Meeting> meetings;
    public List<Meeting> getMeetings(){
        return meetings;
    }
}
