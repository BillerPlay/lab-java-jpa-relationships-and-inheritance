package com.ironhack.jpa.relationshipsandinheritancelab.entities;

import jakarta.persistence.*;

@Entity
@Table(name="contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String company;

    @Column(length = 250, nullable = false)
    private String title;

    @AttributeOverrides({
            @AttributeOverride(name="salutation", column = @Column(name = "salutation")),
            @AttributeOverride(name="firstName", column = @Column(name = "first_name")),
            @AttributeOverride(name="middleName", column = @Column(name = "middle_name")),
            @AttributeOverride(name="lastName", column = @Column(name = "last_name"))
    })
    @Embedded
    private Name fullName;

    public Contact() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }
}
