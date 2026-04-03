package com.ironhack.jpa.relationshipsandinheritancelab.entities;

import com.ironhack.jpa.relationshipsandinheritancelab.enums.Status;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="members")
public class Member {
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.LAPSED;

    @Column(name = "renewal_date")
    private LocalDateTime renewalDate;

    @ManyToOne
    @JoinColumn(name="division_id")
    private Division division;

    public Member() {
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDateTime renewalDate) {
        this.renewalDate = renewalDate;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
