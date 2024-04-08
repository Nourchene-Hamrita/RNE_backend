package com.RNE.demande.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.demande.DTO.StreetDTO;
import com.RNE.demande.entities.Street;
import com.RNE.demande.repositories.StreetRepository;
import com.RNE.demande.serviceInterface.StreetService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StreetImpl implements StreetService{
	
	
	private StreetRepository streetRepository;

	@Override
	public List<StreetDTO> getAllStreets() {
		// TODO Auto-generated method stub
		
		List<Street> streets = streetRepository.findAll();
		return streets.stream()
		.map(StreetDTO::convertEntityToDto)
        .collect(Collectors.toList());
	}

}
