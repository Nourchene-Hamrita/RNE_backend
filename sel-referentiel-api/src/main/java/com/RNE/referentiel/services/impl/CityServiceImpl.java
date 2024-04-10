package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.CityDTO;
import com.RNE.referentiel.dto.mappers.CityMapper;
import com.RNE.referentiel.entities.City;

import com.RNE.referentiel.repositories.CityRepository;
import com.RNE.referentiel.services.CityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;
    private CityMapper cityMapper;

    // save city service
    @Override
    public CityDTO saveCity(CityDTO cityDTO) {
        City city = cityMapper.toEntity(cityDTO);
        return cityMapper.toDto(cityRepository.save(city));
    }

    // get city by code service
    @Override
    public CityDTO getCityByCode(String code) {
        Optional<City> existCity = cityRepository.findById(code);
        return cityMapper.toDto(existCity.get());
    }

    // get all cities services
    @Override
    public List<CityDTO> getAllCity() {
        List<City> cities = cityRepository.findAll();
        return cities.stream().map(cityMapper::toDto).toList();
    }

    // update city service
    @Override
    public CityDTO updateCity(String code, CityDTO cityDTO) {
        City existCity = cityRepository.findById(code).orElse(null);
        existCity.setNameFr(cityDTO.getNameFr());
        existCity.setNameAr(cityDTO.getNameAr());
        existCity.setActivation(cityDTO.getActivation());
        return cityMapper.toDto(cityRepository.save(existCity));
    }

    @Override
    public List<CityDTO> getActivatedCity() {
        List<City> cities = cityRepository.getActivatedCity();
        return cities.stream().map(cityMapper::toDto).toList();
    }

    @Override
    public void deleteCity(String code) {
        cityRepository.deleteById(code);
    }

}