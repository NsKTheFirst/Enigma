package com.simplon.enigma.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;




/**
 * @author Fadi NOUFAL
 */

@Entity
public class Person {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id")
    @GeneratedValue
    UUID id;

    String username;

    String email;

    String password;

    Double scoreAvg;

    @OneToMany
    List<Score> scores;



    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    public Person() {
    }

    public Person(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getScoreAvg() {
        return scoreAvg;
    }

    public void setScoreAvg(Double scoreAvg) {
        this.scoreAvg = scoreAvg;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
