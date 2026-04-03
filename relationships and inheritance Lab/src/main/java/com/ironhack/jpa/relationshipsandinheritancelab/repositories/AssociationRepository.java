package com.ironhack.jpa.relationshipsandinheritancelab.repositories;

import com.ironhack.jpa.relationshipsandinheritancelab.entities.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Association, Long> {
}
