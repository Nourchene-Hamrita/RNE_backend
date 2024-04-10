package com.RNE.referentiel.dto;

import com.RNE.referentiel.enums.Activation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityDTO {

	private String code;

	private String nameFr;

	private String nameAr;

	private Activation activation;

	private String delegationCode;

}