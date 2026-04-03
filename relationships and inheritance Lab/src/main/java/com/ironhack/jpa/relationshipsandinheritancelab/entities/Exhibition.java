package com.ironhack.jpa.relationshipsandinheritancelab.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "exhibitions")
public class Exhibition extends Event{
    public Exhibition() {
    }
}
