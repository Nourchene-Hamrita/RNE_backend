package com.RNE.demande.DTO;

import com.RNE.demande.entities.Street;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StreetDTO {
	
	
	   private Long id;
	   private String nameStreetFr;
	   private String nameStreetAr;
	   

	public static StreetDTO convertEntityToDto(Street street) {
		
		StreetDTO streetDTO = new StreetDTO();
		streetDTO.setId(streetDTO.getId());
		streetDTO.setNameStreetAr(streetDTO.getNameStreetAr());
		streetDTO.setNameStreetFr(streetDTO.getNameStreetFr());
		
		return streetDTO;
		
	}
	
}
