package com.RNE.request.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.request.dto.TypeOrganizationDTO;
import com.RNE.request.dto.mappers.TypeOrganizationMapper;
import com.RNE.request.entities.TypeOrganization;
import com.RNE.request.repositories.TypeOrganizationRepository;
import com.RNE.request.services.TypeOrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TypeOrganizationServiceImpl implements TypeOrganizationService {

    private TypeOrganizationRepository typeOrganizationRepository;
    private TypeOrganizationMapper typeOrganizationMapper;

    @Override
    public TypeOrganizationDTO saveType(TypeOrganizationDTO typeOrganizationDTO) {
        TypeOrganization typeOrganization = typeOrganizationMapper.toEntity(typeOrganizationDTO);
        typeOrganization = typeOrganizationRepository.save(typeOrganization);
        return typeOrganizationMapper.toDto(typeOrganization);
    }

    @Override
    public List<TypeOrganizationDTO> getAllTypes() {
        List<TypeOrganization> typeOrganizations = typeOrganizationRepository.findAll();
        return typeOrganizations.stream().map(typeOrganizationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TypeOrganizationDTO getTypeById(Long id) {
        TypeOrganization typeOrganization = typeOrganizationRepository.findById(id).orElse(null);
        return typeOrganizationMapper.toDto(typeOrganization);
    }

    @Override
    public TypeOrganizationDTO updateType(Long id, TypeOrganizationDTO typeOrganizationDTO) {
        TypeOrganization typeOrganization = typeOrganizationRepository.findById(id).orElse(null);

        if (typeOrganization != null) {
            typeOrganization.setAssociationType(typeOrganizationDTO.getAssociationType());
            typeOrganization.setLegalStatus(typeOrganizationDTO.getLegalStatus());

            typeOrganization = typeOrganizationRepository.save(typeOrganization);
            return typeOrganizationMapper.toDto(typeOrganization);
        } else {
            return null;
        }
    }

    @Override
    public void deleteType(Long id) {
        typeOrganizationRepository.deleteById(id);
    }
}