package com.RNE.referentiel.services;

import java.util.List;

import com.RNE.referentiel.dto.CityDTO;

public interface CityService {

	public CityDTO saveCity(CityDTO cityDTO);

	public CityDTO getCityByCode(String code);

	public List<CityDTO> getAllCity();

	public CityDTO updateCity(String code, CityDTO cityDTO);

	public List<CityDTO> getActivatedCity();

	public void deleteCity(String code);
}