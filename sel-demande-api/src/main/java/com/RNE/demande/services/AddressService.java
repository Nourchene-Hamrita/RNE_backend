package com.RNE.demande.services;

import java.util.List;

import com.RNE.demande.dto.AddressDTO;


public interface AddressService {

	
	public AddressDTO saveAddress(AddressDTO addressDTO);
	public List<AddressDTO> getAllAddress();
}
