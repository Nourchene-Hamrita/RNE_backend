package com.RNE.referentiel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.RNE.referentiel.entities.City;

public interface CityRepository extends JpaRepository<City,String> {
 
	@Query("SELECT v FROM City c WHERE c.activation='Activate' ")
	 List<City> getActivatedCity();
}
