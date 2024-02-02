package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.registrationlogindemo.entity.Meeting;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface MeetingRepository extends JpaRepository<Meeting, Integer>  {
    Meeting findById(int id);
    Meeting findByName(String name);
    //Meeting findTopByOrderByMeeting_idDesc();
    //Meeting findTopByOrderByMeetingIdDesc();

    //@Query("SELECT m FROM Meeting m ORDER BY m.meeting_id DESC")
    //List<Meeting> findLastMeeting(Pageable pageable);

    //Meeting findFirstByOrderByMeeting_idDesc();

    //@Query("SELECT MAX(m.meeting_id) FROM Meeting m")
    //int findMaxMeetingId();

    //@Query("SELECT m FROM Meeting m WHERE m.meeting_id = (SELECT MAX(meeting.meeting_id) FROM Meeting meeting)")
    //Meeting findLastMeeting();

}
