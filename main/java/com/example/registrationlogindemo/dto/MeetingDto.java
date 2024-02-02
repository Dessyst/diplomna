package com.example.registrationlogindemo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.entity.Room;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MeetingDto {
    private Long id;
    @NotEmpty
    private String name;
    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;
    private List<User> users; //?
    private List<Room> rooms;

    public List<User> getUsers() {
        if (this.users == null) {
            this.users = new ArrayList<>(); // Initialize the list if it's null
        }
        return this.users;
    }
}
