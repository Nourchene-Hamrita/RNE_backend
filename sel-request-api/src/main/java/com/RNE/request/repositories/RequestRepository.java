package com.RNE.request.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.request.entities.Request;

public interface RequestRepository extends JpaRepository<Request, Long>{

}
