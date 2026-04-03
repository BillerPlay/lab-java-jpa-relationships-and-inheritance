package com.ironhack.jpa.relationshipsandinheritancelab.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "speakers")
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @AttributeOverrides({
            @AttributeOverride(name="salutation", column = @Column(name = "salutation")),
            @AttributeOverride(name="firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name="middleName", column = @Column(name = "middle_name")),
            @AttributeOverride(name="lastName", column = @Column(name = "last_name"))
    })
    @Embedded
    private Name fullName;

    @Column(name = "presentation_duration")
    private Integer presentationDuration;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    public Speaker() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }

    public Integer getPresentationDuration() {
        return presentationDuration;
    }

    public void setPresentationDuration(Integer presentationDuration) {
        this.presentationDuration = presentationDuration;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }
}
