package com.RNE.demande.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.demande.entities.Membre;

public interface MembreSpecRepository extends JpaRepository<Membre, Long>{

}
