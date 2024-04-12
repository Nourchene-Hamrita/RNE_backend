package com.RNE.request.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import com.RNE.request.dto.TypeOrganizationDTO;
import com.RNE.request.entities.TypeOrganization;

@Component
public class TypeOrganizationMapperImpl implements TypeOrganizationMapper {

    private static final TypeOrganizationMapper INSTANCE = Mappers.getMapper(TypeOrganizationMapper.class);

    @Override
    public TypeOrganizationDTO toDto(TypeOrganization typeOrganization) {
        if (typeOrganization == null) {
            return null;
        }

        TypeOrganizationDTO typeOrganizationDTO = new TypeOrganizationDTO();
        typeOrganizationDTO.setId(typeOrganization.getId());
        typeOrganizationDTO.setAssociationType(typeOrganization.getAssociationType());
        typeOrganizationDTO.setLegalStatus(typeOrganization.getLegalStatus());
        return typeOrganizationDTO;
    }

    @Override
    public TypeOrganization toEntity(TypeOrganizationDTO typeOrganizationDTO) {
        if (typeOrganizationDTO == null) {
            return null;
        }

        TypeOrganization typeOrganization = new TypeOrganization();
        typeOrganization.setId(typeOrganizationDTO.getId());
        typeOrganization.setAssociationType(typeOrganizationDTO.getAssociationType());
        typeOrganization.setLegalStatus(typeOrganizationDTO.getLegalStatus());
        return typeOrganization;
    }

    public static TypeOrganizationMapper getInstance() {
        return INSTANCE;
    }
}