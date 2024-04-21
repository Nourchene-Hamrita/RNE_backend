package com.RNE.demande.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.demande.entities.Documents;

public interface DocumentRepository extends JpaRepository<Documents, Long>{

}
