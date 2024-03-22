package com.RNE.referentiel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RNE.referentiel.entities.Governorate;

@Repository
public interface GovernorateRepository extends JpaRepository<Governorate,String> {
    
	@Query("SELECT g FROM Governorate g WHERE g.activation = 'Activer' ")
	 List<Governorate>getActivatedGov();
}
