package com.RNE.referentiel.services.impl;

import java.util.List;

import com.RNE.referentiel.entities.City;

public interface CityService {

	public City saveCity(City city);

	public City getCityByCode(String code);

	public List<City> getAllCity();

	public City updateCity(String code, City city);

	public List<City> getActivatedCity();

	public void deleteCity(String code);
}
