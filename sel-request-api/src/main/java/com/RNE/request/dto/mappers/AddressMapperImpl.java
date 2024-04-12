package com.RNE.request.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import com.RNE.request.dto.AddressDTO;
import com.RNE.request.entities.Address;

@Component
public class AddressMapperImpl implements AddressMapper {

    private static final AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    @Override
    public AddressDTO toDto(Address address) {
        if (address == null) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setDelCode(address.getDelCode());
        addressDTO.setCityCode(address.getCityCode());
        addressDTO.setPostalCodeId(address.getPostalCodeId());
        return addressDTO;
    }

    @Override
    public Address toEntity(AddressDTO addressDTO) {
        if (addressDTO == null) {
            return null;
        }

        Address address = new Address();
        address.setDelCode(addressDTO.getDelCode());
        address.setCityCode(addressDTO.getCityCode());
        address.setPostalCodeId(addressDTO.getPostalCodeId());
        return address;
    }

    public static AddressMapper getInstance() {
        return INSTANCE;
    }
}