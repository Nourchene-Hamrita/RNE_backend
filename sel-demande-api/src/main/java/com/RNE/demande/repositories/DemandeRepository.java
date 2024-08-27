package com.RNE.demande.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.demande.entities.Demande;

import com.RNE.demande.enums.StatutDemande;

public interface DemandeRepository extends JpaRepository<Demande, Long> {

	long countDemandesByStatutDemande(StatutDemande statutDemande);

}
