package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.City;

public interface CityService {
   
	public City saveCity(City city);
	
	public City getCityByCode(String cityCode);
	
	public List<City>getAllCity();
	
	public City updateCity(String cityCode,City city);
	
	public List<City> getActivatedCity();
	
	public void deleteCity(String cityCode); 
}
