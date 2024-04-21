package com.RNE.request.services;

import java.util.List;
import com.RNE.request.dto.OrganizationDTO;

public interface OrganizationService {
	
    OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
    
    List<OrganizationDTO> getAllOrganizations();
    
    OrganizationDTO getOrganizationById(Long id);
    
    OrganizationDTO updateOrganization(Long id, OrganizationDTO organizationDTO);
    
    void deleteOrganization(Long id);
}