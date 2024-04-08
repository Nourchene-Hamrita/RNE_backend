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

	private CityRepository cityRepository;

	// save city service
	@Override
	public City saveCity(City city) {

		return cityRepository.save(city);
	}

	// get city by code service
	@Override
	public City getCityByCode(String cityCode) {
		Optional<City> existCity = cityRepository.findById(cityCode);
		return existCity.get();
	}

	// get all cities services
	@Override
	public List<City> getAllCity() {

		return cityRepository.findAll();
	}

	// update city service
	@Override
	public City updateCity(String cityCode, City city) {
		City existCity = cityRepository.findById(cityCode).orElse(null);
		existCity.setCityNameFr(city.getCityNameFr());
		existCity.setCityNameAr(city.getCityNameAr());
		existCity.setActivation(city.getActivation());
		existCity.setGovernorate(city.getGovernorate());
		return cityRepository.save(existCity);
	}

	@Override
	public List<City> getActivatedCity() {

		return cityRepository.getActivatedCity();
	}

	@Override
	public void deleteCity(String cityCode) {
		cityRepository.deleteById(cityCode);
	}

}
