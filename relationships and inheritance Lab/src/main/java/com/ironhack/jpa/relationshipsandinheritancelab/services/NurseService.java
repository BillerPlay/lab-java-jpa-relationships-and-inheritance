package com.ironhack.jpa.relationshipsandinheritancelab.services;

import com.ironhack.jpa.relationshipsandinheritancelab.entities.Association;
import com.ironhack.jpa.relationshipsandinheritancelab.entities.Division;
import com.ironhack.jpa.relationshipsandinheritancelab.entities.Member;
import com.ironhack.jpa.relationshipsandinheritancelab.entities.Name;
import com.ironhack.jpa.relationshipsandinheritancelab.enums.Status;
import com.ironhack.jpa.relationshipsandinheritancelab.repositories.AssociationRepository;
import com.ironhack.jpa.relationshipsandinheritancelab.repositories.DivisionRepository;
import com.ironhack.jpa.relationshipsandinheritancelab.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NurseService {
    private final AssociationRepository associationRepository;
    private final DivisionRepository divisionRepository;
    private final MemberRepository memberRepository;

    public NurseService(AssociationRepository associationRepository, DivisionRepository divisionRepository, MemberRepository memberRepository) {
        this.associationRepository = associationRepository;
        this.divisionRepository = divisionRepository;
        this.memberRepository = memberRepository;
    }

    public void createAssociationWithDivisions() {

        Association association = new Association();
        association.setName("Global Health Association");

        for (int i = 1; i <= 7; i++) {

            Division division = new Division();
            division.setName("Division " + i);
            division.setDistrict("District " + i);

            // связь с association
            division.setAssociation(association);
            association.getDivisions().add(division);

            // создаём минимум одного Member
            Member member = new Member();

            Name name = new Name();
            name.setSalutation("Mr.");
            name.setFirstName("John");
            name.setMiddleName("M");
            name.setLastName("Doe" + i);

            member.setFullName(name);
            member.setStatus(Status.ACTIVE);
            member.setRenewalDate(LocalDateTime.now().plusYears(1));

            // связь Member → Division
            member.setDivision(division);
            division.getMembers().add(member);

            // назначаем президента (1:1)
            division.setPresident(member);
        }

        // сохраняем всё
        associationRepository.save(association);
    }
}
