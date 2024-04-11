package com.RNE.request.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.request.dto.AddressDTO;
import com.RNE.request.entities.Address;
import com.RNE.request.repositories.AddressRepository;
import com.RNE.request.services.AddressService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

	private AddressRepository addressRepository;
	
	
	@Override
	public AddressDTO saveAddress(AddressDTO addressDTO) {
		Address address =AddressDTO.convertDtoToEntity(addressDTO) ;
	        return AddressDTO.convertEntityToDto(addressRepository.save(address));
	}

	  @Override
	    public List<AddressDTO> getAllAddress() {
	        return addressRepository.findAll().stream()
	                .map(AddressDTO::convertEntityToDto)
	                .collect(Collectors.toList());
	    }
	
	

}
