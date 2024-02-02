package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Room findById(int id);
}
