package com.example.registrationlogindemo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.registrationlogindemo.entity.Meeting;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
    private Long id;
    private String name;
    private String description;
    private int capacity;
    boolean isAvailable;
    boolean hasProjector;
    boolean hasWhiteboard;
    boolean hasConferenceCall;
    private List<Meeting> meetings;
}
