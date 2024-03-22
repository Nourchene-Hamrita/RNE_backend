package com.RNE.referentiel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.City;
import com.RNE.referentiel.repositories.CityRepository;
import com.RNE.referentiel.serviceInterface.CityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
   
	private CityRepository villeRepository;
	
	
	//save ville service
	@Override
	public City saveCity(City ville) {
		
		return villeRepository.save(ville) ;
	}

    //get ville by code service
	@Override
	public City getCityByCode(String cityCode) {
		Optional<City> existVille =villeRepository.findById(cityCode);
		return existVille.get();
	}
    // get all villes services
	@Override
	public List<City> getAllCity() {
		
		return villeRepository.findAll();
	}
   //update ville service
	@Override
	public City updateCity(String cityCode, City ville) {
		City existVille=villeRepository.findById(cityCode).orElse(null);
		existVille.setCityNameFr(ville.getCityNameFr());
		existVille.setCityNameAr(ville.getCityNameAr());
		existVille.setActivation(ville.getActivation());
		existVille.setGovernerote(ville.getGovernerote());
		return villeRepository.save(existVille);
	}

	@Override
	public List<City> getActivatedCity() {
		
		return villeRepository.getActivatedCity();
	}
	@Override
	public void deleteCity(String cityCode) {
		villeRepository.deleteById(cityCode);
	}

}
