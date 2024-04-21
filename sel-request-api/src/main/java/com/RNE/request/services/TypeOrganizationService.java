package com.RNE.request.services;


import java.util.List;
import com.RNE.request.dto.TypeOrganizationDTO;

public interface TypeOrganizationService {
	
    TypeOrganizationDTO saveType(TypeOrganizationDTO typeOrganizationDTO);
    
    List<TypeOrganizationDTO> getAllTypes();
    
    TypeOrganizationDTO getTypeById(Long id);
    
    TypeOrganizationDTO updateType(Long id, TypeOrganizationDTO typeOrganizationDTO);
    
    void deleteType(Long id);
}
