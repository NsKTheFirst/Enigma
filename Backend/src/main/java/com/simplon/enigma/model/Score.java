package com.simplon.enigma.model;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Fadi NOUFAL
 */

@Entity
public class Score {

    @Id
    @GeneratedValue
    UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    Integer value;



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
