package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.dto.RoomDto;
import com.example.registrationlogindemo.entity.Room;

import java.util.List;

public interface RoomService {
    void saveRoom(RoomDto roomDto);
    List<RoomDto> findAllRooms();

    Room findById(int id);
    List<Room> filterRooms(boolean hasProjector, boolean hasWhiteBoard, boolean hasConferenceCall, int capacity);
}
