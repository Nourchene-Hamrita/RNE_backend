package com.RNE.referentiel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.RNE.referentiel.entities.Gouvernerat;

@Repository
public interface GouverneratRepository extends JpaRepository<Gouvernerat, String> {

	@Query("SELECT g FROM Gouvernerat g WHERE g.activation = 'Active' ")
	List<Gouvernerat> getActivatedGouvernerats();
}
