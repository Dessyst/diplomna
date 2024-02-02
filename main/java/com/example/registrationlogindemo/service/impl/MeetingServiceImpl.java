package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.dto.MeetingDto;
import com.example.registrationlogindemo.dto.UserDto;
import com.example.registrationlogindemo.entity.Meeting;
import com.example.registrationlogindemo.entity.Room;
import com.example.registrationlogindemo.repository.MeetingRepository;
import com.example.registrationlogindemo.repository.RoomRepository;
import com.example.registrationlogindemo.service.EmailService;
import com.example.registrationlogindemo.service.MeetingService;
import org.springframework.stereotype.Service;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class MeetingServiceImpl implements MeetingService{

    private MeetingRepository meetingRepository;
    private UserRepository userRepository;
    private EmailService emailService;
    private RoomRepository roomRepository;

    public MeetingServiceImpl(MeetingRepository meetingRepository, UserRepository userRepository, RoomRepository roomRepository, EmailService emailService) {
        this.meetingRepository = meetingRepository;
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.roomRepository = roomRepository;
    }

    /*public void addUserToMeeting(int meetingId, int userId) {
        //Meeting meeting = meetingRepository.findById(meetingId).get();
        //User user = userRepository.findById(userId).get();
        // i need to put the information in the junction table



        // Add the user to the meeting
        meeting.getUsers().add(user);
        meetingRepository.save(meeting);

        // Send email to the added user
        String userEmail = user.getEmail(); // Assuming User entity has an 'email' field
        String emailSubject = "You've been added to a meeting";
        String emailText = "You have been added to a meeting. Details: [Meeting Details]";
        emailService.sendEmail(userEmail, emailSubject, emailText);
    }*/

    @Override
    public void saveMeeting(MeetingDto meetingDto) {
        Meeting meeting = new Meeting();
        meeting.setName(meetingDto.getName());
        meeting.setStartTime(meetingDto.getStartTime());
        meeting.setEndTime(meetingDto.getEndTime());

        //List<User> users = new ArrayList<>();
        /*for (UserDto userDto : meetingDto.getUsers()) {
            User user = new User();
            user.setName(userDto.getFirstName() + " " + userDto.getLastName());
            user.setEmail(userDto.getEmail());

            // Set the meeting for each user
            user.getMeetings().add(meeting);
            users.add(user);
        }*/

        meeting.setUsers(meetingDto.getUsers());
        meeting.setRooms(meetingDto.getRooms());

        meetingRepository.save(meeting);
    }


    @Override
    @Transactional
    public void addUser(User user, Meeting meeting){
        meeting.getUsers().add(user);
        user.getMeetings().add(meeting);

        meetingRepository.save(meeting);
        userRepository.save(user);

        String userEmail = user.getEmail(); // Assuming User entity has an 'email' field
        String emailSubject = "You've been added to a meeting";
        String emailText = "You have been added to a meeting. Details: [Meeting Details]";
        emailService.sendEmail(userEmail, emailSubject, emailText);
    }

    @Override
    public void addRoom(Room room, Meeting meeting){
        meeting.getRooms().add(room);
        room.getMeetings().add(meeting);

        meetingRepository.save(meeting);
        roomRepository.save(room);
    }



    @Override
    public Meeting findById(int id){
        return meetingRepository.findById(id);
    }

    @Override
    public List<User> findAllUsersInMeeting(int id){
        List<User> users = meetingRepository.findById(id).getUsers();
        return users;
    }

    @Override
    public int getLastMeeting(){
        List<Meeting> meetings = meetingRepository.findAll();
        int size = meetings.size();
        Meeting meeting = meetings.get(size - 1);
        int id = meeting.getId();

        //int id = meetingRepository.findMaxMeetingId();
        return id;
    }


    @Override
    public Meeting findByName(String name){
        return meetingRepository.findByName(name);
    }





    public List<Meeting> findAllMeetings() {
        List<Meeting> meetings = meetingRepository.findAll();
        //return meetings.stream().map((meeting) -> convertEntityToDto(meeting))
          //      .collect(Collectors.toList());
        return meetings;
    }

    private MeetingDto convertEntityToDto(Meeting meeting){
        MeetingDto meetingDto = new MeetingDto();
        meeting.setMeeting_id(meeting.getMeeting_id());
        meetingDto.setName(meeting.getName());
        meetingDto.setStartTime(meeting.getStartTime());
        meetingDto.setEndTime(meeting.getEndTime());
        return meetingDto;
    }
}
