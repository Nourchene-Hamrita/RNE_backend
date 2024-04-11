package com.RNE.demande.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.demande.entities.Request;

public interface RequestRepository extends JpaRepository<Request, Long>{

}
