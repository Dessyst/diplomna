package com.example.registrationlogindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rooms")

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int room_id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String description;
    @Column(nullable=false)
    private int capacity;
    @Column(nullable=false)
    boolean isAvailable;
    @Column(nullable=false)
    boolean hasProjector;
    @Column(nullable=false)
    boolean hasWhiteboard;
    @Column(nullable=false)
    boolean hasConferenceCall;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="rooms_meetings",
            joinColumns={@JoinColumn(name="room_id", referencedColumnName="room_id")},
            inverseJoinColumns={@JoinColumn(name="meeting_id", referencedColumnName="meeting_id")})
    private List<Meeting> meetings = new ArrayList<>();
}
