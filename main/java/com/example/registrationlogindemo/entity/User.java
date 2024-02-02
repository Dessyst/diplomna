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
    @Table(name="users")
    public class User
    {
        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int user_id;

        @Column(nullable=false)
        private String name;

        @Column(nullable=false, unique=true)
        private String email;

        @Column(nullable=false)
        private String password;

        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(
                name="users_meetings",
                joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
                inverseJoinColumns={@JoinColumn(name="meeting_id", referencedColumnName="meeting_id")})
        private List<Meeting> meetings = new ArrayList<>();

        @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
        @JoinTable(
                name="users_roles",
                joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
                inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
        private List<Role> roles = new ArrayList<>();

    }
