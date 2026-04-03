package com.ironhack.jpa.relationshipsandinheritancelab.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "internal_tasks")
public class InternalTask extends Task{
    public InternalTask(){}
}
