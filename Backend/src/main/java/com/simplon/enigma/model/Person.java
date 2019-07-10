package com.simplon.enigma.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;




/**
 * @author Fadi NOUFAL
 */

@Entity
@Table(name = "person")
public class Person implements Serializable {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "person_id")
    @GeneratedValue
    UUID id;

    String username;

    String email;

    String password;

    Double scoreAvg;

    @OneToMany(mappedBy = "person", targetEntity = Score.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Score> scores;


    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    public Person() {
    }

    public Person(String username, String email, String password, Double scoreAvg, List<Score> scores, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.scoreAvg = scoreAvg;
        this.scores = scores;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", scoreAvg=" + scoreAvg +
                ", scores=" + scores +
                ", role=" + role +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
