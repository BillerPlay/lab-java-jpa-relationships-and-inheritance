package com.ironhack.jpa.relationshipsandinheritancelab.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "billable_tasks")
public class BillableTask extends Task{
    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

    public BillableTask() {}

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
