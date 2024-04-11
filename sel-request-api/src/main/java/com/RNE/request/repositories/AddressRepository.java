package com.RNE.request.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.request.entities.Address;

public interface AddressRepository extends JpaRepository<Address,Long >{

}
