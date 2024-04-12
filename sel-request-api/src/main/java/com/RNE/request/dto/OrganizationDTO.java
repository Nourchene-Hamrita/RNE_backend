package com.RNE.request.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrganizationDTO {
	
	private Long id;
	
	private String nameFr;
	
	private String nameAr;
	
	private String email;
	
	private TypeOrganizationDTO type;
	 
    private AddressDTO address; 
    
}