package com.RNE.request.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.RNE.request.dto.AssociationDTO;
import com.RNE.request.entities.Association;

@Component
@Mapper(componentModel = "spring")
public class AssociationMapperImpl implements AssociationMapper {

    private static final AssociationMapper INSTANCE = Mappers.getMapper(AssociationMapper.class);

    private final AddressMapper addressMapper = AddressMapperImpl.getInstance();
    private final TypeOrganizationMapper typeOrganizationMapper = TypeOrganizationMapperImpl.getInstance();

    @Override
    @Mappings({
        @Mapping(target = "subject", source = "associationDTO.subject"),
        @Mapping(target = "objective", source = "associationDTO.objective"),
        @Mapping(target = "address", source = "associationDTO.address", qualifiedByName = "addressMapper.toEntity"),
        @Mapping(target = "typeOrganization", source = "associationDTO.typeOrganization", qualifiedByName = "typeOrganizationMapper.toEntity")
    })
    public Association toEntity(AssociationDTO associationDTO) {
        if (associationDTO == null) {
            return null;
        }

        Association association = new Association();
        association.setNameFr(associationDTO.getNameFr());
        association.setNameAr(associationDTO.getNameAr());
        association.setEmail(associationDTO.getEmail());
        association.setTypeOrganization(typeOrganizationMapper.toEntity(associationDTO.getTypeOrganization()));
        association.setAddress(addressMapper.toEntity(associationDTO.getAddress()));
        association.setSubject(associationDTO.getSubject());
        association.setObjective(associationDTO.getObjective());
        return association;
    }

    @Override
    @Mappings({
        @Mapping(target = "subject", source = "association.subject"),
        @Mapping(target = "objective", source = "association.objective"),
        @Mapping(target = "address", source = "association.address", qualifiedByName = "addressMapper.toDto"),
        @Mapping(target = "typeOrganization", source = "association.typeOrganization", qualifiedByName = "typeOrganizationMapper.toDto")
    })
    public AssociationDTO toDto(Association association) {
        if (association == null) {
            return null;
        }

        AssociationDTO associationDTO = new AssociationDTO();
        associationDTO.setNameFr(association.getNameFr());
        associationDTO.setNameAr(association.getNameAr());
        associationDTO.setEmail(association.getEmail());
        associationDTO.setAddress(addressMapper.toDto(association.getAddress()));
        associationDTO.setSubject(association.getSubject());
        associationDTO.setObjective(association.getObjective());
        return associationDTO;
    }

    public static AssociationMapper getInstance() {
        return INSTANCE;
    }
}