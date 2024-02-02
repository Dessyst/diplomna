package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.dto.MeetingDto;
import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Meeting;
import com.example.registrationlogindemo.entity.Room;
import com.example.registrationlogindemo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MeetingService {
    void saveMeeting(MeetingDto meetingDto);
    Meeting findById(int id);
    public List<User> findAllUsersInMeeting(int id);
    void addUser(User user, Meeting meeting);
    List<Meeting> findAllMeetings();
    void addRoom(Room room, Meeting meeting);

    //int getLastMeetingId();

    int getLastMeeting();

    Meeting findByName(String name);


}
