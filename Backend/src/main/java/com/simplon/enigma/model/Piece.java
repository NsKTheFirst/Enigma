package com.simplon.enigma.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author Fadi NOUFAL
 */

@Entity
public class Piece {

    @Id
    @Type(type = "uuid-char")
    @Column(name = "id")
    @GeneratedValue
    UUID id;

    String nom;

    Integer numPage;

    String imageUrl;

    String text;

    String leftAr;

    String rightAr;

    String backAr;

    String clue;

    Integer position;


    public Integer getNumPage() {
        return numPage;
    }

    public void setNumPage(Integer numPage) {
        this.numPage = numPage;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLeftAr() {
        return leftAr;
    }

    public void setLeftAr(String leftAr) {
        this.leftAr = leftAr;
    }

    public String getRightAr() {
        return rightAr;
    }

    public void setRightAr(String rightAr) {
        this.rightAr = rightAr;
    }

    public String getBackAr() {
        return backAr;
    }

    public void setBackAr(String backAr) {
        this.backAr = backAr;
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
