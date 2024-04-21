package com.RNE.request.services;

import java.util.List;

import com.RNE.request.dto.AssociationDTO;

public interface AssociationService  {

    AssociationDTO saveAssociation(AssociationDTO associationDTO);

   
    List<AssociationDTO> getAllAssociations();

    AssociationDTO getAssociationById(Long id);

    /*AssociationDTO updateAssociation(Long id, AssociationDTO associationDTO);*/
  
  

 
    void deleteAssociation(Long id);
}