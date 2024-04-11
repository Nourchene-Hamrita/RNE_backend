package com.RNE.demande.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.demande.dto.AddressDTO;
import com.RNE.demande.dto.RequestDTO;
import com.RNE.demande.entities.Address;
import com.RNE.demande.entities.Request;
import com.RNE.demande.repositories.RequestRepository;
import com.RNE.demande.services.RequestService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class RequestServiceImpl implements RequestService{
	
	private RequestRepository requestRepository;

	@Override
	public RequestDTO saveRequest(RequestDTO requestDTO) {
		// TODO Auto-generated method stub
		Request request =RequestDTO.convertDtoToEntity(requestDTO) ;
        return RequestDTO.convertEntityToDto(requestRepository.save(request));
	}

	@Override
	public List<RequestDTO> getAllRequest() {
		// TODO Auto-generated method stub
		 return requestRepository.findAll().stream()
	                .map(RequestDTO::convertEntityToDto)
	                .collect(Collectors.toList());
	}
	
	
	

}
