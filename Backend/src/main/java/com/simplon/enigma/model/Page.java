package com.simplon.enigma.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author Fadi NOUFAL
 */


@Entity
public class Page {

    @Id
    @GeneratedValue
    UUID id;

    String nom;

    String imageUrl;

    String text;

    String leftAr;

    String rightAr;

    String backAr;

    String clue;

    Integer position;

}
