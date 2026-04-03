package com.ironhack.jpa.relationshipsandinheritancelab.entities;

import com.ironhack.jpa.relationshipsandinheritancelab.enums.GuestStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "guests")
public class Guest  {
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

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Guest() {
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

    public GuestStatus getStatus() {
        return status;
    }

    public void setStatus(GuestStatus status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
