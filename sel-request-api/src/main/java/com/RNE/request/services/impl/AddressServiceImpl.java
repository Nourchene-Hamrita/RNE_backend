package com.RNE.request.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.RNE.request.dto.AddressDTO;
import com.RNE.request.dto.mappers.AddressMapper;
import com.RNE.request.entities.Address;
import com.RNE.request.repositories.AddressRepository;
import com.RNE.request.services.AddressService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

	private AddressRepository addressRepository;
	private AddressMapper addressMapper;

	@Override
	public AddressDTO saveAddress(AddressDTO addressDTO) {
		Address address = addressMapper.toEntity(addressDTO);
		address = addressRepository.save(address);
		return addressMapper.toDto(address);
	}

	@Override
	public List<AddressDTO> getAllAddresses() {
		List<Address> addresses = addressRepository.findAll();
		return addresses.stream().map(addressMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public AddressDTO getAddressById(Long id) {
		Address address = addressRepository.findById(id).orElse(null);
		return addressMapper.toDto(address);
	}

	@Override
	public AddressDTO updateAddress(Long id, AddressDTO addressDTO) {
		Address address = addressRepository.findById(id).orElse(null);
		// Update address fields based on addressDTO
		address = addressRepository.save(address);
		return addressMapper.toDto(address);
	}

	@Override
	public void deleteAddress(Long id) {
		addressRepository.deleteById(id);
	}
}