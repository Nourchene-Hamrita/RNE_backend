package com.RNE.request.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.request.dto.OrganizationDTO;
import com.RNE.request.entities.Organization;

@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    private static final OrganizationMapper INSTANCE = Mappers.getMapper(OrganizationMapper.class);

    @Autowired
    private TypeOrganizationMapper typeOrganizationMapper; 

    @Autowired
    private AddressMapper addressMapper; 

    @Override
  
    public OrganizationDTO toDto(Organization organization) {
        if (organization == null) {
            return null;
        }

        OrganizationDTO organizationDTO = new OrganizationDTO();
        organizationDTO.setId(organization.getId());
        organizationDTO.setNameFr(organization.getNameFr());
        organizationDTO.setNameAr(organization.getNameAr());
        organizationDTO.setEmail(organization.getEmail());
        // Populate type and address
        if (organization.getTypeOrganization() != null) {
            organizationDTO.setType(typeOrganizationMapper.toDto(organization.getTypeOrganization()));
        }
        if (organization.getAddress() != null) {
            organizationDTO.setAddress(addressMapper.toDto(organization.getAddress()));
        }

        return organizationDTO;
    }

    @Override
 
    public Organization toEntity(OrganizationDTO organizationDTO) {
        if (organizationDTO == null) {
            return null;
        }

        Organization organization = new Organization();
        organization.setId(organizationDTO.getId());
        organization.setNameFr(organizationDTO.getNameFr());
        organization.setNameAr(organizationDTO.getNameAr());
        organization.setEmail(organizationDTO.getEmail());

     // Set type and address
        if (organizationDTO.getType() != null) {
            organization.setTypeOrganization(typeOrganizationMapper.toEntity(organizationDTO.getType()));
        }
        if (organizationDTO.getAddress() != null) {
            organization.setAddress(addressMapper.toEntity(organizationDTO.getAddress()));
        }

        return organization;
    }
    public static OrganizationMapper getInstance() {
        return INSTANCE;
    }
}