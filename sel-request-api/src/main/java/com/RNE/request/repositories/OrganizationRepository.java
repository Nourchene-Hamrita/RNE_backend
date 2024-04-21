package com.RNE.request.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RNE.request.entities.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}
