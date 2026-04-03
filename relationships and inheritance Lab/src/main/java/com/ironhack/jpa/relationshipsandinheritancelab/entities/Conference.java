package com.ironhack.jpa.relationshipsandinheritancelab.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="conferences")
public class Conference extends Event{
    @OneToMany(mappedBy = "speakers")
    @JsonIgnore
    private List<Speaker> speakers = new ArrayList<>();

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }
}
