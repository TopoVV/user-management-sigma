package com.topov.usermanagement.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "app_users")
@NoArgsConstructor
@SequenceGenerator(name = "user_id_gen", sequenceName = "user_id_seq", allocationSize = 1)
public class User {
    @Id
    @GeneratedValue(generator = "user_id_gen", strategy = GenerationType.SEQUENCE)
    private Long userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private LocalDate birthDate;
    @Column(unique = true)
    private String login;
    @Column
    private String password;
    @Column
    private String about;
    @Embedded
    private Address address;

    public User(String firstName, String lastName, LocalDate birthDate, String login, String password, String about, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.login = login;
        this.password = password;
        this.about = about;
        this.address = address;
    }
}
