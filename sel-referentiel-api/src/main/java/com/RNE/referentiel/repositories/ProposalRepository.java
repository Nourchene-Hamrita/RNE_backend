package com.RNE.referentiel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.referentiel.entities.Proposal;

public interface ProposalRepository extends JpaRepository<Proposal,String> {

}
