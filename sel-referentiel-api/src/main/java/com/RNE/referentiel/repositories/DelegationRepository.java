package com.RNE.referentiel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RNE.referentiel.entities.Delegation;

@Repository
public interface DelegationRepository extends JpaRepository<Delegation, String> {

	@Query("SELECT d FROM Delegation d WHERE d.activation = 'Activate' ")
	List<Delegation> getActivatedDelegation();
}
