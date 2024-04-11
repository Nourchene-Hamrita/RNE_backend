package com.RNE.referentiel.dto;

import java.util.List;

import com.RNE.referentiel.enums.Activation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DelegationDTO {

	private String code;

	private String nameFr;

	private String nameAr;

	private Activation activation;
	
	private List<CityDTO> cities;

}