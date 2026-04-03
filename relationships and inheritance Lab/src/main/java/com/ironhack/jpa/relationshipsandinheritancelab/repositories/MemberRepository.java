package com.ironhack.jpa.relationshipsandinheritancelab.repositories;

import com.ironhack.jpa.relationshipsandinheritancelab.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
