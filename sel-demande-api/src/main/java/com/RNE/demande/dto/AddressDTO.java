package com.RNE.demande.dto;

import com.RNE.demande.entities.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String delCode;
    private String cityCode;
    private String postalCodeId;

    public static AddressDTO convertEntityToDto(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        
        addressDTO.setId(address.getId());
        addressDTO.setCityCode(address.getCityCode());
        addressDTO.setDelCode(address.getDelCode());
        addressDTO.setPostalCodeId(address.getPostalCodeId());
        
        return addressDTO;
    }

    public static Address convertDtoToEntity(AddressDTO addressDTO) {
        Address address = new Address();
        
        address.setId(addressDTO.getId());
        address.setCityCode(addressDTO.getCityCode());
        address.setDelCode(addressDTO.getDelCode());
        address.setPostalCodeId(addressDTO.getPostalCodeId());
        
        return address;
    }
}
