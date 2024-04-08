package com.RNE.referentiel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.City;
import com.RNE.referentiel.repositories.CityRepository;
import com.RNE.referentiel.services.impl.CityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

	private CityRepository cityRepository;

	// save city service
	@Override
	public City saveCity(City city) {

		return cityRepository.save(city);
	}

	// get city by code service
	@Override
	public City getCityByCode(String code) {
		Optional<City> existCity = cityRepository.findById(code);
		return existCity.get();
	}

	// get all cities services
	@Override
	public List<City> getAllCity() {

		return cityRepository.findAll();
	}

	// update city service
	@Override
	public City updateCity(String code, City city) {
		City existCity = cityRepository.findById(code).orElse(null);
		existCity.setNameFr(city.getNameFr());
		existCity.setNameAr(city.getNameAr());
		existCity.setActivation(city.getActivation());
		existCity.setDelegation(city.getDelegation());
		return cityRepository.save(existCity);
	}

	@Override
	public List<City> getActivatedCity() {

		return cityRepository.getActivatedCity();
	}

	@Override
	public void deleteCity(String code) {
		cityRepository.deleteById(code);
	}

}
