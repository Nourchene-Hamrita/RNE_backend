package com.RNE.request.dto.mappers;

import org.mapstruct.Mapper;
import com.RNE.request.dto.AddressDTO;
import com.RNE.request.entities.Address;

@Mapper(componentModel = "spring")

public interface AddressMapper {
	AddressDTO toDto(Address address);

	Address toEntity(AddressDTO addressDTO);
}