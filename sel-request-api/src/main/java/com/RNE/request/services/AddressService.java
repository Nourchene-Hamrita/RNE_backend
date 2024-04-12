package com.RNE.request.services;

import java.util.List;
import com.RNE.request.dto.AddressDTO;

public interface AddressService {
	
    AddressDTO saveAddress(AddressDTO addressDTO);
    
    List<AddressDTO> getAllAddresses();
    
    AddressDTO getAddressById(Long id);
    
    AddressDTO updateAddress(Long id, AddressDTO addressDTO);
    
    void deleteAddress(Long id);
}