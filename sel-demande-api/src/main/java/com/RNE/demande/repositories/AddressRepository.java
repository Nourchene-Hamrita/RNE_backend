package com.RNE.demande.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.demande.entities.Address;

public interface AddressRepository extends JpaRepository<Address,Long >{

}
