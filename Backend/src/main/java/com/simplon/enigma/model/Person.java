package com.simplon.enigma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

/**
 * @author Fadi NOUFAL
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    UUID id;

    String nom;

    String email;

    String password;

    Double scoureAvg;

    @OneToMany
    List<Score> scores;

    public User(String nom, String email, String password) {
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getScoureAvg() {
        return scoureAvg;
    }

    public void setScoureAvg(Double scoureAvg) {
        this.scoureAvg = scoureAvg;
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
}
