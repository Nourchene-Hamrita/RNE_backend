package com.RNE.referentiel.serviceInterface;

import java.util.List;

import com.RNE.referentiel.entities.City;

public interface CityService {
   
	public City saveCity(City ville);
	
	public City getCityByCode(String cityCode);
	
	public List<City>getAllCity();
	
	public City updateCity(String codeVille,City ville);
	
	public List<City> getActivatedCity();
	
	public void deleteCity(String codeVille); 
}
