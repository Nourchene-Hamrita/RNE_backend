package com.RNE.request.services;

import java.util.List;

import com.RNE.request.dto.AddressDTO;


public interface AddressService {

	
	public AddressDTO saveAddress(AddressDTO addressDTO);
	public List<AddressDTO> getAllAddress();
}
