package com.RNE.request.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.request.dto.AddressDTO;
import com.RNE.request.dto.RequestDTO;
import com.RNE.request.entities.Address;
import com.RNE.request.entities.Request;
import com.RNE.request.repositories.RequestRepository;
import com.RNE.request.services.RequestService;

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

	@Override
	public void deleteRequest(Long id) {
		// TODO Auto-generated method stub
		requestRepository.deleteById(id);	
	}
}
