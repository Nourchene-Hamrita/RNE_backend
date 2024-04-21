package com.RNE.request.services.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.RNE.request.dto.OrganizationDTO;
import com.RNE.request.dto.mappers.AddressMapper;
import com.RNE.request.dto.mappers.OrganizationMapper;
import com.RNE.request.entities.Organization;
import com.RNE.request.repositories.AddressRepository;
import com.RNE.request.repositories.OrganizationRepository;
import com.RNE.request.services.OrganizationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    private OrganizationMapper organizationMapper;
    private AddressMapper addressMapper;
    private AddressRepository addressRepository;
   
    @Override
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
        // Save the address entity first if it's a new one
        if (organizationDTO.getAddress() != null && organizationDTO.getAddress().getId() == null) {
            organizationDTO.setAddress(addressMapper.toDto(addressRepository.save(addressMapper.toEntity(organizationDTO.getAddress()))));
        }

        Organization organization = organizationMapper.toEntity(organizationDTO);
        organization = organizationRepository.save(organization);
        return organizationMapper.toDto(organization);
    }
    @Override
    public List<OrganizationDTO> getAllOrganizations() {
        List<Organization> organizations = organizationRepository.findAll();
        return organizations.stream().map(organizationMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public OrganizationDTO getOrganizationById(Long id) {
        Organization organization = organizationRepository.findById(id).orElse(null);
        return organizationMapper.toDto(organization);
    }

    @Override
    public OrganizationDTO updateOrganization(Long id, OrganizationDTO organizationDTO) {
        Organization organization = organizationRepository.findById(id).orElse(null);
       
            // Update organization fields based on organizationDTO
            organization.setNameFr(organizationDTO.getNameFr());
            organization.setNameAr(organizationDTO.getNameAr());
            organization.setEmail(organizationDTO.getEmail());

          

            organization = organizationRepository.save(organization);
            return organizationMapper.toDto(organization);
      
    }

    @Override
    public void deleteOrganization(Long id) {
        organizationRepository.deleteById(id);
    }
}