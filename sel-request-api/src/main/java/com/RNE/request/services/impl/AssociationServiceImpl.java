package com.RNE.request.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.request.dto.AssociationDTO;
import com.RNE.request.dto.mappers.AddressMapper;
import com.RNE.request.dto.mappers.AssociationMapper;
import com.RNE.request.entities.Association;
import com.RNE.request.repositories.AddressRepository;
import com.RNE.request.repositories.AssociationRepository;
import com.RNE.request.services.AssociationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AssociationServiceImpl implements AssociationService {

    private AssociationRepository associationRepository;
    private AssociationMapper associationMapper;   
    private AddressMapper addressMapper;
    private AddressRepository addressRepository;
    

    @Override
    public AssociationDTO saveAssociation(AssociationDTO associationDTO) {
    	   // Save the address entity first if it's a new one
        if (associationDTO .getAddress() != null && associationDTO.getAddress().getId() == null) {
        	associationDTO.setAddress(addressMapper.toDto(addressRepository.save(addressMapper.toEntity(associationDTO.getAddress()))));
        }
        Association association = associationMapper.toEntity(associationDTO);
        association = associationRepository.save(association);
        return associationMapper.toDto(association);
    }

    @Override
    public List<AssociationDTO> getAllAssociations() {
        List<Association> associations = associationRepository.findAll();
        return associations.stream().map(associationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AssociationDTO getAssociationById(Long id) {
        Association association = associationRepository.findById(id).orElse(null);
        return associationMapper.toDto(association);
    }

    /*@Override
    public AssociationDTO updateAssociation(Long id, AssociationDTO associationDTO) {
        Association association = associationRepository.findById(id).orElse(null);

        // Update association fields based on associationDTO
        association.setNameFr(associationDTO.getNameFr());
        association.setNameAr(associationDTO.getNameAr());
        association.setEmail(associationDTO.getEmail());
        association.setTypeOrganization(associationDTO.getTypeOrganizations());
        association.setAddress(associationDTO.getAddress());

        association = associationRepository.save(association);
        return associationMapper.toDto(association);
    }
*/
    @Override
    public void deleteAssociation(Long id) {
        associationRepository.deleteById(id);
    }
}