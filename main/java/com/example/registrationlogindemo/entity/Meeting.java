package com.example.registrationlogindemo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meeting_id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private LocalDateTime startTime;
    @Column(nullable=false)
    private LocalDateTime endTime;
    @ManyToMany(mappedBy="meetings", fetch = FetchType.LAZY)
    private List<User> users;
    @ManyToMany(mappedBy="meetings", fetch = FetchType.LAZY)
    private List<Room> rooms;

    public void setId(int id) {
        this.meeting_id = id;
    }

    public int getId() {
        return meeting_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

     public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

     public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Room> getRooms() {
        if (rooms == null) {
            rooms = new ArrayList<>();
        }
        return rooms;
    }

    /*public List<User> getUsers() {

        return users != null ? users : new ArrayList<>();
    }*/
}
